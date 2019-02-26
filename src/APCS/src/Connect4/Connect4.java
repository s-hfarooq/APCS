//Hassan Farooq
//APCS P.5
//Connect4 Project
//

package Connect4;

public class Connect4 {
	private char[][] matrix;
	
	public Connect4() {
		matrix = new char[6][7];
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++)
				matrix[i][j] = '-';
		}
	}
	
	//Inserts char into desired column in next open spot (if one exists)
	public boolean insert(int col, char symbol) {
		boolean isValid = true;
		
		//First makes sure that col is within bounds
		//and makes sure the top slot isn't filled,
		//then fills the spot in the next open spot
		if(col < 0 || col > matrix.length || matrix[0][col] != '-') {
			isValid = false;
		} else {
			int fillSpot = 0, loc = matrix.length - 1;
			
			boolean isDone = false;
			while(!isDone) {
				if(loc < 0) {
					isDone = true;
					isValid = false;
				} else if(matrix[loc][col] == '-') {
					isDone = true;
					fillSpot = loc;
				}
				
				loc--;
			}
			
			if(isValid)
				matrix[fillSpot][col] = symbol;
		}
		
		return isValid;
	}
	
	//Checks if board is full
	public boolean isFull() {
		boolean isDraw = true;
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == '-')
					isDraw = false;
			}
		}
		
		return isDraw;
	}
	
	//Checks to see if a player has won
	public boolean hasWon(char symbol) {
		boolean hasWon = false;
		if(rowWon(symbol) || columnWon(symbol) || upDiagWon(symbol) || downDiagWon(symbol))
			hasWon = true;
		
		return hasWon;
	}
	
	//Works
	private boolean rowWon(char symbol) {
		boolean hasWon = false, isDone = false;
		int counter = 0;
		
		String symbStr = "";
		for(int i = 0; i < 4; i++)
			symbStr += symbol;
		
		while(!isDone) {
			String temp = "";
			
			for(int i = 0; i < matrix.length; i++)
				temp += matrix[counter][i];
			
			counter++;
			
			if(temp.indexOf(symbStr) != -1) {
				isDone = true;
				hasWon = true;
			} else if(counter > matrix.length - 1) {
				isDone = true;
			}
		}
		
		return hasWon;
	}
	
	//Works
	private boolean columnWon(char symbol) {
		boolean hasWon = false, isDone = false;
		int counter = 0;
		
		String symbStr = "";
		for(int i = 0; i < 4; i++)
			symbStr += symbol;
		
		while(!isDone) {
			String temp = "";
			
			for(int i = 0; i < matrix.length; i++)
				temp += matrix[i][counter];
			
			counter++;
			
			if(temp.indexOf(symbStr) != -1) {
				isDone = true;
				hasWon = true;
			} else if(counter > matrix[0].length - 1) {
				isDone = true;
			}
		}
		
		return hasWon;
	}
	
	//Works
	private boolean upDiagWon(char symbol) {
		boolean hasWon = false;
		
		for(int i = 0; i < matrix.length - 3; i++) {
			for(int j = 3; j < matrix[i].length; j++) {
				boolean pt1 = symbol == matrix[i][j] && symbol == matrix[i + 1][j - 1];
				boolean pt2 = symbol == matrix[i + 2][j - 2] && symbol == matrix[i + 3][j - 3];
				
				if(pt1 && pt2)
					hasWon = true;
			}
		}
		
		return hasWon;
	}
	
	//Works
	private boolean downDiagWon(char symbol) {		
		boolean hasWon = false;
		
		for(int i = 0; i < matrix.length - 3; i++) {
			for(int j = 0; j < matrix[i].length - 3; j++) {
				boolean pt1 = symbol == matrix[i][j] && symbol == matrix[i + 1][j + 1];
				boolean pt2 = symbol == matrix[i + 2][j + 2] && symbol == matrix[i+3][j+3];
				
				if(pt1 && pt2)
					hasWon = true;
			}
		}
		
		return hasWon;
	}
	
	public String toString() {
		String output = "1234567\n";
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++)
				output += matrix[i][j];
			
			output += "\n";
		}
		
		return output;
	}
}