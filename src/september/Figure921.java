package september;
public class Figure921 {

	public static void main(String[] args) {
		/*equalLine();
		System.out.println();
		centerSlashes();
		equalLine(); */
		/*
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= (5 - i); j++)
				System.out.print(".");

			System.out.println(i);
			
			for (int k = 1; k <= i; k++)
			{
				System.out.println(".");
			}
		}*/
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= (5-i); j++)
				System.out.print(".");
			for (int j = 1; j <= i; j++)
				System.out.print(i);
			
			System.out.println();
		}
		
		System.out.println();
				
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= (5 - i); j++)
				System.out.print(".");

			System.out.print(i);
			
			for (int j = 1; j <= (i - 1); j++)
				System.out.print(".");
			
			System.out.println();
		}
	}
	
	public static void equalLine() {
		for (int i = 0; i < 10; i++)
			System.out.print("=");
	}
	
	public static void centerSlashes() {
		for (int i = 0; i < 4; i++) {
			System.out.println("\\        /");
			System.out.println("/        \\");
		}
	}

}

/*
System.out.println(Math.pow((i+1), 2));


*
**
***
****
*****


2, 5, 8
j <= 3*i-1
System.out.print(i)


for (int i = 1; i <= 5; i++) {
	for (int j = 1; j <= (5 - i); j++)
		System.out.print(".");

	System.out.println(i);
}


*/