
public class Movie {

	private String title;
	private int price;
	
	public Movie(String title, int price) {
		this.title = title;
		this.price = price;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	@Override
	public String toString() {
		return this.title;
	}
}
