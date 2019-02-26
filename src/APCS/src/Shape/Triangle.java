package Shape;

public class Triangle extends Shape {
	private double a, b, c;
	
	public Triangle(String newColor, double newA, double newB, double newC) {
		super(newColor);
		a = newA;
		b = newB;
		c = newC;
	}
	
	@Override
	public double getArea() {
		//Heron's law
		double s = getPerimeter() / 2;
		double temp = s * (s - a) * (s - b) * (s - c);
		return Math.sqrt(temp);
	}

	@Override
	public double getPerimeter() {
		return a + b + c;
	}

	@Override
	public int getNumSides() {
		return 3;
	}
	
	public double[] getSides() {
		return new double[] {a, b, c};
	}
}