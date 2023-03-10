package day22;

public class Faculty implements Comparable<Faculty> {
	private final String firstName;
	private final String lastName;
	private final int rank;

	public Faculty(String firstName, String lastName, int rank) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.rank = rank;
	} // end ctor

	public int compareTo(Faculty inc) { // this is the key to the prioritization process!
		return ((Integer) this.rank).compareTo(inc.rank);
	} // end compareTo

	@Override
	public String toString() {
		return firstName + " " + lastName + "(" + rank + ")";
	} // end toString
} // end Faculty