
public class Customer {

	private Catalog movies;
	private Person user;
	
	public Customer(Person user) {
		this.movies = new Catalog();
		this.user = user;
	}
	
	public boolean addMovie(Movie movie) {
		return this.movies.addTitle(movie);
	}
	
	public boolean hasMovie(Movie movie) {
		Movie mov = this.movies.search(movie.toString());
		if (mov == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public int getMoney() {
		return this.user.getMoney();
	}
	
	public void pay(int amount) {
		this.user.pay(amount);
	}
	
	@Override
	public String toString() {
		return user.toString();
	}
}
