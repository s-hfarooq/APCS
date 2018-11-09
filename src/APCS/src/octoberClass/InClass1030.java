package octoberClass;

import java.util.Scanner;

public class InClass1030 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		//not30(console);
		
		//System.out.print((int)(Math.random() * 5) + 3); //3-7
		System.out.print((int)(Math.random() * -86) - 7); //[-92, -7]
	}
	
	public static void not30(Scanner input) {
		int num1 = 0, num2 = 0, sum = 0, product = 1;
		boolean isDone = false;	
		
		while(!isDone) {
			System.out.print("Enter 2 more numbers: ");
			num1 = input.nextInt();
			num2 = input.nextInt();
			
			sum = num1 + num2;
			product = num1 * num2;
			
			if(sum < 30 && product > 30)
				isDone = true;
			else
				System.out.println("Doesn't meet requirements...");
		}
		
		System.out.printf("Numbers: %d & %d, sum: %d, product: %d", num1, num2, sum, product);
	}
}