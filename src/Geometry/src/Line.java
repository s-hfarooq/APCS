
public class Line {
	private double yInt;
	private double slope;
	private Point p1;
	private Point p2;
	
	//Constructors
	public Line(double slope, double yInt) {
		this.yInt = yInt;
		this.slope = slope;
		p1 = new Point(0, yInt);
	}
	
	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
		setSlope();
		setYInt();
	}
	
	//Finds slope from 2 points
	public double setSlope() {
		double locSlope = (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
		slope = locSlope;
		return slope;
	}
	
	//Finds yInt from 2 points
	public double setYInt() {
		double b = p1.getY() - (slope * p1.getX());
		yInt = b;
		
		return yInt;
	}
	
	//Checks to see if a point is on the line
	public boolean isOnLine(Point other) {
		boolean onLine = false;
		double pointAtX = (slope * other.getX()) + yInt;
		
		if(pointAtX == other.getY())
			onLine = true;
		
		return onLine;
	}
	
	//Alters yInt
	public void translateY(double vertTranslation) {
		yInt += vertTranslation;
	}
	
	//Alters slope
	public void setSlope(double newSlope) {
		slope = newSlope;
	}
	
	public double getSlope() {
		return slope;
	}
	
	public double getYInt() {
		return yInt;
	}
	
	public String toString() {
		//return "y = " + slope + "x + " + yInt;
		return "y - " + p1.getY() + " = " + slope + "(x - " + p1.getX() + ")";
	}
}