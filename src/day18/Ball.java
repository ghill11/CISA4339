package day18;

public class Ball {
	private int value = 0;
	
	public Ball() {
		// do nothing
	} // end ctor
	
	public Ball(int value) {
		this.value = value;
	} // end Ball
	
	public int getValue() {
		return this.value;
	} // end getValue
	
	public void setValue(int inc) {
		this.value = inc;
	} // end setValue
} // end Ball