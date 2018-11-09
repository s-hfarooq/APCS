package octoberHW;

public class Homework105 {

	//Size of table (rows and columns)
	public static final int SIZE = 4;

	public static void main(String[] args) {
		printTable();
	}
	
	//Prints out the table of values
	public static void printTable() {
		//Top of table
		System.out.print("    ");
		for(int rowNum = 1; rowNum <= SIZE; rowNum++)
			System.out.printf("%6d", rowNum);
		
		for(int rows = 1; rows <= SIZE; rows++) {
			System.out.println();
			
			//Side of table
			System.out.printf("%4d", rows);
			
			//Values
			for(int column = 1; column <= SIZE; column++) {
				double length = findHypot(rows, column);
				System.out.printf(" %5.2f", length);
			}
		}
	}
	
	//Returns hypotenuse of right triangle with given lengths
	public static double findHypot(double sideA, double sideB) {
		double hypot = Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2));
		return hypot;
	}
}