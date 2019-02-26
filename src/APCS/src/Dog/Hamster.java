package Dog;

public class Hamster extends Pet {

	public Hamster(String newName) {
		super(newName);
	}
	
	public void burrow() {
		changeHappiness(1);
	}
	
	public Hamster(String newName, String newFavFood) {
		super(newName, newFavFood);
	}
	
	public String toString() {
		return "I'm a hamster - " + super.toString();
	}
}