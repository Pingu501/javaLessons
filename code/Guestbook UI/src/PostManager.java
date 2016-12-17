import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Created by alex on 07/12/2016.
 */
public class PostManager {


	/**
	 * Singleton
	 */
	private static PostManager postManager = new PostManager();

	private PostManager() {

	}

	public static PostManager getInstance() {
		return postManager;
	}

	/**
	 * HashMap with postId containing an HashMap with the userId and the text of the post.
	 */
	private static Map<Integer, Post> posts = new HashMap<>();
	private static Integer currentId = 0;


	public void addPost() {
//		Scanner scanner = new Scanner(System.in);
//
//		System.out.println("From which user is the post? ");
//
//		UserManager userManager = UserManager.getInstance();
//		if (userManager.countUsers() == 0) {
//			System.out.println("No users available!");
//			return;
//		}
//
//		userManager.printAllUsers();
//
//		Integer userId = scanner.nextInt();
//		User user = userManager.getUserById(userId);
//
//		System.out.println("What is the post from " + user + "?");
//		// Skip the newline
//		scanner.nextLine();
//		String text = scanner.nextLine();

		int userID = UserManager.getInstance().getSelectedUserID();

		if (userID == -1) { return; }

		String text = textField.getText();

		System.out.println(text);

		Post post = new Post(userID, text);
		posts.put(currentId, post);
		currentId++;

		viewPostsByUser();
	}

	public void viewAllPosts() {
		UserManager userManager = UserManager.getInstance();

		posts.forEach((k,v) -> {
			System.out.println("[" + k + "]");
			System.out.println("\t" + userManager.getUserById(v.getUserId()));
			System.out.println("\t" + v.getText());
		});
	}

	public void viewPostsByUser() {
		UserManager userManager = UserManager.getInstance();

		int userID = userManager.getSelectedUserID();

		if (userID ==  -1) { return; }

		titleLabel.setText(userManager.getUserById(userID).toString() + "'s Posts:");

		textField.setText("");

		List<String> postsByUser = new ArrayList<>();
		posts.forEach((k,v) -> {
			if(v.getUserId() == userID) {
				postsByUser.add(v.getText());
				postList.setListData(postsByUser.toArray());
			}
		});
	}

	private JLabel titleLabel;
	private JList postList;
	private JTextField textField;

	public JPanel getPostPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.FIRST_LINE_START;

		titleLabel = new JLabel("");
		panel.add(titleLabel, c);

		c = new GridBagConstraints();
		c.anchor = GridBagConstraints.LINE_START;
		c.gridwidth = 3;
		c.gridheight = 1;

		postList = new JList();
		panel.add(postList, c);

		c = new GridBagConstraints();
		c.anchor = GridBagConstraints.LAST_LINE_START;
		c.gridwidth = 2;

		textField = new JTextField();
		panel.add(textField, c);

		JButton postButton = new JButton("Post");

		c = new GridBagConstraints();
		c.anchor = GridBagConstraints.LAST_LINE_END;
		c.gridwidth = 1;

		postButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addPost();
			}
		});

		panel.add(postButton, c);

		return panel;
	}

	public JPanel newPanel() {
		JPanel panel = new JPanel();

		JLabel postLabel = new JLabel("Posts:");
		panel.add(postLabel);

		JPanel scrollPanel = new JPanel();

		JScrollPane scrollPane = new JScrollPane (scrollPanel,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// JScrollPane wird dem Dialog hinzugefügt
		panel.add(scrollPane);

		JList posts = new JList();
		posts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPanel
				.add(posts);

		posts.setListData(new String[]{"Ich bin neu hier", "Hört mich jemand?", "Ich bin neu hier", "Hört mich jemand?", "Ich bin neu hier", "Hört mich jemand?", "Ich bin neu hier", "Hört mich jemand?", "Ich bin neu hier", "Hört mich jemand?", "Ich bin neu hier", "Hört mich jemand?", "Ich bin neu hier", "Hört mich jemand?", "Ich bin neu hier", "Hört mich jemand?", "Ich bin neu hier", "Hört mich jemand?", "Ich bin neu hier", "Hört mich jemand?", "Ich bin neu hier", "Hört mich jemand?", "Ich bin neu hier", "Hört mich jemand?", "Ich bin neu hier", "Hört mich jemand?", "Ich bin neu hier", "Hört mich jemand?", "Ich bin neu hier", "Hört mich jemand?", "Ich bin neu hier", "Hört mich jemand?", "Ich bin neu hier", "Hört mich jemand?", "Ich bin neu hier", "Hört mich jemand?", "Ich bin neu hier", "Hört mich jemand?"});

		return panel;
	}
}
