/**
 * Created by alex on 15/01/2017.
 */
public class Application {

	public static void main(String[] args) {
		System.out.println("Welcome to Minesweeper for Java!");

		Minesweeper game = new Minesweeper();
		game.initGame();
	}

}
