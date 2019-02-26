package HW118;

public class Client {
	public static void main(String[] args) {
		int randSize = (int)(Math.random() * 151) + 50;
		School newSchool = new School(randSize);
		
		System.out.println("SIZE: " + randSize);
		
		for(int i = 0; i < randSize; i++) {
			int num = (int)(Math.PI * i);
			String randGen = (int)(Math.random() * 2) == 0 ? "Boy" : "Girl";
			newSchool.addStudent(num, randGen + num, i);
		}
		
		newSchool.printStudentNames();
	}
}