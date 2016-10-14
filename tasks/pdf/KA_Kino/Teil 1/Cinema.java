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

	public void addHall(){}
	
	public int getNumberOfHalls() {
		return 0;
	}
	
	public boolean addScreening(Movie m ,int hall, int startH, int startM) {
		// Startzeit des Films: startH:startM
		return true;
	}
	
	public String[] getProgram() {
		return null;
	}

	public String[] getProgram(int Hall) {
		return null;
	}

}
