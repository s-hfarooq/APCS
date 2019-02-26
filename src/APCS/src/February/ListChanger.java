package February;

import java.util.ArrayList;

public class ListChanger {

	public static void main(String[] args) {
		ArrayList<Double> nums = new ArrayList<Double>();
		
		for(int i = 2; i < 21; i += 2)
			nums.add(Math.sqrt(i));
		
		System.out.println(nums);
		
		
		int len = nums.size();
		for(int i = 0; i < len / 2; i++)
			nums.remove(i);
		
		System.out.println(nums);
	}
}