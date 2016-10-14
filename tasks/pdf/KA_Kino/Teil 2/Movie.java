
public class Movie {

	private int runningTime;
	private String title;
	
	public Movie (String title, int runningTime) {
		this.title = title;
		this.runningTime = runningTime;
	}
	
	public int getRunningTime() {
		return this.runningTime;
	}

	public String getTitle() {
		return this.title;
	}
}
