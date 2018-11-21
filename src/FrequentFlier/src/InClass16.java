import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InClass16 {

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("miles.txt");
		System.out.printf("%.1f", frequentFlier(f));
		
		//swapWords();
	}
	
	public static double frequentFlier(File f) throws FileNotFoundException {
		Scanner fileScan = new Scanner(f);
		double total = 0;
		
		while(fileScan.hasNext()) {
			String nextWord = fileScan.next().toLowerCase();
			
			if(nextWord.equals("firstclass"))
				total += fileScan.nextDouble() * 2;
			else if(nextWord.equals("coach"))
				total += fileScan.nextDouble();
			
			System.out.println(total);
		}
		
		fileScan.close();
		
		return total;
	}
	
	
	public static void swapWords() throws FileNotFoundException {
		File story = new File("story.txt");
		Scanner stScan = new Scanner(story);
		
		while(stScan.hasNextLine()) {
			Scanner line = new Scanner(stScan.nextLine());
			String s1 = "", s2 = "";
			
			while(line.hasNext()) {
				s1 = line.next();
				
				if(line.hasNext()) {
					s2 = line.next();
					System.out.print(s2 + " ");
				}
				
				System.out.print(s1 + " ");	
			}
			
			System.out.println();
		}
	}
}