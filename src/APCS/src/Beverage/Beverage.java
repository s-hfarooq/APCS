package Beverage;

public class Beverage {
	public static final int ROOM_TEMP = 68;
	private int ouncesLeft;
	private int temperature;
	
	public Beverage(int newOuncesLeft, int newTemperature) {
		ouncesLeft = newOuncesLeft;
		temperature = newTemperature;
	}
	
	public void drink() {
		ouncesLeft--;
		
		if(temperature > ROOM_TEMP)
			temperature--;
		else if(temperature < ROOM_TEMP)
			temperature++;
	}
	
	public int getOunces() {
		return ouncesLeft;
	}
	
	public int getTemp() {
		return temperature;
	}
	
	public boolean isRoomTemp() {
		boolean temp = false;
		
		if(temperature == ROOM_TEMP)
			temp = true;
		
		return temp;
	}
	
	public String toString() {
		String out = "left: " + ouncesLeft + "oz, temperature: " + temperature + "F ";
		
		if(temperature == ROOM_TEMP)
			out += "(room temp)";
		if(ouncesLeft <= 0)
			out = "left: none";
		
		return out;
	}
}