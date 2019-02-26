package Dog;

public class Dog extends Pet {
	private int totalBarks;
	
	public Dog(String newName) {
		super(newName);
		totalBarks = 0;
	}
	
	public Dog(String newName, String newTreat) {
		super(newName, newTreat);
	}	
	
	public void bark() {
		totalBarks++;
	}
	
	public int getTotalBarks() {
		return totalBarks;
	}
	
	public String toString() {
		return "I'm a dog - " + super.toString() + " total barks: " + totalBarks;
	}
}