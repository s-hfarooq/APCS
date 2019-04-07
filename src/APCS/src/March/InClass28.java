package March;

import java.util.Arrays;

public class InClass28 {

	public static void main(String[] args) {
		int[] a = {1, 3, 7, 7, 9, 10};
		int[] b = {2, 3, 4, 5, 8, 11, 12, 13, 14};
		
		System.out.println(Arrays.toString(merge(a, b)));
	}
	
	public static int[] merge(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		int indexA = 0, indexB = 0, indexC = 0;
		
		while(indexA < a.length && indexB < a.length) {
			if(a[indexA] <= b[indexB]) {
				c[indexC] = a[indexA];
				indexA++;
			} else {
				c[indexC] = b[indexB];
				indexB++;
			}
			
			indexC++;
		}
		
		while(indexA < a.length) {
			c[indexC] = a[indexA];
			indexA++;
			indexC++;
		}
		
		while(indexB < b.length) {
			c[indexC] = b[indexB];
			indexB++;
			indexC++;
		}
		
//		if(indexA == a.length) {
//			for(int i = indexB; i < b.length; i++) {
//				c[indexC] = b[i];
//				indexC++;
//			}
//		} else if(indexB == b.length) {
//			for(int i = indexA; i < a.length; i++) {
//				c[indexC] = a[i];
//				indexC++;
//			}
//		}
		
		return c;
	}
}