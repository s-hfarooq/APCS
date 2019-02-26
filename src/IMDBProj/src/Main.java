//Hassan Farooq
//APCS P.5
//November 20, 2018
//IMDB Project
//
//Prints out desired outputs based on info from imdb txt file

import java.io.*;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException {
		//Files
		File imdbDoc = new File("imdb.txt");
		File output = new File("imdbOutput.txt");
		PrintStream filePrint = new PrintStream(output);
		
		//Get total lines in input file
		Scanner lineScanner = new Scanner(imdbDoc);
		int lineNum = 0;
		
		while(lineScanner.hasNextLine()) {
			lineNum++;
			lineScanner.nextLine();
		}
		
		lineScanner.close();
		int rankAmnt = (lineNum / 2) + 2;
		
		//User choice
		Scanner console = new Scanner(System.in);
		boolean isDone = false;
		
		//Repeat until user wants to quit
		while(!isDone) {
			menuOutput();
			
			char usrChoice = console.nextLine().charAt(0);
			
			if(usrChoice == 'a')
				rankingRecord(console, imdbDoc, filePrint, rankAmnt);
			else if(usrChoice == 'b')
				rankingTitle(console, imdbDoc, filePrint, rankAmnt);
			else if(usrChoice == 'c')
				titleRank(imdbDoc, filePrint, console, rankAmnt);
			else if(usrChoice == 'd')
				yearMovies(console, imdbDoc, filePrint);
			else if(usrChoice == 'e') 
				ratingRange(console, imdbDoc, filePrint);
			else if(usrChoice == 'q')
				isDone = true;
			else
				System.out.println("Not a valid option");
		}
		
		System.out.print("Goodbye.");
		
		console.close();
	}
	
	//Menu choices
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
	
	//Parses input string line into 5 parts and returns them
	public static String[] getInfo(String inputLine) {
		//Get rank, rating, votes into variables
		Scanner line = new Scanner(inputLine);
		
		String rank = line.nextInt() + "";
		String rating = line.nextDouble() + "";
		String votes = line.nextInt() + "";
		
		//Get rest of line and parse into title and year
		String restOfLine = line.nextLine();
		String title = restOfLine.substring(1, restOfLine.length() - 7);		
		String year = restOfLine.substring(restOfLine.length() - 5, restOfLine.length() - 1);
		
		//Special case for rank #146
		if(year.indexOf("/I") > -1) {
			title = restOfLine.substring(1, restOfLine.length() - 8);
			year = restOfLine.substring(restOfLine.length() - 7, restOfLine.length() - 3);
		}
		
		line.close();
		
		return new String[] {rank, rating, votes, title, year};
	}
	
	//Gets line from txt file based on ranking desired
	public static String getLine(int ranking, File imdbDoc) throws FileNotFoundException {
		Scanner docScan = new Scanner(imdbDoc);
		
		boolean isDone = false;
		String line = "";
		
		//Scans until it finds line with correct rank
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
	
	//Make sure values are in range for A and B
	public static int getRankingInRange(Scanner console, int rankAmnt) {
		int ranking = 0;
		String rankingStr = "";
		
		while(ranking < 1 || ranking >= rankAmnt) {
			System.out.print("Ranking (from 1 - " + (rankAmnt - 1) + "): ");
			rankingStr = console.nextLine();
			Scanner scn = new Scanner(rankingStr);
			ranking = scn.nextInt();
			scn.close();
		}
		
		return ranking;
	}
	
	//A - gets record from ranking
	public static void rankingRecord(Scanner console, File imdbDoc, PrintStream filePrint, int rankAmnt) throws FileNotFoundException {
		int ranking = getRankingInRange(console, rankAmnt);
		
		//Gets line and prints it
		String inputLine = getLine(ranking, imdbDoc);
		
		System.out.println("\t" + inputLine);

		filePrint.println("You asked for the record at rank " + ranking);
		filePrint.println("\t" + inputLine);
		
		isGrail(inputLine, filePrint);
		filePrint.println();
	}
	
	//B - get title from ranking
	public static void rankingTitle(Scanner console, File imdbDoc, PrintStream filePrint, int rankAmnt) throws FileNotFoundException {
		int ranking = getRankingInRange(console, rankAmnt);
		
		//Gets title from other functions then prints it out
		String line = getLine(ranking, imdbDoc);
		String[] info = getInfo(line);
		
		System.out.println("\tTitle: " + info[3]);
		
		filePrint.println("You asked for the movie title at rank " + ranking);
		filePrint.println("\tTitle: " + info[3]);
		isGrail(info[3], filePrint);
		filePrint.println();
	}
	
	//C - get ranking from title
	public static void titleRank(File imdbDoc, PrintStream filePrint, Scanner console, int rankAmnt) throws FileNotFoundException {	
		boolean isDone = false;
		int counter = 1;
		
		System.out.print("Title: ");
		String title = console.nextLine();
		
		//Get ranking from title of movie
		while(!isDone) {
			String[] info = getInfo(getLine(counter, imdbDoc));
			String inFile = info[3];
			
			if(counter >= rankAmnt - 1)
				isDone = true;
			else if(title.equals(inFile))
				isDone = true;
			else
				counter++;
		}
		
		//Print ranking
		filePrint.println("You asked for the ranking of " + title);
		
		String[] info = getInfo(getLine(rankAmnt - 1, imdbDoc));
		if(counter < 250) {
			System.out.print("\tRanking: " + counter);
			filePrint.println("\tRanking: " + counter);
		} else if(title.equals(info[3]) && counter == 250) {
			System.out.print("\tRanking: " + counter);
			filePrint.println("\tRanking: " + counter);
		} else {
			System.out.print("\tNot on list");
			filePrint.println("\tNot on list");
		}
		
		isGrail(title, filePrint);
		filePrint.println();
	}
	
	//D - prints number of movies from given year
	public static void yearMovies(Scanner console, File imdbDoc, PrintStream filePrint) throws FileNotFoundException {
		Scanner docScan = new Scanner(imdbDoc);
		
		//Gets year from user
		System.out.print("Year: ");
		String usrYearStr = console.nextLine();
		Scanner sc = new Scanner(usrYearStr);
		int usrYear = sc.nextInt();
		sc.close();

		int onLine = 1;
		int amount = 0;
		docScan.nextLine();
		
		//Goes through all movies - increments amount when movie is from user year
		while(docScan.hasNextLine()) {
			String line = getLine(onLine, imdbDoc);
			String[] info = getInfo(line);
			
			if(Integer.parseInt(info[4]) == usrYear)
				amount++;
			
			onLine++;
			
			for(int i = 0; i < 2; i++)
				docScan.nextLine();
		}
		
		//Last movie on list - fenceposting
		String line = getLine(onLine, imdbDoc);
		String[] info = getInfo(line);
		
		if(Integer.parseInt(info[4]) == usrYear)
			amount++;
		
		//Prints results
		filePrint.println("You asked for the amount of movies from " + usrYearStr);
		
		System.out.println("\tNumber of movies: " + amount);
		filePrint.println("\tNumber of movies: " + amount);
		filePrint.println();
		
		docScan.close();
	}
	
	//E - get all movies between two ratings
	public static void ratingRange(Scanner console, File imdbDoc, PrintStream filePrint) throws FileNotFoundException {
		Scanner docScan = new Scanner(imdbDoc);
		int lineNum = 1;
		double lowerLim = -1, upperLim = -2;
		boolean isDone = false;
		
		//Makes sure user doesn't enter value below 0 and that min < max
		while(lowerLim < 0 && upperLim < lowerLim) {
			System.out.print("Lower limit: ");
			String ln = console.nextLine();
			Scanner scLn1 = new Scanner(ln);
			lowerLim = scLn1.nextDouble();
			
			System.out.print("Upper limit: ");
			String ln2 = console.nextLine();
			Scanner scLn2 = new Scanner(ln2);			
			upperLim = scLn2.nextDouble();
			
			scLn1.close();
			scLn2.close();
			
			docScan.nextLine();
		}
		
		filePrint.printf("You asked for all moves which scored between %.1f and %.1f\n", lowerLim, upperLim);
		
		//Finds/prints all movies within desired range
		while(!isDone) {
			for(int i = 0; i < 2; i++)
				docScan.nextLine();
			
			String[] info = getInfo(getLine(lineNum, imdbDoc));
			String title = info[3];
			double rating = Double.parseDouble(info[1]);
						
			if(rating >= lowerLim && rating <= upperLim) {
				System.out.println("\t" + title);
				filePrint.println("\t" + title);
				
				isGrail(title, filePrint);
			} else if(rating < lowerLim) {
				isDone = true;
			}
			
			lineNum++;
		}
		
		filePrint.println();
		
		docScan.close();
	}
	
	//Checks if title contains "Holy Grail"
	public static boolean isGrail(String input, PrintStream filePrint) {
		boolean isGrail = false;
		
		if(input.indexOf("Holy Grail") > -1) {
			System.out.println("\t\t - Greatest Comedy of All Time");
			filePrint.println("\t\t - Greatest Comedy of All Time");
			isGrail = true;
		}
		
		return isGrail;
	}
}