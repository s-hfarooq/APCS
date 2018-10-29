package october;

import java.util.Scanner;

public class InClass1015 {

	public static void main(String[] args) {
		//question();
		numbers();
	}
	
	public static void question() {
		Scanner console = new Scanner(System.in);
		
		System.out.print("What is x if 0=3x^2-9?\na. 3\nb. 6\nc. sqrt(3)\nd. sqrt(4)\nAnswer: ");
		String answer = console.next();
		
		String output;
		
		if(answer.equals("a") || answer.equals("b") || answer.equals("d"))
			output = "Incorrect";
		else if(answer.equals("c"))
			output = "Correct";
		else
			output = "Invalid";
		
		System.out.print(output);
	}
	
	public static void numbers() {
		Scanner console = new Scanner(System.in);
		
		System.out.print("Enter 3 integers: ");
		int val1 = console.nextInt();
		int val2 = console.nextInt();
		int val3 = console.nextInt();

		String output = "All different";
		
		if(val1 == val2 && val2 == val3)
			output = "All the same";
		else if(val1 == val2 || val2 == val3 || val1 == val3)
			output = "Two match";
		
		System.out.print(output);
	}
}