import java.util.ArrayList;
import java.util.Collections;

public class CardClient {

	public static void main(String[] args) {
		ArrayList<Card> deck = new ArrayList<Card>();
		
		for(int i = 1; i <= 13; i++) {
			deck.add(new Card("Spades", i));
			deck.add(new Card("Hearts", i));
			deck.add(new Card("Clubs", i));
			deck.add(new Card("Diamonds", i));
		}
		
		System.out.println("Original: " + deck);
		Collections.shuffle(deck);
		System.out.println("Shuffled: " + deck);
		System.out.println("Index of '3 of Hearts': " + seqSearch(deck, "3 of Hearts"));
		
		Collections.sort(deck);
		
		//Collections.binarySearch(deck, null);
		System.out.println("Sorted: " + deck);
		int index = seqSearch(deck, "Jack of Diamonds");
		System.out.println("Index of 'Jack of Diamonds' (sequential): " + index);
		System.out.println("Index of 'Jack of Diamonds' (recursive binary): " + recBinSearch(deck, 0, deck.size(), deck.get(index)));
	}
	
	public static int seqSearch(ArrayList<Card> deck, String desired) {
		int index = -1, curr = 0;
		
		while(index == -1 && curr < deck.size()) {
			if(deck.get(curr).toString().equals(desired))
				index = curr;
			curr++;
		}
		
		return index;
	}
	
	public static int recBinSearch(ArrayList<Card> deck, int min, int max, Card desired) {
		int index = (max + min) / 2;
		
		if(deck.size() < 1 || min >= max)
			return -1;
		else if(deck.get(index).compareTo(desired) == 0)
			return index;
		else if(deck.get(index).compareTo(desired) > 0)
			return recBinSearch(deck, min, index + 1, desired);
		else if(deck.get(index).compareTo(desired) < 0)
			return recBinSearch(deck, index - 1, max, desired);
		
		return -1;
	}
}