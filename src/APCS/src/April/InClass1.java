package April;

import java.util.Arrays;
import java.util.Scanner;

public class InClass1 {
	
	private static boolean isSorted = false;

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		System.out.print("Enter n, min, and max values: ");
		int n = console.nextInt();
		int min = console.nextInt();
		int max = console.nextInt();
		int[] arr = testArray(n, min, max);
		
		boolean isDone = false;
		
		while(!isDone) {
			System.out.print("Do you want to print the array (y/n)? ");
			if(console.next().toLowerCase().charAt(0)  == 'y')
				System.out.println(Arrays.toString(arr));
			
			System.out.print("Do you want to search for a value (y/n)? ");
			if(console.next().toLowerCase().charAt(0) == 'y') {
				System.out.print("Value to search for: ");
				int searchVal = console.nextInt();
				
				if(!isSorted) {
					System.out.println("The array must first be sorted");
					
					int sortType = 0;
					while(sortType < 1 || sortType > 2) {
						System.out.print("How do you want to sort (1. insertion, 2. selection): ");
						sortType = console.nextInt();
					}
					
					if(sortType == 1)
						insertionSort(arr);
					else
						selectionSort(arr);
					
					System.out.println("Sorted array: " + Arrays.toString(arr));
				}
				
				int index = binarySearch(arr, 0, arr.length, searchVal);
				System.out.println("Index of " + searchVal + " is " + index);
			}
			
			System.out.print("Do you want to shuffle the array (y/n)? ");
			if(console.next().toLowerCase().charAt(0) == 'y') {
				shuffle(arr);
				System.out.println(Arrays.toString(arr));
			}
			
			System.out.print("Repeat (y/n)? ");
			if(console.next().toLowerCase().charAt(0) != 'y')
				isDone = true;
		}
		
		console.close();
	}
	
	// Works
	public static int[] testArray(int n, int min, int max) {
		int[] arr = new int[n];
		
		// Fills array with random ints within given range
		for(int i = 0; i < n; i++)
			arr[i] = (int)(Math.random() * (max - min + 1)) + min;
		
		return arr;
	}
	
	// Works
	public static void insertionSort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int tempVal = arr[i];
			int tempIndex = i - 1;
			
			// Moves all smaller values towards left side - left side already sorted while right side still needs sorting
			while(tempIndex > -1 && arr[tempIndex] > tempVal) {
				arr[tempIndex + 1] = arr[tempIndex];
				tempIndex--;
			}
			
			arr[tempIndex + 1] = tempVal;
		}
		
		isSorted = true;
	}
	
	// Works
	public static void selectionSort(int[] arr) {
		// Finds smallest value on right side and moves to left
		for(int i = 0; i < arr.length; i++) {
			int min = findMin(i, arr);
			swap(arr, i, min);
		}
		
		isSorted = true;
	}
	
	// Works
	public static int findMin(int index, int[] array) {
		int value = array[index];
		int min = index;
		
		// Goes through array to find smallest value from starting index
		for(int i = index + 1; i < array.length; i++) {
			if(array[i]<value) {
				value = array[i];
				min = i;
			}
		}
		
		return min;
	}
	
	// Works
	public static void swap(int[] arr, int index, int min) {
		// Swaps elements at index and min locations in arr
		int temp = arr[index];
		arr[index] = arr[min];
		arr[min] = temp;
	}
	
	// Works
	public static int binarySearch(int[] arr, int min, int max, int value) {
		// Splits array into 2, finds out which side value will be on, then recursively splits/searches that
		int index = (max + min) / 2;
		
		if(min > max)
			return -1;
		if(arr[index] == value)
			return index;
		else if(arr[index] > value)
			return binarySearch(arr, min, index - 1, value);
		else if(arr[index] < value)
			return binarySearch(arr, index + 1, max, value);

		return -1;
	}
	
	// Works
	public static void shuffle(int[] arr) {
		// Swaps value at index i with a value at a random index
		for(int i = 0; i < arr.length; i++) {
			int rand = (int)(Math.random() * arr.length);
			swap(arr, i, rand);
		}
		
		isSorted = false;
	}
}