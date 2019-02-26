package Dog;

public class Goldfish extends Pet {

	public Goldfish(String newName) {
		super(newName);
	}
	
	public void playChase() {
		changeHappiness(-1);
	}
	
	public void bubbles() {
		changeHappiness(1);
	}
	
	public void ignore() {
		changeHappiness(1);
	}
	
	public String toString() {
		return "I'm a goldfish - " + super.toString();
	}

}