/**
 * Created by alex on 15/01/2017.
 */
public class Field {

	public enum Type {
		EMPTY,
		BOMB,
	}

	public enum Status {
		COVERED,
		REVEALD,
		FLAGGED,
		OPENED
	}

	private Status status;
	private Type type;

	private int positionX;
	private int positionY;

	public Field(int positionX,int positionY) {
		this.status = Status.COVERED;
		this.type = Type.EMPTY;

		this.positionX = positionX;
		this.positionY = positionY;
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public Status getStatus() {
		return status;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
