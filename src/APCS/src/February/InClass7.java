package February;

public class InClass7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public static void doubler(int[][] ary) {
		ary[0][0] *= 2;
		ary[ary.length - 1][0] *= 2;
		ary[0][ary[0].length - 1] *= 2;
		ary[ary.length - 1][ary[ary.length - 1].length  -1] *= 2;
	}
}