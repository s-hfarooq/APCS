
public class Berry {
	private String color;
	private int tastiness;
	
	public Berry(String newColor, int newTastiness) {
		color = newColor;
		tastiness = newTastiness;
		
		if(tastiness < 1)
			tastiness = 1;
		else if(tastiness > 10)
			tastiness = 10;
	}
	
	public String toString() {
		return "color: " + color + ", tastiness: " + tastiness;
	}
}