import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

public class InClass25 {

	public static void main(String[] args) {
		//warmup();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		list1.add(1);
		list2.add(1);
		for(int i = 1; i < 10000; i++) {
			list1.add(list1.get(i - 1) + (int)(Math.random() * 10));
			list2.add(list2.get(i - 1) + (int)(Math.random() * 10));
		}
		
		System.out.println("list1: " + list1);
		System.out.println("list2: " + list2);
		System.out.println("intersect: " + intersect(list1, list2));
	}
	
	public static void warmup() {
		ArrayList<String> words = new ArrayList<String>();
		
		String[] wordAry = {"to", "be", "or", "not", "to", "be"};		
		for(int i = 0; i < 6; i++)
			words.add(wordAry[i]);
		
		System.out.println(words);
		
//		for(int i = 5; i > 0; i--)
//			words.add(i, "~");
//		System.out.println(words);
		
		int end = words.size() * 2 - 1;
		for(int i = 1; i < end; i += 2)
			words.add(i, "~");
		System.out.println(words);
		
//		for(int i = 1; i < words.size(); i++)
//			words.remove(i);
		
		end = words.size() / 2 + 1;
		for(int i = 1; i < end; i++)
			words.remove(i);
		System.out.println(words);
	}
	
	public static ArrayList<Integer> intersect(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		int index1 = 0, index2 = 0;
		ArrayList<Integer> out = new ArrayList<Integer>();
		
		while(index1 < list1.size() && index2 < list2.size()) {
			if(list1.get(index1) == list2.get(index2)) {
				out.add(list1.get(index1));
				
				index1++;
				index2++;
			} else if(list1.get(index1) > list2.get(index2)) {
				index2++;
			} else {
				index1++;
			}
		}
		
		return out;
	}
}