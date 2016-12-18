import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 * Created by alex on 07/12/2016.
 */
public class Controller {

	private UserManager userManager;
	private PostManager postManager;

	public Controller() {
		this.userManager = UserManager.getInstance();
		this.postManager = PostManager.getInstance();

		// Create a new window
		JFrame window = new JFrame();

		// Set its title and size
		window.setTitle("Guestbook");
		window.setSize(500, 500);

		// Create menu bar and items..
		MenuBar bar = new MenuBar();
		Menu menu = new Menu("File");

		MenuItem item = new MenuItem("Create new User");
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userManager.addUser();
			}
		});

		menu.add(item);
		bar.add(menu);

		JSplitPane splitPane = new JSplitPane();

		splitPane.setLeftComponent(userManager.getUserPanel());
		splitPane.setRightComponent(postManager.getPostPanel());

		splitPane.setDividerLocation(0.3);

		window.setMenuBar(bar);
		window.add(splitPane);

		// Set the window to be visible
		window.setVisible(true);
	}

	public void pathsController() {

		boolean running = true;

		while (running) {
			System.out.print("\n############################## \n");

			System.out.println("[1] \t create User");
			System.out.println("[2] \t add post");
			System.out.println("[3] \t view all posts");
			System.out.println("[4] \t view posts by user");
			System.out.println("[9] \t to exit");

			Scanner scanner = new Scanner(System.in);
			Integer route = scanner.nextInt();

			switch (route) {
				case 1:
					userManager.addUser();
					break;
				case 2:
					postManager.addPost();
					break;
				case 3:
					postManager.viewAllPosts();
					break;
				case 4:
					postManager.viewPostsByUser();
					break;
				case 9:
					running = false;
					break;
				default:
					System.out.println("Unsupported input");
			}
		}
	}

}
