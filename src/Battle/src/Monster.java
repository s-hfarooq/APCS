//Hassan Farooq P.5
//January 25, 2019
//Battle project
//Monster class
//

public class Monster {
	private String type;
	private int health;
	private int minDmg;
	private int maxDmg;
	private int lastDmg;
	
	//Constructor
	public Monster(String newType, int newHealth, int newMinDmg, int newMaxDmg) {
		type = newType;
		health = newHealth;
		minDmg = newMinDmg;
		maxDmg = newMaxDmg;
	}
	
	//Attacks player
	public void attack(Player enemy) {
		int randDmg = (int)(Math.random() * (maxDmg - minDmg + 1)) + minDmg;
		lastDmg = randDmg;
		enemy.recieveDmg(randDmg);
	}
	
	//Takes away health of monster based on damage received
	public void recieveDmg(int damage) {
		int newHealth = health - damage;
		health = newHealth <= 0 ? 0 : newHealth;
	}
	
	//Returns true if monster is dead, false otherwise
	public boolean isDead() {
		return health <= 0 ? true : false;
	}
	
	//Accessors
	public String getType() {
		return type;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getLastDmg() {
		return lastDmg;
	}
	
	public String toString() {
		return type + " currently has " + health + " health with\nminimum damage of " + 
			   minDmg + ",\nand maximum damage of " + maxDmg;
	}
}