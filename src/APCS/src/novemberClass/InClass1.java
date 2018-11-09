package novemberClass;

public class InClass1 {

	public static void main(String[] args) {
		//System.out.print(randomLetter("go"));
		//System.out.print(randomWord(3));
		
		//substrings();
		
		System.out.println(phoneNumber("(425)867-5309"));
		reverseNum("(425)867-5309");
	}
	
	public static char randomLetter(String text) {
		int len = text.length();
		char randLet = ' ';
		
		if(len != 0) {
			int randNum = (int)(Math.random() * len);
			
			randLet = text.charAt(randNum);
		}
		
		return randLet;
	}
	
	public static String randomWord(int length) {
		String output = "";
		
		for(int i = 0; i < length; i++)
			output += randomLetter("abcdefghijklmnopqrstuvwxyz");
		
		return output;
	}
	
	public static String randomWord2(int length) {
		String output = "";
		boolean yes = false;
		int loop = 0;
		
		while(!yes) {
			for(int i = 0; i < length; i++)
				output += randomLetter("abcdefghijklmnopqrstuvwxyz");
		
			if(!output.equals("bob")) { 
				output = "";
				loop++;
			} else {
				System.out.println(loop); 
				yes = true;
			}
		}
		
		return output;
	}
	
	public static void substrings() {
		String sentence = "I like unicorns";
		
		//System.out.println(sentence.substring(0, 0));
		//System.out.println(sentence.substring(6, 2));
		//System.out.println(sentence.substring(7, 21));
		System.out.println(sentence.substring(7, 11));
		System.out.println(sentence.substring(13, 14));
	}
	
	public static String phoneNumber(String number) {
		return number.substring(1, 4) + "-" + number.substring(5);
	}
	
	public static void reverseNum(String number) {
		String output = "";
		
		for(int i = 12; i >= 0; i--) {
			output += number.charAt(i);
		}
		
		System.out.print(output);
	}
}