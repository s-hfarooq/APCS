// Hassan Farooq P.5
// February 26, 2019
// CourseFinder project
// Client
//

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseFinder {

	public static void main(String[] args) throws FileNotFoundException {
		long initTime = System.nanoTime();
		
		ArrayList<Course> courses = new ArrayList<Course>();
		ArrayList<Student> students = new ArrayList<Student>();
		
		setup(courses, students);
		
		// Loop through all students, add to next priority
		while(!allStudentsDone(students)) {
			addAllStudentsTopChoice(courses, students);
			
			// Check class overload - add removed students to next preference
			for(int i = 0; i < courses.size(); i++) {
				if(courses.get(i).isTooFull()) {
					while(courses.get(i).isTooFull()) {
						Student rand = courses.get(i).removeRandomStudent();
						addStudentTopChoice(rand);
					}
					
					courses.get(i).lockClass();
				} else if(courses.get(i).amntOverload() == 0) {
					courses.get(i).lockClass();
				}
 			}
		}
		
		// Check underfilled courses and remove students from them
		for(int i = 0; i < courses.size(); i++) {
			if(courses.get(i).notEnoughStudents()) {
				for(int j = courses.get(i).getStudentAmnt() - 1; j >= 0; j--) {
					Student s1 = courses.get(i).getStudent(j);
					courses.get(i).dropStudent(s1);
					s1.dropCourse(courses.get(i));
					
					Course pref = addStudentTopChoice(s1);
					
					if(pref != null && pref.amntOverload() == 0)
					pref.lockClass();
				}
				
				courses.get(i).lockClass();
			}
		}
		
		printOutput(students, courses, initTime);
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
		
		// If a desired course isn't in CouseList.txt but is present in the preferred courses, add it to the courses ArrayList
		if(index == -1) {
			courses.add(new Course(desiredCourse));
			index = courses.size() - 1;
		}
		
		return index;
	}
	
	public static Course addStudentTopChoice(Student student) {
		Course pref = null;
		if(student.hasAnotherPref()) {
			pref = student.getNextPref();
			
			if(!pref.isLocked())
				student.addCourse(pref);
			else
				addStudentTopChoice(student);
		}
		
		return pref;
	}
	
	public static void addAllStudentsTopChoice(ArrayList<Course> courses, ArrayList<Student> students) {
		for(int i = 0; i < students.size(); i ++) {
			if(students.get(i).hasAnotherPref())
				addStudentTopChoice(students.get(i));
		}
	}
	
	public static boolean allStudentsDone(ArrayList<Student> students) {
		boolean done = true;
		int counter = students.size() - 1;
		
		while(done && counter > -1) {
			if(!students.get(counter).isDone())
				done = false;
			counter--;
		}
		
		return done;
	}
	
	public static void printOutput(ArrayList<Student> students, ArrayList<Course> courses, long initTime) throws FileNotFoundException {
		File cRoster = new File("CourseRosters.txt");
		File schedules = new File("StudentSchedules.txt");
		PrintStream rosterPS = new PrintStream(cRoster);
		PrintStream schedulePS = new PrintStream(schedules);
		
		System.out.println("CLASS ROSTERS:");
		for(int i = 0; i < courses.size(); i++)
			System.out.println(courses.get(i));
		for(int i = 0; i < 2; i++)
			System.out.println();
		
		rosterPS.println("CLASS ROSTERS:");
		for(int i = 0; i < courses.size(); i++)
			rosterPS.println(courses.get(i));
		
		System.out.println("STUDENT CLASS LISTS:");
		for(int i = 0; i < students.size(); i++)
			System.out.println(students.get(i).getFinalCourses());
		for(int i = 0; i < 2; i++)
			System.out.println();
		
		schedulePS.println("STUDENT CLASS LISTS:");
		for(int i = 0; i < students.size(); i++)
			schedulePS.println(students.get(i).getFinalCourses());
		
		rosterPS.close();
		schedulePS.close();
		
		long finalTime = System.nanoTime();
		double elapsed = ((double)(finalTime - initTime) / 1000000.0);
		System.out.printf("Elapsed time: %.2f miliseconds\n", elapsed);
	}
}