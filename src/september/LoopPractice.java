package september;
public class LoopPractice {
	public static void main(String[] args) {
		pattern7();
		pattern8();
		pattern9();
		pattern11();
		pattern12();
	}
	
	public static void pattern7() {
//		*       *
//		**     **
//		***   ***
//		**** ****
		
		printHeader(7);
		
		for(int i = 1; i <= 4; i++) {
			int totalAmnt = 9;
			
			for(int k = 0; k < i; k++) {
				System.out.print("*");
				totalAmnt -= 1;
			}
			
			int secondAmnt = totalAmnt; 
			for(int k = 1; k <= secondAmnt - i; k++) {
				System.out.print(" ");
				totalAmnt -= 1;
			}
			
			for(int k = 0; k < totalAmnt; k++)
				System.out.print("*");
			
			System.out.println();
		}
	}
	
	public static void pattern8() {
//		-----1-----
//		----333----
//		---55555---
//		--7777777--
//		-999999999-
		
		printHeader(8);

		for(int i = 1; i <= 5; i++) {	
            for(int j = 1; j <= (-1 * i + 6); j++) 
                System.out.print("-"); 
            
            for(int j = 1; j <= (2 * i - 1); j++)
                System.out.print(2 * i - 1);
            
            for(int j = 1; j <= (-1 * i + 6); j++) 
                System.out.print("-");
            
            System.out.println(); 
        }
	}
	
	
	public static void pattern9() {
//		12345  
//		23451
//		34512
//		45123
//		51234
		
		printHeader(9);
		
	    for(int i = 1; i <= 5; i++) {
	      for(int j = i; j <= 5; j++)
	         System.out.print(j);
	      
	      for(int j = 1; j < i; j++)
	 	    System.out.print(j);
	      
	      System.out.println();
	    }
	}
	
	public static void pattern11() {
		printHeader(11);
		
		for(int i = 1; i <= 4; i++) {
			for(int j = 0; j < (2 * i + 1); j++)
				System.out.print(".");
			
			System.out.println("\\\\");
		}
	}
	
	public static void pattern12() {
		printHeader(12);
		
		for(int row = 0; row < 4; row++) {
			for(int pd = 0; pd < (2 * row + 3); pd++)
				System.out.print(".");
				
			System.out.print("/");
			
			for(int dash = 0; dash < (9 - 2 * row); dash++)
				System.out.print("-");
			
			System.out.println();
		}
	}
	
	public static void printHeader(int vNum) {
		for(int i = 0; i < 10; i++)
			System.out.print("_");
		System.out.println("\nPATTERN " + vNum + ":\n");
	}

}