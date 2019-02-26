package novemberHW;

public class HW29 {

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5};
		printAry(a);
		a = add(a, 99);
		printAry(a);
		
		int[] b = {1, 5, 7, 9};
		a = remove(a, 2);
		printAry(a);
	}
	
	public static int[] add(int[] a, int element) {
		int[] newAry = new int[a.length + 1];
		
		for(int i = 0; i < a.length; i++)
			newAry[i] = a[i];
		newAry[newAry.length - 1] = element;
		
		return newAry;
	}
	
	public static int[] remove(int[] a, int index) {
		int[] newAry = new int[a.length - 1];
		
		for(int i = 0; i < index; i++)
			newAry[i] = a[i];
		for(int i = index; i < newAry.length; i++)
			newAry[i] = a[i + 1];
		
		return newAry;
	}
	
	public static void printAry(int[] ary) {
		for(int i = 0; i < ary.length; i++)
			System.out.print(ary[i] + " ");
		
		System.out.println();
	}
}