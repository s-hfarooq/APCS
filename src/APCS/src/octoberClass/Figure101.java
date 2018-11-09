package octoberClass;
public class Figure101 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		multiplyer();
	}
	
	public static void multiplyer() {
		int col = 11;
		int row = 13;
		int finalNum = 0;
		
		for(int rowNum = 0; rowNum < row; rowNum++) {
			System.out.printf("Row%2d: ", rowNum);
			for(int colNum = 0; colNum < col; colNum++) {
				finalNum += 1;
				System.out.printf("%3d ", finalNum);
			}
			
			System.out.println();
		}
		
		System.out.print(col + " times " + row + " is " + finalNum);
	}
}