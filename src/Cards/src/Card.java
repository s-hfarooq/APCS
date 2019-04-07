
public class Card implements Comparable {
	private String suit;
	private int value;
	
	public Card(String newSuit, int newVal) {
		suit = newSuit;
		value = newVal;
	}
	
	//heart, spade, club, diamond
	public int compareTo(Object obj) {
		int returnVal = 0;
		if(obj instanceof Card) {
			Card crd = (Card)obj;
			
			int thisVal = (getSuitInt() * 100) + value;
			int otherVal = (crd.getSuitInt() * 100) + crd.getValue();
			
			if(thisVal > otherVal)
				returnVal = 1;
			else if(thisVal < otherVal)
				returnVal = -1;
		}
		
		return returnVal;
	}
	
	public int getSuitInt() {
		int output = -1;
		
		if(suit.equals("Hearts"))
			output = 1;
		else if(suit.equals("Spades"))
			output = 2;
		else if(suit.equals("Clubs"))
			output = 3;
		else if(suit.equals("Diamonds"))
			output = 4;
		
		return output;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public int getValue() {
		return value;
	}
	
	public String toString() {
		String output = "";
		
		if(value == 1)
			output += "Ace";
		else if(value == 11)
			output += "Jack";
		else if(value == 12)
			output += "Queen";
		else if(value == 13)
			output += "King";
		else
			output += value;
		
		return output + " of " + suit;
	}
}