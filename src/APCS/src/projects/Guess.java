//Hassan Farooq
//APCS P.5
//November 9, 2018
//Guessing game project
//
//A simple guessing game allowing the user to make guesses until they're right

package projects;

import java.util.Scanner;

public class Guess {
	
	//Max number to guess
	public static final int MAX_NUM = 100;
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		boolean isDone = false;
		int totalTrys = 0, totalGames = 0, bestGame = Integer.MAX_VALUE;
		
		introduction();
		
		//Repeat until the user wants to quit
		while(!isDone) {
			System.out.println();
			
			int trys = playGame(console);
			
			totalTrys += trys;
			totalGames++;
			
			//Find the least amount of guesses
			if(trys < bestGame)
				bestGame = trys;
			
			//Ask to play again
			System.out.print("Do you want to play again? ");
			String repeat = console.next().toLowerCase();
			
			//Quit if response doesn't start with y
			isDone = (repeat.charAt(0) != 'y');
		}
		
		//Print overall results
		results(totalGames, totalTrys, bestGame);
	}
	
	//Introduces game
	public static void introduction() {
		System.out.println("A simple integer guessing game");
		System.out.println("Guess until you get it right");
	}
	
	//Play the game
	public static int playGame(Scanner console) {
		//Intro
		System.out.println("I'm thinking of a number between 1 and " + MAX_NUM + "...");
		System.out.print("Your guess? ");
		
		//Random number
		int randNum = (int)(Math.random() * MAX_NUM) + 1;
		
		int numberOfTimes = 0;
		boolean isRight = false;
		
		//Repeat while the user is wrong
		while(!isRight) {
			int input = console.nextInt();
			
			//Print if guess is higher or lower - exit while loop if guess is right
			if(input > randNum) {
				System.out.println("It's lower.");
				System.out.print("Your guess? ");
			} else if(input < randNum) {
				System.out.println("It's higher.");
				System.out.print("Your guess? ");
			} else
				isRight = true;
			
			numberOfTimes++;		
		}
		
		//"guess" instead of "guesses" if only 1 guess
		String guessStr = (numberOfTimes == 1) ? " guess" : " guesses";
		
		//Final output
		System.out.println("You got it right in " + numberOfTimes + guessStr);
		
		return numberOfTimes;
	}
	
	//Prints out the overall results
	public static void results(int totalGames, int totalTrys, int bestGame) {
		System.out.println();
		System.out.println("Overall resuts:");
		System.out.println("    total games   = " + totalGames);
		System.out.println("    total guesses = " + totalTrys);
		System.out.printf("    guesses/game  = %.1f\n", ((double)totalTrys / totalGames));	
		System.out.println("    best game     = " + bestGame);
	}
}