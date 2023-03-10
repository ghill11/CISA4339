package day23;

public class Box <T> {
	
	private T t;
	
	public Box(T inc) {
		this.t = inc;
	} // end ctor
	
	public T get() {
		return this.t;
	} // end get
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("The contents of the box are: ").append(t.toString());
		return sb.toString();
	} // end toString
} // end Box