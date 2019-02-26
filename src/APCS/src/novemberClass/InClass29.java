package novemberClass;

public class InClass29 {

	public static void main(String[] args) {
//		int list[] = {3, 7, 12, -8, 29};
//		System.out.println(isPresent(list, 7));
//		System.out.println(isPresent(list, 10));
		
		int[] a1 = {12, 34, 56};
		int[] a2 = {7, 8, 9, 10};
		int[] a3 = merge(a1, a2);
		
		printAry(a1);
		printAry(a2);
		printAry(a3);
	}
	
	public static boolean isPresent(int[] numbers, int value) {
		boolean present = false;
		int i = 0;
		int len = numbers.length - 1;
		
		while(i < len && numbers[i] != value)
			i++;
		
		if(numbers[i] == value)
			present = true;
		
		return present;
	}
	
	public static boolean isPresentFor(int[] numbers, int value) {
		boolean present = false;
		
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] == value)
				present = true;
		}
		
		return present;
	}
	
	public static int[] merge(int[] first, int[] second) {
		int[] newAry = new int[first.length + second.length];
		
		for(int i = 0; i < first.length; i++)
			newAry[i] = first[i];
		for(int i = 0; i < second.length; i++)
			newAry[i + first.length] = second[i];
		
		return newAry;
	}
	
	public static void printAry(int[] ary) {
		for(int i = 0; i < ary.length; i++)
			System.out.print(ary[i] + " ");
		
		System.out.println();
	}
}