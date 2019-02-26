package octoberClass;

import java.util.Scanner;

public class InClass1012 {

	public static void main(String[] args) {
		warmup();
	}
	
	public static void warmup() {
		System.out.print("Enter a number: ");
		Scanner console = new Scanner(System.in);
		int inNum = console.nextInt();
		
		if(inNum >= 1000)
			System.out.print("really ");
		if(inNum >= 100)
			System.out.print("really ");
		if(inNum >= 10)
			System.out.print("big");
		if(inNum < 10)
			System.out.print("Not in range");
	}
}

//String a = "abc";
//String b = "def";
//
//if(!a.equals(b))
//	System.out.print("Not equal");