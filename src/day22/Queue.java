package day22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Queue {
	private List<String> queue;
	
	public Queue(int type) {
		// Can use multiple underlying concrete data structures, but must be appropriate for required behavior.
		// Must retain insertion order and must retain duplicates! Lists are good candidates, but could also use
		// a LinkedHashMap if K,V behavior was desirable for the focal business problem.
		switch (type) {
			case 1: queue = new ArrayList<String>();break;
			case 2: queue = new LinkedList<String>();break;
			default: queue = new Vector<String>();break;
		} // end switch
	} // end ctor
	
	public void offer(String inc) {
		this.queue.add(inc);
	} // end offer
	
	public String poll() { // FIFO
		return this.queue.remove(0);
	} // end poll
	
	public String peek() { // FIFO
		return this.queue.get(0);
	} // end peek
	
	public boolean isEmpty() { // helps to avoid index out of bounds exceptions during usage
		return queue.isEmpty();
	} // end isEmpty
	
	public int size() {
		return this.queue.size();
	} // end size
} // end Queue