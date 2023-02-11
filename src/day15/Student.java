package day15;

public class Student {
	private String fName;
	private String lName;
	private double gpa;
	
	public Student(String fName, String lName, double gpa) {
		this.fName = fName;
		this.lName = lName;
		this.gpa = gpa;
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

	public void setfName(String fName) {
		this.fName = fName;
	} // end setfName

	public void setlName(String lName) {
		this.lName = lName;
	} // end setlName

	public void setGpa(double gpa) {
		this.gpa = gpa;
	} // end setGpa
} // end Student