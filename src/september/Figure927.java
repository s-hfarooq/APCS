package september;

public class Figure927 {

	public static final int SIZE = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Figure();

	}
	
	public static void Figure() {
		for(int row = 0; row < SIZE + 1; row++) {
			for(int frontslash = 0; frontslash < (4 * SIZE) - (4 * row); frontslash++)
				System.out.print("/");
			for(int ast = 0; ast < 8 * row; ast++)
				System.out.print("*");
			for(int backslash = 0; backslash < (4 * SIZE) - (4 * row); backslash++)
				System.out.print("\\");
			System.out.println();
		}
	}

}
