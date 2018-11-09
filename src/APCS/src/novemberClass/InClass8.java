package novemberClass;

import java.util.Scanner;

public class InClass8 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		noWords(console);
	}
	
	public static void noWords(Scanner console) {
		System.out.println("Enter some words (exit with \"stop\"): ");
		
		String input = console.next();
		int numOfNo = 0;
		
		while(!input.equals("stop")) {
			int len = input.length();
			
			if(len >= 2 && input.charAt(len - 2) == 'n' && input.charAt(len - 1) == 'o')
				numOfNo++;
			
			input = console.next();
		}
		
		System.out.print("Words ending with no: " + numOfNo);
	}
}