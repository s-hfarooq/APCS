package sai;

import java.util.Arrays;

public class HB {
	private String[][] board;
	
	public HB(int row) {
		board = new String[row][3];
		

		int counter = row - 1;
		for(int i = row; i > 0; i--) {
			String temp = "";
			for(int j = 0; j < i; j++)
				temp += i + "";
			board[counter][0] = temp;
			temp = "";
			counter--;
		}
		
		for(int r = 0; r < board.length; r++) {
			for(int c = 1; c < board[r].length; c++) {
				board[r][c] = "*";
			}
		}
		
		System.out.println(Arrays.toString(board[1]));
	}
	
	public boolean move(int colomn1, int colomn2) {
		boolean out = false;
		//checking the paramiter for the coloms
		
		if(colomn1 >= 0 && colomn1 < board[0].length && colomn2 > 0 && colomn2 < board[0].length) {
			//correcting the off by one error
			colomn1 --;
			colomn2 --;
			if(hasItem(colomn1)) {
				String movePeg = getTopItem(colomn1);
				String secondPeg = getTopItem(colomn2);
				
				if(secondPeg.length() == 0)
					secondPeg = "*";
				
				if(movePeg.length() <= secondPeg.length()) {
					out = true;
					getBottomEmpty(colomn1);
					//board[colomn1][getBottomEmpty(colomn1)] = movePeg;
					//board[colomn2][getBottomEmpty(colomn2)] = secondPeg;
				}
			}
		}
		
		return out;
	}
	
	private boolean hasItem(int colomn) {
		boolean out = false;
		for(int r = 0; r < board.length; r++) {
			if(board[r][colomn] != "*") out = true;
		}
		return out;
	}
	
	private String getTopItem(int colomn) {
		String out = "";
		for(int r = 0; r < board.length; r++) {
			if(board[r][colomn] != "*" && out == "") {
				out = board[r][colomn];
			}
		}
		
		return out;
	}
	
	private int getBottomEmpty(int colomn) {
		int out = -1;
		for(int r = 0; r < board.length; r++) {
			if(board[r][colomn] != "*") {
				out = r-1;
				System.out.println(r);

			}
		}
		
		
		return out;
	}
	
	private String removeTopItem(int colomn) {
		for(int r = 0; r < board.length; r++) {
			if(board[r][colomn] != "*") {
				board[r][colomn] = "*";
				return null;
			}
		}
		return null;
	}
	
	public String toString() {
		String out = "";
		
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[r].length; c++) {
				for(int i = 0; i < 9-board[r][c].length(); i++) out += " ";
				out+= board[r][c];
			}
			out+="\n";
		}
		
		return out;
	}
}
