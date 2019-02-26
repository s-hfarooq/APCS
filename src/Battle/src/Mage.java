//Hassan Farooq P.5
//January 25, 2019
//Battle project
//Mage class
//

public class Mage extends Player {
	private int mana;
	
	//Constructor
	public Mage(String newName, Item[] newBag, int newMana) {
		super(newName, newBag);
		
		mana = newMana;
	}
	
	//Attack method override
	public void attack(Monster enemy) {
		if(mana > 0) {
			super.attack(enemy);
			mana -= 5;
			System.out.println(getName() + " has " + mana + " left.");
		} else {
			System.out.println("Not enough mana!");
		}
	}
	
	//Increase mana amount
	public void alterMana(int amnt) {
		mana += amnt;
		if(mana < 0)
			mana = 0;
	}
	
	public int getMana() {
		return mana;
	}
}