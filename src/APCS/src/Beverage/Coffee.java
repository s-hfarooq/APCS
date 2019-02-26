package Beverage;

public class Coffee extends Beverage {
	private String type;
	
	public Coffee(int newOuncesLeft, int newTemperature, String newType) {
		super(newOuncesLeft, newTemperature);
		type = newType;
	}
	
	public String toString() {
		//return "Coffee - " + super.toString();
		return super.toString() + "\n" + type + " makes me happy!";
	}
}