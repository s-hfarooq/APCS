package octoberHW;

import java.util.Scanner;

import octoberClass.InClass1017;

public class HW1018 {

	public static void main(String[] args) {
		System.out.print("Enter a positive integer: ");
		Scanner console = new Scanner(System.in);
		int inNum = console.nextInt();
		
		double[] values = primes(inNum);
		
		System.out.println("\nSum = " + values[0]);
		System.out.printf("Average = %.2f", values[1]);
		
	}
	
	public static double[] primes(int number) {
		int totalPrimes = 0; //all primes added up
		int amnt = 0; //total number of prime values

		for(int i = 1; i <= number; i++) {
			if(InClass1017.isPrime(i)) {
				System.out.print(i + " ");
				totalPrimes += i;
				amnt++;
			}
		}
		
		double avg = (double)totalPrimes / amnt;
		
		return new double[] {totalPrimes, avg};
	}
}