package March;

import java.util.ArrayList;

public class Sandwich {
	private ArrayList<String> sandwich;
	
	public Sandwich() {
		sandwich = new ArrayList<String>();
		
		for(int i = 0; i < 2; i++)
			sandwich.add("bread");
	}
	
	public void add(String item) {
		sandwich.add((sandwich.size() + 1 )/ 2, item);
	}
	
	public void eat() {
		sandwich.clear();
	}
	
	public String toString() {
		String output = sandwich.toString();
		if(sandwich.indexOf("peanut butter") != -1 && sandwich.indexOf("ham") != -1 && sandwich.indexOf("cheese") != -1)
			output += " barf";
		
		return output;
	}
}