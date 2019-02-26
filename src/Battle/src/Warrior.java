//Hassan Farooq P.5
//January 25, 2019
//Battle project
//Warrior class
//

public class Warrior extends Player {
	private double shieldStrength;
	
	//Constructor
	public Warrior(String newName, Item[] newBag) {
		super(newName, 120, 15, 30, newBag);
		
		shieldStrength = Math.random();
	}
	
	//recieveDmg override
	public void recieveDmg(int damage) {
		int blocked = (int)(shieldStrength * damage);
		System.out.println(getName() + " blocks " + blocked + " damage.");
		alterHealth(blocked - damage);
	}
}