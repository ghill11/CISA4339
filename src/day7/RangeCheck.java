package day7;

public class RangeCheck extends Exception {
	
	private static int minimum = 0;
	private static int maximum = 100;
	
	public RangeCheck(String inc) {
		super(inc);
	} // end ctor
	
	public static boolean inRange(int inc) {
		if (inc >= minimum && inc <= maximum) { // what is the semantic meaning of the && symbols?
			return true;
		} else {
			return false;
		} // end else
	} // end inRange
} // end RangeCheck