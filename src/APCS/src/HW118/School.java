package HW118;

public class School {
	private Student[] students;
	
	public School(int numStudents) {
		students = new Student[numStudents];
	}
	
	public void addStudent(int id, String name, int index) {
		students[index] = new Student(id, name);
	}
	
	public void printStudentNames() { 				
		for(int i = 0; i < students.length; i++)
			System.out.println(students[i].getName());
	}
}