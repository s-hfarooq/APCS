package Shape;

public abstract class Shape implements Comparable {
	private String color;
	
	public Shape(String newColor) {
		color = newColor;
	}
	
	public abstract double getArea();
	
	public abstract double getPerimeter();
	
	public abstract int getNumSides();
	
	public String getColor() {
		return color;
	}
	
	public int compareTo(Object obj) {
		int output = 0;
		if(obj instanceof Shape) {
			Shape other = (Shape)obj;
			if(Math.abs(this.getArea() - other.getArea()) < 1e-10)
				output = 0;
			else if(this.getArea() - other.getArea() < 0.0)
				output = -1;
			else
				output = 1;
		}

		return output;
	}
	
	public String toString() {
		return "Type: " + getClass().getSimpleName() + ", color: " + getColor() +
			   ", area: " + getArea() + ", perimeter: " + getPerimeter();
	}
}