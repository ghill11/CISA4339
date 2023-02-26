package day17;

public class Ball {
	private String value = "";
	
	public Ball() {
		// do nothing
	} // end ctor
	
	public Ball(String value) {
		this.value = value;
	} // end Ball
	
	public String getValue() {
		return this.value;
	} // end getValue
	
	public void setValue(String inc) {
		this.value = inc;
	} // end setValue
} // end Ball