package octoberClass;

import java.util.Scanner;

public class InClass1031 {

	public static void main(String[] args) {
		//System.out.print(getRandInt());
		
//		String str = "the phrase";
//		char last = endsWith(str);
//		System.out.print("\"" + str + "\" ends with \"" + last + "\"");
		
//		System.out.print(isThirdStar("**"));
		
		Scanner console = new Scanner(System.in);
		System.out.print(monsterMovie(console));
	}
	
	public static int getRandInt() {
		double version = Math.random();
		int returnVal = 0;
		
		if(version < 0.3)
			returnVal = (int)(Math.random() * 20) + 1;
		else
			returnVal = (int)(Math.random() * -16) - 5;
		
		return returnVal;
	}
	
	public static char endsWith(String phrase) {
		int len = phrase.length();
		return phrase.charAt(len - 1);
	}
	
	public static boolean isThirdStar(String text) {
		boolean isStar = false;
		
		if(text.length() > 2) {
			char thirdChar = text.charAt(2);
			
			if(thirdChar == '*')
				isStar = true;
		}
		
		return isStar;
	}
	
	public static String monsterMovie(Scanner console) {
		String output = "";
		System.out.print("Full name: ");
		
		String first = console.next().toLowerCase();
		int fLast = (int)first.charAt(0);
		
		String middle = console.next().toLowerCase();
		int mLast = (int)middle.charAt(0);
		
		String last = console.next().toLowerCase();
		int lLast = (int)last.charAt(0);
		
		if(fLast >= 97 && fLast <= 102)
			output += "Attack of the ";
		else if(fLast >= 103 && fLast <= 109)
			output += "Earth vs. the ";
		else if(fLast >= 110 && fLast <= 115)
			output += "Invasion of the ";
		else
			output += "Return of the ";
		
		if(mLast >= 97 && mLast <= 102)
			output += "mutant ";
		else if(mLast >= 103 && mLast <= 109)
			output += "flying ";
		else if(mLast >= 110 && mLast <= 115)
			output += "disco ";
		else
			output += "giant ";
		
		if(lLast >= 97 && lLast <= 102)
			output += "zombies";
		else if(lLast >= 103 && lLast <= 109)
			output += "robots";
		else if(lLast >= 110 && lLast <= 115)
			output += "swamp beasts";
		else
			output += "muffins";
		
		return output;
	}
}