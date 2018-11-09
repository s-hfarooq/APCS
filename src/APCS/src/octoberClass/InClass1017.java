package octoberClass;

public class InClass1017 {

	public static void main(String[] args) {
		//System.out.print(isPrime(15));
		
//		for(int i = 1; i <= 100; i++) {
//			if(isPrime(i))
//				System.out.println(i);
//		}
		
		System.out.println("1, 2, 3 is " + consecutive(1, 3, 2));
		System.out.println("3, 2, 4 is " + consecutive(3, 2, 4));
		System.out.println("-10, -8, -9 is " + consecutive(-10, -8, -9));
		System.out.println("3, 5, 7 is " + consecutive(3, 5, 7));
		System.out.println("1, 2, 2 is " + consecutive(1, 2, 2));
		System.out.println("7, 7, 9 is " + consecutive(7, 7, 9));
		System.out.println("0, -1, 1 is " + consecutive(0, -1, 1));
	}
	
	public static boolean isPrime(int n) {
		boolean prime = true;
		
		for(int i = 2; i < n - 1; i++) {
			if(n % i == 0)
				prime = false;
		}
		
		return prime;
	}
	
	public static boolean consecutive(int a, int b, int c) {
		boolean numConsecutive = false;
		
		int[] values = {a, b, c};
		
		for(int i = 0; i < 2; i++) {
			if(values[i] > values[i+1]) {
				int temperary = values[i];
				values[i] = values[i + 1];
				values[i + 1] = temperary;
			}
		}
		
		if(values[0] == values[1] - 1 && values[0] == values[2] - 2)
			numConsecutive = true;
		
		return numConsecutive;
	}
}


//a != b || b > c
//a == b && a > c
//a >= b || b >= c

//41
