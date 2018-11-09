package octoberHW;
import java.util.Scanner;

public class HW1022 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		System.out.println("Programs:");
		System.out.println("\t1. Return the sum of all multiples of 3 between 1 and n");
		System.out.println("\t2. Return the sum of all squares between 1 and n");
		System.out.println("\t3. Return the sum of all powers of b from b^0 to b^n");
		System.out.println("\t4. Return the sum of all odd numbers between a and b");
		System.out.println("\t5. Return the range of a set of n numbers");
		System.out.println("\t6. Print all adjacent duplicates from a set of n numbers");
		System.out.print("Which program (1-6)? ");
		
		int version = console.nextInt();
		
		String outStr = "Not a valid option";
		
		if(version == 1)
			outStr = "Sum of all multiples of 3 between 1 and n: " + questionOne(console);
		else if(version == 2)
			outStr = "Sum of squares: " + questionTwo(console);
		else if(version == 3)
			outStr = "Sum of all powers of b from b^0 to b^n: " + questionThree(console);
		else if(version == 4)
			outStr = "Sum of all positive integers between the values: " + questionFour(console);
		else if(version == 5)
			outStr = "Range: " + questionFive(console);
		else if(version == 6)
			outStr = "Duplicates: " + questionSix(console);
		
		System.out.print(outStr);
	}
	
	public static int questionOne(Scanner console) {
		System.out.print("Enter a positive integer: ");
		int n = console.nextInt();
		
		int sum = 0;
		
		for(int i = 3; i <= n; i += 3)
			sum += i;
		
		return sum;
	}
	
	public static int questionTwo(Scanner console) {
		System.out.print("Enter a positive integer: ");
		int n = console.nextInt();
		
		int sum = 0;
		
		for(int i = 1; i <= n; i++)
			sum += Math.pow(i, 2);
				
		return sum;
	}
	
	public static double questionThree(Scanner console) {
		System.out.print("Base: ");
		int b = console.nextInt();
		
		System.out.print("Final exponent: ");
		int n = console.nextInt();

		double sum = 0;
		
		for(int i = 0; i <= n; i++)
			sum += Math.pow(b, i);
		
		return sum;
	}
	
	public static int questionFour(Scanner console) {
		System.out.print("Lower limit: ");
		int a = console.nextInt();
		
		System.out.print("Upper limit: ");
		int b = console.nextInt();
		
		int sum = 0;
		
		for(int i = a; i <= b; i++) {
			if(i % 2 == 1)
				sum += i;
		}
				
		return sum;
	}
	
	public static int questionFive(Scanner console) {
		System.out.print("Enter amount: ");
		int n = console.nextInt();
		
		System.out.print("Numbers: ");
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i++) {
			int nextNum = console.nextInt();
			
			if(nextNum < min)
				min = nextNum;
			else if(nextNum > max)
				max = nextNum;
		}
		
		return (max - min);
	}
	
	public static String questionSix(Scanner console) {
		System.out.print("Enter amount: ");
		int n = console.nextInt();
		
		String finalStr = "";
		
		System.out.print("Numbers: ");
		
		int[] numbers = new int[n];
		
		for(int i = 0; i < n; i++)
			numbers[i] = console.nextInt();
		
		for(int i = 0; i < n - 1; i++) {
			if(numbers[i] == numbers[i + 1])
				finalStr += numbers[i] + " and " + numbers[i + 1] + ", ";
		}
		
		if(finalStr.equals(""))
			finalStr = "No adjacent duplicates";
		else
			finalStr = finalStr.replaceAll(", $", ""); //removes trailing comma
		
		return finalStr;
	}
}