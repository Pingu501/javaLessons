import static org.junit.Assert.*;

import org.junit.*;

public class CinemaTest {
	
	private Cinema cinema;

	@Before
	public void setUp(){
		this.cinema = new Cinema(8, 0, 22, 0);
		this.cinema.addHall(200);
		this.cinema.addHall(50);
		this.cinema.addHall(50);
	}
	
	@After
	public void tearDown() {
		this.cinema = null;
	}
	
	@Test
	public void testSeatCount() {
		assertEquals(cinema.getSeats(1), 200);
		assertEquals(cinema.getSeats(2), 50);
		assertEquals(cinema.getSeats(3), 50);
		assertEquals(cinema.getNumberOfHalls(), 3);
	}
	
	@Test
	public void testProgram() {
		Movie m = new Movie("Wag the Dog", 97);
		this.cinema.addScreening(m, 2, 10, 30);
		this.cinema.addScreening(m, 2, 12, 30);
		this.cinema.addScreening(m, 2, 13, 30);
		
		boolean match1 = false;
		boolean match2 = false;
		
		for(String s : this.cinema.getProgram(2)){
			if(s.matches("\\[ID\\s\\d*\\] 10:30 \\.\\.\\. 12:07 Wag the Dog")){
				match1 = true;
			} else if(s.matches("\\[ID\\s\\d*\\] 13:30 \\.\\.\\. 15:07 Wag the Dog")) {
				match2 = true;
			} else if(s.matches("\\[ID\\s\\d*\\] 12:30 \\.\\.\\. 14:07 Wag the Dog")) {
				fail();
			}
		}
		assertTrue(match1 && match2);
	}

	@Test
	public void testMaxSeats() {
		Movie m = new Movie("Wag the Dog", 97);
		int id = this.cinema.addScreening(m, 3, 13, 00);
		
		assertTrue(this.cinema.buyTickets(id, 10));
		assertFalse(this.cinema.buyTickets(id, -3));
		assertFalse(this.cinema.buyTickets(id, 0));
		assertTrue(this.cinema.buyTickets(id, 39));
		assertTrue(this.cinema.buyTickets(id, 1));
		assertFalse(this.cinema.buyTickets(id, 1));
		
	}
}