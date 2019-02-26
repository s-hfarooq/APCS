
public class BerryClient {

	public static void main(String[] args) {
		BerryBush bb = new BerryBush("blue");
		
		for(int i = 0; i < 2; i++)
			bb.growBerry();
		
		String[] magic = {"cures poison", "turns you into a gerbil", "cures gerbil"};
		for(int i = 0; i < 3; i++)
			bb.growBerry(magic[i]);
		
		System.out.println(bb);
	}
}