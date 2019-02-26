package novemberClass;

public class InClass5 {

	public static void main(String[] args) {
		System.out.print(astCount("**h*i"));
	}
	
	public static int astCount(String input) {
		int amnt = 0;
		boolean isDone = false;
		
		while(!isDone) {
			int loc = input.indexOf("*");
			input = input.substring(0, loc) + input.substring(loc + 1);
			
			amnt++;
			isDone = (input.indexOf("*") == -1);
		}
		
		System.out.println(input);
		
		return amnt;
	}
}

//int i = (int)(Math.random() * 7) + 7; //7-13

//.substring, .indexof, .charat, .length, .equals