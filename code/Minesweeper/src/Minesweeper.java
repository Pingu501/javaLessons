import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by alex on 15/01/2017.
 */
public class Minesweeper {

	private List<Field> fields = new ArrayList<>();
	private WindowController windowController;

	public void initGame() {
		int width = 10;
		int height = 10;

		windowController = new WindowController(width, height, this);
		generateFields(width, height);
		placeBombs(width, height);
	}

	private void generateFields(int width, int height) {
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				fields.add(new Field(i, j));
			}
		}
	}

	private void placeBombs(int width, int height) {
		Random random = new Random();

		int bombsToBePlaced = 10;

		while (bombsToBePlaced > 0) {
			int randomPositionX = random.nextInt(width);
			int randomPositionY = random.nextInt(height);

			Field field = getFieldByCoordinates(randomPositionX, randomPositionY);
			if(field != null) {
				if (field.getType() == Field.Type.EMPTY) {
					field.setType(Field.Type.BOMB);
					bombsToBePlaced--;
				}
			}
		}
	}

	public Field getFieldByCoordinates(int x, int y) {
		for(Field field : fields) {
			if(field.getPositionX() == x && field.getPositionY() == y) {
				return field;
			}
		}

		return null;
	}

	public void clickField(int xPosition, int yPosition) {
		windowController.updateField(getFieldByCoordinates(xPosition, yPosition));
	}
}
