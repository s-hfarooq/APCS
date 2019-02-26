package February;

import java.util.Arrays;

public class InClass20 {

	public static void main(String[] args) {
		String[] ary = {"abc", "def", "ghi", "jkl", "mno", "pqr"};
		
		System.out.println(Arrays.toString(ary));
		System.out.println(Arrays.toString(addElement(ary, 3, "was")));
		System.out.println(Arrays.toString(removeElement(ary, 3)));
	}
	
	public static String[] addElement(String[] ary, int index, String newString) {		
		String[] newAry = new String[ary.length + 1];
		
		if(index > -1 && index < newAry.length) {
			for(int i = 0; i < index; i++)
				newAry[i] = ary[i];
			
			newAry[index] = newString;
			
			for(int i = index + 1; i < newAry.length; i++)
				newAry[i] = ary[i - 1];	
		} else {
			newAry = ary;
		}
		
		return newAry;
	}
	
	public static String[] removeElement(String[] ary, int index) {
		String[] newAry = new String[ary.length - 1];
		
		if(index > -1 && index < ary.length) {
			for(int i = 0; i < index; i++)
				newAry[i] = ary[i];
			for(int i = index; i < newAry.length; i++)
				newAry[i] = ary[i + 1];
		} else {
			newAry = ary;
		}
		
		return newAry;
	}
}