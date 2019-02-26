package HW1211;

import java.util.Arrays;

public class Cards {

	private int hearts;
	private int spades;
	private int clubs;
	private int diamonds;
	private String[] cardOrder;
	private String[] dealt;
	
	//Set cardOrder equal to something
	public String[] setCards(String[] order) {
		cardOrder = order;
		return cardOrder;
	}
	
	//Shuffle cardOrder array
	public String[] shuffle() {
		String temp;
		
		for (int i = 0; i < cardOrder.length; i++) {
			int ix = (int)(Math.random() * (cardOrder.length - 1));
	        temp = cardOrder[ix];
	        cardOrder[ix] = cardOrder[i];
	        cardOrder[i] = temp;
	    }
		
		return cardOrder;
	}
	
	//Return amnt number of cards (from "top" of deck)
	public String[] dealCards(int amnt) {
		dealt = new String[amnt];
		
		for(int i = 0; i < amnt; i ++)
			dealt[i] = cardOrder[i];
		
		return dealt;
	}
	
	//Find frequency of each suit
	public void setValues() {
		for(int i = 0; i < cardOrder.length; i++) {
			if(cardOrder[i].equals("h"))
				hearts++;
			else if(cardOrder[i].equals("s"))
				spades++;
			else if(cardOrder[i].equals("c"))
				clubs++;
			else if(cardOrder[i].equals("d"))
				diamonds++;
		}
	}
	
	public String[] getOrder() {
		return cardOrder;
	}
	
	public int getHearts() {
		return hearts;
	}
	
	public int getSpades() {
		return spades;
	}
	
	public int getClubs() {
		return clubs;
	}
	
	public int getDiamonds() {
		return diamonds;
	}
	
	public String[] getDealt() {
		return dealt;
	}
	
	public String toString() {
		return Arrays.toString(cardOrder);
	}
}