package March;

public class InClass6 {

	public static void main(String[] args) {
		System.out.println(factorial(15));
		
		System.out.println(printStars(5));
		
		System.out.println(backwards("backwards"));
	}
	
	public static int factorial(int input) {
//		int total = 1;
//		
//		for(int i = 1; i < input + 1; i++)
//			total *= i;
//		
//		return total;
		
		if(input == 0) 
			return 1;
		return input * factorial(input - 1);
	}
	
	public static String printStars(int n) {
		if(n == 1) 
			return "*";
		return "*" + printStars(n - 1);
	}
	
	public static String backwards(String str) {
		if(str.equals("")) 
			return "";
		return str.charAt(str.length() - 1) + backwards(str.substring(0, str.length() - 1));
	}
}