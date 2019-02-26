package novemberHW;

import java.util.Arrays;

public class HW30 {

	public static void main(String[] args) {
		int[] ary = {26, 12, 25, 19, 46, 31, 22};
		//System.out.println("range: " + range(ary));
		
		//int[] ary2 = {74, 85, 102, 99, 101, 56, 84};
		int[] ary2 = {1, 3, 5, 4, 2};
		System.out.print("kthLargest: " + kthLargest(3, ary2));
	}
	
	public static int range(int[] ary) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		
		for(int x : ary) {
			if(x <= min)
				min = x;
			else if(x >= max)
				max = x;
		}
		
		int range = max - min + 1;
		
//		Arrays.sort(ary);
//		int range = ary[ary.length - 1] - ary[0] + 1;		
		
		return range;
	}
	
	public static int kthLargest(int k, int[] a) {
		Arrays.sort(a);
		
		int value = a[a.length - k - 1];
		
		return value;
	}
}