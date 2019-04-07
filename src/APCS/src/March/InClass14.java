package March;

public class InClass14 {
	
	private static String path = "";
	private static int success = 0;

	public static void main(String[] args) {
		//System.out.println(strangeSum(7, 18));
		explore(0, 0, 2, 3);
		System.out.println("Total successes: " + success);
	}
	
	public static int strangeSum(int lo, int hi) {
		int total = 0;
		
		if(lo > hi)
			return total;
		else if(lo % 3 == 0)
			total += lo;
		return total + strangeSum(lo + 1, hi);	
	}
	
	public static void explore(int curX, int curY, int tarX, int tarY) {
		if(curX == tarX && curY == tarY) {
			System.out.println(path + "- Solution");
			success++;
		} else if(curX > tarX || curY > tarY) {
			System.out.println(path + "- Fail");
		} else {
			path += "E  ";
			explore(curX + 1, curY, tarX, tarY);
			path = path.substring(0, path.length() - 3);
			
			path += "N  ";
			explore(curX, curY + 1, tarX, tarY);
			path = path.substring(0, path.length() - 3);
			
			path += "NE ";
			explore(curX + 1, curY + 1, tarX, tarY);
			path = path.substring(0, path.length() - 3);
		}
	}
}