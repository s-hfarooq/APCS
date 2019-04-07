package sai;

import java.util.Scanner;

public class client {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("how big do you want your stack(1-9)? ");
		int row = input.nextInt();
		input.close();
		
		HB test = new HB(row);
		
		System.out.println(test);
		System.out.println(test.move(1, 2));
		System.out.println(test);

	}
}
