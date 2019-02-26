//Hassan Farooq P.5
//January 25, 2019
//Battle project
//Player class
//

public class Player {
	private String name;
	private int maxHealth;
	private int currentHealth;
	private int minDmg;
	private int maxDmg;
	private int lastDmg;
	private int gold;
	private Item[] inventory;
	
	//Constructors
	public Player(String newName, Item[] newBag) {
		name = newName;
		maxHealth = (int)(Math.random() * 20) + 80;
		currentHealth = maxHealth;
		minDmg = (int)(Math.random() * 10) + 15;
		maxDmg = (int)(Math.random() * 10) + minDmg;
		gold = 0;
		inventory = newBag;
	}	
	
	public Player(String newName, int newMaxHealth, int newMinDmg, int newMaxDmg, Item[] newBag) {
		name = newName;
		maxHealth = newMaxHealth;
		currentHealth = maxHealth;
		minDmg = newMinDmg;
		maxDmg = newMaxDmg;
		gold = 0;
		inventory = newBag;
	}
	
	//Attacks monster
	public void attack(Monster enemy) {
		int randDmg = (int)(Math.random() * (maxDmg - minDmg + 1)) + minDmg;
		lastDmg = randDmg;
		enemy.recieveDmg(randDmg);
	}
	
	//Takes away health of player based on damage received
	public void recieveDmg(int damage) {
		int newHealth = currentHealth - damage;
		currentHealth = newHealth <= 0 ? 0 : newHealth;
	}
	
	//Returns true if player is dead, false otherwise
	public boolean isDead() {
		return currentHealth <= 0 ? true : false;
	}
	
	//Add gold
	public void addGold(int amnt) {
		gold += amnt;
	}
	
	//Returns string of inventory
	public String displayInventory() {
		String output = "";
		
		for(int i = 1; i <= inventory.length; i++)
			output += "Item " + i + ": " + inventory[i - 1].toString() + "; ";
		
		return output;
	}
	
	//Use an item in the inventory
	public void useItem(int indexChoice) {
		if(indexChoice < inventory.length && indexChoice > -1)
			inventory[indexChoice].use(this);
		else
			System.out.println("Invalid inventory index!");
	}
	
	//Method for buying an item after checking to make sure it's a valid choice for the character class
	public void buyItem(String itemChoice) {
		if(itemChoice.equals("Mana potion") && !(this instanceof Mage))
			System.out.println("Not a valid option with this class!");
		else
			buyItemAfterCheck(itemChoice);
	}
	
	//Helper method to buy item and add to inventory
	private void buyItemAfterCheck(String itemChoice) {
		//Find cost of item
		int cost = Item.getCost(itemChoice);
		
		//Makes sure item exists and costs less than available gold
		if(cost != 0 && cost <= gold) {
			//Find empty slot, if none available nothing is bought
			int empty = -1;
			for(int i = 0; i < inventory.length; i++) {
				if(inventory[i].toString().equals("empty slot") && empty == -1)
					empty = i;
			}
			
			//If no space exists, print no free space
			if(empty == -1) {
				System.out.println("No free space!");
			} else {
				gold -= cost;
				inventory[empty] = new Item(itemChoice);
			}
			
			System.out.println("Inventory: " + displayInventory());
		} else {
			System.out.println("Not enough gold!");
		}
	}
	
	//Alter damage that can be done
	public void changeDmg(int newDmgRng) {
		minDmg += newDmgRng;
		maxDmg += newDmgRng;
	}
	
	//Alter current health
	public void alterHealth(int amnt) {
		currentHealth += amnt;
		
		if(currentHealth > maxHealth)
			currentHealth = maxHealth;		
	}
	
	//Set the last damage that was done
	protected void setLastDmg(int lDmg) {
		lastDmg = lDmg;
	}
	
	//Accessors
	public String getName() {
		return name;
	}
	
	public Item[] getInventoryArray() {
		return inventory;
	}
	
	public int getCurrentHealth() {
		return currentHealth;
	}
	
	public int getMaxDmg() {
		return maxDmg;
	}
	
	public int getMinDmg() {
		return minDmg;
	}
	
	public int getLastDmg() {
		return lastDmg;
	}
	
	public int getGold() {
		return gold;
	}
	
	public String toString() {
		return name + " currently has " + currentHealth + " health\nwith max health of " + maxHealth +
			   ",\nminimum damage of " + minDmg + ",\nand maximum damage of " + maxDmg;
	}
}