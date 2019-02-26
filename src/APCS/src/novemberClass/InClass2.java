package novemberClass;

public class InClass2 {

	public static void main(String[] args) {
		secondWord();
	}
	
	public static void secondWord() {
		String str = "This is my phrase; that is not my phrase.";
		String wanted = "phrase";
		
		int loc = str.indexOf(wanted);
		int loc2 = 0;
		int locTotal = loc;
		
		if(loc != -1) {
			String str2 = str.substring(loc + 1);
			loc2 = str2.indexOf(wanted);
		}
		
		if(loc2 != -1)
			locTotal = loc + loc2  + 1;
		
		System.out.println(locTotal);
		System.out.print(str.substring(locTotal));
	}
	
	public static void sentences() {
		String sentence = "was and It dark night a stormy";
		String str1 = sentence.substring(0, 3);
		String str2 = sentence.substring(4, 7);
		String str3 = sentence.substring(8, 10);
		String str4 = sentence.substring(11, 15);
		String str5 = sentence.substring(16, 21);
		String str6 = sentence.substring(22, 23);
		String str7 = sentence.substring(24);
		String s = " ";
		
		System.out.print(str3 + s + str1 + s + str6 + s + str4 + s + str2 + s + str7 + s + str5);
	}
}