
public class Person {
	
	private int money;
	private int customerID;
	private String name;

	public Person(String name) {
		this.name = name;
		this.money = 100;
	}
	
	public void register(Shop shop) {
		this.customerID = shop.becomeCustomer(this);
	}
	
	public void pay(int amount) {
		this.money -= amount;
	}
	
	public int getMoney() {
		return this.money;
	}
	
	public boolean buy(Shop shop, Movie movie) {
		return shop.buy(movie, this.customerID);
	}
	
	public boolean watch(Shop shop, Movie movie) {
		return shop.stream(movie, this.customerID);
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
