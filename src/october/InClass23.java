package october;

public class InClass23 {

	public static void main(String[] args) {
		//System.out.printf("%.3f", fractionSum(5));
		//printNumbers(5);
		
		//System.out.print(fencepost(6));
		
		System.out.println(digitList(329));
	}
	
	public static double fractionSum(int n) {
		double sum = 0;
		
		for(int i = 1; i <= n; i++)
			sum += 1.0 / i;
		
		return sum;
	}
	
	public static void printNumbers(int n) {
		for(int i = 1; i < n; i++)
			System.out.print(i + ", ");
		System.out.print(n);
	}
	
	public static String fencepost(int n) {
		String fencepostStr = "";
		
		for(int i = 1; i <= n; i++)
			fencepostStr += "|==";
		fencepostStr += "|";
		
		return fencepostStr;
	}
	
	public static String digitList(int num) {
		String finalAns = "";
		int sum = 0;
		int ones = 0, tens = 0, hundreds = 0, thousands = 0, tenThousands = 0;
		
		tenThousands = (num - (num % 10000)) / 10000;
		num -= tenThousands * 10000;
		
		ones = num % 10; 
		tens = ((num % 100) - ones) / 10;
		hundreds = ((num % 1000) - tens) / 100;
		
		thousands = ((num % 10000) - (hundreds * 100)) / 1000;
		
		sum = tenThousands + thousands + hundreds + tens + ones;
		
		if(tenThousands != 0)
			finalAns += tenThousands + ".." + thousands + ".." + hundreds + ".." + tens + "..";
		else if(thousands != 0)
			finalAns += thousands + ".." + hundreds + ".." + tens + "..";
		else if(hundreds != 0)
			finalAns += hundreds + ".." + tens + "..";
		else if(tens != 0)
			finalAns += tens + "..";
		
		finalAns += ones;
				
		System.out.println("Sum = " + sum);
		
		return finalAns;
	}
}