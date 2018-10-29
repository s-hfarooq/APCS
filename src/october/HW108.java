package october;

import java.util.Scanner;

public class HW108 {

	public static void main(String[] args) {
		int[] pointOne = getPoints("First");
		int[] pointTwo = getPoints("Second");
		
		double distance = findDistance(pointOne[0], pointOne[1], pointTwo[0], pointTwo[1]);
		
		System.out.printf("\nThe distance between (%d, %d) and (%d, %d) is %.2f", pointOne[0], 
																					  pointOne[1], 
																					  pointTwo[0], 
																					  pointTwo[1], 
																					  distance);
	}
	
	public static double findDistance(int x1, int y1, int x2, int y2) {
		double distance;
		distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
		return distance;
	}
	
	public static int[] getPoints(String version) {
		Scanner console = new Scanner(System.in);

		System.out.print(version + " point? (enter in x,y format) ");
		
		String coordinate = console.nextLine();
		
		String[] split = coordinate.split(",");
		
		int x = Integer.parseInt(split[0]);
		int y = Integer.parseInt(split[1]);
		
		return new int[] {x, y};
	}
}