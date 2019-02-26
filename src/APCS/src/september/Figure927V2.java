package september;
public class Figure927V2 {

	public static final int SIZE = 8;

	public static void main(String[] args) {
		line();
		
		topBox();
		bottomBox();
		
		line();
		
		bottomBox();
		topBox();
		
		line();
	}
	
	public static void line() {
		System.out.print("+");
		
		for(int dashes = 0; dashes < SIZE * 2 + 1; dashes++)
			System.out.print("-");
		
		System.out.println("+");
	}
	
	public static void topBox() {
		//Top section
		for(int row = 0; row < SIZE; row++) {
			System.out.print("|");
			
			for(int space = 0; space < SIZE - row; space++)
				System.out.print(" ");
			for(int slash = 0; slash < row; slash++)
				System.out.print("/");
			
			System.out.print("*");
			
			for(int slash = 0; slash < row; slash++)
				System.out.print("\\");
			for(int space = 0; space < SIZE - row; space++)
				System.out.print(" ");
			
			System.out.println("|");
		}
	}
	
	public static void bottomBox() {
		for(int row = 0; row < SIZE; row++) {
			System.out.print("|");
			
			for(int space = 0; space < 1 + row; space++)
				System.out.print(" ");
			for(int slash = 0; slash < SIZE - row - 1; slash++)
				System.out.print("\\");
			
			System.out.print("*");
			
			for(int slash = 0; slash < SIZE - row - 1; slash++)
				System.out.print("/");
			for(int space = 0; space < 1 + row; space++)
				System.out.print(" ");
			
			System.out.println("|");
		}
	}
}