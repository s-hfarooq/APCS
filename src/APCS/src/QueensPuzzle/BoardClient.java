package QueensPuzzle;

public class BoardClient {

	public static void main(String[] args) {
		Board b = new Board(8);
		
		System.out.println(b);
		b.place(4, 5);
		System.out.println(b);
		System.out.println(b);
		System.out.println(b.isSafe(6, 6));
	}
}