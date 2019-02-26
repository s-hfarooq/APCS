package octoberClass;

import java.util.Scanner;

public class InClass108 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("What's the meal price? ");
		double mealPrice = console.nextDouble();
		System.out.print("What's the tip percentage? ");
		int tipPercent = console.nextInt();
		
		double tip = findTip(mealPrice, tipPercent);
		
		System.out.printf("A $%.2f meal plus $%.2f tip totals $%.2f", mealPrice, tip, mealPrice + tip);
		
//		Scanner console = new Scanner(System.in); 
//		System.out.print("Favorite number? ");
//		int num = console.nextInt();
//		System.out.print("Favorite color? ");
//		String color = console.next();
//		System.out.println("Favorite number = " + num + " favorite color = " + color);
//		console.close();
	}
	
	public static double findTip(double mealPrice, int tipPercent) {
		return mealPrice * tipPercent / 100.0;
	}
}