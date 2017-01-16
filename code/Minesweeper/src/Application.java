/**
 * Created by Alex on 15.01.17.
 */
public class Application {

	private static Minesweeper game;

	public static void main(String[] args) {
		System.out.println("Welcome to Minesweeper for Java!");
		game = new Minesweeper();
		game.initGame();
	}
}
