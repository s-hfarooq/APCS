package February;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class HW20 {

	public static void main(String[] args) throws FileNotFoundException {
			Scanner console = new Scanner(System.in);
			
			ArrayList<String> groceryList = new ArrayList<String>();
			String item = "";
			
			while(!item.equals("done") && !item.equals("exit")) {
				if(groceryList.indexOf(item) == -1)
					groceryList.add(item);
				else
					System.out.println("Already on list");
				
				System.out.print("What do you need to buy? ");
				item = console.nextLine().toLowerCase();
				
				if(item.equals("milk"))
					item = "chocolate milk";
			}
			
			groceryList.remove(0);
			
			int icIndex = groceryList.indexOf("ice cream");
			if(icIndex != -1) {
				if(groceryList.indexOf("hot fudge") == -1)
					groceryList.add("hot fudge");
				
				groceryList.remove(icIndex);
				groceryList.add("ice cream");
			}
			
			int skIndex = groceryList.indexOf("sauerkraut");
			if(skIndex != -1)
				groceryList.remove(skIndex);
			
			System.out.println(groceryList);
			
			if(groceryList.size() > 9)
				System.out.println("Greater than 10 items (" + groceryList.size() + "). Will need help carrying it");
			
			toFile(groceryList);
	}
	
	public static void toFile(ArrayList<String> groceryList) throws FileNotFoundException {
		File f = new File("groceryList.txt");
		PrintStream ps = new PrintStream(f);
		
		ps.println("GROCERY LIST");
		
		if(groceryList.size() > 9)
			ps.println("Greater than 10 items (" + groceryList.size() + "). Will need help carrying it");
		
		ps.println();
		
		for(int i = 0; i < groceryList.size(); i++)
			ps.println((i + 1) + ". " + groceryList.get(i));
	}
}