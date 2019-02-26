package octoberClass;

public class Figure104 {

	public static void main(String[] args) {
		//areaTriangle(3.0, 5.0, "inches");
		//multTest(3, 4);h
		quadraticForm(2.5, 4, -6.3);
	}
	
	public static void areaTriangle(double base, double height, String units) {
		double area = base * height * 0.5;
		System.out.printf("The area is %.2f square %s\n", area, units);
	}
	
	public static void multTest(int num1, int num2) {
		System.out.println(num1 + " times " + num2 + " is " + (num1 * num2));
	}
	
	public static void quadraticForm(double a, double b, double c) {
		double partOne = (-1 * b) / (2 * a);
		double partTwo = Math.sqrt(Math.pow(b, 2) - (4 * a * c)) / (2 * a);
		System.out.printf("%.3fx² + %.3fx + %.3f ", a, b, c);
		System.out.printf("has solutions of %.3f and %.3f.", (partOne + partTwo), (partOne - partTwo));
	}
}


//Many a student in the computer of fred
//Many a computer in the department of major
//Many a department in the  major of fred
//Many a major in the department of computer