package day22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class PriorityQueue {
	private List<Faculty> pq;
	
	public PriorityQueue(int type) {
		// Can use multiple underlying concrete data structures, but must be appropriate for required behavior.
		// Must retain insertion order and must retain duplicates! Lists are good candidates, but could also use
		// a LinkedHashMap if K,V behavior was desirable for the focal business problem.
		switch (type) {
			case 1: pq = new ArrayList<Faculty>();break;
			case 2: pq = new LinkedList<Faculty>();break;
			default: pq = new Vector<Faculty>();break;
		} // end switch
	} // end ctor
	
	public void offer(Faculty inc) {
		this.pq.add(inc);
		// This is where the magic happens...
		// .sort() method implicitly invokes the .compareTo() method in the POJO
		// Referred to as the "natural sort order"
		// Elements will be sorted high to low on the rank field in the POJO, but their insertion order
		// 	is still maintained so higher ranks are prioritized over lower ranks, but equal ranks retain
		//  their insertion position relative to each other!
		Collections.sort(pq); 
	} // end offer
	
	public Faculty poll() { // FIFO, but prioritized!
		return this.pq.remove(0);
	} // end poll
	
	public Faculty peek() { // FIFO, but prioritized!
		return this.pq.get(0);
	} // end peek
	
	public boolean isEmpty() { // helps to avoid index out of bounds exceptions during usage
		return pq.isEmpty();
	} // end isEmpty
	
	public int size() {
		return this.pq.size();
	} // end size
} // end PriorityQueue