package projects;
//Hassan Farooq
//10-03-2018
//APCS P.5
//Space Needle
//
//This project prints a scalable ASCII Space Needle

public class SpaceNeedle {
	
	//Defines the size of the printed Space Needle
	public static final int SIZE = 4;

	public static void main(String[] args) {
		//Needle
		needle();
		
		//Top section
		base();
		topUnderside();
		
		//Midsection
		needle();
		midsection();
		
		//Base
		base();
	}
	
	//Prints out the top needle as well as the repeated shape near the middle
	public static void needle() {
		//Print values while row < SIZE
		for(int row = 0; row < SIZE; row++) {
			//Print spaces until 3*SIZE
			for(int spaces = 0; spaces < (3 * SIZE); spaces++)
				System.out.print(" ");
			
			System.out.println("||");
		}
	}
	
	//Prints out the bottom half of the top piece
	public static void topUnderside() {
		System.out.println();
		//Prints values while row < SIZE
		for(int row = 0; row < SIZE; row++) {
			//Prints spaces until 2 * row
			for(int spaces = 0; spaces < (2 * row); spaces++)
				System.out.print(" ");
			
			System.out.print("\\_/");
			
			//Prints out \/ for (3 * SIZE - (2 * (row+1))
			for(int slashes = 0; slashes < ((3 * SIZE) - (2 * (row + 1))); slashes++)
				System.out.print("\\/");
			
			System.out.println("\\_/");
		}
	}
	
	//Prints out the midsection of the Space Needle
	public static void midsection() {
		//Makes SIZE^2 rows 
		for(int row = 0; row < Math.pow(SIZE, 2); row++) {
			//Adds (SIZE * 2) + 1 leading spaces for every line
			for(int spaces = 0; spaces < (2 * SIZE) + 1; spaces++)
				System.out.print(" ");
			
			//Prints out |%| (amount of % = SIZE - 2)
			for(int midPart = 0; midPart < 2; midPart++) {
				System.out.print("|");
				for(int percentSg = 0; percentSg < (SIZE - 2); percentSg++)
					System.out.print("%");
				System.out.print("|");
			}
			
			System.out.println();
		}
	}
	
	//Prints out the base and top half of the top piece
	public static void base() {
		//Makes SIZE rows
		for(int row = 0; row < SIZE; row++) {
			//Prints spaces for (3 * SIZE) - (3 * (row + 1))
			for(int spaces = 0; spaces < (3 * SIZE) - (3 * (row + 1)); spaces++)
				System.out.print(" ");
			
			System.out.print("__/");
			
			//Prints colons for 3 * row
			for(int colon = 0; colon < (3 * row); colon++)
				System.out.print(":");
			
			System.out.print("||");
			
			//Prints colons for 3 * row
			for(int colon = 0; colon < (3 * row); colon++)
				System.out.print(":");
			
			System.out.println("\\__");
		}
		
		//Prints the bottom line (|""|)
		System.out.print("|");
		for(int quotes = 0; quotes < (6 * SIZE); quotes++)
			System.out.print("\"");
		System.out.print("|");
	}
}