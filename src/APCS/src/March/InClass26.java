package March;

import java.util.Arrays;

public class InClass26 {

	public static void main(String[] args) {
		int[] arr = {6, 5, 4, 3, 2, 1};
		insertionSort(arr);
		
		int[] arr2 = {6, 5, 4, 3, 2, 1};
		selectionSort(arr2);
	}
	
	public static void insertionSort(int[] arr) {
		int compare = 0, write = 0;
		
		for(int i = 0; i < arr.length; i++, compare++) {
			
			int temp = arr[i];
			write++;
			int index = i - 1;
			
			while(index > -1 && arr[index] > temp) {
				compare++;
				arr[index + 1] = arr[index];
				write++;
				index--;
			}
			
			arr[index + 1] = temp;
			write++;
		}
		
		System.out.println("Insertion sort: " + Arrays.toString(arr));
		System.out.println("\tCompare: " + compare + ", write: " + write);
	}
	
	public static void selectionSort(int[] arr) {
		int compare = 0, write = 0;
		
		for(int i = 0; i < arr.length - 1; i++, compare++) {
			int index = i;
			
			for(int j = i + 1; j < arr.length; j++, compare += 2) {
				if(arr[index] > arr[j])
					index = j;
			}
			
			int temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
			write += 3;
		}		
		
		System.out.println("Selection sort: " + Arrays.toString(arr));
		System.out.println("\tCompare: " + compare + ", write: " + write);
	}
}