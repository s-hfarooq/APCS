package Beverage;

public class BeverageClient {

	public static void main(String[] args) {
		Coffee cf = new Coffee(25, 200, "Mocha");
		SoftDrink sf = new SoftDrink(25, 33);
		
		System.out.println("Coffee:");
		for(int i = 0; i < 10; i++) {
			cf.drink();
			System.out.println(cf);
		}
		
		System.out.println();
		System.out.println("SoftDrink:");
		for(int i = 0; i < 10; i++) {
			sf.drink();
			System.out.println(sf);
		}
	}
}