package day20;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class Driver {

	public static void main(String[] args) {

		/**
		 * Java supports 3 key types of lists (there are others for niche purposes (e.g.
		 * concurrency queues) ArrayList, LinkedList, Vector
		 * 
		 * Arrays are usually lumped into discussions surrounding lists because of the
		 * inherent similarities
		 * 
		 * https://byjus.com/gate/difference-between-array-and-arraylist-in-java/
		 * https://byjus.com/gate/difference-between-array-and-linked-list/
		 * https://byjus.com/gate/difference-between-singly-linked-list-doubly-linked-list/
		 * https://byjus.com/gate/difference-between-arraylist-and-vector-in-java/
		 * 
		 * ArrayList is the best "general purpose" list to use in the majority of
		 * situations *IF* performance issues warrant it, investigate using other data
		 * structures
		 * 
		 * Common important performance characteristics include: element population,
		 * element traversal (forward & backward!), random element selection, and
		 * element sorting
		 */
		int dataSize = 1_000_000; // what does these _ characters do?
		Random rng = new Random();
		NumberFormat nf = NumberFormat.getIntegerInstance();

		System.out.println("*************** Populate Array ***************");
		long startUsed = getUsedMemory();
		long startTime = System.currentTimeMillis();
		int[] numArray = new int[dataSize];
		for (int i = 0; i < dataSize; i++) {
			numArray[i] = rng.nextInt(0, 10_000);
		} // end for
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime - startTime));
		long stopUsed = getUsedMemory();
		System.out.println("Memory usage (in bytes): " + nf.format((stopUsed - startUsed)));

		System.out.println("*************** Populate ArrayList ***************");
		startUsed = getUsedMemory();
		startTime = System.currentTimeMillis();
		List<Integer> numArrayList = new ArrayList<Integer>();
		for (int i = 0; i < dataSize; i++) {
			numArrayList.add(rng.nextInt(0, 10_000));
		} // end for
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime - startTime));
		stopUsed = getUsedMemory();
		System.out.println("Memory usage (in bytes): " + nf.format((stopUsed - startUsed)));

		System.out.println("*************** Populate LinkedList ***************");
		// Java's LinkedList is a doubly linked list
		startUsed = getUsedMemory();
		startTime = System.currentTimeMillis();
		List<Integer> numLinkedList = new LinkedList<Integer>();
		for (int i = 0; i < dataSize; i++) {
			numLinkedList.add(rng.nextInt(0, 10_000));
		} // end for
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime - startTime));
		stopUsed = getUsedMemory();
		System.out.println("Memory usage (in bytes): " + nf.format((stopUsed - startUsed)));

		System.out.println("*************** Populate Vector ***************");
		startUsed = getUsedMemory();
		startTime = System.currentTimeMillis();
		List<Integer> numVector = new Vector<Integer>();
		for (int i = 0; i < dataSize; i++) {
			numVector.add(rng.nextInt(0, 10_000));
		} // end for
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime - startTime));
		stopUsed = getUsedMemory();
		System.out.println("Memory usage (in bytes): " + nf.format((stopUsed - startUsed)));

		System.out.println("*************** Traverse Array Forward ***************");
		startTime = System.currentTimeMillis();
		for (int i = 0; i < dataSize; i++) {
			int temp = numArray[i];
		} // end for
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime - startTime));

		System.out.println("*************** Traverse ArrayList Forward ***************");
		startTime = System.currentTimeMillis();
		for (int i = 0; i < dataSize; i++) {
			int temp = numArrayList.get(i);
		} // end for
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime - startTime));

//		System.out.println("*************** Traverse LinkedList Forward ***************");
//		System.out.println("This takes an absolutely crazy amount of time with 1,000,000 elements! (** 31.6 minutes at my desktop! **");
//		// LinkedList, because it is doubly linked list, will automatically start at the closest end and work to the desired element!
//		startTime = System.currentTimeMillis();
//		for (int i=0;i<dataSize;i++) {
//			int temp = numLinkedList.get(i);
//		} // end for
//		endTime = System.currentTimeMillis();
//		System.out.println("Execution time in milliseconds: " + (endTime-startTime));

		System.out.println("*************** Traverse Vector Forward ***************");
		startTime = System.currentTimeMillis();
		for (int i = 0; i < dataSize; i++) {
			int temp = numVector.get(i);
		} // end for
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime - startTime));

		System.out.println("*************** Traverse Array Backward ***************");
		startTime = System.currentTimeMillis();
		for (int i = dataSize - 1; i > 0; i--) {
			int temp = numArray[i];
		} // end for
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime - startTime));

		System.out.println("*************** Traverse ArrayList Backward ***************");
		startTime = System.currentTimeMillis();
		for (int i = dataSize - 1; i > 0; i--) {
			int temp = numArrayList.get(i);
		} // end for
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime - startTime));

//		System.out.println("*************** Traverse LinkedList Backward ***************");
//		System.out.println("This takes an absolutely crazy amount of time with 1,000,000 elements!");
//		// LinkedList, because it is doubly linked list, will automatically start at the closest end and work to the desired element!
//		startTime = System.currentTimeMillis();
//		for (int i=dataSize-1;i>0;i--) {
//			int temp = numLinkedList.get(i);
//		} // end for
//		endTime = System.currentTimeMillis();
//		System.out.println("Execution time in milliseconds: " + (endTime-startTime));

		System.out.println("*************** Traverse Vector Backward ***************");
		startTime = System.currentTimeMillis();
		for (int i = dataSize - 1; i > 0; i--) {
			int temp = numVector.get(i);
		} // end for
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime - startTime));

		System.out.println("*************** Traverse Array Random 10% of elements ***************");
		startTime = System.currentTimeMillis();
		for (int i = 0; i < dataSize / 10; i++) {
			int temp = numArray[rng.nextInt(0, dataSize)];
		} // end for
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime - startTime));

		System.out.println("*************** Traverse ArrayList Random 10% of elements ***************");
		startTime = System.currentTimeMillis();
		for (int i = 0; i < dataSize / 10; i++) {
			int temp = numArrayList.get(rng.nextInt(0, dataSize));
		} // end for
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime - startTime));

//		System.out.println("*************** Traverse LinkedList Random 10% of elements ***************");
//		System.out.println("This takes an absolutely crazy amount of time with 1,000,000 elements!");
//		// LinkedList, because it is doubly linked list, will automatically start at the closest end and work to the desired element!
//		startTime = System.currentTimeMillis();
//		for (int i=0;i<dataSize/10;i++) {
//			int temp = numLinkedList.get(i);
//		} // end for
//		endTime = System.currentTimeMillis();
//		System.out.println("Execution time in milliseconds: " + (endTime-startTime));

		System.out.println("*************** Traverse Vector Random 10% of elements ***************");
		startTime = System.currentTimeMillis();
		for (int i = 0; i < dataSize / 10; i++) {
			int temp = numVector.get(rng.nextInt(0, dataSize));
		} // end for
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime - startTime));

		System.out.println("********************** SORTING **********************");
		/**
		 * https://stackoverflow.com/questions/4018332/is-java-7-using-tim-sort-for-the-method-arrays-sort
		 * 
		 * Java's Collections.sort() & Arrays.sort() has built-in heuristics to
		 * determine which "type" of sort to use based on the underlying data type,
		 * number of elements, degree of 'sortedness' already existing, and other
		 * metrics.
		 * 
		 * Many types of sorts exist
		 * https://www.javatpoint.com/sorting-algorithms
		 * 
		 * Big O Notation - https://www.interviewcake.com/article/java/big-o-notation-time-and-space-complexity
		 * Used to indicate the worst-case scenario for comparative purposes between algorithms. However, that isn't
		 * the whole story, average execution time is also useful information!
		 * Singly linked list traversal --> O(n)
		 * Singly linked list traversal average --> O(n/2)
		 * Doubly linked list traversal --> O(n/2)
		 * Doubly linked list traversal average --> O(n/4)
		 */

		// create an unsorted array
		int arrSize = 100_000;
		int[] unsortedArray = new int[arrSize];
		for (int i=0;i<arrSize;i++) {
			unsortedArray[i] = rng.nextInt(0, 100_000);
		} // end for
		
		System.out.println("*************** JAVA's DUAL-PIVOT QUICKSORT ***************");
		int[] cloneArray = unsortedArray.clone();
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<arrSize/100;i++) { // get the first 1% for demonstration purposes
			sb.append(cloneArray[i]).append(",");
		} // end for
		System.out.println(sb.toString().substring(0,sb.toString().length()-1));
		startTime = System.currentTimeMillis();
		// need to make it a List<> for the built-in sorter
		List<Integer> unsortedList = new ArrayList<Integer>();
		for (int eachOne: cloneArray) {
			unsortedList.add(eachOne);
		} // end for
		Collections.sort(unsortedList);
		
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime - startTime));
		sb = new StringBuilder();
		for (int i=0;i<arrSize/100;i++) { // get the first 1% for demonstration purposes
			sb.append(unsortedList.get(i)).append(",");
		} // end for
		System.out.println(sb.toString().substring(0,sb.toString().length()-1));
		
		System.out.println("*************** INSERTION SORT ***************");
		// https://www.javatpoint.com/insertion-sort-in-java
		cloneArray = unsortedArray.clone();
		sb = new StringBuilder();
		for (int i=0;i<arrSize/100;i++) { // get the first 1% for demonstration purposes
			sb.append(cloneArray[i]).append(",");
		} // end for
		System.out.println(sb.toString().substring(0,sb.toString().length()-1));
		startTime = System.currentTimeMillis();
		insertionSort(cloneArray);
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime - startTime));
		sb = new StringBuilder();
		for (int i=0;i<arrSize/100;i++) { // get the first 1% for demonstration purposes
			sb.append(cloneArray[i]).append(",");
		} // end for
		System.out.println(sb.toString().substring(0,sb.toString().length()-1));
		
		System.out.println("*************** BUBBLE SORT ***************");
		// https://www.javatpoint.com/bubble-sort-in-java
		cloneArray = unsortedArray.clone();
		sb = new StringBuilder();
		for (int i=0;i<arrSize/100;i++) { // get the first 1% for demonstration purposes
			sb.append(cloneArray[i]).append(",");
		} // end for
		System.out.println(sb.toString().substring(0,sb.toString().length()-1));
		startTime = System.currentTimeMillis();
		bubbleSort(cloneArray);
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime - startTime));
		sb = new StringBuilder();
		for (int i=0;i<arrSize/100;i++) { // get the first 1% for demonstration purposes
			sb.append(cloneArray[i]).append(",");
		} // end for
		System.out.println(sb.toString().substring(0,sb.toString().length()-1));
		
		System.out.println("*************** SELECTION SORT ***************");
		// https://www.javatpoint.com/selection-sort
		cloneArray = unsortedArray.clone();
		sb = new StringBuilder();
		for (int i=0;i<arrSize/100;i++) { // get the first 1% for demonstration purposes
			sb.append(cloneArray[i]).append(",");
		} // end for
		System.out.println(sb.toString().substring(0,sb.toString().length()-1));
		startTime = System.currentTimeMillis();
		selectionSort(cloneArray);
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime - startTime));
		sb = new StringBuilder();
		for (int i=0;i<arrSize/100;i++) { // get the first 1% for demonstration purposes
			sb.append(cloneArray[i]).append(",");
		} // end for
		System.out.println(sb.toString().substring(0,sb.toString().length()-1));
	} // end main

	private static long getUsedMemory() {
		// this calculates used memory based on the maximum amount available to the JVM
		// compared to the amount the JVM is using right now
		return Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory();
	} // end getUsedMemory

	private static int[]  insertionSort(int inc[]) {
		int n = inc.length;
		for (int j = 1; j < n; j++) {
			int key = inc[j];
			int i = j - 1;
			while ((i > -1) && (inc[i] > key)) {
				inc[i + 1] = inc[i];
				i--;
			} // end while
			inc[i + 1] = key;
		} // end for
		return inc;
	} // end insertionSort
	
	private static int[] bubbleSort(int[] inc) {
		int n = inc.length;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (inc[j - 1] > inc[j]) {
					// swap elements
					temp = inc[j - 1];
					inc[j - 1] = inc[j];
					inc[j] = temp;
				} // end if
			} // end for
		} // end for
		return inc;
	} // end bubbleSort
	
	private static void selectionSort(int[] inc) {
		int i, j, small;
		int n = inc.length;
		for (i = 0; i < n - 1; i++) {
			small = i; // minimum element in unsorted array
			for (j = i + 1; j < n; j++) {
				if (inc[j] < inc[small]) {
					small = j; // Swap the minimum element with the first element
				} // end if
			} // end for
			int temp = inc[small];
			inc[small] = inc[i];
			inc[i] = temp;
		} // end for
	} // end selectionSort
} // end Driver