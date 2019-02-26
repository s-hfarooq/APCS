package HW1211;

import java.util.Arrays;

public class CardsClient {

	public static void main(String[] args) {
		Cards cds = new Cards();
				
		String[] order = {"h", "h", "h", "h", "h", "h", "h", "h", "h", "h", "h", "h", "h",
				  		  "s", "s", "s", "s", "s", "s", "s", "s", "s", "s", "s", "s", "s",
				  		  "c", "c", "c", "c", "c", "c", "c", "c", "c", "c", "c", "c", "c", 
				  		  "d", "d", "d", "d", "d", "d", "d", "d", "d", "d", "d", "d", "d"};
		
		cds.setCards(order);
		System.out.println("Original order: " + cds);
		
		cds.shuffle();
		System.out.println("Shuffled order: " + cds);
		
		cds.dealCards(10);
		System.out.println("Dealt: " + Arrays.toString(cds.getDealt()));
		
		cds.setValues();	
		System.out.println("Hearts: " + cds.getHearts() + 
						   ", spades: " + cds.getSpades() + 
						   ", clubs: " + cds.getClubs() + 
						   ", diamonds: " + cds.getDiamonds());
		
		
		System.out.println();
		System.out.println();
		
		Cards cds2 = new Cards();
		String[] order2 = {"d", "d", "d", "d", "d", "d", "d", "d", "d", "d", "d", "d", "d",
						   "h", "h", "h", "h", "h", "h", "h", "h", "h", "h", "h", "h", "h",
						   "c", "c", "c", "c", "c", "c", "c", "c", "c", "c", "c", "c", "c", 
						   "s", "s", "s", "s", "s", "s", "s", "s", "s", "s", "s", "s", "s"};

		cds2.setCards(order2);
		System.out.println("Original order (2): " + cds2);
		
		cds2.shuffle();
		System.out.println("Shuffled order: " + cds2);
		
		cds2.dealCards(10);
		System.out.println("Dealt: " + Arrays.toString(cds2.getDealt()));
		
		cds2.setValues();	
		System.out.println("Hearts: " + cds2.getHearts() + 
						   ", spades: " + cds2.getSpades() + 
						   ", clubs: " + cds2.getClubs() + 
						   ", diamonds: " + cds2.getDiamonds());
	}
}