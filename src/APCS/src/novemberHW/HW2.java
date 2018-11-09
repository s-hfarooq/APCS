package novemberHW;

import java.util.Scanner;

public class HW2 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		String input = getInput(console);
		String noSpaces = removeSpaces(input);
		String reverseStr = reverse(noSpaces);
		
		printInput(input);
		System.out.println(noSpaces);
		System.out.println(reverseStr);
	}
	
	public static String getInput(Scanner console) {
		System.out.print("Enter string: ");
		String input = console.nextLine();
		
		return input;
	}
	
	public static void printInput(String input) {
		System.out.println(input);
	}
	
	public static String removeSpaces(String input) {	
		while(input.indexOf(" ") != -1) {
			int loc = input.indexOf(" ");
			input = input.substring(0, loc) + input.substring(loc + 1);
		}
		
		return input;
	}
	
	public static String reverse(String input) {
		String output = "";
		int max = input.length() - 1;
		
		for(int i = max; i >= 0; i--)
			output += input.charAt(i);
		
		return output;
	}
}