package BigBang;

import java.util.Scanner;

public class BigBangClient {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int choice = 0;
		
		while(choice != 1 && choice != 2) {
			System.out.println("1. computer vs computer");
			System.out.println("2. user vs computer");
			System.out.print("\tPick one (1 or 2): ");
			
			choice = console.nextInt();
		}
		
		System.out.println();
		
		if(choice == 1)
			compVsComp();
		else
			compVsUsr(console);
		
		console.close();		
	}
	
	public static void compVsComp() {
		BigBang pl1 = new BigBang("Computer 1");
		BigBang pl2 = new BigBang("Computer 2");
		int gameAmnt = 1;
		
		while(!pl1.isEliminated() && !pl2.isEliminated()) {
			pl1.newSymbol();
			pl2.newSymbol();
			System.out.println("\tGame #" + gameAmnt);			
			
			BigBang.challenge(pl1, pl2);
			
			System.out.println(pl1.getName() + ": " + pl1.getLastSymbol());
			System.out.println(pl2.getName() + ": " + pl2.getLastSymbol());
			
			System.out.println(pl1);
			System.out.println(pl2);
			
			System.out.println();
			gameAmnt++;
		}
	}
	
	public static void compVsUsr(Scanner console) {
		System.out.print("Enter user name: ");
		String name = console.next();
		
		BigBang pl1 = new BigBang("Computer");
		BigBang pl2 = new BigBang(name);
		int gameAmnt = 1;
		
		while(!pl1.isEliminated() && !pl2.isEliminated()) {
			String usrIn = "";
			String[] val = {"ROCK", "PAPER", "SCISSORS", "LIZARD", "SPOCK"};
			
			while(!usrIn.equals(val[0]) && !usrIn.equals(val[1]) && !usrIn.equals(val[2]) && !usrIn.equals(val[3]) && !usrIn.equals(val[4])) {
				System.out.print("Enter rock, paper, scissors, lizard, or spock: ");
				usrIn = console.next().toUpperCase();
			}
			
			pl1.newSymbol();
			pl2.setSymbol(usrIn);
			System.out.println("\tGame #" + gameAmnt);			
			
			BigBang.challenge(pl1, pl2);
			
			System.out.println(pl1.getName() + ": " + pl1.getLastSymbol());
			System.out.println(pl2.getName() + ": " + pl2.getLastSymbol());
			
			System.out.println(pl1);
			System.out.println(pl2);
			
			System.out.println();
			System.out.println();
			gameAmnt++;
		}
	}
}