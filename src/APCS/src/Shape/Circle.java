package Shape;

public class Circle extends Shape {
	private double radius; 
	
	public Circle(String newColor, double newRadius) {
		super(newColor);
		radius = newRadius;
	}
	
	@Override
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	public double getPerimeter() {
		return Math.PI * 2 * radius;
	}

	@Override
	public int getNumSides() {
		return 0;
	}
	
	public double getRadius() {
		return radius;
	}
}