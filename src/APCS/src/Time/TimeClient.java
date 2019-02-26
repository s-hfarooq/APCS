package Time;

public class TimeClient {

	public static void main(String[] args) {
		Time t = new Time();
		
		for(int i = 0; i < 61; i++) {
			t.addMinute(12);
			System.out.println(t);
		}
	}
}