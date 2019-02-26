package octoberClass;

import java.util.Scanner;

public class InClass1018 {

	public static void main(String[] args) {
		printValues();
	}
	
	public static void printValues() {
		int sum = 0;
		int valMax = Integer.MIN_VALUE;
		int valMin = Integer.MAX_VALUE;
		double valAvg = 0;
		
		Scanner console = new Scanner(System.in);
		
		System.out.print("Integer amount: ");
		int inAmnt = console.nextInt();
		System.out.print("Values: ");
		
		for(int i = 0; i < inAmnt; i++) {
			int value = console.nextInt();
			
			sum += value;
			
			if(value > valMax)
				valMax = value;
			else if(value < valMin)
				valMin = value;
		}
		
		valAvg = (double)sum / inAmnt;
		
		System.out.printf("Sum: %d, min: %d, max: %d, avg: %.2f", sum, valMin, valMax, valAvg);
	}
	
	public static int addEven(int n) {
		if(n > 0)
			n = addEvenPos(n);
		else
			n = addEvenNeg(n);
		
		return n;
	}
	
	public static int addEvenPos(int n) {
		int sum = 0;
		
		for(int i = 0; i <= n; i+=2)
			sum += i;
		
		return sum;
	}
	
	public static int addEvenNeg(int n) {
		int sum = 0;
		
		for(int i = 0; i >= n; i-=2)
			sum += i;
		
		return sum;
	}
}