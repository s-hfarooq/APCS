import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

	public static void main(String[] args) throws FileNotFoundException {
		temperatures();
	}
	
	public static void inClass() throws FileNotFoundException {
		File fileOnDisk = new File("filename.txt");
		Scanner fileScan = new Scanner(fileOnDisk);
		
//		String word1 = fileScan.next();
//		String word2 = fileScan.next();
//		int num1 = fileScan.nextInt();
//		double doub1 = fileScan.nextDouble();
//		String word3 = fileScan.next();
//		System.out.print(word1 + " " + word2 + " " + num1 + " " + doub1 + " " + word3);
		
		String str = "";
		
		while(fileScan.hasNext()) {
			str = fileScan.next();
			System.out.println(str);
		}
	}
	
	public static void temperatures() throws FileNotFoundException {
		File tempFile = new File("temps.txt");
		Scanner tempScan = new Scanner(tempFile);
		
		double temp1 = tempScan.nextDouble();
		double temp2 = tempScan.nextDouble();
		System.out.printf("%.1f to %.1f, change = %.1f\n", temp1, temp2, temp2 - temp1);

		
		while(tempScan.hasNext()) {
			temp1 = temp2;
			temp2 = tempScan.nextDouble();
			System.out.printf("%.1f to %.1f, change = %.1f\n", temp1, temp2, temp2 - temp1);
		}
	}
}