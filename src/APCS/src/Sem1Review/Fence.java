package Sem1Review;

import java.util.Scanner;

public class Fence {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		boolean done = false;
		int height = 0, dist = 0, posts = 0, scale = 0;
		while(!done) {
			System.out.println("Height, distance, posts, and scale (2-10): ");
			height = console.nextInt();
			dist = console.nextInt();
			posts = console.nextInt();
			scale = console.nextInt();			
			
			if(height < 2 || height > 10 || dist < 2 || dist > 10 || posts < 2 || posts > 10 || scale < 2 || scale > 10)
				done = false;
			else
				done = true;
		}
		
		makeFence(height, dist, posts, scale);
	}
	
	public static void makeFence(int height, int dist, int posts, int scale) {
		height *= scale;
		dist *= scale;
		
		for(int h = 0; h < height; h++) {
			for(int i = 0; i < posts; i++) {
				System.out.print("\"\"");
				
				for(int j = 0; j < dist; j++) {
					if(h == 1)
						System.out.print("*");
					else
						System.out.print(" ");
				}
			}
			
			System.out.println("\"\"");
		}
	}
}
