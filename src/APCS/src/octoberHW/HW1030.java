package octoberHW;

import java.util.Scanner;

public class HW1030 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		boolean done = false;
		
		while(!done) {
			System.out.print("Enter how many, min, and max (0 to exit): ");
			int howMany = console.nextInt();
			
			if(howMany != 0) {
				int min = console.nextInt();
				int max = console.nextInt();
				
				double theoreticalAvg = (double)(max + min) / 2;
				double randomAvg = randomAverage(min, max, howMany);
				double percentErr = ((randomAvg - theoreticalAvg) / theoreticalAvg) * 100.0;
				
				System.out.printf("theoretical avg: %.2f, random avg: %.2f, %% error: %.2f%%\n", 
														theoreticalAvg, randomAvg, percentErr);
			} else {
				System.out.println("EXIT");
				done = true;
			}
		}
	}
	
	public static double randomAverage(int min, int max, int howMany) {
		int total = 0, num = 0;
		int range = max - min;
		
		for(int amntMade = 0; amntMade < howMany - 1; amntMade++) {
			num = (int)(Math.random() * (range + 1)) + min;
			total += num;
			System.out.print(num + ", ");
		}
		
		num = (int)(Math.random() * (range + 1)) + min;
		total += num;
		System.out.println(num);
		
		double avg = (double)total / howMany;
		
		return avg;
	}
}
