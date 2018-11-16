import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
	
	public static void main(String[] args) throws FileNotFoundException {
		//temperatures();
		//inClass8();
	}
	
	public static void inClass8() throws FileNotFoundException {
		File fileOnDisk = new File("filename.txt");
		Scanner fileScan = new Scanner(fileOnDisk);
		
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