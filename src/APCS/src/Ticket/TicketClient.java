package Ticket;

public class TicketClient {

	public static void main(String[] args) {
		int num = 1;
		
		WalkupTicket wt = new WalkupTicket(num);
		System.out.println("WalkupTicket - " + wt);
		num++;
		
		AdvanceTicket at = new AdvanceTicket(num, 5, 1);
		System.out.println("AdvanceTicket - " + at);
		num++;
		
		StudentAdvanceTicket sat = new StudentAdvanceTicket(num, 5);
		System.out.println("StudentAdanceTicket - " + sat);
		num++;		
	}
}