package Dog;

public class Cat extends Pet {
	private int ownerHappiness;
	
	public Cat(String newName) {
		super(newName);
		
		ownerHappiness = 5;
	}
	
	public void ignore() {
		changeHappiness(1);
	}
	
	public void playChase() {
		changeHappiness(-1);
	}
	
	public void scratch() {
		if(ownerHappiness > 0)
			ownerHappiness--;
	}
	
	public int getOwnerHappiness() {
		return ownerHappiness;
	}
	
	public String toString() {
		return "I'm a cat - " + super.toString();
	}
}
