//Hassan Farooq P.5
//February 26, 2019
//CourseFinder project
//Client
//

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseFinder {

	public static void main(String[] args) throws FileNotFoundException {		
		ArrayList<Course> courses = new ArrayList<Course>();
		ArrayList<Student> students = new ArrayList<Student>();
		
		setup(courses, students);
		addStudentTopChoice(courses, students);
		checkOverload();
		
		printOutput(students, courses);
	}
	
	public static void checkOverload() {
		
	}
	
	public static void addStudentTopChoice(ArrayList<Course> courses, ArrayList<Student> students) {
		for(int i = 0; i < students.size(); i ++) {
			Course pref = students.get(i).getNextPref();
			students.get(i).addCourse(pref);
		}
	}
	
	public static void setup(ArrayList<Course> courses, ArrayList<Student> students) throws FileNotFoundException {
		File studentList = new File("StudentList.txt");
		File courseList = new File("CourseList.txt");
		Scanner sListScn = new Scanner(studentList);
		Scanner cListScn = new Scanner(courseList);
		
		// Course ArrayList setup
		while(cListScn.hasNextLine()) {
			Scanner newLine = new Scanner(cListScn.nextLine());
			courses.add(new Course(newLine.next()));
			newLine.close();
		}
		
		// Student ArrayList setup
		while(sListScn.hasNextLine()) {
			Scanner newLine = new Scanner(sListScn.nextLine());
			students.add(new Student(newLine.next()));
			
			// Each individual student
			while(newLine.hasNext()) {
				String desiredCourse = newLine.next();
				
				int index = getDesiredCourseIndex(courses, students, desiredCourse);
				students.get(students.size() - 1).addPreferredCourse(courses.get(index));
			}
			
			newLine.close();
		}
		
		sListScn.close();
		cListScn.close();
	}
	
	public static int getDesiredCourseIndex(ArrayList<Course> courses, ArrayList<Student> students, String desiredCourse) {
		int index = -1;
		
		for(int i = 0; i < courses.size(); i ++) {
			if(courses.get(i).getName().equals(desiredCourse))
				index = i;
		}
		
		// If a desired course isn't in CouseList.txt, still add it to the courses ArrayList
		if(index == -1) {
			courses.add(new Course(desiredCourse));
			index = courses.size() - 1;
		}
		
		return index;
	}
	
	public static void printOutput(ArrayList<Student> students, ArrayList<Course> courses) {
		System.out.println("Students: " + students);
		
		for(int i = 0; i < students.size(); i++) {
			System.out.print(students.get(i) + ": ");
			students.get(i).printPref();
		}
		
		System.out.println("All courses: " + courses);
	}
}