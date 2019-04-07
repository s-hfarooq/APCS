package March;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InClass11 {

	public static void main(String[] args) throws FileNotFoundException {
		//writeSequence(10);
		//File input = new File("class11.txt");
		//Scanner in = new Scanner(input);
		//reverse(in);
		
		System.out.println(digitMatch(1234567, 2112225566));
	}
	
	public static void writeSequence(int n) {
		if(n == 1) {
			System.out.print("1");
		} else {
			System.out.print((n + 1)/ 2);
			if(n != 2)
				writeSequence(n - 2);
			System.out.print((n + 1) / 2);
		}
	}
	
	public static void reverse(Scanner in) {
		if(in.hasNextLine()) {
			String ln = in.nextLine();
			reverse(in);
			System.out.println(ln);
		}
	}
	
	public static int digitMatch(long a, long b) {
		if(a == 0 || b == 0)
			return 0;
		else if(a % 10 == b % 10)
			return 1 + digitMatch(a / 10, b / 10);
		else
			return digitMatch(a / 10, b / 10);
	}
}