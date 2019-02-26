package decemberClass;

public class Frog {
	private int numFlies;
	
	public Frog(int flyNumber) {
		numFlies = flyNumber;
	}
	
	public void catchFly() {
		numFlies++;
	}
	
	public String toString() {
		return "Flys caught: " + numFlies;
	}
}
