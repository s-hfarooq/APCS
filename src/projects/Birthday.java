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
		//Header
		System.out.println("This program tells you how many days");
		System.out.println("it will be until your next birthday.\n");
		
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
		System.out.printf("What is the day   (1-%d)? ", daysInMonth);
		int day = console.nextInt();
		
		//Day of year
		int numberOfDays = numberOfDays(month, day);
		System.out.printf("%d/%d is day #%d of 365.\n\n", month, day, numberOfDays);
		
		return numberOfDays;
	}
	
	//Determines the amount of days in a month
	public static int daysInMonth(int months) {
		int daysInMonth = 0;
		if(months == 2)
			daysInMonth = 28;
		else if(months == 4 || months == 6 || months == 9 || months == 11)
			daysInMonth = 30;
		else
			daysInMonth = 31;
		
		return daysInMonth;
	}
	
	//Calculates the day of the year for a given date
	public static int numberOfDays(int inMonth, int inDay) {		
		for(int months = 1; months < inMonth; months++)
			inDay += daysInMonth(months);
		
		return inDay;
	}
	
	//Figures out which string to print based on days left
	public static void daysForBirthday(int today, int birthday) {
		//Determines days left until birthday
		int days = birthday - today;
		
		//If the birthday already occurred this year
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