package proj1;
import java.util.*;

public class Candidate {
	
	private String time;
	private int rating;
	
	public Candidate(String time, int rating) {
		this.time = time;
		this.rating = rating;
	}
	
	public String getTime() {
		return time;
	}
	
	public int getRating() {
		return rating;
	}
}

class sortByRating implements Comparator<Candidate> {
	public int compare(Candidate a, Candidate b) {
		return a.getRating() - b.getRating();
	}
}