//Hassan Farooq P.5
//February 26, 2019
//CourseFinder project
//Course
//

import java.util.ArrayList;

public class Course {
	private String name;
	private int minStudents;
	private int maxStudents;
	private boolean isLocked;
	ArrayList<Student> students;
	
	public Course(String newName) {
		name = newName;
		minStudents = 5;
		maxStudents = 15;
		isLocked = false;
		
		students = new ArrayList<Student>();
	}
	
	public void addStudent(Student newStudent) {
		students.add(newStudent);
	}
	
	public void dropStudent(Student newStudent) {
		int index = 0;
		String studentName = newStudent.getName();
		
		for(int i = 0; i < students.size(); i ++) {
			if(students.get(i).getName().equals(studentName))
				index = i;
		}
		
		students.remove(index);
	}
	
	public void removeRandomStudent() {
		int rand = (int)(Math.random() * students.size());
		Student randStudent = students.get(rand);
		
		randStudent.dropCourse(this);
		dropStudent(randStudent);
	}
	
	public boolean isTooFull() {
		boolean tooFull = false;
		
		if(students.size() > maxStudents)
			tooFull = true;
		
		return tooFull;
	}
	
	public boolean notEnoughStudents() {
		boolean notEnough = false;
		
		if(students.size() < minStudents)
			notEnough = true;
		
		return notEnough;
	}
	
	public boolean isLocked() {
		return isLocked;
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