import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		//Menu system
		File imdbDoc = new File("imdb.txt");
		File output = new File("imdbOutput.txt");
		PrintStream outPrint = new PrintStream(output);

		//User choice
		Scanner console = new Scanner(System.in);
		boolean isDone = false;
		
		while(!isDone) {
			menuOutput();
			
			char usrChoice = console.next().charAt(0);
			
			if(usrChoice == 'a')
				rankingRecord(console, imdbDoc, outPrint);
			else if(usrChoice == 'b')
				rankingTitle(console, imdbDoc, outPrint);
			else if(usrChoice == 'c')
				titleRank(imdbDoc, outPrint);
			else if(usrChoice == 'd')
				yearMovies(console, imdbDoc, outPrint);
			else if(usrChoice == 'e') 
				ratingRange(console, imdbDoc, outPrint);
			else if(usrChoice == 'q')
				isDone = true;
			else
				System.out.println("Not a valid option");
		}
		
		console.close();
	}
	
	public static void menuOutput() {
		System.out.println();
		System.out.println("Choose one of the following:");
		System.out.println("\ta. Enter ranking to get the record at that location");
		System.out.println("\tb. Enter ranking to get the title at that location");
		System.out.println("\tc. Enter movie title and get its ranking");
		System.out.println("\td. Enter the year and get the total movies from that year");
		System.out.println("\te. Enter range of ratings and print titles");
		System.out.println("\tq. Quit");
		System.out.print("Your choice (a, b, c, d, e, q): ");
	}
	
	//Parses input string line into 5 parts
	public static String[] getInfo(String inputLine) {
		//Get rank, rating, votes into variables
		Scanner line = new Scanner(inputLine);
		
		int rank = line.nextInt();
		double rating = line.nextDouble();
		int votes = line.nextInt();
		
		//Get rest of line and parse into title and year
		String restOfLine = line.nextLine();
		String title = restOfLine.substring(1, restOfLine.length() - 7);		
		String year = restOfLine.substring(restOfLine.length() - 5, restOfLine.length() - 1);
		
		line.close();
		
		return new String[] {rank + "", rating + "", votes + "", title, year};
	}
	
	//Gets line from txt file based on ranking desired
	public static String getLine(int ranking, File imdbDoc) throws FileNotFoundException {
		Scanner docScan = new Scanner(imdbDoc);
		
		boolean isDone = false;
		String line = "";
		
		while(!isDone) {
			String nextLine = docScan.nextLine();
			Scanner lineScanner = new Scanner(nextLine);
			
			if(lineScanner.hasNextInt() && lineScanner.nextInt() == ranking) {
				line = lineScanner.nextLine();
				isDone = true;
			}
			
			lineScanner.close();
		}
		
		docScan.close();
		
		return ranking + line;
	}
	
	//A - gets record from ranking
	public static void rankingRecord(Scanner console, File imdbDoc, PrintStream outPrint) throws FileNotFoundException {
		int ranking = 0;
		
		while(ranking < 1) {
			System.out.print("Ranking: ");
			ranking = console.nextInt();
		}
				
		String inputLine = getLine(ranking, imdbDoc);
		
		String[] info = getInfo(inputLine);
		System.out.println("\tRank: " + info[0] + 
				   		   "\n\tRating: " + info[1] + 
				   		   "\n\tVotes: " + info[2] + 
				   		   "\n\tTitle: " + info[3] +
				   		   "\n\tYear: " + info[4]);
		
		outPrint.println("You asked for the record at rank " + ranking);
		outPrint.println("\tRank: " + info[0] + 
						 "\n\tRating: " + info[1] + 
						 "\n\tVotes: " + info[2] + 
						 "\n\tTitle: " + info[3] +
						 "\n\tYear: " + info[4]);
		
		isGrail(info[3], outPrint);
		outPrint.println();
	}
	
	
	//B - get title from ranking
	public static void rankingTitle(Scanner console, File imdbDoc, PrintStream outPrint) throws FileNotFoundException {
		int ranking = 0;
		
		while(ranking < 1) {
			System.out.print("Ranking: ");
			ranking = console.nextInt();
		}
		
		String line = getLine(ranking, imdbDoc);
		String[] info = getInfo(line);
		
		System.out.print("\tTitle: " + info[3]);
		
		outPrint.println("You asked for the movie title at rank " + ranking);
		outPrint.println("\tTitle: " + info[3]);
		outPrint.println();

		isGrail(info[3], outPrint);
	}
	
	//C - get ranking from title
	public static void titleRank(File imdbDoc, PrintStream outPrint) throws FileNotFoundException {	
		Scanner newConsole = new Scanner(System.in);
		boolean isDone = false;
		int counter = 1;
		
		System.out.print("Title: ");
		String title = newConsole.nextLine();

		while(!isDone) {
			String[] info = getInfo(getLine(counter, imdbDoc));
			String inFile = info[3];
			
			if(title.equals(inFile))
				isDone = true;
			else if(counter > 250)
				isDone = true;
			else
				counter++;
		}
		
		outPrint.println("You asked for the ranking of " + title);
		
		if(counter <= 250) {
			System.out.print("\tRating: " + counter);
			outPrint.println("\tRating: " + counter);
		} else {
			System.out.print("Not on list");
			outPrint.println("Not on list");
		}
		
		isGrail(title, outPrint);
		outPrint.println();

		newConsole.close();
	}
	
	//D - prints number of movies from given year
	public static void yearMovies(Scanner console, File imdbDoc, PrintStream outPrint) throws FileNotFoundException {		
		Scanner docScan = new Scanner(imdbDoc);
		
		System.out.print("Year: ");
		int usrYear = console.nextInt();
		int lineNum = 1;
		int amount = 0;
		docScan.nextLine();
		
		while(docScan.hasNextLine()) {
			String line = getLine(lineNum, imdbDoc);
			String[] info = getInfo(line);
			
			if(Integer.parseInt(info[4]) == usrYear)
				amount++;
			
			lineNum++;
			
			for(int i = 0; i < 2; i++)
				docScan.nextLine();
		}
		
		String line = getLine(lineNum, imdbDoc);
		String[] info = getInfo(line);
		
		if(Integer.parseInt(info[4]) == usrYear)
			amount++;
		
		outPrint.println("You asked for the amount of movies from " + usrYear);
		
		System.out.println("\tNumber of movies: " + amount);
		outPrint.println("\tNumber of movies: " + amount);
		outPrint.println();

		docScan.close();
	}
	
	//E - get all movies between two ratings
	public static void ratingRange(Scanner console, File imdbDoc, PrintStream outPrint) throws FileNotFoundException {
		Scanner docScan = new Scanner(imdbDoc);
		int lineNum = 1;
		
		System.out.print("Lower limit: ");
		double lowerLim = console.nextDouble();
		System.out.print("Upper limit: ");
		double upperLim = console.nextDouble();
		boolean isDone = false;
		docScan.nextLine();
		
		outPrint.printf("You asked for all moves which scored between %.1f and %.1f\n", lowerLim, upperLim);
		
		while(!isDone) {
			for(int i = 0; i < 2; i++)
				docScan.nextLine();
			
			String[] info = getInfo(getLine(lineNum, imdbDoc));
			String title = info[3];
			double rating = Double.parseDouble(info[1]);
			
			if(rating >= lowerLim && rating <= upperLim) {
				System.out.println("\t" + title);
				outPrint.println("\t" + title);
				
				isGrail(title, outPrint);
			} else if(rating < lowerLim || docScan.hasNextLine()) {
				isDone = true;
			}
			
			lineNum++;
		}
		
		outPrint.println();
		
		docScan.close();
	}
	
	//Checks if title contains "Holy Grail"
	public static boolean isGrail(String input, PrintStream outPrint) {
		boolean isGrail = false;
		
		if(input.indexOf("Holy Grail") > -1) {
			System.out.println("\t\t - Greatest Comedy of All Time");
			outPrint.println("\t\t - Greatest Comedy of All Time");
			isGrail = true;
		}
		
		return isGrail;
	}
}