public class Cinema {
	
	public Cinema(int startH, int startM, int endH, int endM) {
		
		/* Öffnungszeiten des Kinos
		 * von startH:startM Uhr bis endH:endM Uhr
		 */
	}
	
	public String getOpenTime(){
		// z.B. "09:30"
		return null;
	}
	public String getClosingTime(){
		// z.B. "23:05"
		return null;
	}

	// seats - Anzahl der Sitze pro Saal
	public void addHall(int seats){}
	
	public int getNumberOfHalls() {
		return 0;
	}

	public int getSeats(int hall) {
		return 0;
	}

	// return true - wenn der Ticketverkauf möglich ist 
	public boolean buyTickets(int screeningID, int amount) {
		return false;
	}
	
	// return screeningID - wenn die Vorführung überschneidungsfrei möglich ist
	// return -1 - sonst
	public int addScreening(Movie m ,int hall, int startH, int startM) {
		// Startzeit des Films: startH:startM
		return -1;
	}
	
	public String[] getProgram() {
		return null;
	}

	public String[] getProgram(int hall) {
		return null;
	}

}
