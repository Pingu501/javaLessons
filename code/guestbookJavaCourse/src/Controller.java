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
