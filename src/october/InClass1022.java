package october;
import java.util.Scanner;

public class InClass1022 {

	public static void main(String[] args) {
//		for(int i = 1; i <= 1000; i++) {
//			if(isPerfect(i))
//				System.out.println(i);
//		}
		
	}
	
	public static boolean isPerfect(int n) {
		boolean perfect = false;
		int sum = printFactors(n);
		
		if(sum == (2 * n))
			perfect = true;
		
		return perfect;
	}
	
	public static int printFactors(int n) {
		int total = 0;
		
		for(int i = 1; i <= n; i++) {
			if(n % i == 0)
				total += i;
		}
		
		return total;
	}
	
	public static int getInteger() {
		Scanner console = new Scanner(System.in);
		
		System.out.print("Enter a positive integer: ");
		int n = console.nextInt();
		
		return n;
	}
	
	public static void questionOne() {
		int n = getInteger();
		
		int sum = 0;
		
		for(int i = 3; i <= n; i += 3)
			sum += i;
		
		System.out.print("Sum of all multiples of 3 between 1 and n = " + sum);
	}
	
	public static void questionTwo() {
		int n = getInteger();
		
		int sum = 0;
		
		for(int i = 1; i <= n; i++)
			sum += Math.pow(i, 2);
		
		System.out.print("Sum of squares = " + sum);
	}
	
	public static void questionThree() {
		int b = getInteger();
		int n = getInteger();

		int sum = 0;
		
		for(int i = 0; i <= n; i++)
			sum += Math.pow(b,  i);
		
		System.out.print(sum);
	}
	
	public static void questionFour() {
		int a = getInteger();
		int b = getInteger();
		
		int sum = 0;
		
		for(int i = a; i <= b; i++) {
			if(i % 2 ==0)
				sum += i;
		}
		
		System.out.print(sum);
	}
	
	public static void questionFive() {
		int n = getInteger();
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i = 1; i <= n; i++) {
			int newInt = getInteger();
			
			if(newInt < min)
				min = newInt;
			else if(newInt > max)
				max = newInt;
		}
		
		System.out.print(max - min);
	}
	
	public static void questionSix() {
		int n = getInteger();
		int num1 = 0;
		int num2 = 0;
		
		String finalStr = "";
		
		for(int i = 1; i <= n; i++) {
			if(i == 1) 
				num1 = getInteger();
			
			num2 = getInteger();
			
			if(num1 == num2)
				finalStr += num1 + " and " + num2 + " | ";
			
			num1 = num2;
		}
		
		System.out.print(finalStr);
	}
}
