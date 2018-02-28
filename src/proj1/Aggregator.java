package proj1;

import java.util.Arrays;
import java.util.Comparator;

public class Aggregator {
	
	/* Columns represent days while rows represent time in the XX:XX format.
	 * Finding a specific timeSlot would look like slots[column][row].
	 */
	private timeSlot[][] slots;
	private int slotCount;
	private int rowCount;
	private int colCount;
	
	public Aggregator(int rows, int cols) { //TODO: add start date, end date, start hour, end hour, calendar, probably avoid strings
		this.rowCount = rows;
		this.colCount = cols;
		this.slotCount = rows * cols;
		this.slots = new timeSlot[cols][rows]; //TODO: Figure out how to resize
		
				
	}
	
	public timeSlot[] conflictSort() {
		timeSlot[] sorted = new timeSlot[slotCount];
		for (int i=0;i<colCount;i++) {
			sorted.append(slots[i]);
		}
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