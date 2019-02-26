package decemberClass;

public class FrogClient {

	public static void main(String[] args) {
		Frog f = new Frog(0);
		for(int i = 0; i < 5; i++) {
			f.catchFly();
			System.out.println(f);
		}
	}
}