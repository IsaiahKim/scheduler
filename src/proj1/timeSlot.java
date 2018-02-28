package proj1;
import java.time.Instant;
import java.util.Comparator;
import java.util.Hashtable;

public class timeSlot {
	
	private Instant timeMarker; // The time the timeSlot starts at
	private String time; // Time written out as time, date. 4:00PM, January 9th
	private int userCount; // TODO: Make sure this updates every time a user joins
	
	// The following show the number of each rating the time slot received
	private int loves; 		// 3, ideal time to meet
	private int likes; 		// 1, aka won't be tired
	private int dislikes; 	// -1, aka will be tired
	private int hates;		// -3, can meet but would greatly prefer not to
	private int vetoes;		// -infinity, have something to do
	// Comments made by users on this timeSlot <user, text>
	private Hashtable<String, String> comments;
	
	public timeSlot(int loves, int likes, int dislikes, int hates, int vetoes) {
		this.loves = loves;
		this.likes = likes;
		this.dislikes = dislikes;
		this.hates = hates;
		this.vetoes = vetoes;
		this.comments = new Hashtable<String, String>();
	}
	
	public int[] getRatings() {
		int ratings[] = {this.loves, this.likes, this.dislikes, this.hates, this.vetoes};
		return ratings;
	}
	
	public int getLoves() {
		return this.loves;
	}
	
	public int getLikes() {
		return this.likes;
	}
	
	public int getDislikes() {
		return this.dislikes;
	}
	
	public int getHates() {
		return this.hates;
	}
	
	public int getVetoes() {
		return this.vetoes;
	}
	
	public void addComment(String user, String text) {
		if (comments.containsKey(user)) {
			comments.replace(user, text);
		}
		comments.put(user, text);
		
	}
	
	public void rmvComment(String user) {
		comments.remove(user);
	}
}
