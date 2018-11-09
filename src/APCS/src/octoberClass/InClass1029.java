package octoberClass;

import java.util.Scanner;

public class InClass1029 {

	public static void main(String[] args) {
		//printNums();
		
		//System.out.print(gcf(40, 21));
		System.out.println(reduce(15, -20));
		System.out.println(reduce(20, -10));
		System.out.println(reduce(-20, -10));
		System.out.println(reduce(0, -10));
		System.out.println(reduce(-10, 0));
		System.out.println(reduce(62_512_742, 62_520_649));

	}
	
	public static void printNums() {
		Scanner console = new Scanner(System.in);
		
		int sum = 0, totalAmnt = 0;
		double avg = 0;
		
		System.out.print("Enter an integer (0 to quit): ");
		int input = console.nextInt();
		
		while(input != 0) {
			if(input > 0)
				System.out.println("positive");
			else if (input < 0)
				System.out.println("negative");
			
			sum += input;
			totalAmnt++;
			
			System.out.print("Enter an integer (0 to quit): ");
			input = console.nextInt();
		}
		
		avg = (double)sum / totalAmnt;
		
		System.out.printf("sum: %d, amount: %d, average: %.2f", sum, totalAmnt, avg);
	}
	
	public static int gcf(int a, int b) {
		int gcfVal = 1, num = 1;
		
		while(num <= a && num <= b) {
			if(a % num == 0 && b % num == 0)
				gcfVal = num;
			
			num++;
		}
		num--;
		System.out.print("loops: " + num + "\t");
		
		return gcfVal;
	}
	
	public static String reduce(int numerator, int denominator) {
		String endStr = "";
		int gcf = 1;
		boolean nuNeg = false, deNeg = false;
		
		if(numerator < 0) {
			nuNeg = true;
			numerator = Math.abs(numerator);
		}
		
		if(denominator < 0) {
			deNeg = true;
			denominator = Math.abs(denominator);
		}
		
		gcf = gcf(numerator, denominator);
		
		if(nuNeg)
			numerator *= -1;
		if(deNeg)
			denominator *= -1;

		numerator /= gcf;
		denominator /= gcf;
		
		endStr = numerator + " / " + denominator;
		
		
		if(numerator == 0)
			endStr = numerator + " / " + denominator + " (or just 0)";
		else if(denominator == 0)
			endStr = "divide by zero error";
		else if(denominator == 1)
			endStr = numerator + " / " + denominator + " (or just " + numerator + ")";
		else if(denominator < 0 || numerator < 0) {
			if(denominator < 0 && numerator < 0)
				endStr = Math.abs(numerator) + " / " + Math.abs(denominator);
			else if (denominator < 0 || numerator < 0)
				endStr = "-" + Math.abs(numerator) + " / " + Math.abs(denominator);
		}
		
		
		return endStr;
	}
}