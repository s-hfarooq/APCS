package octoberClass;

public class InClass105 {
	public static void main(String[] args) {
		System.out.print(coneVolume(4, 5));
	}
	
	public static double coneVolume(double radius, double height) {
		double volume = height * Math.pow(radius, 2) * Math.PI / 3.0;
		return volume;
	}
}