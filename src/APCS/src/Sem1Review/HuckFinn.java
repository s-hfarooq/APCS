package Sem1Review;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class HuckFinn {

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("HuckFinn.txt");
		File output = new File("Tom_and_Huck.txt");
		Scanner fScan = new Scanner(f);
		PrintStream filePrint = new PrintStream(output);
		
		int lines = 0, words = 0, sawyer = 0, tom = 0;
		
		while(fScan.hasNextLine()) {
			lines++;
			
			String line = fScan.nextLine();
			Scanner lineScan = new Scanner(line);
			
			if(lineScan.hasNext()) {
				words++;
				String nextWord = lineScan.next();
				if(nextWord.indexOf("Sawyer") > -1)
					sawyer++;
				else if(nextWord.indexOf("Tom") > -1)
					tom++;
			}
		}
		
//		filePrint.println("Lines: " + lines);
//		filePrint.println("Total words: " + words);
//		filePrint.println("Sawyer occurrences: " + sawyer);
//		filePrint.println("Tom occurrences: " + tom);
		System.out.println("lines: " + lines);
		System.out.println("words: " + words);
		System.out.println("sawyer: " + sawyer);
		System.out.println("tom: " + tom);
	}
}