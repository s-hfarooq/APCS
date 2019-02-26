package Sem1Review;

import java.util.Scanner;

public class FenceClass {
	private int height;
	private int dist;
	private int posts;
	private int scalar;
	private String output;
	
	public FenceClass(int newHeight, int newDist, int newPosts) {
		height = newHeight;
		dist = newDist;
		posts = newPosts;
		scalar = (int)(Math.random() * 8) + 2;
		output = "";
	}
	
	public void setHeight(int newHeight) {
		height = newHeight;
	}
	
	public void setDist(int newDist) {
		dist = newDist;
	}
	
	public void setNumPosts(int newPosts) {
		posts = newPosts;
	}
	
	public void setScalar(int newScalar) {
		scalar = newScalar;
	}
	
	public String makeFence(int height, int dist, int posts, int scale) {
		String output = "";
		
		height *= scale;
		dist *= scale;
		
		for(int h = 0; h < height; h++) {
			for(int i = 0; i < posts; i++) {
				output += "\"\"";
				
				for(int j = 0; j < dist; j++) {
					if(h == 1)
						output += "*";
					else
						output += " ";
				}
			}
			
			output += "\"\"\n";
		}
		
		this.output = output;
		
		return output;
	}
	
	public String toString() {
		return output;
	}	
}