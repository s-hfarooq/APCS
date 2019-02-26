package novemberHW;

import java.util.Scanner;

public class HW1 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);

		//System.out.println(halfFirst(console));
		
		System.out.print(noLeadingSpace("   "));
	}
	
	public static String halfFirst(Scanner console) {
		System.out.print("Enter a word: ");
		String word = console.next();
		
		int len = word.length() / 2;
		
		String output = word.substring(len) + word.substring(0, len);
		
		return output;
	}
	
	public static String noLeadingSpace(String text) {
		boolean isDone = false;
		
		while(!isDone) {
			if(text.charAt(0) == ' ')
				text = text.substring(1);
			else
				isDone = true;
		}
		
		return text;
	}
}