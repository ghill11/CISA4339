package day23;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Stack <T> { // T is the convention used for classes
	private List<T> stack;
	
	public Stack(int type) {
		switch (type) {
			case 1: stack = new ArrayList<T>();break;
			case 2: stack = new LinkedList<T>();break;
			default: stack = new Vector<T>();break;
		} // end switch
	} // end ctor
	
	public void push(T inc) {
		this.stack.add(inc);
	} // end push
	
	public Stack <T> chainedPush(T inc) {
		// This exemplifies the "fluent interface" cocnept that allows method chaining
		// in short, the method must return "this" so that the calling code can repetitively
		// invoke the method against the same object
		this.stack.add(inc);
		return this;
	} // end chainedPush
	
	public T pop() { // LIFO
		return this.stack.remove(this.stack.size()-1);
	} // end pop
	
	public T peek() { // LIFO
		return this.stack.get(this.stack.size()-1);
	} // end peek
	
	public boolean isEmpty() {
		return stack.isEmpty();
	} // end isEmpty
	
	public int size() {
		return this.stack.size();
	} // end size
} // end Stack