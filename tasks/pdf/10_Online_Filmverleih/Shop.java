import java.util.LinkedList;
import java.util.List;

public class Shop {

	private List<Customer> customers;
	private Catalog availableMovies;
	private String name;

	public Shop(String name) {
		this.customers = new LinkedList<Customer>();
		this.availableMovies = new Catalog();
		this.name = name;
	}

	public int becomeCustomer(Person newUser) {
		this.customers.add(new Customer(newUser));
		System.out.println(newUser + " is now a customer from " + this.name);
		return this.customers.size() - 1;
	}

	public boolean addMovie(Movie movie) {
		return this.availableMovies.addTitle(movie);
	}

	public Movie search(String title) {
		return this.availableMovies.search(title);
	}

	public boolean buy(Movie movie, int customerID) {
		int price = movie.getPrice();
		Customer c = this.customers.get(customerID);

		if (c.getMoney() < movie.getPrice()) {
			System.out.println(c + " can't afford to buy " + movie);
			return false;
		}

		if (c.hasMovie(movie)) {
			System.out.println(c + " already has " + movie);
			return false;
		}
		
		c.pay(price);
		c.addMovie(movie);

		System.out.println(c + " buys " + movie + " for just " + movie.getPrice());

		return true;
	}
	
	public boolean stream(Movie movie, int customerID) {
		Customer c = this.customers.get(customerID);

		if (! c.hasMovie(movie)) {
			System.out.println(c + " can't stream " + movie);
			return false;
		}

		System.out.println(c + " watches " + movie);
		
		return true;
	}
}
