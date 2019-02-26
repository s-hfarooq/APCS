package BigBang;

public class BigBang {
	private String name;
	private int lossesRemaining;
	private String lastSymbol;
	private double pRock;
	private double pPaper;
	private double pScissors;
	private double pLizard;
	private double pSpock;
	
	//Constructors
	public BigBang(String newName) {
		name = newName;
		lossesRemaining = 5;
		lastSymbol = null;
		pRock = 0.2;
		pPaper = 0.2;
		pScissors = 0.2;
		pLizard = 0.2;
		pSpock = 0.2;
	}
	
	public BigBang(String newName, int newLR, String newLS, double newPR, double newPP, double newPSc, double newPL, double newPSp) {
		name = newName;
		lossesRemaining = newLR;
		lastSymbol = newLS;
		pRock = newPR;
		pPaper = newPP;
		pScissors = newPSc;
		pLizard = newPL;
		pSpock = newPSp;
	}
	
	//2 players challenge each other, returns 1 if currentUsr wins; 0 if other wins; -1 if tie
	public static int challenge(BigBang currentUsr, BigBang other) {
		String[] val = {"ROCK", "PAPER", "SCISSORS", "LIZARD", "SPOCK"};
		String otherS = other.getLastSymbol();
		String thisS = currentUsr.getLastSymbol();
		int didThisWin = 0;
		
		//Checks to see if this player won (otherwise the other play wins)
		if(thisS.equals(val[0]) && (otherS.equals(val[3]) || otherS.equals(val[2])))
			didThisWin = 1;
		else if(thisS.equals(val[1]) && (otherS.equals(val[0]) || otherS.equals(val[4])))
			didThisWin = 1;
		else if(thisS.equals(val[2]) && (otherS.equals(val[1]) || otherS.equals(val[3])))
			didThisWin = 1;
		else if(thisS.equals(val[3]) && (otherS.equals(val[4]) || otherS.equals(val[1])))
			didThisWin = 1;
		else if(thisS.equals(val[4]) && (otherS.equals(val[2]) || otherS.equals(val[0])))
			didThisWin = 1;
		else if(thisS.equals(otherS))
			didThisWin = -1;
		
		//Removes one from losses remaining
		if(didThisWin == 1)
			other.lost();
		else if(didThisWin == 0)
			currentUsr.lost();
		
		return didThisWin;
	}
	
	//Returns random rock, paper, etc. - based on given probabilities
	public String newSymbol() {
		double rand = Math.random();
		String[] val = {"ROCK", "PAPER", "SCISSORS", "LIZARD", "SPOCK"};
		String randVal;
		
		if(rand < pRock)
			randVal = val[0];
		else if(rand < pRock + pPaper)
			randVal = val[1];
		else if(rand < pRock + pPaper + pScissors)
			randVal = val[2];
		else if(rand < pRock + pPaper + pScissors + pLizard)
			randVal = val[3];
		else if(rand < pRock + pPaper + pScissors + pLizard + pSpock)
			randVal = val[4];
		else
			randVal = "NOT VALID PROBABILITIES";
		
		lastSymbol = randVal;
		
		return randVal;
	}
	
	//Decrements lossesRemaining
	public void lost() {
		lossesRemaining--;
	}
	
	//Sets symbol
	public void setSymbol(String symb) {
		lastSymbol = symb;
	}
	
	//Returns true if lossesRemaning <= 0
	public boolean isEliminated() {
		return lossesRemaining <= 0 ? true : false;
	}
	
	//Returns name
	public String getName() {
		return name;
	}
	
	//Returns last symbol used
	public String getLastSymbol() {
		return lastSymbol;
	}
	
	//Returns losses remaining
	public int getLossesRemaining() {
		return lossesRemaining;
	}
	
	//Prints name/remaining losses/is eliminated
	public String toString() {
		String output = "Name: " + name + ", losses remaining: ";
		output += isEliminated() ? "is eliminated" : lossesRemaining;
		
		return output;
	}
}