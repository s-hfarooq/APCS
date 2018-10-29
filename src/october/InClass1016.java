package october;

import java.util.Scanner;

public class InClass1016 {

	public static void main(String[] args) {
		//System.out.print("Quadrant " + quadrant(-4.2, 17.3));
		//fizzBuzz();

		printFactors(96);
		
//		String output = rpcInput();
//		if(output.equals("tie"))
//			System.out.print("Tie");
//		else
//			System.out.print("Player " + output + " wins");
	}
	
	public static int quadrant(double x, double y) {
		int quadrant = 0;
		
		if(x > 0 && y > 0)
			quadrant = 1;
		else if(x < 0 && y > 0)
			quadrant = 2;
		else if(x < 0 && y < 0)
			quadrant = 3;
		else if(x > 0 && y < 0)
			quadrant = 4;
		
		return quadrant;
	}
	
	public static void fizzBuzz() {
		for(int i = 1; i <= 100; i++) {
			if(i % 3 == 0)
				System.out.print("Fizz");
			if(i % 5 == 0)
				System.out.print("Buzz");
			else if(i % 3 != 0 && i % 5 != 0)
				System.out.print(i);
			
			System.out.println();
		}
	}
	
	public static void printFactors(int n) {
		for(int i = 1; i <= n; i++) {
			if(n % i == 0)
				System.out.print(i + " ");
		}
	}
	
	public static String rpcInput() {
		Scanner console = new Scanner(System.in);
		
		System.out.print("Player 1 - rock, paper, or scissors? ");
		String player1 = console.next();
		System.out.print("Player 2 - rock, paper, or scissors? ");
		String player2 = console.next();
		
		return rockPaperScissors(player1, player2);
	}
	
	public static String rockPaperScissors(String player1, String player2) {
		String output = "";
		
		if (player1.equals(player2))
			output = "tie";
		else if (player1.equals("rock")) {
			if (player2.equals("scissors"))
				output = "1";
			else
				output = "2";
		} else if (player1.equals("paper")) {
			if (player2.equals("scissors"))
				output = "2";
			else
				output = "1";
		} else if (player1.equals("scissors")) {
			if (player2.equals("paper"))
				output = "1";
			else
				output = "2";
		}
		
		return output;
	}
}