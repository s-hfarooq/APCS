package Shape;

import java.util.Arrays;

public class ShapeClient {
	public static void main(String[] args) {
		Shape[] shapes = {new Circle("Red", 5), 
						  new Rectangle("Green", 5.0, 10.0), 
						  new Triangle("Blue", 5, 5, 6),
				 		  new EquilateralTriangle("Yellow", 5)};
		
		for(int i = 0; i < shapes.length; i++) {
			System.out.println(shapes[i]);
			System.out.println();
		}
		
		//Sorting
		System.out.println(Arrays.toString(shapes));
		System.out.println();
		System.out.println();
		Arrays.sort(shapes);
		System.out.println(Arrays.toString(shapes));
	}
}