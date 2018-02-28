package proj1;

public class User {
	
	// Schedule the user was created for
	private Schedule s;
	
	// Name of the user
	private String name;
	
	// A 2D array of how he user rated each time slot
	private int[][] ratings;
	
	// A 2D array of what comments the user made on the given time slots
	private String[][] comments;
	
	public User(Schedule s, String name) {
		this.s = s;
		this.name = name;
	}
	
}
