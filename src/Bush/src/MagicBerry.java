
public class MagicBerry extends Berry {
	private String magicProperty;
	
	public MagicBerry(String newColor, int newTastiness, String newMagicProperty) {
		super(newColor, newTastiness);
		magicProperty = newMagicProperty;
	}
	
	public String toString() {
		return super.toString() + ", magic: " + magicProperty;
	}
}