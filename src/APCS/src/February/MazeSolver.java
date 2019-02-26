package February;

public class MazeSolver {

	public static void main(String[] args) {
//		char[][] array = {{' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
//						  {' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|'},
//						  {' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' '},
//						  {'|', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' '},
//						  {' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', '|', ' '},
//						  {' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' '},
//						  {' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' '}};
		
		char[][] array = {{' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
						  {' ', ' ', ' ', ' ', '|', ' ', '|', ' ', ' ', '|'},
						  {' ', ' ', '|', ' ', ' ', '|', ' ', ' ', ' ', ' '},
						  {'|', ' ', '|', ' ', ' ', '|', ' ', ' ', ' ', ' '},
						  {' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' '},
						  {' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' '},
						  {' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' '}};
		
		System.out.println("INDEX: " + mazeSolver(array));
	}
	
	public static int mazeSolver(char[][] array) {
		int width = array[0].length, height = array.length;
		int indexX = 0, indexY = 0, counter = 0;
		int max = width * height;
		
		while(indexY < height && counter < max) {
			if(indexX < width - 1 && array[indexY][indexX + 1] == ' ')
				indexX++;
			else
				indexY++;
			
			counter++;
		}
		
		if(counter >= max - 1)
			indexX = -1;
		
		return indexX;
	}
}