//Hassan Farooq
//APCS P.5
//October 22, 2018
//
//Birthday project
//This program takes the current date and compares it to the users birthday to compute the days left

package projects;

import java.util.Scanner;

public class Birthday2 {
	
	public static void main(String[] args) {
		System.out.println("This program tells you how many days\nit will be until your next birthday.\n");
		
		//Gets today's date
		int[] getToday = getDateInput("today's date");
		int today = numberOfDays(getToday[0], getToday[1]);
		
		//Gets birthday date
		int[] getBirthday = getDateInput("your birthday");
		int birthday = numberOfDays(getBirthday[0], getBirthday[1]);
		
		//Calculates days left until birthday
		daysForBirthday(today, birthday);
	}
	
	//Gets user input for the dates
	public static int[] getDateInput(String version) {
		Scanner console = new Scanner(System.in);
		
		System.out.println("Please enter " + version + ": ");
		
		//Month
		System.out.print("What is the month (1-12)? ");
		int month = console.nextInt();
		
		int daysInMonth = daysInMonth(month);
		
		//Day
		System.out.printf("What is the day   (1-%d)? ", daysInMonth);
		int day = console.nextInt();
		
		return new int[] {month, day};
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
		int dayAmnt = inDay;
		
		for(int months = 1; months < inMonth; months++)
			dayAmnt += daysInMonth(months);
		
		System.out.printf("%d/%d is day #%d of 365.\n\n", inMonth, inDay, dayAmnt);
		
		return dayAmnt;
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
