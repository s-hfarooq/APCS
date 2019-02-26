package February;

public class InClass06 {

	public static void main(String[] args) {
		char[][] ary = {{'a', 'b', 'c'}, 
						{'d', 'e', 'f'}};
		
		swap(ary, 0, 0, 1, 1);
		
		String output = "";
		for(int i = 0; i < ary.length; i++) {
			for(int j = 0; j < ary[i].length; j++)
				output += ary[i][j];
			
			output += "\n";
		}
		
		System.out.println(output);
	}
	
	public static void swap(char[][] array, int rowA, int colA, int rowB, int colB) {
		char temp = array[rowA][colA];
		
		array[rowA][colA] = array[rowB][colB];
		array[rowB][colB] = temp;		
	}
}