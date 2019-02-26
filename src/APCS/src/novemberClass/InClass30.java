package novemberClass;

import java.util.Arrays;

public class InClass30 {

	public static void main(String[] args) {
//		String[] strAry1 = {"sdf", "asdfa", "ewrwear", "t"};
//		String[] strAry2 = {"sdfa", "t", "asdfasdf", "rwe"};
//		
//		System.out.print(findRepeats(strAry1, strAry2));
		forEach();
	}
	
	public static void forEach() {
//		int[] nums = new int[6];
//		for(int i = 0; i < nums.length; i++)
//			nums[i] = 99;
//		printAry(nums);
//		
//		int[] n2 = new int[9];
//		int index = 0;
//		for(int x : nums) {
//			n2[index] = x;
//			index++;
//		}
//		printAry(n2);
//		
//		for(int i = 0; i < n2.length; i++)
//			n2[i] = 50 - (3 * i);
//		printAry(n2);
//		
//		Arrays.sort(n2);
//		printAry(n2);
		
		int[] nums = new int[6];
		Arrays.fill(nums, 99);
		System.out.println(Arrays.toString(nums));
		
		int[] n2 = Arrays.copyOf(nums, 9);
		System.out.println(Arrays.toString(n2));
		
		for(int i = 0; i < n2.length; i++)
			n2[i] = 50 - (3 * i);
		System.out.println(Arrays.toString(n2));
		
		Arrays.sort(n2);
		System.out.println(Arrays.toString(n2));
	}
	
	public static void printAry(int[] ary) {
		for(int x : ary)
			System.out.print(x + " ");
		System.out.println();
	}
	
	public static boolean findRepeats(String[] strAry1, String[] strAry2) {
		boolean repeat = false;
		int lenAry1 = strAry1.length;
		int lenAry2 = strAry2.length;
		
//		for(int i = 0; i < lenAry1; i++) {
//			for(int j = 0; j < lenAry2; j++) {
//				if(strAry1[i].equals(strAry2[j]))
//					repeat = true;
//			}
//		}
		
		int i = 0;
		while (i < lenAry1 && !repeat) {
			int j = 0;
			while(j < lenAry2 && !repeat) {
				if(strAry1[i].equals(strAry2[j]))
					repeat = true;
				
				j++;
			}
			i++;
		}
		
		return repeat;
	}
}