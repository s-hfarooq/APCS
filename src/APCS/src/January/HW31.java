package January;

import java.util.Arrays;

public class HW31 {

	public static void main(String[] args) {
		printMonth(28, 6);
		System.out.println();
		printMonth(31, 7);
	}
	
	public static void printMonth(int days, int start) {
		int[][] month = new int[days / 7 + 1][7];
		
		start -= 2;
		int day = 1;
		boolean hasStarted = false;
		
		//Set the basic values
		for(int i = 0; i < month.length; i++) {
			for(int j = 0; j < month[i].length; j++) {
				if(i == 0 && j > start) {
					month[i][j] = day;
					day++;
					hasStarted = true;
				} else if(hasStarted) {
					month[i][j] = day;
					day++;
				}
			}
		}
		
		boolean removeRow = true;
		int lastRow = month.length - 1;
		
		//Removes last row if blank
		for(int i = 0; i < month[lastRow].length; i++) {
			if(month[lastRow][i] != 0)
				removeRow = false;
		}
		
		if(removeRow)
			month = Arrays.copyOf(month, month.length - 1);
		
		boolean needsNextRow = true;
		
		//Removes all values greater than amount of days
		lastRow = month.length - 1;
		for(int i = 0; i < month[lastRow].length; i++) {
			if(month[lastRow][i] > days)
				month[lastRow][i] = 0;
			
			if(month[lastRow][i] == days)
				needsNextRow = false;
		}
		
		//Adds another row if some dates are missing
		if(needsNextRow) {
			int[][] temp = new int[month.length + 1][7];
			for(int i = 0; i < month.length; i++)
				temp[i] = month[i];
			
			for(int i = 0; i < temp[month.length - 1].length; i++) {
				int val = month[month.length - 1][6] + i;
				if(val <= days)
					temp[temp.length - 1][i] = val;
			}
			
			month = temp;
		}
		
		//Print
		System.out.println("DAYS: " + days + ", START: " + (start + 2));
		for(int i = 0; i < month.length; i++) {
			for(int j = 0; j < month[i].length; j++) {
				System.out.printf("%2d ", month[i][j]);
			}
			
			System.out.println();
		}
	}
}