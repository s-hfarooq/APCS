import java.util.ArrayList;

public class Course {
	private String name;
	private int minStudents;
	private int maxStudents;
	ArrayList<Student> students;
	
	public Course(String newName) {
		name = newName;
		minStudents = 5;
		maxStudents = 15;
		
		students = new ArrayList<Student>();
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		String output = name;
		
		for(int i = 0; i < students.size(); i++)
			output += students.get(i) + " ";
		
		return output;
	}
}