package octoberClass;

import java.util.Scanner;

public class InClass1026 {

	public static void main(String[] args) {
		//oddCountdown(9);
		enterInt();
	}
	
	public static void oddCountdown(int start) {
		for(int i = start; i > 2; i--) {
			if(i % 2 != 0)
				System.out.print(i + "...");
		}
		
		if(start <= 0)
			System.out.print("Invalid entry");
		else
			System.out.print(1);
	}
	
	public static void enterInt() {
		Scanner console = new Scanner(System.in);
		
		int sum = 0, totalAmnt = 0;
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		double avg = 0;
		
		System.out.print("Enter an integer (-1 to quit): ");
		
		int input = console.nextInt();
		
		while(input != -1) {
			sum += input;
			if(input > max)
				max = input;
			else if(input < min)
				min = input;
			
			System.out.print("Enter an integer (-1 to quit): ");
			input = console.nextInt();
			
			totalAmnt++;
		}
		
		min = -9;
		
		avg = (double)sum / totalAmnt;
		
		System.out.printf("Sum: %d, max: %d, min: %d, avg: %.2f", sum, max, min, avg);
	}
}