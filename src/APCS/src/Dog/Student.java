package Dog;

public class Student implements Comparable, Measureable {
	private double GPA;
	
	public Student(double newGPA) {
		GPA = newGPA;
	}
	
	public double getGPA() {
		return GPA;
	}
	
	@Override
	public int compareTo(Object obj) {
		int output = 0;
		
		if(obj instanceof Student) {
			Student other = (Student)obj;
			
			if(this.getGPA() < other.getGPA())
				output = 1;
			else if(this.getGPA() > other.getGPA())
				output = -1;
		}
		
		return output;
	}
	
	@Override
	public double getMeasure() {
		return getGPA();
	}
	
	@Override
	public String toString() {
		return "GPA: " + getGPA();
	}
}