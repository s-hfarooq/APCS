package Time;

public class Time {
	private int hour;
	private int minute;
	private boolean isPM;
	
	public Time() {
		hour = 12;
		minute = 0;
		isPM = false;
	}
	
	public Time(int newHour, int newMin, boolean pm) {
		hour = newHour;
		minute = newMin;
		isPM = pm;
	}
	
	public void addMinute() {
		addMinute(1);
	}
	
	public void addMinute(int minAdd) {
		minute += minAdd;
		hourCheck();
	}
	
	private void hourCheck() {
		//Increments hour after 60 mins
		while(minute >= 60) {
			minute -= 60;
			hour++;
			
			//Changes to 1 after 12:59
			if(hour > 12)
				hour = 1;
			
			//Toggles AM/PM
			if(hour == 12) {
				if(!isPM)
					isPM = true;
				else
					isPM = false;
			}
		}
		
//		if(minute < 0) {
//			minute += 60;
//			hour--;
//			
//			if(hour < 1) {
//				hour = 12;
//				if(!isPM)
//					isPM = true;
//				else
//					isPM = false;
//			}
//		}
//		
//		int amnt = minute / 60;
//		minute %= 60;
//		for(int i = 0; i < amnt; i++) {
//			hour++;
//			
//			//Changes to 1 after 12:59
//			if(hour > 12)
//				hour = 1;
//			
//			//Toggles AM/PM
//			if(hour == 12) {
//				if(!isPM)
//					isPM = true;
//				else
//					isPM = false;
//			}
//		}
	}
	
	public String toString() {
		//Adds AM/PM to end and 00 if min = 0
		String minStr = minute + "";
		if(minute == 0)
			minStr = "00";
		
		if(!isPM)
			minStr += " AM";
		else
			minStr += " PM";
		
		return hour + ":" + minStr;
	}
}