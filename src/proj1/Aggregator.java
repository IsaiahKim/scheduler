package proj1;

import java.util.Arrays;
import java.util.Comparator;

public class Aggregator {
	
	private timeSlot[] slots;
	private int rowCount;
	private int colCount;
	
	public Aggregator(int rows, int cols) {
		this.rowCount = rows;
		this.colCount = cols;
		//TODO: CREATE TIME SLOTS
	}
	
	public timeSlot[] conflictSort() {
		Arrays.sort(slots, new sortByLeastConflict());
		return slots;
	}
	
	public timeSlot[] ratingSort() {
		Arrays.sort(slots, new sortByRating());
		return slots;
	}
}

/**
 * This comparator compares by which timeSlot has fewer vetoes.
 * Should two timeSlots have an equal number of vetoes, the process
 * is repeated for hates, then dislikes. If all three of those are
 * equal, the timeSlots are compared by the sum of loves and likes
 * with loves being worth more than likes.
 */
class sortByLeastConflict implements Comparator<timeSlot> {
	public int compare(timeSlot a, timeSlot b) {
		if (b.getVetoes() - a.getVetoes() != 0) {
			return b.getVetoes() - a.getVetoes();
		}
		else if (b.getHates() - a.getHates() != 0) {
			return b.getHates() - a.getHates();
		}
		else if (b.getDislikes() - a.getDislikes() != 0) {
			return b.getDislikes() - a.getDislikes();
		}
		else {
			return (3*a.getLoves() + a.getLikes()) - (3*b.getLoves() + b.getLikes());
		}
	}
}

/**
 * This comparator sees which timeSlot has a higher overall
 * rating after adding together all the likes, loves, dislikes,
 * and hates given to it. Any timeSlot with vetoes is always worth
 * less than a timeSlot with fewer vetoes.
 */
class sortByRating implements Comparator<timeSlot> {
	public int compare(timeSlot a, timeSlot b) {
		if (b.getVetoes() - a.getVetoes() != 0) {
			return b.getVetoes() - a.getVetoes();
		}
		else {
			return (3*a.getLoves() + a.getLikes() - a.getDislikes() - 3*a.getHates())
					- (3*b.getLoves() + b.getLikes() - b.getDislikes() - 3*b.getHates());
		}
	}
}