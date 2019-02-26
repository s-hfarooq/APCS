package Beverage;

public class SoftDrink extends Beverage {
	private int fizziness;
	
	public SoftDrink(int newOuncesLeft, int newTemperature) {
		super(newOuncesLeft, newTemperature);
		fizziness = 10;
	}
	
	public void drink() {
		super.drink();
		
		if(fizziness > 0)
			fizziness--;
	}
	
	public int getFizziness() {
		return fizziness;
	}
	
	public String toString() {
		return "Soft drink - " + "fizziness: " + fizziness + ", " + super.toString();
	}
}