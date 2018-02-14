package proj1;
import java.util.Date;

public class Schedule {
	
	// A list of people attempting to agree on a schedule
	private String[] members;
	
	// Whether or not all members can fully veto a time slot
	private boolean allVeto;
	
	// The earliest and latest days the schedule's bounds includes
	private Date fstDay;
	private Date lstDay;
	
	// The earliest and latest hours the desired event can take place
	private int startTime;
	private int endTime;
	
	// The dimensions of the schedule
	private int rowCount;
	private int colCount;
	
	// Length of the desired event, saved but not required for future use
	private int meetLen;
	
	// The length of each time slot in minutes. Defaults to 30 minutes.
	private int slotLen;
	
	// A 2D array of rating aggregators for each time slot
	private Aggregator agg;
	
	// All of the comments placed on the time slots in a 2D array
	private String[][] comments;
	
	
	

}
