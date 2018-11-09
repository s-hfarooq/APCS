package octoberClass;

import java.util.Scanner;

public class InClass1011 {

	public static void main(String[] args) {
		//warmup();
		ifDemo();
	}
	
	public static void warmup() {
		Scanner console = new Scanner(System.in);
		
		System.out.print("Type a char: ");
		char inputChar = console.next().charAt(0);
		
		System.out.print("Type a positive integer: ");
		int inputInt = console.nextInt();
		
		for(int amount = 0; amount < inputInt; amount++)
			System.out.print(inputChar);
	}
	
	public static void ifDemo() {
		Scanner console = new Scanner(System.in);
		
		System.out.print("Enter a grade (9-12): ");
		int grade = console.nextInt();
		
		System.out.print("Your grade: " + getGrade(grade));
	}
	
	public static String getGrade(int grade) {
		String outputStr;
		
		if(grade == 9)
			outputStr = "Freshman";
		else if (grade == 10)
			outputStr = "Sophmore";
		else if (grade == 11)
			outputStr = "Junior";
		else if (grade == 12)
			outputStr = "Senior";
		else
			outputStr = "Invalid";
		
		return outputStr;
	}
}