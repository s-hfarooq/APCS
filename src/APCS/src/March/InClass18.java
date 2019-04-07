package March;

public class InClass18 {

	public static void main(String[] args) {
		//System.out.println(blocks(5));
		int[] ary = {2,4,8};
		System.out.println(groupSum(0, ary, 14));
	}
	
	public static int blocks(int n) {
		if(n == 0)
			return 0;
		else
			return n + blocks(n - 1);
	}
	
	public static boolean groupSum(int start, int[] ary, int val) {
		if(start == ary.length)
			return val == ary[start - 1];
		else
			return groupSum(start + 1, ary, val - ary[start]) || groupSum(start + 1, ary, val);
	}
}