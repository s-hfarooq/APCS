//Hassan Farooq P.5
//February 26, 2019
//CourseFinder project
//Student
//

import java.util.ArrayList;

public class Student {

	private String name;
	private ArrayList<Course> prefList;
	private ArrayList<Course> actualCourses;
	
	public Student(String newName) {
		name = newName;
		
		prefList = new ArrayList<Course>();
	}
	
	public String getName() {
		return name;
	}
	
	public void addPreferredCourse(Course newCourse) {
		prefList.add(newCourse);
	}
	
	public void printPref() {
		System.out.println(prefList);
	}
	
	public Course getNextPref() {
		return prefList.remove(0);
	}
	
	public void addCourse(Course newCourse) {
		actualCourses.add(newCourse);
		newCourse.addStudent(this);
	}
	
	public void dropCourse(Course newCourse) {
		int index = 0;
		String courseName = newCourse.getName();
		
		for(int i = 0; i < actualCourses.size(); i ++) {
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
	
	public String toString() {
		return name;
	}
}