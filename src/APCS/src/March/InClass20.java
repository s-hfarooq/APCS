package March;

import java.util.Arrays;

public class InClass20 {

	public static void main(String[] args) {
		int[] a = {0, 1, 2, 3, 4};
		shift(a);
		System.out.println(Arrays.toString(a));
	}
	
	public static void shift(int[] a) {
		int temp = a[a.length - 1];
		
		for(int i = a.length - 1; i > 0; i--)
			a[i] = a[i - 1];
		
		a[0] = temp;
	}	
}