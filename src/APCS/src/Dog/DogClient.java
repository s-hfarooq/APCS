package Dog;

import java.util.Arrays;

public class DogClient {
	
	public static void main(String[] args) {		
		Pet[] pet2 = {new Dog("dog1"), new Cat("cat1"), new Goldfish("goldfish1"), new Hamster("hamster1")};
		
		for(int i = 0; i < pet2.length; i++) {
			int rand = (int)(Math.random() * 5);
			int rand2 = (int)(Math.random() * pet2.length);
			
			for(int j = 0; j < rand; j++) {
				pet2[i].playWith(pet2[rand2]);
				pet2[i].feed("food");
				pet2[i].playChase();
			}
		}
		
		System.out.println(Arrays.toString(pet2));
		System.out.println("AVG happiness: " + average(pet2));
		
//		testDog();
//		testCat();
//		testHamster();
//		testGoldfish();
//		play();
		
//		Pet[] pets = {new Dog("dog1"), new Cat("cat1"), new Dog("dog2"), new Hamster("hamster1")};
//		
//		pets[3].changeHappiness(2);
//		for(int i = 0; i < 2; i++)
//			pets[0].playWith(pets[1]);
//		for(int i = 0; i < 1; i++)
//			pets[2] = pets[3];
//		
//		System.out.println(Arrays.toString(pets));
//		System.out.println();
//		System.out.println();
////		Arrays.sort(pets);
////		System.out.println(Arrays.toString(pets));
//		
//		System.out.println("AVG: " + average(pets));		
	}
	
	public static double average(Measureable[] list) {
		double total = 0;
		
		for(int i = 0; i < list.length; i++)
			total += list[i].getMeasure();
		
		return total / list.length;
	}
	
	public static int[] removeMid(int ary[]) {
		int len = ary.length;
		int tempAry[] = new int[len - 1];
		int loc = 0;
		
		for(int i = 0; i < len; i++) {
			if(i != len / 2) {
				tempAry[loc] = ary[i];
				loc++;
			}
		}
		
		ary = tempAry;
		return tempAry;
	}
	
//	public static void play() {
//		Pet dg = new Dog("newDog");
//		Pet ct = new Cat("newCat");
//		System.out.println("Dog: " + dg.getHappiness());
//		System.out.println("Cat: " + ct.getHappiness());
//		System.out.println();
//		
//		dg.playWith(ct);
//		System.out.println("Dog: " + dg.getHappiness());
//		System.out.println("Cat: " + ct.getHappiness());
//		System.out.println();
//
//		ct.playWith(dg);
//		System.out.println("Dog: " + dg.getHappiness());
//		System.out.println("Cat: " + ct.getHappiness());
//		System.out.println();
//	}
//	
//	public static void testDog() {
//		Dog dg = new Dog("newDog");
//		
//		for(int i = 0; i < 5; i++) {
//			dg.bark();
//			System.out.println(dg);
//		}
//		
//		System.out.println();
//	}
//	
//	public static void testCat() {
//		Cat ct = new Cat("newCat");
//		
//		for(int i = 0; i < 7; i++) {
//			ct.playChase();
//			System.out.println(ct);
//		}
//		
//		System.out.println();
//	}
//	
//	public static void testHamster() {
//		Hamster hm = new Hamster("newHamster");
//		
//		for(int i = 0; i < 7; i++) {
//			hm.burrow();
//			System.out.println(hm);
//		}
//		
//		System.out.println();
//	}
//
//	public static void testGoldfish() {
//		Goldfish gd = new Goldfish("newGoldfish");
//		
//		for(int i = 0; i < 5; i++) {
//			gd.bubbles();
//			System.out.println(gd);
//		}
//		
//		System.out.println();
//	}
}
