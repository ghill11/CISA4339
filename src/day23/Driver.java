package day23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		// these do need to be reference types, not primitives
		ArrayList<String> words = new ArrayList<String>(Arrays.asList("UCA","UALR","UAPB","UACCM"));
		System.out.println(simplePrintIt(words)); // this works just fine
		ArrayList<Integer> integers = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
//		System.out.println(simplePrintIt(integers)); // this does not work! 
		// How do we fix this problem without creating many method overloads with inherent code duplication?

		System.out.println(printIt(words));
		System.out.println(printIt(integers));
		ArrayList<Double> doubles = new ArrayList<Double>(Arrays.asList(6.1,7.2,8.3,9.4,10.5));
		System.out.println(printIt(doubles));
		
		List<String> names = Arrays.asList("Steve","Grace","Jeff");
		System.out.println(getLargest(names));
		
		List<Integer> numbers = Arrays.asList(987987323, 23423, 34654564);
		System.out.println(getLargest(numbers));
		
		// We can also create classes that use the concept of generics that are expressed through parameterization
		// This is exactly what ArrayList<String> is doing!

		Box<String> box1 = new Box<String>("Fred");
		System.out.println(box1.toString());
		
		Box<Integer> box2 = new Box<Integer>(4567892);
		System.out.println(box2.toString());
		
		Box<List<String>> box3 = new Box<List<String>>(new ArrayList<String>(Arrays.asList("George,Nancy,Gene")));
		System.out.println(box3);
		
		// We can make our own abstract data structures use the generics concept and parameterization too!
		Stack<String> stack = new Stack<String>(1);
		stack.push("Jeff");
		stack.push("Brigid");
		stack.push("Mike");
		stack.push("Steven");
		stack.push("Joe");
		stack.push("Mike");
		stack.push("Overwrite!");
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()){
			sb.append(stack.pop()).append(",");
		} // end for
		System.out.println(sb.toString().substring(0,sb.toString().length()-1));
		
		Stack<Integer> stack2 = new Stack<Integer>(1);
		stack2.push(4);
		stack2.push(12);
		stack2.push(43);
		stack2.push(24);
		stack2.push(65);
		stack2.push(34);
		stack2.push(3);
		sb = new StringBuilder();
		while (!stack2.isEmpty()){
			sb.append(stack2.pop()).append(",");
		} // end for
		System.out.println(sb.toString().substring(0,sb.toString().length()-1));
		
		// Method chaining requires a "fluent interface", but allows us to simplify repetitive method invocation statements
		Stack<Integer> stack3 = new Stack<Integer>(1);
		stack3.chainedPush(8).chainedPush(34).chainedPush(213).chainedPush(908).chainedPush(23).chainedPush(312);
		sb = new StringBuilder();
		while (!stack3.isEmpty()){
			sb.append(stack3.pop()).append(",");
		} // end for
		System.out.println(sb.toString().substring(0,sb.toString().length()-1));		
	} // end main
	
	public static String simplePrintIt(List<String> inc) {
		StringBuilder sb = new StringBuilder();
		for (String eachOne: inc) {
			sb.append(eachOne).append(", ");
		} // end for
		return sb.toString().substring(0,sb.toString().length()-2);
	} // end simplePrintIt
	
	public static <E> String printIt(List<E> inc) { // E is the convention used for methods
		StringBuilder sb = new StringBuilder();
		for (E eachOne: inc) {
			sb.append(eachOne).append(", ");
		} // end for
		return sb.toString().substring(0,sb.toString().length()-2);
	} // end printIt
	
	private static <E extends Comparable<E>> String getLargest(List<E> inc) {
		return Collections.max(inc) + " is the largest!";
	} // end getLargest
} // end Driver