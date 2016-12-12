import java.util.*;

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
		Scanner scanner = new Scanner(System.in);

		System.out.println("From which user is the post? ");

		UserManager userManager = UserManager.getInstance();
		if (userManager.countUsers() == 0) {
			System.out.println("No users available!");
			return;
		}

		userManager.printAllUsers();

		Integer userId = scanner.nextInt();
		User user = userManager.getUserById(userId);

		System.out.println("What is the post from " + user + "?");
		// Skip the newline
		scanner.nextLine();
		String text = scanner.nextLine();

		Post post = new Post(userId, text);
		posts.put(currentId, post);
		currentId++;
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

		System.out.println("Posts by which user?");
		userManager.printAllUsers();

		Scanner scanner = new Scanner(System.in);
		int userId = scanner.nextInt();

		System.out.println(userManager.getUserById(userId));
		posts.forEach((k,v) -> {
			if(v.getUserId() == userId) {
				System.out.println(v.getText());
				System.out.println("#################");
			}

		});
	}
}
