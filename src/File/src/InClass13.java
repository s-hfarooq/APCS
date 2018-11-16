import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InClass13 {

	public static void main(String[] args) throws FileNotFoundException {
		//amntOfWords();
		lineScan();
	}
	
	public static void amntOfWords() throws FileNotFoundException {
		File iF = new File("words.txt"); //inputFile
		Scanner iFS = new Scanner(iF);
		int total = 0;
		
		while(iFS.hasNext()) {
			iFS.next();
			total++;
		}
		
		System.out.print("Total words: " + total);
	}
	
	
	public static void lineScan() throws FileNotFoundException {
		File iF = new File("words.txt"); //inputFile
		Scanner iFS = new Scanner(iF);
		int lineTotal = 0, totalWords = 0;
		String line = "";
		
		while(iFS.hasNextLine()) {
			lineTotal++;
			line = iFS.nextLine();
			Scanner lineScanner = new Scanner(line);
			int lineWords = 0;
			
			while(lineScanner.hasNext()) {
				lineWords++;
				lineScanner.next();
			}

			totalWords += lineWords;

			System.out.println("Line: " + lineTotal + ", words: " + lineWords + ", total: " + totalWords);
			
			lineScanner.close();
		}
		
		iFS.close();
	}
	
}