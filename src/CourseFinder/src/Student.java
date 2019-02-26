import java.util.ArrayList;

public class Student {

	private String name;
	private ArrayList<Course> classList;
	
	public Student(String newName) {
		name = newName;
		
		classList = new ArrayList<Course>();
	}
	
	public String getName() {
		return name;
	}
	
	public void addPreferredCourse(Course newCourse) {
		classList.add(newCourse);
	}
	
	public void printPref() {
		System.out.println(classList);
	}
	
	public String toString() {
		return name;
	}
}