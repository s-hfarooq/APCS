package september;
public class Figure925 {

	public static void main(String[] args) {
		upsideDownTri();
	}
	
	public static void upsideDownTri() {
		for(int row = 0; row < 4; row++) {
			for(int space = 0; space < 3 + row; space++)
				System.out.print(" ");
			
			for(int as = 0; as < (7 - 2 * row); as++)
				System.out.print("*");
			
			System.out.println();
		}
	}
	
	public static void sizeTable() {
		//Print +
		//Loop for width (2 * size) - make it its own method
			//Prints /\
		//Print +
		//Loop for height (height = size)
			//Print |
			//Print (4*size) " "
			//Print |
	}

}