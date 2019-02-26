
public class GeoClient {

	public static void main(String[] args) {
		//Creates points
		Point p1 = new Point(2, 3);
		Point p2 = new Point(-1, 5);
		//Point p3 = new Point(4, 8);

		//Creates lines
		Line l1 = new Line(p1, p2);
		Line l2 = new Line(2, -3);
		
		//Prints 2 lines
		System.out.println("Line 1: " + l1);
		System.out.println("Line 2: " + l2);
		
		//Checks if point is on line
		//System.out.println("On line (" + p1 + "): " + l1.isOnLine(p1));
		
		//Calls accessor methods to print line
		System.out.printf("Line 1 accessor: y = %.1fx + %.1f \n", l1.getSlope() , l1.getYInt());
		
		//Alters l1 then prints it
		l1.translateY(-2);
		//l1.setSlope(15);
		System.out.println("Line 1 changed: " + l1);
	}
	
	public static void pointOnly() {
		Point p1 = new Point(2, 3);
		Point p2 = new Point(3, 7);
		Point p3 = new Point(2, 4);
		
//		p1.setCoordinates(2, 3);
//		p2.setCoordinates(3, 7);
//		p3.setCoordinates(2, 4);
		
		boolean vert = p1.isVertical(p3);
		double dist = p1.getDistance(p2);
		
		System.out.printf("Distance: %.2f\n", dist);
		System.out.println("1: " + p1);
		System.out.println("3: " + p3);
		System.out.println("1/3 Vertical: " + vert);
		
		p1.flipVertical();
		System.out.println("1: Flipped " + p1);
	}
}