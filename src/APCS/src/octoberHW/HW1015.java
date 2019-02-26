package octoberHW;

import java.util.Scanner;

public class HW1015 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		printGPA(console);
	}
	
	public static void printGPA(Scanner console) {
		System.out.print("Enter a student record: ");
		String name = console.next();
		int totalAmnt = console.nextInt();
		
		int numerator = 0;
		
		for(int gradeAmnt = 0; gradeAmnt < totalAmnt; gradeAmnt++)
			numerator += console.nextInt();
		
		double finalGrade = (double)numerator / totalAmnt;
		
		System.out.printf("%s's grade is %.2f", name, finalGrade);
	}
}