package day4;

public class Person {
	private String fName;
	private String lName;
	
	public Person(String fName, String lName) {
		this.fName = fName;
		this.lName = lName;
	} // end ctor

	public String getfName() {
		return fName;
	} // end getfName

	public void setfName(String fName) {
		this.fName = fName;
	} // end setfName

	public String getlName() {
		return lName;
	} // end getlName

	public void setlName(String lName) {
		this.lName = lName;
	} // end setlName

	@Override
	public String toString() {
		return "Person [fName=" + fName + ", lName=" + lName + "]";
	} // end toString
} // end Person