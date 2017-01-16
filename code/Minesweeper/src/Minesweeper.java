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

	public void clickField(int xPosition, int yPosition, boolean isRightClick) {
		Field field = getFieldByCoordinates(xPosition, yPosition);

		if(isRightClick) {
			if(field.getStatus() == Field.Status.FLAGGED) {
				field.setStatus(Field.Status.COVERED);
			} else {
				field.setStatus(Field.Status.FLAGGED);
			}
		} else {
			if(field.getStatus() != Field.Status.FLAGGED) {

				if (field.getType() != Field.Type.BOMB) {
					calculateNumber(field);
					field.setStatus(Field.Status.OPENED);

					if (field.getNumber() == 0) {
						revealNeighbors(field);
					}
				} else {
					field.setStatus(Field.Status.OPENED);
				}
			}
		}

		windowController.updateField(field);
	}


	private void calculateNumber(Field field) {
		List<Field> fields = getAllNeighbors(field);
		int number = 0;

		for(Field neighborField : fields) {
			if(neighborField == null) {
				continue;
			}

			if(neighborField.getType() == Field.Type.BOMB) {
				number++;
			}
		}

		field.setNumber(number);
	}

	private List<Field> getAllNeighbors(Field field) {
		ArrayList<Field> fields = new ArrayList<>();

		//row above
		fields.add(getFieldByCoordinates(field.getPositionX() - 1, field.getPositionY() - 1));
		fields.add(getFieldByCoordinates(field.getPositionX(), field.getPositionY() - 1));
		fields.add(getFieldByCoordinates(field.getPositionX() + 1, field.getPositionY() - 1));

		//same row
		fields.add(getFieldByCoordinates(field.getPositionX() - 1, field.getPositionY()));
		fields.add(getFieldByCoordinates(field.getPositionX() + 1, field.getPositionY()));

		//row below
		fields.add(getFieldByCoordinates(field.getPositionX() - 1, field.getPositionY() + 1));
		fields.add(getFieldByCoordinates(field.getPositionX(), field.getPositionY() + 1));
		fields.add(getFieldByCoordinates(field.getPositionX() + 1, field.getPositionY() + 1));

		return fields;
	}

	private void revealNeighbors(Field field) {
		List<Field> fields = getAllNeighbors(field);

		for(Field neighborField : fields) {
			if(neighborField == null) {
				continue;
			}

			if(neighborField.getStatus() == Field.Status.OPENED) {
				continue;
			}

			calculateNumber(neighborField);
			neighborField.setStatus(Field.Status.OPENED);
			windowController.updateField(neighborField);

			if(neighborField.getNumber() == 0) {
				revealNeighbors(neighborField);
			}
		}
	}
}
