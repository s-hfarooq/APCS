package March;

public class SandwichClient {

	public static void main(String[] args) {
		Sandwich s = new Sandwich();
		System.out.println(s);
		
		s.add("peanut butter");
		System.out.println(s);
		
		s.add("jelly");
		System.out.println(s);
		
		s.add("ham");
		System.out.println(s);
		
		s.add("cheese");
		System.out.println(s);
		
		s.eat();
		System.out.println(s);
	}
}