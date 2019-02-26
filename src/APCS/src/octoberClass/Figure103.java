package octoberClass;

public class Figure103 {
	
	public static void main(String[] args) {
		figure(9, '(', 2);
		figure(3, '@', 3);
		figure(5, '\\', 4);
	}
	
	public static void figure(int size, char symb, int howMany) {
		for(int amount = 0; amount < howMany; amount++) {
			for(int row = 0; row < size; row++) {
				for(int spaces = 0; spaces < size - row - 1; spaces++)
					System.out.print(" ");
				for(int symbols = 0; symbols < 2 * row + 1; symbols++)
					System.out.print(symb);
				System.out.println();
			}
			
			size++;
		}
	}
}


//mystery(5,2,9)
//2 and 4

//mystery(2,9,5)
//9 and 3
