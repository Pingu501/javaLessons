import java.util.HashMap;
import java.util.Map;

public class Catalog {
	
	private Map<String, Movie> movies;

	public Catalog() {
		this.movies = new HashMap<String, Movie>();
	}
	
	public boolean addTitle(Movie movie) {
		if (this.movies.keySet().contains(movie.toString())) {
			return false;
		} else {
			this.movies.put(movie.toString(), movie);
			return true;
		}
	}
	
	public Movie search(String title) {
		if (movies.keySet().contains(title)) {
			return this.movies.get(title);
		} else {
			return null;
		}
	}
}
