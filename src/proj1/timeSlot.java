package proj1;
import java.time.Instant;
import java.util.Comparator;

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
	
	public timeSlot(int loves, int likes, int dislikes, int hates, int vetoes) {
		this.loves = loves;
		this.likes = likes;
		this.dislikes = dislikes;
		this.hates = hates;
		this.vetoes = vetoes;
	}
	
	public int[] getRatings() {
		int ratings[] = {this.loves, this.likes, this.dislikes, this.hates, this.vetoes};
		return ratings;
	}
	
	class sortByLeastConflict implements Comparator<timeSlot> {
		public int compare(timeSlot a, timeSlot b) {
			if (b.vetoes - a.vetoes != 0) {
				return b.vetoes - a.vetoes;
			}
			else if (b.hates - a.hates != 0) {
				return b.hates - a.hates;
			}
			else if (b.dislikes - a.dislikes != 0) {
				return b.dislikes - a.dislikes;
			}
			else {
				return (3*a.loves + a.likes) - (3*b.loves + b.likes);
			}
		}
	}
	
	class sortByAvgRating implements Comparator<timeSlot> {
		public int compare(timeSlot a, timeSlot b) {
			if (b.vetoes - a.vetoes != 0) {
				return b.vetoes - a.vetoes;
			}
			else {
				return (3*a.loves + a.likes - a.dislikes - 3*a.hates)
						- (3*b.loves + b.likes - b.dislikes - 3*b.hates);
			}
		}
	}
}
