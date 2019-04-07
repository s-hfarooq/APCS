// Hassan Farooq P.5
// April 2, 2019
// Search/sort project
// Search
//

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Search {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
		int file = -1, sort = -1, search = -1;
		File inputF = new File("words_utf-8.txt");
		ArrayList<String> words = new ArrayList<String>();

		// File
		System.out.println("\t0: words_utf-8\n\t1: words_utf-8-shuffle\n\t2: wordlist-reverseOrder\n\t3: wordlist-shuffled\n\t4: wordlist\n\t5: wordlist-15words-repeated");
		while(file < 0 || file > 5) {
			System.out.print("Choose a file: ");
			file = console.nextInt();
		}
		
		if(file == 1)
			inputF = new File("words_utf-8-shuffled.txt");
		else if(file == 2)
			inputF = new File("wordlist-reverseOrder.txt");
		else if(file == 3)
			inputF = new File("wordlist-shuffled.txt");
		else if(file == 4)
			inputF = new File("wordlist.txt");
		else if(file == 5)
			inputF = new File("wordlist-15words-repeated.txt");

		Scanner fScan = new Scanner(inputF);
		while(fScan.hasNext())
			words.add(fScan.next());
		fScan.close();

		System.out.println("Size: " + words.size());
		
		// Sorting
		System.out.print("Do you want to sort (y/n): ");
		char sortAns = console.next().toLowerCase().charAt(0);
		
		if(sortAns == 'y')
			System.out.println("\t0: Collections.sort\n\t1: insertion sort\n\t2: selection sort\n\t3: merge sort\n\t4. quick sort");
		
		while(sortAns == 'y' && (sort < 0 || sort > 4)) {
			System.out.print("Choose how to sort: ");
			sort = console.nextInt();
		}

		System.out.println("Unsorted:");
		sortList(words, sort);

		// Searching
		System.out.print("\t0: sequential\n\t1: binary\n\t2: recursive binary\n");
		while(search < 0 || search > 2) {
			System.out.print("Choose how to search: ");
			search = console.nextInt();
		}

		// Make sure list is sorted before binary search
		if((search == 1 || search == 2) && sortAns == 'n') {
			System.out.println("You must sort first");
			System.out.println("\t0: Collections.sort\n\t1: insertion sort\n\t2: selection sort\n\t3: merge sort\n\t4. quick sort\n");
			
			while(sort < 0 || sort > 3) {
				System.out.print("Choose how to sort: ");
				sort = console.nextInt();
			}

			System.out.println("Unsorted:");
			sortList(words, sort);
			System.out.println("Sorted:");
			sortList(words, sort);
		}

		System.out.print("Word to search: ");
		String desired = console.next();
		console.close();
		searchList(words, search, desired);
	}

	// Sorts list and prints out time taken
	public static void sortList(ArrayList<String> words, int sort) {
		if(sort == 0) {
			long startTime = System.nanoTime();
			Collections.sort(words);
			long endTime = System.nanoTime();
			System.out.println("\tTIME: " + (endTime - startTime) / 1000000.0 + "ms");
		} else if(sort == 1) {
			long startTime = System.nanoTime();
			insertionSort(words);
			long endTime = System.nanoTime();
			System.out.println("\tTIME: " + (endTime - startTime) / 1000000.0 + "ms");
		} else if(sort == 2) {
			long startTime = System.nanoTime();
			selectionSort(words);
			long endTime = System.nanoTime();
			System.out.println("\tTIME: " + (endTime - startTime) / 1000000.0 + "ms");
		} else if(sort == 3){
			long startTime = System.nanoTime();
			mergeSort(words);
			long endTime = System.nanoTime();
			System.out.println("\tTIME: " + (endTime - startTime) / 1000000.0 + "ms");
		} else {
			long startTime = System.nanoTime();
			quickSort(words, 0, words.size() - 1);
			long endTime = System.nanoTime();
			System.out.println("\tTIME: " + (endTime - startTime) / 1000000.0 + "ms");
		}
	}

	// Searches list and prints out time taken
	public static void searchList(ArrayList<String> words, int search, String desired) {
		if(search == 0) {
			System.out.println("Sequential search:");
			long startTime = System.nanoTime();
			int index = seqSearch(words, desired);
			long endTime = System.nanoTime();
			System.out.println("\tINDEX: " + index);
			System.out.println("\tTIME: " + (endTime - startTime) / 1000000.0 + "ms");
		} else if(search == 1) {
			System.out.println("Binary search:");
			long startTime = System.nanoTime();
			int index = binSearch(words, desired);
			long endTime = System.nanoTime();
			System.out.println("\tINDEX: " + index);
			System.out.println("\tTIME: " + (endTime - startTime) / 1000000.0 + "ms");
		} else {
			System.out.println("Binary recursion search:");
			long startTime = System.nanoTime();
			int index = recBinSearch(words, 0, words.size(), desired);
			System.out.println("\tINDEX: " + index);
			long endTime = System.nanoTime();
			System.out.println("\tTIME: " + (endTime - startTime) / 1000000.0 + "ms");
		}
	}

	// Sequence search
	public static int seqSearch(ArrayList<String> words, String desired) {
		int index = -1, curr = 0;
		
		while(index == -1 && curr < words.size()) {
			if(words.get(curr).equals(desired))
				index = curr;
			curr++;
		}
		
		return index;
	}

	// Binary search
	public static int binSearch(ArrayList<String> words, String desired) {
		int i = 0, max = words.size() - 1;

		while(i <= max) {
			int temp = i + (max - i) / 2;

			if(words.get(temp).equals(desired))
				return temp;
			if(words.get(temp).compareTo(desired) < 0)
				i = temp + 1;
			else
				max = temp - 1;
		}

		return -1;
	}

	// Recursive binary search
	public static int recBinSearch(ArrayList<String> words, int start, int end, String desired) {
		int i = (start + end) / 2;

		if(words.get(i).equals(desired))
			return i;
		else if(words.get(i).compareTo(desired) > 0)
			return recBinSearch(words, start, i - 1, desired);
		else if(words.get(i).compareTo(desired) < 0)
			return recBinSearch(words, i + 1, end, desired);

		return -1;
	}

	// Insertion sort
	public static void insertionSort(ArrayList<String> words) {
		for(int i = 1; i <= words.size() - 1; i++) {
			String originalStr = words.get(i);
			int tempInt = i - 1;

			while(tempInt >= 0 && words.get(tempInt).compareTo(originalStr) > 0) {
				words.set(tempInt + 1, words.get(tempInt));
				tempInt--;
			}

			words.set(tempInt + 1, originalStr);
		}
	}

	// Selection sort
	public static void selectionSort(ArrayList<String> words) {
		for(int i = 0; i < words.size(); i++) {
			int index = i;
			String temp = words.get(i);

			for(int j = i + 1; j < words.size(); j++) {
				if(words.get(j).compareTo(temp) < 0) {
					temp = words.get(j);
					index = j;
				}
			}

			temp = words.get(index);
			words.set(index, words.get(i));
			words.set(i, temp);
		}
	}
	
	// Merge sort
	public static ArrayList<String> mergeSort(ArrayList<String> a) {
		ArrayList<String> first = new ArrayList<String>();
		ArrayList<String> second = new ArrayList<String>();

		if(a.size() == 1) {
			return a;
		} else {
			for(int i = 0; i < a.size() / 2; i++)
				first.add(a.get(i));
			for(int i = a.size() / 2; i < a.size(); i++)
				second.add(a.get(i));

			first = mergeSort(first);
			second = mergeSort(second);

			merge(first, second, a);
		}

		return a;
	}

	// Merge sort helper method - merges two ArrayLists
	private static void merge(ArrayList<String> first, ArrayList<String> second, ArrayList<String> a) {
		int indexF = 0, indexS = 0, indexA = 0;

		while(indexF < first.size() && indexS < second.size()) {
			if(first.get(indexF).compareTo(second.get(indexS)) < 0) {
				a.set(indexA, first.get(indexF));
				indexF++;
			} else {
				a.set(indexA, second.get(indexS));
				indexS++;
			}

			indexA++;
		}

		while(indexF < first.size()) {
			a.set(indexA, first.get(indexF));
			indexF++;
			indexA++;
		}

		while(indexS < second.size()) {
			a.set(indexA, second.get(indexS));
			indexS++;
			indexA++;
		}
	}
	
	// Quick sort
	private static ArrayList<String> quickSort(ArrayList<String> words, int lower, int upper) {
		int i = lower, j = upper;
		int pivotIndex = (int)(Math.random() * (upper - lower + 1)) + lower;
		String pivot = words.get(pivotIndex);
		
		while(i <= j) {
			while(words.get(i).compareTo(pivot) < 0)
				i++;
			while(words.get(j).compareTo(pivot) > 0)
				j--;
			
			if(i <= j) {
				String temp = words.get(i);
				words.set(i, words.get(j));
				words.set(j, temp);
				i++;
				j--;
			}
		}
		
		if(j > lower)
			quickSort(words, lower, j);
		if(i < upper)
			quickSort(words, i, upper);
		
		return words;
	}
}