package day13;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String fName;
	private String lName;
	private double gpa;
	private List<String> courses;
	
	public Student(String fName, String lName, double gpa) {
		this.fName = fName;
		this.lName = lName;
		this.gpa = gpa;
		this.courses = new ArrayList<String>();
	} // end ctor

	public String getfName() {
		return fName;
	} // end getfName

	public String getlName() {
		return lName;
	} // end getlName

	public double getGpa() {
		return gpa;
	} // end getGpa

	public List<String> getCourses() {
		return courses;
	} // end getCourses
	
	public void addCourse(String inc) {
		this.courses.add(inc); // how can we make this so it won't register for an already existing course?
	} // end addCourse
	
	public void dropCourse(String inc) {
		this.courses.remove(this.courses.indexOf(inc)); // how can we make this robust to invalid courses?
	} // end dropCourse
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.fName).append(" ").append(this.lName).append(" (").append(this.gpa).append(")").append("\n");
		for (String eachOne: courses) {
			sb.append(eachOne).append("\n");
		} // end for
		return sb.toString();
	} // end toString
} // end Student