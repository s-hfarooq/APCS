//Hassan Farooq
//APCS P.5
//October 22, 2018
//
//Birthday project
//This program takes the current date and compares it to the users birthday to compute the days left

package projects;

import java.util.Scanner;

public class Birthday {
	
	public static void main(String[] args) {
		System.out.println("This program tells you how many days\nit will be until your next birthday.\n");
		
		//Gets today's date + birthday date
		int today = getDateInput("today's date");
		int birthday = getDateInput("your birthday");
		
		//Calculates days left until birthday
		daysForBirthday(today, birthday);
	}
	
	//Gets user input for the dates
	public static int getDateInput(String version) {
		Scanner console = new Scanner(System.in);
		
		System.out.println("Please enter " + version + ": ");
		
		//Month
		System.out.print("What is the month (1-12)? ");
		int month = console.nextInt();
		
		int daysInMonth = daysInMonth(month);
		
		//Day
		System.out.printf("What is the date  (1-%d)? ", daysInMonth);
		int day = console.nextInt();
		
		//Day of year
		int numberOfDays = numberOfDays(month, day);
		System.out.printf("%d/%d is day #%d of 365.\n\n", month, day, numberOfDays);
		
		return numberOfDays;
	}
	
	//Calculates the day of the year for a given date
	public static int numberOfDays(int inMonth, int gDay) {
		int totalDays = gDay;
		
		for(int months = 1; months < inMonth; months++)
			totalDays += daysInMonth(months);
		
		return totalDays;
	}

	//Determines the amount of days in a month
	public static int daysInMonth(int months) {
		int totalDays = 0;
		if(months == 2)
			totalDays = 28;
		else if(months == 4 || months == 6 || months == 9 || months == 11)
			totalDays = 30;
		else
			totalDays = 31;
		
		return totalDays;
	}
	
	//Figures out which string to print based on days left
	public static void daysForBirthday(int today, int birthday) {
		//Determines days left until birthday
		int days = birthday - today;
		//If birthday already occurred this year, figure out days until the next one
		if(days < 0)
			days += 365;
		
		if(days == 0)
			System.out.print("Happy birthday!");
		else if(days == 1)
			System.out.print("Wow, your birthday is tomorrow!");
		else
			System.out.printf("Your next birthday is in %d days.", days);
	}
}