package day4;

public class Professor extends Person {
	private String title;
	private int experience;
	
	public Professor(String title, String fName, String lName, String experience) {
		super(fName, lName);
		this.title = title;
		this.experience = Integer.valueOf(experience); // what is the semantic meaning of Integer.valueOf()?
	} // end ctor

	public String getTitle() {
		return title;
	} // end getTitle
	
	public void setTitle(String title) {
		this.title = title;
	} // end setTitle

	public int getExperience() {
		return experience;
	} // end getExperience

	public void setExperience(int experience) {
		this.experience = experience;
	} // end setExperience
} // end Professor