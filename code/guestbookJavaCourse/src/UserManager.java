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

	private UserManager() {

	}

	public static UserManager getInstance() {
		return userManager;
	}



	private static HashMap<Integer, User> users = new HashMap<>();
	private static int currentId = 0;

	public int countUsers() {
		return users.size();
	}

	public void addUser() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter username for new user: ");
		String userName = scanner.nextLine();

		User user = new User(userName);
		users.put(currentId, user);

		System.out.println("Added new user " + userName);
		currentId++;
	}

	public User getUserById(Integer id) {
		return users.get(id);
	}

	public void printAllUsers() {
		users.forEach((k,v) -> {
			System.out.println("[" + k  + "]" + " \t " + v);
		});
	}
}
