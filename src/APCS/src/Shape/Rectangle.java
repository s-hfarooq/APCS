package Shape;

public class Rectangle extends Shape {
	private double len, width;
	
	public Rectangle(String newColor, double newLen, double newWidth) {
		super(newColor);
		len = newLen;
		width = newWidth;
	}
	
	@Override
	public double getArea() {
		return len * width;
	}

	@Override
	public double getPerimeter() {
		return (2 * len) + (2 * width);
	}

	@Override
	public int getNumSides() {
		return 4;
	}
	
	public double[] getSides() {
		return new double[] {len, width};
	}
}