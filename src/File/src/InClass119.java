import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InClass119 {

	public static void main(String[] args) throws FileNotFoundException {
		//temperaturesUpdated();
		
		//HW
//		File inFile = new File("nums.txt");
//		Scanner inFileScan = new Scanner(inFile);
//		runningSum(inFileScan);
//		
		
		File inFile2 = new File("printDuplicatesFile.txt");
		Scanner inFileScan2 = new Scanner(inFile2);
		printDuplicates(inFileScan2);
	}

	public static void warmup() throws FileNotFoundException {
		File fileOnDisk = new File("numbers.txt");
		Scanner numberScan = new Scanner(fileOnDisk);
		
		double total = 0;
		int amount = 0;
		
		while(numberScan.hasNext()) {
			amount++;
			total += numberScan.nextDouble();
		}
		
		double avg = (double)total / amount;
		
		System.out.printf("Sum: %.2f, amnt: %d, avg: %.2f", total, amount, avg);
	}
	
	public static void temperaturesUpdated() throws FileNotFoundException {
		File tempFile = new File("temps.txt");
		Scanner tempScan = new Scanner(tempFile);
		
		double temp1 = tempScan.nextDouble();
		double temp2 = tempScan.nextDouble();
		System.out.printf("%.1f to %.1f, change = %.1f\n", temp1, temp2, temp2 - temp1);
		
		while(tempScan.hasNext()) {
			if(tempScan.hasNextDouble()) {
				temp1 = temp2;
				temp2 = tempScan.nextDouble();
				System.out.printf("%.1f to %.1f, change = %.1f\n", temp1, temp2, temp2 - temp1);
			} else {
				tempScan.next();
			}
		}
	}
	
	public static void runningSum(Scanner inputFile) {
		double sum = 0, num1 = 0, maxSum = 0;
		System.out.print("Running sum =");
		
		while(inputFile.hasNext()) {
			num1 = inputFile.nextDouble();
			sum += num1;
			
			System.out.printf(" %.2f", sum);
			
			if(sum > maxSum)
				maxSum = sum;
		}
		
		System.out.printf("\nmax sum = %.2f", maxSum);
	}
	
	public static void printDuplicates(Scanner inputFile) {	
		while(inputFile.hasNextLine()) {
			Scanner newLine = new Scanner(inputFile.nextLine());
			String str1 = "", str2 = "";
			int counter = 0;
			
			while(newLine.hasNext()) {
				str2 = newLine.next();
				
				if(str1.equals(str2)) {
					counter++;
				} else {
					if(counter > 1)
						System.out.print(str1 + "*" + counter + " ");
					
					str1 = str2;
					counter = 1;
				}
			}
			
			if(counter > 1)
				System.out.print(str1 + "*" + counter + " ");
			
			str1 = str2;
			counter = 1;
			
			System.out.println();
		}
	}
}