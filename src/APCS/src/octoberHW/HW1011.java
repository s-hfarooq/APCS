package octoberHW;

import java.util.Scanner;

public class HW1011 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		while(true) {
		System.out.print("Month: ");
		int month = console.nextInt();
		System.out.print("Date: ");
		int day = console.nextInt();
		System.out.println(season(month, day));}
		/*
		System.out.print("Grade: ");
		int grade = console.nextInt();
		System.out.printf("%.1f", getGrade(grade));*/
	}
	
	//Question 3
	public static String season(int month, int day) {
		String season = "invalid";

		if(month <= 3) 
			season = seasonV(month, day, 3, "winter", "spring");
		else if (month > 3 && month <= 6)
			season = seasonV(month, day, 6, "spring", "summer");
		else if (month > 6 && month <= 9)
			season = seasonV(month, day, 9, "summer", "fall");
		else
			season = seasonV(month, day, 12, "fall", "winter");
		
		return season;
	}
	
	public static String seasonV(int month, int day, int monLast, String option1, String option2) {
		String season = "";
		
		if(month == monLast && day <= 15)
			season = option1;
		if(month == monLast && day > 15)
			season = option2;
		else
			season = option1;
		
		return season;
	}
	
	//Question 15
	public static double getGrade(int grade) {
		double gradeVal = 0;
		
		if(grade < 60)
			gradeVal = 0.0;
		else if(grade > 60 && grade < 62)
			gradeVal = 0.7;
		else if(grade > 62 || grade < 95) 
			gradeVal = 0.1 * (grade - 55);
		else if (grade >= 95)
			gradeVal = 4.0;
		
		return gradeVal;
	}
}