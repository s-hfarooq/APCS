package novemberClass;

import java.util.Arrays;

public class InClass28 {

	public static void main(String[] args) {
		int[] x = {1, 2, 2, 3, 2, 4, 4};
		//int[] x = {5, 5, 5, 2, 3, 3, 5};
		System.out.print(countDuplicates(x));
	}
	
	public static int countDuplicates(int[] list) {
		int duplicates = 0;
		
		for(int i = 0; i < list.length - 1; i++) {
			if(list[i] == list[i + 1])
				duplicates++;
		}
		
		return duplicates;
	}
	
	public static void warmpup() {
		double[] values = new double[12];
		
		for(int i = 0; i < values.length; i++)
			values[i] = -3 * Math.pow((i - 5), 2) + 10;
		
		System.out.print("X:");
		for(int i = 0; i < values.length; i++)
			System.out.printf("%8d", i);
		System.out.print("\nY:");
		for(int i = 0; i < values.length; i++)
			System.out.printf("%8.1f", values[i]);
		
		//graph(values);
	}
	
	public static void graph(double[] values) {
		Arrays.sort(values);
		
		String[] rows = new String[5];
		System.out.println();
//		for(double y = values[11]; y > values[0]; y++) {
//			//System.out.print("|");
//			for(int j = 0; j < 5; j++) {
//				int amnt = 0;
//				if(amnt == values[j])
//					rows[j] += "*";
//				else
//					rows[j] += " ";
//				amnt++;
//			}
//
//		}
		
		System.out.print(rows[0]);
	}

}