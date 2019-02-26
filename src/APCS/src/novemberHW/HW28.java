package novemberHW;

public class HW28 {

	public static void main(String[] args) {
		String[] values = {"one", "two", "three", "four", "five"};
		printAry(values);
		
		stringShift(values);
		printAry(values);
	}
	
	public static void stringShift(String[] values) {
		String temp = values[values.length - 1];
		
		for(int i = values.length - 2; i >= 0; i--)
			values[i + 1] = values[i];
			
		values[0] = temp;
	}
	
	public static void printAry(String[] values) {
		for(int i = 0; i < values.length; i++)
			System.out.print(values[i] + " ");
		System.out.println();
	}
}