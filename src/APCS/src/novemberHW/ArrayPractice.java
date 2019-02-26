package novemberHW;

import java.util.Arrays;

public class ArrayPractice {

	public static void main(String[] args) {
		//#1
//		int[] a1 = {10, 20, 30, 40, 50, 60};
//		int[] a2 = {10, 20, 30, 40, 50, 60};
//		int[] a3 = {20, 3, 50, 10, 68};
//		System.out.print(equals(a1, a2));
		
		//#2
//		int[] a1 = {5, 78, 4, 10, 7, 8, 3};
//		System.out.print(countLower(a1, 7));
		
		//#3
//		int[] a1 = {91, 92, 93, 94, 97, 96};
//		System.out.print(isInOrder(a1));
		
		//#4
//		int[] array = {1, 3, 6, 7, 12};
//		System.out.print(minGap(array));
		
		//#5
//		int[] ary = {6, 2, 9, 11, 3};
//		System.out.print(percentEven(ary));
		
		//#6
//		int[] a1 = {11, 42, -5, 27, 0, 89};
//		int[] a2 = {10, 20, 30, 40, 50, 60};
//		swapAll(a1, a2);
//		System.out.print(Arrays.toString(a1) + "\n" + Arrays.toString(a2));
		
		//#7
//		int[] a1 = {5, 78, 4, 10, 7, 8, 3};
//		System.out.print(Arrays.toString(largerNeighbor(a1)));

		//#8
//		int[] a1 = {5, 78, 4, 10, 7, 8, 3};
//		System.out.print(secondLargest(a1));
		
		//#9
//		int[] a1 = {10, 20, 30, 40, 50, 60};
//		int[] a2 = {91, 92, 93, 94, 95, 96};
//		System.out.print(Arrays.toString(copyRange(a1, a2, 0, 2, 3)));
		
		//#10
//		int[] a1 = {5, 78, 4, 10, 7, 8, 3};
//		System.out.print(Arrays.toString(removeLower(a1, 7)));
		
		//#11
//		int[] a1 = {5, 78, 4, 10, 7, 8, 3};
//		System.out.print(Arrays.toString(evenFirst(a1)));
		
		//#12
//		int[] a1 = {18, 7, 4, 24, 11};
//		System.out.print(Arrays.toString(strech(a1)));
	}
	
	//#1
	public static boolean equals(int[] ary1, int[] ary2) {
		boolean isSame = true;
		
		if(ary1.length != ary2.length) {
			isSame = false;
		} else {
			for(int i = 0; i < ary1.length; i++) {
				if(ary1[i] != ary2[i])
					isSame = false;
			}
		}
		
		return isSame;
	}
	
	//#2
	public static int countLower(int[] ary, int val) {
		int counter = 0;
		for(int i = 0; i < ary.length; i++) {
			if(ary[i] < val)
				counter++;
		}
		
		return counter;
	}
	
	//#3
	public static boolean isInOrder(int[] ary) {
		boolean order = true;
		
		for(int i = 0; i < ary.length - 1; i++) {
			if(ary[i] > ary[i + 1])
				order = false;
		}
		
		return order;
	}
	
	//#4
	public static int minGap(int[] ary) {
		int gap = Integer.MAX_VALUE;
		
		for(int i = 0; i < ary.length - 1; i++) {
			int tempGap = Math.abs(ary[i] - ary[i + 1]);
			if(tempGap <= gap)
				gap = tempGap;
		}
		
		return gap;
	}
	
	//#5
	public static double percentEven(int[] ary) {
		int counter = 0;
		
		for(int i = 0; i < ary.length; i++) {
			if(ary[i] % 2 == 0)
				counter++;
		}
		
		double even = (double)counter * 100 / ary.length;
		
		return even;
	}
	
	//#6
	public static void swapAll(int[] ary1, int[] ary2) {
		for(int i = 0; i < ary1.length; i++) {
			int temp = 0;
			temp = ary1[i];
			ary1[i] = ary2[i];
			ary2[i] = temp;
		}
	}
	
	//#7
	public static int[] largerNeighbor(int[] ary) {
		int[] ary2 = new int[ary.length];
		
		for(int i = 0; i < ary.length; i++)
			ary2[i] = ary[i];
		
		for(int i = 1; i < ary.length - 1; i++) {
			if(ary2[i - 1] >= ary2[i + 1])
				ary[i] = ary2[i - 1];
			else
				ary[i] = ary2[i + 1];
		}
		
		return ary;
	}
	
	//#8
	public static int secondLargest(int[] ary) {
		Arrays.sort(ary);
		int sLar = ary[ary.length - 2];
		
		return sLar;
	}
	
	//#9
	public static int[] copyRange(int[] ary1, int[] ary2, int i1, int i2, int l) {
		int[] temp = new int[l];
		
		for(int i = 0; i < l; i++)
			temp[i] = ary1[i1 + i];
		
		for(int i = 0; i < l; i++) {
			ary2[i2 + i] = temp[i];
		}
		
		return ary2;
	}
	
	//#10
	public static int[] removeLower(int[] ary, int val) {
		int below = 0;
		
		for(int i = 0; i < ary.length; i++) {
			if(ary[i] < val)
				below++;
		}
		
		int[] newAry = new int[ary.length - below];
		int counter = 0;
		for(int i = 0; i < ary.length; i++) {
			if(ary[i] >= val) {
				newAry[counter] = ary[i];
				counter++;
			}
		}
		
		return newAry;
	}
	
	//#11
	public static int[] evenFirst(int[] ary) {
		int[] ary2 = new int[ary.length];
		int counterEven = 0, counterOdd = 0;
		for(int i = 0; i < ary.length; i++) {
			if(ary[i] % 2 == 0) {
				ary2[counterEven] = ary[i];
				counterEven++;
			} else {
				ary2[ary2.length - 1 - counterOdd] = ary[i];
				counterOdd++;
			}
		}
		
		for(int i = 0; i < ary.length; i++)
			ary[i] = ary2[i];
		
		return ary;
	}
	
	//#12
	public static int[] strech(int[] ary) {
		int[] ary2 = new int[ary.length * 2];
		
		for(int i = 0; i < ary2.length - 1; i ++) {
			if(ary[i / 2] % 2 == 0) {
				ary2[i] = ary[i / 2] / 2;
				ary2[i + 1] = ary[i / 2] / 2;
			} else {
				ary2[i] = ary[i / 2] /2 + 1;
				ary2[i + 1] = ary[i / 2] / 2;
			}
		}
		
		return ary2;
	}
}