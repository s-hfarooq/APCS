package decemberClass;

public class InClass10 {

	public static void main(String[] args) {
		String[] a = {"ads", "sdfs", "fefsdf"};
		System.out.print(allPlural(a));
	}
	
	public static boolean allPlural(String[] ary) {
		boolean plural = true;
		
//		int i = 0;
//		
//		while(plural && i < ary.length) {
//			if(ary[i].charAt(ary[i].length() - 1) != 's')
//				plural = false;
//			i++;
//		}
		
		for(String s : ary) {
			if(s.charAt(s.length() - 1) != 's')
				plural = false;
		}
		
		return plural;
	}
}

//States
//	mass
//	power
//	color
//	size
//	lengthOfTail
//	wingNumber
//	numOfFeet
//	scaleType
//	numOfTeeth
//	name

//Behavoirs
//	roarSound
//	fireSpewed
//	action
//	distanceFlew