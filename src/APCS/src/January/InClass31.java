package January;

import java.util.Arrays;

public class InClass31 {
	
	public static void main(String[] args) {
		String[][] movies = {{"a", "f", "178"},
							 {"b", "c", "124"}};
		
		System.out.println(Arrays.toString(movies));
		
		String[] movies2 = {"a", "f", "178"};
		System.out.println(Arrays.toString(movies2));
	}
	
//	public static double maxTempC(FoodItem[] items) {
//		double max = Double.MIN_VALUE;
//		
//		for(int i = 0; i < items.length; i++) {
//			double tempVal = items[i].getCelsius();
//			if(tempVal > max)
//				max = tempVal;
//		}
//		
//		return max;
//	}
}