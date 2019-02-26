//Hassan Farooq P.5
//January 25, 2019
//Battle project
//Client
//

import java.util.Scanner;

public class Battle {
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		Player character = characterCreation(console);
		
		int round = 1, wins = 0, nextPlay = 1;
		
		//Continues game while character is still alive and player chooses to fight again or buy an item
		while(!character.isDead() && (nextPlay == 1 || nextPlay == 2)) {
			System.out.print("Type 2 to purchase a new item, 1 to battle another monster, or 0 to quit: ");
			nextPlay = console.nextInt();
			
			if(nextPlay == 1) {
				Monster enemy = monsterCreation(character);
				while(!character.isDead() && !enemy.isDead()) {
					battle(character, enemy, round, console);
					round++;
				}
				
				roundEnding(character, enemy);
			} else if (nextPlay == 2) {
				System.out.print("Which item? 1. health potion (" + Item.getCost("Health potion") + 
								 " gold) 2. strength potion (" + Item.getCost("Strength potion") + 
								 " gold) 3. mana potion (" + Item.getCost("Mana potion") + " gold): ");
				int buy = console.nextInt();
				
				String type = "Health potion";
				if(buy == 2)
					type = "Strength potion";
				else if(buy == 3)
					type = "Mana potion";
				
				character.buyItem(type);
			}
			
			if(!character.isDead() && nextPlay == 1)
				wins++;
			
			round = 1;
		}
		
		gameEnding(character, wins);
	}
	
	//Creates character with name given by user
	public static Player characterCreation(Scanner console) {
		System.out.print("Choose a name for your character: ");
		String name = console.next();
		console.nextLine();
		int chooseClass = 0;
		
		//Makes sure character class is a valid choice
		while(chooseClass < 1 || chooseClass > 3) {
			System.out.print("Choose a class for your character (1. warrior, 2. rogue, 3. mage): ");
			chooseClass = console.nextInt();
		}
		
		Item[] inventory = {new Item(), new Item(), new Item()};
		
		Player character;
		if(chooseClass == 1)
			character = new Warrior(name, inventory);
		else if(chooseClass == 2)
			character = new Rogue(name, inventory);
		else
			character = new Mage(name, inventory, 20);
		
		System.out.println(character);
		System.out.println();
		
		return character;
	}
	
	//Creates monster with random characteristics
	public static Monster monsterCreation(Player character) {
		String[] monsterNames = {"troll", "zombie", "mummy", "dragon"};
		
		//Random characteristics
		int randHealth = (int)(Math.random() * 70) + 30;
		int randMinDmg = (int)(Math.random() * 20) + 5;
		int randMaxDmg = (int)(Math.random() * 10) + randMinDmg;
		int randType = (int)(Math.random() * monsterNames.length);
		
		Monster enemy = new Monster(monsterNames[randType], randHealth, randMinDmg, randMaxDmg);
		
		System.out.println(character.getName() + " has encountered a " + enemy.getType() + "!");
		System.out.println(enemy);
		
		return enemy;
	}
	
	//Battle between given player and monster
	public static void battle(Player character, Monster enemy, int round, Scanner console) {
		//Header
		System.out.println();
		for(int i = 0; i < 34; i++)
			System.out.print("+");
		System.out.print(" ROUND " + round + " ");
		for(int i = 0; i < 34; i++)
			System.out.print("+");
		System.out.println();
				
		//User turn
		playerTurn(character, enemy, console);
		System.out.println();
		
		if(!enemy.isDead()) 
			monsterTurn(character, enemy);
	}
	
	//Player's turn
	public static void playerTurn(Player character, Monster enemy, Scanner console) {
		System.out.println(character.displayInventory());
		System.out.print("Type an inventory slot number or 0 to attack: ");
		int choice = console.nextInt();
		
		//Attack enemy, otherwise use inventory item - 
		//	useItem() has check to make sure choice is within inventory array size
		if(choice == 0) {
			character.attack(enemy);
			System.out.println(character.getName() + " attacks the " + enemy.getType() + 
							   " doing " + character.getLastDmg() + " damage.");
			
			String out = "The " + enemy.getType() + " has " + enemy.getHealth() + " health left.";
			if(enemy.isDead())
				out = "The " + enemy.getType() + " is dead.";
			System.out.println(out);
		} else {
			character.useItem(choice - 1);
		}
	}
	
	//Monster's turn
	public static void monsterTurn(Player character, Monster enemy) {
		enemy.attack(character);
		System.out.println("The " + enemy.getType() + " attacks " + character.getName() + 
						   " doing " + enemy.getLastDmg() + " damage.");
		
		String output = character.getName() + " has " + character.getCurrentHealth() + " health left.";
		
		if(character.isDead())
			output = character.getName() + " is dead.";
		
		System.out.println(output);
	}
	
	//Runs when either the player or enemy dies
	public static void roundEnding(Player character, Monster enemy) {
		//Header
		for(int i = 0; i < 2; i++) {
			System.out.println();
			for(int j = 0; j < 77; j++)
				System.out.print("+");
		}
		
		System.out.println();
		
		String output = "The " + enemy.getType() + " has defeated " + character.getName();
		
		//If the enemy is dead, give the player gold + print out "defeated enemy"
		if(enemy.isDead()) {
			int randGold = (int)(Math.random() * 35) + 5;
			character.addGold(randGold);
			
			output = character.getName() + " has defeated the " + enemy.getType() + 
					 "\n" + character.getName() + " gains " + randGold + " gold\n";
		}
		
		System.out.println();
		System.out.println(output);
	}
	
	//Prints out when the user wants to quit, provides an overview of stats
	public static void gameEnding(Player character, int wins) {
		//Header
		System.out.println();
		for(int i = 0; i < 35; i++)
			System.out.print("+");
		System.out.print(" STATS ");
		for(int i = 0; i < 35; i++)
			System.out.print("+");
		for(int i = 0; i < 2; i++)
			System.out.println();
		
		System.out.println("The game has ended.");
		System.out.println("Monsters defeated: " + wins);
		System.out.println("Final gold: " + character.getGold());
		System.out.println("Final inventory: " + character.displayInventory());
	}
}