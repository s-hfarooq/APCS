package Ticket;

public class Ticket {
	private int number;
	private double price;
	
	public Ticket(int newNumber, int newDaysLeft, int type) {
		int newPrice = 0;
		
		if(type == 1 && newDaysLeft <= 10)
			newPrice = 40;
		else if(type == 1 && newDaysLeft > 10)
			newPrice = 30;
		else if(type == 2 && newDaysLeft <= 10)
			newPrice = 20;
		else if(type == 2 && newDaysLeft > 10)
			newPrice = 15;
		else
			newPrice = 50;
		
		number = newNumber;
		price = newPrice;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String toString() {
		return "Number: " + number + ", Price: " + price; 
	}
}
