package QueensPuzzle;

public class Board {
	int size;
	boolean[][] board;
	
	public Board(int newSize) {
		size = newSize;
		board = new boolean[size][size];
	}
	
	public boolean isSafe(int row, int column) {
		boolean safe = true;
		
		for(int i = 0; i < size; i++) {
			if(board[i][column])
				safe = false;
			if(board[row][i])
				safe = false;
		}
		
		int r = row, c = column;
		while(safe && r > 0 && c > 0) {
			if(board[r][c])
				safe = false;
			r--;
			c--;
		}
		
		r = row;
		c = column;
		while(safe && r < size && c < size) {
			if(board[r][c])
				safe = false;
			r++;
			c++;
		}
		
		r = row;
		c = column;
		while(safe && r < size && c > 0) {
			if(board[r][c])
				safe = false;
			r++;
			c--;
		}
		
		r = row;
		c = column;
		while(safe && r > 0 && c < size) {
			if(board[r][c])
				safe = false;
			r--;
			c++;
		}
		
		return safe;
	}
	
//	public boolean queenRecursion(int n, int row, int column) {
//		if(n == 8) {
//			return true;
//		} else {
//			if(isSafe(row, column))
//				queenRecursion(n + 1, 1, 3);
//			
//			return false;
//		}
//	}
	
	public void place(int row, int column) {
		board[row][column] = true;
	}
	
	public void remove(int row, int column) {
		board[row][column] = false;
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
		String output = " ";
		
		for(int i = 0; i < size; i++) {
			output += " " + i + " ";
		}
		
		output += "\n";
		
		for(int i = 0; i < size; i++) {
			output += i;
			for(int j = 0; j < size; j++) {
				if(board[i][j])
					output += " X ";
				else
					output += " - ";
			}
			
			output += "\n";
		}
		
		return output;
	}
}