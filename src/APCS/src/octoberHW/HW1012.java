package octoberHW;

import java.util.Scanner;

public class HW1012 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		System.out.print("Enter 3 colors (ie. red yellow green): ");
		String wire1 = console.next();
		String wire2 = console.next();
		String wire3 = console.next();
		
		System.out.print(wireToCut(wire1, wire2, wire3));
	}
	
	public static String wireToCut(String wire1, String wire2, String wire3) {
		String output = "Cut the last (" + wire3 + ") wire.";
		int blueWires = 0;
		
		if(!wire1.equals("red") && !wire2.equals("red") && !wire3.equals("red"))
			output = "Cut the second (" + wire2 + ") wire.";
		else if(wire3.equals("white"))
			output = "Cut the last (" + wire3 + ") wire.";
		else if(wire1.equals("blue") || wire2.equals("blue") || wire3.equals("blue")) {
			if(wire1.equals("blue"))
				blueWires++;
			if(wire2.equals("blue"))
				blueWires++;
			if(wire3.equals("blue"))
				blueWires++;
			
			if(blueWires > 1)
				output = "Cut the last blue wire";
		}
		
		return output;
	}
}