package novemberClass;

import java.util.Scanner;

public class InClass27 {
	
	public static final double TAX_AMNT = 0.108;
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		System.out.print("Item amount: ");
		int amnt = console.nextInt();
		
		double[] prices = new double[5];
		int[] howMany = new int[5];
		double totalAmnt = 0;
		int totalItems = 0;
		
		for(int i = 0; i < amnt; i++) {
			System.out.print("Price of item " + (i + 1) + ": ");
			prices[i] = console.nextDouble();
			System.out.print("Amont of item " + (i + 1) + ": ");
			howMany[i] = console.nextInt();
		}		
		
		System.out.println();
		System.out.println("      Item  Quantity     Price       Tax  Subtotal");
		for(int i = 0; i < amnt; i++) {
			double tax = prices[i] * TAX_AMNT;
			double total = (prices[i] + tax) * howMany[i];
			
			totalAmnt += total;
			totalItems += howMany[i];
			
			System.out.printf("%10d%10d   $%6.2f   $%6.2f   $%6.2f\n", i + 1, howMany[i], prices[i], tax, total);
		}
		
		System.out.printf("\n     Total%33s$%6.2f", "", totalAmnt);

		double averagePrice = totalAmnt / totalItems;
		int amntAbove = 0;
		for(int i = 0; i < amnt; i++) {
			if(prices[i] >= averagePrice)
				amntAbove += howMany[i];
		}
		
		System.out.printf("\n\nAverage: $%.2f, total items: %d, amount above average: %d", averagePrice, totalItems, amntAbove);
	}
}