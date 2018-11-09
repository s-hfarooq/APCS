package octoberHW;

public class BoughtMeACat {
	public static void main(String args[]) {

	    String name = null;
	    
	    for(int version = 1; version <= 5; version++) {
		    switch(version) {
		    	case 1: name = "cat";
		    			break;
		    	case 2: name = "student";
		    			break;
		    	case 3: name = "duck";
		    			break;
		    	case 4: name = "goose";
		    			break;
		    	case 5: name = "sheep";
		    			break;
		    }
		    verse(name);
	    }
	}
	
	public static void cat() {
	    System.out.println("Cat goes fiddle-i-fee.\n");
	}
	
	public static void hen() {
	    System.out.println("student goes waaa,");
	    cat();
	}
	
	public static void duck() {
	    System.out.println("Duck goes quack, quack,");
	    hen();
	}
	
	public static void goose() {
	    System.out.println("Goose goes hissy, hissy,");
	    duck();
	}
	
	public static void sheep() {
	    System.out.println("Sheep goes baa, baa,");
	    goose();
	}
	
	public static void verse(String name) {
	    System.out.printf("Bought me a %s and the %s pleased me,\nI fed my %s under yonder tree.\n", name, name, name);
	    
	    switch(name) {
	    	case "cat": cat();
	    				break;
	    	case "hen": hen();
	    				break;
	    	case "duck": duck();
	    				break;
	    	case "goose": goose();
	    				break;
	    	case "sheep": sheep();
	    				break;
	    }
	} 
	
	
	/*public static void main(String args[]) {

	    String name = null;
	    
	    for(int version = 1; version <= 5; version++) {
		    switch(version) {
		    	case 1: name = "cat";
		    			break;
		    	case 2: name = "hen";
		    			break;
		    	case 3: name = "duck";
		    			break;
		    	case 4: name = "goose";
		    			break;
		    	case 5: name = "sheep";
		    			break;
		    }
		    verse(name);
	    }
	}
	
	public static void verse(String name) {
	    System.out.printf("Bought me a %s and the %s pleased me,\nI fed my %s under yonder tree.\n", name, name, name);
	    switchSt(name);
	}
	
	public static void switchSt(String name) {
	    switch(name) {
	    	case "cat": System.out.println("Cat goes fiddle-i-fee.\n");
	    				break;
	    	case "hen": System.out.println("Hen goes chimmy chuck, chimmy chuck,");
	    	            switchSt("cat");
	    				break;
	    	case "duck": System.out.println("Duck goes quack, quack,");
	    	            switchSt("hen");
	    				break;
	    	case "goose": System.out.println("Goose goes hissy, hissy,");
	    	            switchSt("duck");
	    				break;
	    	case "sheep": System.out.println("Sheep goes baa, baa,");
	    	            switchSt("goose");
	    				break;
	    }
	}*/
}