// Hassan Farooq P.5
// March 19, 2019
// HanoiBoard project
// HanoiClient
//

import java.util.Scanner;

public class HanoiClient {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		int size = 0;
		while(size < 1 || size > 9) {
			System.out.print("Size of board (1-9)? ");
			size = console.nextInt();
		}
		
		int version = -1;
		while(version < 0 || version > 1) {
			System.out.print("Computer (0) or human (1)? ");
			version = console.nextInt();
		}
		
		HanoiBoard hb = new HanoiBoard(size);
		System.out.println();
		
		if(version == 0)
			computerPlay(console, size, hb);
		else
			humanPlay(console, hb);
		
		System.out.println("\n\nEnd");
		console.close();
	}
	
	public static void computerPlay(Scanner console, int size, HanoiBoard hb) {
		int to = -1, extra = 1;
		while(to < 1 || to > 2) {
			System.out.print("To position (1 or 2)? ");
			to = console.nextInt();
		}
		
		if(to == 1)
			extra = 2;
		
		System.out.println(hb);
		
		hb.compPlay(size, 0, to, extra);
		System.out.println(hb);
	}
	
	public static void humanPlay(Scanner console, HanoiBoard hb) {
		System.out.println(hb);
		
		int pos1 = 0, pos2 = 0;
		
		while(pos1 > -1 && pos1 < 3 && pos2 > -1 && pos2 < 3) {
			System.out.print("From/to positions (0-2, others to quit): ");
			pos1 = console.nextInt();
			pos2 = console.nextInt();
			
			if(pos1 > -1 && pos1 < 3 && pos2 > -1 && pos2 < 3) {
				hb.move(pos1, pos2);
				System.out.println(hb);
			}
			
			System.out.println();
		}
	}
}