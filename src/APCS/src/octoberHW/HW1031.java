package octoberHW;

import java.util.Scanner;

public class HW1031 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Enter a word: ");
		String word = console.next();
		
		System.out.println(commaLetters(word));
		System.out.println(fiveTimes(word));
		System.out.println(backwards(word));
	}
	
	public static String commaLetters(String word) {
		String output = "";
		int max = word.length() - 1;
		
		for(int i = 0; i < max; i++)
			output += word.charAt(i) + ", ";
		output += word.charAt(max);
		
		return output;
	}
	
	public static String fiveTimes(String word) {
		String output = "";
		int max = word.length() - 1;
		
		for(int i = 0; i < max + 1; i++) {
			for(int j = 0; j < 5; j++)
				output += word.charAt(i);
		}
		
		return output;
	}
	
	public static String backwards(String word) {
		String output = "";
		int max = word.length() - 1;
		
		for(int i = max; i >= 0; i--)
			output += word.charAt(i);
		
		return output;
	}
}