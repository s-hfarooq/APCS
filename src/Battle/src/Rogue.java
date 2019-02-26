//Hassan Farooq P.5
//January 25, 2019
//Battle project
//Rogue class
//

public class Rogue extends Player {
	private double critChance;
	
	//Constructor
	public Rogue(String newName, Item[] newBag) {
		super(newName, newBag);
		
		critChance = 0;
	}
	
	//Attack method override
	public void attack(Monster enemy) {
		critChance = Math.random();
		
		//Only do a critical hit if the random double is greater than 0.7
		if(critChance > 0.7) {
			int randDmg = (int)(Math.random() * (getMaxDmg() - getMinDmg() + 1)) + getMinDmg();
			setLastDmg(2 * randDmg);
			System.out.println(getName() + " gets a critical hit!");
			enemy.recieveDmg(randDmg);
		} else {
			super.attack(enemy);
		}
	}
}