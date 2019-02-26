package February;

import java.util.ArrayList;

public class InClass21 {

	public static void main(String[] args) {
		aryVsAryLst();
	}
	
	public static void aryVsAryLst() {
		int[] nums = {1, 2, 3, 4, 5, 6};
		
		ArrayList<Integer> aryList = new ArrayList<Integer>();
		
		for(int i = 0; i < nums.length; i++)
			aryList.add(nums[i]);
		
		//reverse
		for(int i = nums.length; i > 0; i--)
			aryList.add(nums[i - 1]);
		
		System.out.println("ARYLIST: " + aryList);
	}
	
	public static void warmup() {
		ArrayList<String> letters = new ArrayList<String>();
		
		letters.add("a");
		letters.add("c");
		letters.add(1, "b");
		
		System.out.println(letters);
		
		letters.set(letters.indexOf("c"), "t");
		
		System.out.println(letters);
		
		letters.remove(letters.indexOf("b"));
		
		System.out.println(letters);
	}
}