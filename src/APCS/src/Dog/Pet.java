package Dog;

public abstract class Pet implements Comparable, Measureable {
	private String name;
	private int happiness;
	private String favFood;
	
	public Pet(String newName) {
		name = newName;
		favFood = "treat";
		happiness = 5;
	}
	
	public Pet(String newName, String newFavFood) {
		name = newName;
		favFood = newFavFood;
		happiness = 5;
	}
	
	public void playWith(Pet other) {
		this.playOther(other);
		other.playOther(this);
	}
	
	private void playOther(Pet other) {
		if(this instanceof Dog)
			changeHappiness(1);
		else if(this instanceof Cat && (other instanceof Hamster || other instanceof Goldfish))
			changeHappiness(1);
		else if(this instanceof Cat && other instanceof Dog)
			changeHappiness(-1);
		else if(this instanceof Hamster && other instanceof Hamster)
			changeHappiness(1);
		else if(this instanceof Hamster && (other instanceof Dog || other instanceof Cat))
			changeHappiness(-1);
		else if(this instanceof Goldfish && !(other instanceof Goldfish))
			changeHappiness(-1);
	}
	
	protected void changeHappiness(int amnt) {
		if(happiness < 10 && happiness > 0)
			happiness += amnt;
	}
	
	public void playChase() {
		changeHappiness(1);
	}
	
	public void feed(String foodType) {
		if(foodType.equals(favFood))
			changeHappiness(2);
		else
			changeHappiness(1);
	}
	
	public void ignore() {
		changeHappiness(-1);
	}
	
	//Accessors
	public String getName() {
		return name;
	}
	
	public int getHappiness() {
		return happiness;
	}
	
	public String getFavFood() {
		return favFood;
	}
	
	public double getMeasure() {		
		return getHappiness();
	}
	
	public int compareTo(Object obj) {
		int output = 0;
		
		if(obj instanceof Pet) {
			Pet other = (Pet)obj;
			if(this.getHappiness() > other.getHappiness())
				output = 1;
			else if(this.getHappiness() < other.getHappiness())
				output = -1;
		}
		
		return output;
	}
	
	public String toString() {
		return "Name: " + name + ", happiness: " + happiness;
	}
}