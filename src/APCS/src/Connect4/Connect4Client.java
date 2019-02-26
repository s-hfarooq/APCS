//Hassan Farooq
//APCS P.5
//Connect4 Project
//

package Connect4;

import java.util.Scanner;

public class Connect4Client {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		//Setup
		Connect4 c4 = new Connect4();
		char symb1 = '-', symb2 = '-';
		
		while(symb1 == '-') {
			System.out.print("Player 1 enter character (no '-'): ");
			symb1 = console.next().charAt(0);
		}
		
		while(symb2 == '-') {
			System.out.print("Player 2 enter character (no '-'): ");
			symb2 = console.next().charAt(0);
		}
		
		playerTurns(symb1, symb2, console, c4);
		
		//Ending
		if(c4.hasWon(symb1))
			System.out.println("Player 1 has won");
		else if(c4.hasWon(symb2))
			System.out.println("Player 2 has won");
		else
			System.out.println("A draw");		
	}
	
	//Player moves
	public static void playerTurns(char symb1, char symb2, Scanner console, Connect4 c4) {
		while(!c4.hasWon(symb1) && !c4.hasWon(symb2) && !c4.isFull()) {
			int p1Row = -1;
			boolean canMove = false;
			
			while(!canMove) {
				System.out.print("Player 1 row (1-7): ");
				p1Row = console.nextInt() - 1;
				
				canMove = c4.insert(p1Row, symb1);
			}
			
			System.out.println(c4);
			System.out.println();
			
			if(!c4.hasWon(symb1)) {
				canMove = false;
				
				while(!canMove) {
					System.out.print("Player 2 row (1-7): ");
					p1Row = console.nextInt() - 1;
					
					canMove = c4.insert(p1Row, symb2);
				}
				
				System.out.println(c4);
				System.out.println();
			}
		}
	}	
}