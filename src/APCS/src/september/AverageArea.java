package september;
public class AverageArea {
	public static void main (String[] args) {
		avgArea();
	}
	
	public static void avgArea() {
		int length = 7;
		int width = 8;
		int height = 9;
		
		int surfaceArea = 2 * ((width * length) + (width * height) + (length * height));
		double avgFaceArea = surfaceArea / 6.0;
		
		System.out.println("Surface area: " + surfaceArea);
		System.out.println("Average area per face: " + avgFaceArea);
	}
}