package Dog;

import java.util.Arrays;

public class StudentClient {

	public static void main(String[] args) {
		Student[] list = {new Student(3), new Student(2.5), new Student(3.7)};
		System.out.printf("AVG: %.2f\n", average(list));
		
		//Sort
		System.out.println(Arrays.toString(list));
		System.out.println();
		System.out.println();
		Arrays.sort(list);
		System.out.println(Arrays.toString(list));
	}
	
	public static double average(Measureable[] list) {
		double total = 0;
		
		for(int i = 0; i < list.length; i++)
			total += list[i].getMeasure();
		
		return total / list.length;
	}
}