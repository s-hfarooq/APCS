package september;
public class Figure924 {
	
	public static final int SIZE = 7;
	
	public static void main(String[] args) {
		endLines();
		topTri();
		bottomTri();
		endLines();
	}
	
	public static void endLines() {
		System.out.print("#");
		
		for(int i = 0; i < 4 * SIZE; i++)
			System.out.print("=");
		
		System.out.print("#");
	}
	
	public static void topTri() {
		for(int row = 0; row < SIZE; row++) {
			System.out.println();
			System.out.print("|");
			
			for(int space = 0; space < ((2 * SIZE - 2) - 2 * row); space++)
				System.out.print(" ");
			
			System.out.print("<>");
			
			for(int dot = 0; dot < (4 * row); dot++)
				System.out.print(".");
			
			System.out.print("<>");
			
			for(int endSpace = 0; endSpace < ((2 * SIZE - 2) - 2 * row); endSpace++)
				System.out.print(" ");
			
			System.out.print("|");
		}
	}
	
	public static void bottomTri() {
		for(int row = 0; row < SIZE; row++) {
			System.out.println();
			System.out.print("|");
			
			for(int space = 0; space < (2 * row); space++)
				System.out.print(" ");
			
			System.out.print("<>");
			
			for(int dot = 0; dot < ((4 * SIZE - 4) - (4 * row)); dot++)
				System.out.print(".");
			
			System.out.print("<>");
			
			for(int endSpace = 0; endSpace < (2 * row); endSpace++)
				System.out.print(" ");
			
			System.out.print("|");
		}
		
		System.out.println();
	}
}