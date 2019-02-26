import java.util.Arrays;

public class BerryBush extends Bush {
	private Berry[] berries;
	private String berryColor;
	
	public BerryBush(String newColor) {
		super();
		
		berryColor = newColor;		
		int tastiness = (int)(Math.random() * 10) + 1;
		
		berries = new Berry[1];
		berries[0] = new Berry(berryColor, tastiness);
	}
	
	public void growBerry(String magic) {
		int tastiness = (int)(Math.random() * 10) + 1;
		
		berries = Arrays.copyOf(berries, berries.length + 1);
		berries[berries.length - 1] = new MagicBerry(berryColor, tastiness, magic);
	}
	
	public void growBerry(int tastiness) {
		berries = Arrays.copyOf(berries, berries.length + 1);
		berries[berries.length - 1] = new Berry(berryColor, tastiness);
	}
	
	public void growBerry() {
		int tastiness = (int)(Math.random() * 10) + 1;
		growBerry(tastiness);
	}
	
	public void grow() {
		super.grow();
		growBerry();
	}
	
	public String toString() {
		return Arrays.toString(berries);
	}
}