package Dog;

public class Client {

	public static void main(String[] args) {
		catTest();
		
		System.out.println();
		dogTest();
		
		System.out.println();
		hamsterTest();
		
		System.out.println();
		goldfishTest();
	}
	
	public static void catTest() {
		Cat ct = new Cat("CatName");
		
		for(int i = 0; i < 5; i++) {
			System.out.println(ct);
			ct.playChase();
		}
		
		for(int i = 0; i < 5; i++) {
			System.out.println("Owner happiness: " + ct.getOwnerHappiness());
			ct.scratch();
		}
	}
	
	public static void dogTest() {
		Dog dg = new Dog("DogName");
		
		for(int i = 0; i < 5; i++) {
			System.out.println(dg);
			dg.playChase();
		}
		
		for(int i = 0; i < 5; i++) {
			System.out.println("Barks: " + dg.getTotalBarks());
			dg.bark();
		}
	}
	
	public static void hamsterTest() {
		Hamster hm = new Hamster("HamsterName");
		
		for(int i = 0; i < 5; i++) {
			System.out.println(hm);
			hm.playChase();
		}
		
		hm.burrow();
		System.out.println(hm);
	}
	
	public static void goldfishTest() {
		Goldfish gf = new Goldfish("GoldfishName");
		
		for(int i = 0; i < 5; i++) {
			System.out.println(gf);
			gf.playChase();
		}
		
		gf.bubbles();
		System.out.println(gf);
	}
}