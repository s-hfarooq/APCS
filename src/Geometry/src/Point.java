
public class Point {
	
	private double x;
	private double y;
	
	public Point() {
		setCoordinates(0, 0);
	}
	
	public Point(double newX, double newY) {
		setCoordinates(newX, newY);
	}
	
	public void setCoordinates(double newX, double newY) {
		x = newX;
		y = newY;
	}
	
	public double getDistance(Point p2) {
		double dist = Math.pow(p2.getY() - y, 2);
		dist += Math.pow(p2.getX() - x, 2);
		dist = Math.sqrt(dist);
		
		return dist;
	}
	
	public boolean isVertical(Point other) {
		boolean vertical = false;
		
		if(x == other.getX() && y != other.getY())
			vertical = true;
		
		return vertical;
	}
	
	public void flipVertical() {
		y *= -1;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public String toString() {
		return "Point: (" + x + ", " + y + ")";
	}
}

//
//public class Point {
//	
//	private int x;
//	private int y;
//	
//	public Point() {
//		setCoordinates(0, 0);
//	}
//	
//	public Point(int newX, int newY) {
//		setCoordinates(newX, newY);
//	}
//	
//	public void setCoordinates(int newX, int newY) {
//		x = newX;
//		y = newY;
//	}
//	
//	public double getDistance(Point p2) {
//		double dist = Math.pow(p2.getY() - y, 2);
//		dist += Math.pow(p2.getX() - x, 2);
//		dist = Math.sqrt(dist);
//		
//		return dist;
//	}
//	
//	public boolean isVertical(Point other) {
//		boolean vertical = false;
//		
//		if(x == other.getX() && y != other.getY())
//			vertical = true;
//		
//		return vertical;
//	}
//	
//	public void flipVertical() {
//		y *= -1;
//	}
//	
//	public int getX() {
//		return x;
//	}
//	
//	public int getY() {
//		return y;
//	}
//	
//	public String toString() {
//		return "Point: (" + x + ", " + y + ")";
//	}
//}