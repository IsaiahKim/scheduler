package proj1;
import java.time.Instant;

public class Aggregator {
	
	private Instant timeSlot;
	private int userCount; // TODO: Make sure this updates every time a user joins
	
	// The following show the number of each rating the time slot received
	private int loves; 		// 3, ideal time to meet
	private int likes; 		// 1, aka won't be tired
	private int dislikes; 	// -1, aka will be tired
	private int vetoes;		// -infinity, have something to do
	
	//public int leastConflict() { 
	//}
	
	// TODO: create a comparator that can ensure no amount of loves can match 1 dislike
}
