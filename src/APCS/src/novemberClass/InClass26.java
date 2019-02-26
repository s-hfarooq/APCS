package novemberClass;

import java.util.Scanner;

public class InClass26 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		//warmup(console);
		//doubleArrays(console);
		warmupArray(console);
		
		console.close();
	}
	
	public static void warmupArray(Scanner console) {
		System.out.print("How many days? ");
		int days = console.nextInt();
		
		int totalTemp = 0, aboveAvg = 0;
		int hottestDay = Integer.MIN_VALUE, coldestDay = Integer.MAX_VALUE;
		int[] temps = new int[days];
		
		for(int i = 1; i <= days; i++) {
			System.out.print("Enter Day " + i + "'s high temp: ");
			int nextTemp = console.nextInt();
			temps[i - 1] = nextTemp;
			totalTemp += nextTemp;
		}
		
		double avg = (double)totalTemp / days;
		
		for(int i = 0; i < temps.length; i++) {
			if(temps[i] >= avg)
				aboveAvg++;
			if(temps[i] > hottestDay)
				hottestDay = temps[i];
			else if(temps[i] < coldestDay)
				coldestDay = temps[i];
		}
		
		System.out.println();
		System.out.printf("Average: %.2f\n", avg);
		System.out.printf("Days above average: %d\n", aboveAvg);
		System.out.printf("Degrees above avg for hottest day: %.2f\n", (hottestDay - avg));
		System.out.printf("Degrees below avg for coldest day: %.2f\n", (coldestDay - avg));
		
		System.out.println("Temp in reverse: ");
		for(int i = temps.length - 1; i >= 0; i--)
			System.out.println("\t" + temps[i]);
	}
	
	public static void warmup(Scanner console) {
		System.out.print("How many days? ");
		int days = console.nextInt();
		int totalTemp = 0;
		
		for(int i = 1; i <= days; i++) {
			System.out.print("Enter Day " + i + "'s high temp: ");
			totalTemp += console.nextInt();
		}
		
		double avg = (double)totalTemp / days;
		
		System.out.printf("Average: %.1f", avg);
	}
	
	public static void doubleArrays(Scanner console) {
		System.out.print("length of array: ");
		int len = console.nextInt();
		
		double[] numbers = new double[len];
		
		for(int i = 0; i < len; i++)
			numbers[i] = Math.sqrt(i);
		
		for(int i = len - 1; i >= 0; i--)
			System.out.printf("sqrt of %d is %.2f\n", i, numbers[i]);
	}
}