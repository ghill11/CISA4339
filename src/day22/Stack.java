package day22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Stack {
	private List<String> stack;
	
	public Stack(int type) {
		// Can use multiple underlying concrete data structures, but must be appropriate for required behavior.
		// Must retain insertion order and must retain duplicates! Lists are good candidates, but could also use
		// a LinkedHashMap if K,V behavior was desirable for the focal business problem.
		switch (type) {
			case 1: stack = new ArrayList<String>();break;
			case 2: stack = new LinkedList<String>();break;
			default: stack = new Vector<String>();break;
		} // end switch
	} // end ctor
	
	public void push(String inc) {
		this.stack.add(inc);
	} // end push
	
	public String pop() { // LIFO
		return this.stack.remove(this.stack.size()-1);
	} // end pop
	
	public String peek() { // LIFO
		return this.stack.get(this.stack.size()-1);
	} // end peek
	
	public boolean isEmpty() { // helps to avoid index out of bounds exceptions during usage
		return stack.isEmpty();
	} // end isEmpty
	
	public int size() {
		return this.stack.size();
	} // end size
} // end Stack