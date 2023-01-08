package day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		// What is the difference between these two collection types?
		int[] array = new int[] {10,20,30,40,50,60,70,80,90,100};
		// Can we create an ArrayList using primitive data types?
		// Is the parameterized type required?
		// What fundamental OOP technique is the List<Integer> on the left side an example of?
		// Does this imply there are other list types in Java?
		List<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(10,20,30,40,50,60,70,80,90,100));
		
		for (int i=0;i<array.length;i++) {
			System.out.print(array[i] + " ");
		} // end for
		// what is the semantic meaning of the '\n' escape sequence? Why is it used here? Why does it result in 2 CR/LFs?
		System.out.println("\n");
		
		for (int i=0;i<arrayList.size();i++) {
			System.out.print(arrayList.get(i) + " ");
		} // end for
		System.out.println();
		
//		// try to output the elements of the collections in pages of 3...
//		// why doesn't this work?
//		for (int i=0;i<array.length;i+=3) {
//			System.out.println(array[i] + " " + array[i+1] + " " + array[i+2] + " ");
//		} // end for
//
//		for (int i=0;i<arrayList.size();i+=3) {
//			System.out.println(arrayList.get(i) + " " + arrayList.get(i+1) + " " + arrayList.get(i+2) + " ");
//		} // end for
		
		int pageSize = 3;
		int pages = array.length / pageSize;
		pages += array.length % pageSize > 0 ? 1 : 0; // what is the semantic meaning of this?
		// why would we even want to add 1 or not in this situation?
		for (int i=0;i<pages;i++) { // why use pages here?
			for (int j=0;j<pageSize;j++) { // why use pageSize here?
				if (i*pageSize+j < array.length) { // what is the purpose of this conditional test?
					System.out.print(array[i*pageSize+j] + " "); // why use i & pageSize & j here?						
				} // end if
			} // end for
			System.out.println();
		} // end for

		pages = arrayList.size() / pageSize;
		pages += arrayList.size() % pageSize > 0 ? 1 : 0; // what is the semantic meaning of this?
		// why would we even want to add 1 or not in this situation?
		for (int i=0;i<pages;i++) { // why use pages here?
			for (int j=0;j<pageSize;j++) { // why use pageSize here?
				if (i*pageSize+j < arrayList.size()) { // what is the purpose of this conditional test?
					System.out.print(arrayList.get(i*pageSize+j) + " "); // why use i & pageSize & j here?						
				} // end if
			} // end for
			System.out.println();
		} // end for
		
		// How do we change the elements per page to 4 (or any other number)?
		
		System.out.println("The sum value of the elements within the array is: " + doArraySum(array));
		System.out.println("The sum value of the elements within the arrayList is: " + doArrayListSum(arrayList));

		// but, two methods that do the same thing makes maintenance coding more difficult
		// how can we use a single method regardless of the underlying type of the data collection?
		
		// the following doesn't work with primitive array types because Arrays.asList() doesn't handle boxing!
		// but it would work for reference types!
//		System.out.println("The sum value of the elements within the array is: " + doArrayListSum(Arrays.asList(array)));

		// this works for primitives types 
		System.out.println("The sum value of the elements within the array is: " + doArrayListSum(Arrays.stream(array).boxed().toList()));
		
		// for reference types, just remove the .boxed() portion!
		String[] test = new String[] {"Fred","Flintstone","Wilma","Flintstone"};
		for (String eachOne: Arrays.stream(test).toList()){
			System.out.println(eachOne);
		} // end for
	} // end main
	
	private static int doArraySum(int[] inc) { // why use "inc" here?
		int total = 0;
		for (int i=0;i<inc.length;i++) {
			total += inc[i];
		} // end for
		return total;
	} // end doArraySum

	private static int doArrayListSum(List<Integer> inc) { // why use "inc" here?
		int total = 0;
		for (int i=0;i<inc.size();i++) {
			total += inc.get(i);
		} // end for
		return total;
	} // end doArrayListSum
} // end Driver