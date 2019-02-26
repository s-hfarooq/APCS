//Hassan Farooq
//APCS P.5
//DNA Project
//December 7, 2018
//
//Reports information about DNA nucleotide sequences that may encode proteins. Gets info from a txt file.

package projects;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class DNA {
	
	//Class constants
	public static final int MIN_CODONS = 4;				//minimum number of codons a valid protein must have
	public static final int PERCENT_MASS_CG = 30;		//percentage of mass from C and G in order for a protein to be valid
	public static final int UNIQUE_NUC = 4;				//number of unique nucleotides (4, representing A, C, G, and T)
	public static final int NUC_PER_CODON = 3;			//number of nucleotides per codon
	public static final String FILE_NAME = "dna.txt";	//file name to be read from
	
	public static void main(String[] args) throws FileNotFoundException {
		//Setup
		System.out.println("This program reports information about DNA nucleotide sequences that may encode proteins.");
		System.out.println();
		
		File f = new File(FILE_NAME);
		Scanner scn = new Scanner(f);
		
		//Loop while input file has another line
		while(scn.hasNextLine()) {
			//Get info from file
			String name = scn.nextLine();
			
			//Makes sure it has a line for nucleotides
			if(scn.hasNextLine()) {
				String nuc = scn.nextLine().toUpperCase();
				
				//Parse info and do calculations
				int[] nucleoCount = nucCount(nuc);
				double[] massPer = massPercents(nucleoCount);
				String[] codons = codons(nuc);
				
				boolean encodes = doesEncodeProtein(codons, massPer);
				String encodesStr = encodes ? "yes" : "no";
				
				//Prints output to console
				System.out.println("Name: " + name);
				System.out.println("Nucleotides: " + nuc);
				System.out.println("Nucleotide counts: " + Arrays.toString(nucleoCount));
				
				System.out.print("Mass percentages: ");
				printDoublesTo1Digit(massPer);
				
				System.out.println("Codons: " + Arrays.toString(codons));
				System.out.println("Encodes a protein: " + encodesStr);
				
				System.out.println();
			} else {
				System.out.println("Name: " + name);
				System.out.println("Nucleotides: NO NUCLEOTIDES FOUND");
			}
		}
		
		scn.close();
	}
	
	//Prints arrays of double to 1 decimal place (used for mass percentages)
	public static void printDoublesTo1Digit(double[] massPer) {
		System.out.print("[");
		
		for(int i = 0; i < massPer.length - 1; i++)
			System.out.printf("%.1f, ", massPer[i]);
		
		System.out.printf("%.1f]", massPer[massPer.length - 1]);
		System.out.println();
	}
	
	//Finds amount of times A, C, G, T appear in the nucleotides
	public static int[] nucCount(String nuc) {
		int[] counts = new int[UNIQUE_NUC];
		
		for(int i = 0; i < nuc.length(); i++) {
			char currChar = nuc.charAt(i);
			
			if(currChar == 'A')
				counts[0]++;
			else if(currChar == 'C')
				counts[1]++;
			else if(currChar == 'G')
				counts[2]++;
			else if(currChar == 'T')
				counts[3]++;
		}
		
		return counts;
	}
	
	//Calculates mass percentages for nucleotides
	public static double[] massPercents(int[] nucleoCount) {
		double[] percents = new double[UNIQUE_NUC];
		double[] weights = {135.128, 111.103, 151.128, 125.107};
		double totalMass = 0;
		
		//Puts total mass of each nucleotide into percents[] and finds total mass
		for(int i = 0; i < UNIQUE_NUC; i++) {
			percents[i] = nucleoCount[i] * weights[i];
			totalMass += percents[i];
		}
		
		//Converts mass of each nucleotide into percent mass
		for(int i = 0; i < UNIQUE_NUC; i++)
			percents[i] = percents[i] * 100 / totalMass;
		
		return percents;
	}
	
	//Parses nucleotides into individual codons and stores in an array
	public static String[] codons(String nuc) {
		String[] codons = new String[nuc.length() / NUC_PER_CODON];
		
		int pos = 0;
		
		for(int i = 0; i < codons.length; i++) {
			codons[i] = nuc.substring(pos, pos + NUC_PER_CODON);
			pos += NUC_PER_CODON;
		}
		
		return codons;
	}
	
	//Checks to see if codons encodes a protein
	public static boolean doesEncodeProtein(String[] codons, double[] massPer) {
		boolean encodes = false;
		
		int len = codons.length - 1;
		
		//Conditions that must be true if encoding occurs
		boolean firstCod = codons[0].equals("ATG");
		boolean lastCod = codons[len].equals("TAA") || codons[len].equals("TAG") || codons[len].equals("TGA");
		boolean codLen = len + 1 >= MIN_CODONS;
		boolean corrMass = massPer[1] + massPer[2] >= PERCENT_MASS_CG;
		
		if(firstCod && lastCod && codLen && corrMass)
			encodes = true;
		
		return encodes;
	}
}