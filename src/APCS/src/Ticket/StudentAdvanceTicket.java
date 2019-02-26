package Ticket;

public class StudentAdvanceTicket extends AdvanceTicket {

	public StudentAdvanceTicket(int newNumber, int newDaysLeft) {
		super(newNumber, newDaysLeft, 2);
	}
	
	public String toString() {
		return super.toString() + " (ID required)";
	}
}