import javafx.geometry.Pos;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by alex on 07/12/2016.
 */
public class UserManager {


	/**
	 * Singleton
	 */
	private static UserManager userManager = new UserManager();

	private JList userList;

	private UserManager() {

	}

	private JTabbedPane tabbedPane;

	public static UserManager getInstance() {
		return userManager;
	}

	private static HashMap<Integer, User> users = new HashMap<>();
	private static int currentId = 0;

	public int countUsers() {
		return users.size();
	}

	public void addUser() {
		String userName = null;

		while (userName == null) {
			userName = JOptionPane.showInputDialog("Please enter the username for the new user:");
		}

		User user = new User(userName);
		users.put(currentId, user);

		System.out.println("Added new user " + userName);
		currentId++;

		userList.setListData(users.values().toArray());
	}

	public User getUserById(Integer id) {
		return users.get(id);
	}

	public void printAllUsers() {
		users.forEach((k,v) -> {
			System.out.println("[" + k  + "]" + " \t " + v);
		});
	}

	public JPanel getUserPanel() {
		JPanel panel = new JPanel();

		this.userList = new JList();
		this.userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		panel.add(userList);

		userList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				PostManager.getInstance().viewPostsByUser();
			}
		});

		return panel;
	}

	public int getSelectedUserID() {
		return userList.getSelectedIndex();
	}
}
