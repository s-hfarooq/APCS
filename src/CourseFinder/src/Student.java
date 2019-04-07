// Hassan Farooq P.5
// February 26, 2019
// CourseFinder project
// Student
//

import java.util.ArrayList;

public class Student {
	
	private String name;
	private ArrayList<Course> prefList;
	private ArrayList<Course> actualCourses;
	
	public Student(String newName) {
		name = newName;
		
		prefList = new ArrayList<Course>();
		actualCourses = new ArrayList<Course>();
	}
	
	public void addPreferredCourse(Course newCourse) {
		prefList.add(newCourse);
	}
	
	public void printPref() {
		System.out.println(prefList);
	}
	
	public void removeNextPref() {
		prefList.remove(0);
	}
	
	public boolean hasAnotherPref() {
		return prefList.size() != 0 ? true : false; 
	}
	
	public void addCourse(Course newCourse) {
		actualCourses.add(newCourse);
		newCourse.addStudent(this);
	}
	
	// Removes course from student's actualCourses ArrayList
	public void dropCourse(Course newCourse) {
		int index = 0;
		String courseName = newCourse.getName();
		
		for(int i = 0; i < actualCourses.size(); i++) {
			if(actualCourses.get(i).getName().equals(courseName))
				index = i;
		}
		
		actualCourses.remove(index);
	}
	
	public boolean isDone() {
		boolean isDone = false;
		
		if(actualCourses.size() >= 6)
			isDone = true;
		else if(prefList.size() <= 0)
			isDone = true;
		
		return isDone;
	}
	
	public String getFinalCourses() {
		String output = name + ": ";
		
		for(int i = 0; i < actualCourses.size() - 1; i++) 
			output += actualCourses.get(i).getName() + ", ";
		
		output += actualCourses.get(actualCourses.size() - 1).getName();
		
		return output;
	}
	
	public Course getNextPref() {
		return prefList.remove(0);
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name;
	}
}