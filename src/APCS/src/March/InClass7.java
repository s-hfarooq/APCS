package March;

public class InClass7 {

	public static void main(String[] args) {
		System.out.println(sumEvens(10));
		
		System.out.println(yToX("yyayyxxpx"));
	}
	
	public static int sumEvens(int input) {
		if(input < 2)
			return 0;
		if(input % 2 == 0)
			return input + sumEvens(input - 2);
		return sumEvens(input - 1);
	}
	
	public static String yToX(String s) {
		if(s.equals(""))
			return "";
		if(s.charAt(0) == 'y')
			return 'x' + yToX(s.substring(1));
		
		return s.charAt(0) + yToX(s.substring(1));
	}
}