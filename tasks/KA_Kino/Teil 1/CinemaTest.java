import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CinemaTest {
	
	//
	// Tests für Aufgabenstellung Teil 1
	//
	
	Cinema cinema;
	
	@Before
	public void setUp(){
		cinema = new Cinema(8, 0, 22, 0);
	}
	
	@After
	public void tearDown(){
		cinema = null;
	}
	
	@Test
	public void testDayPlan() {
		cinema.addHall();
		cinema.addHall();
		Movie m1 = new Movie("Movie1", 45);
		Movie m2 = new Movie("Movie2", 90);
		assertFalse(cinema.addScreening(m2, 1, 21, 0));
		assertTrue(cinema.addScreening(m2, 1, 13, 0));
		assertFalse(cinema.addScreening(m1, 1, 14, 30));
		assertTrue(cinema.addScreening(m1, 1, 15, 0));
		assertTrue(cinema.addScreening(m2, 2, 15, 0));
		assertFalse(cinema.addScreening(m2, 3, 13, 0));
		assertFalse(cinema.addScreening(null, 1, 10, 0));
	}
	
	@Test
	public void testHalls(){
		assertTrue(cinema.getNumberOfHalls() == 0);
		cinema.addHall();
		cinema.addHall();
		cinema.addHall();
		assertTrue(cinema.getNumberOfHalls() == 3);
	}
	
	@Test
	public void timeTesting(){
		assertEquals(cinema.getOpenTime(), "08:00");
		assertEquals(cinema.getClosingTime(), "22:00");
		cinema.addHall();
		Movie m1 = new Movie("Movie1", 45);
		cinema.addScreening(m1, 1, 13, 0);
		String[] dayPlanHallOne = cinema.getProgram(1);
		boolean correctness = false;
		for(String s : dayPlanHallOne){
			if(s.contains("13:00 ... 13:45 Movie1")){
				correctness = true;
			}
		}
		assertTrue(correctness);
		
	}

}
