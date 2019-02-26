
public class Bush {
	private int numBranches;
	private int numLeaves;
	
	public Bush() {
		numBranches = 1;
		numLeaves = 1;
	}
	
	public void growBranch() {
		numBranches++;
	}
	
	public void growLeaf() {
		numLeaves++;
	}
	
	public void grow() {
		growBranch();
		growLeaf();
	}
}