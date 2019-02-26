//Hassan Farooq P.5
//January 25, 2019
//Battle project
//Item class
//

public class Item {
	private String type;
	
	//Constructors
	public Item() {
		type = "empty slot";
	}
	
	public Item(String option) {
		if(option.equals("Health potion") || option.equals("Strength potion") || option.equals("Mana potion"))
			type = option;
		else
			type = "empty slot";
	}
	
	//Returns cost of item based on what it is
	public static int getCost(String itemType) {
		int cost = 0;
		
		if(itemType.equals("Health potion"))
			cost = 15;
		else if(itemType.equals("Strength potion"))
			cost = 10;
		else if(itemType.equals("Mana potion"))
			cost = 5;
		
		return cost;
	}
	
	//Uses chosen item
	public void use(Player character) {
		if(type.equals("Health potion")) {
			character.alterHealth(20);
			System.out.println(character.getName() + " now has " + character.getCurrentHealth() + " health.");
		} else if(type.equals("Strength potion")) {
			character.changeDmg(10);
			System.out.println(character.getName() + " can now do more damage.");			
		} else if(type.equals("Mana potion")) {
			if(character instanceof Mage) {
				((Mage) character).alterMana(5);
				System.out.println(character.getName() + " now has " + ((Mage) character).getMana() + " mana.");
			} else {
				System.out.println("Can only use if mage class!");
			}
		} else {
			System.out.println("That inventory slot is empty!");
		}
	}
	
	public String toString() {
		return type;
	}
}
