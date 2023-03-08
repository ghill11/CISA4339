package day20;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class Driver {

	public static void main(String[] args) {
		int dataSize = 1000000;
		Random rng = new Random();
		
		System.out.println("*************** Populate Array ***************");
		long startTime = System.currentTimeMillis();
		int[] numArray = new int[dataSize];
		for (int i=0;i<dataSize;i++) {
			numArray[i]=rng.nextInt(0, 10000);
		} // end for
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime-startTime));
		
		System.out.println("*************** Populate ArrayList ***************");
		// https://byjus.com/gate/difference-between-array-and-arraylist-in-java/
		startTime = System.currentTimeMillis();
		List<Integer> numArrayList = new ArrayList<Integer>();
		for (int i=0;i<dataSize;i++) {
			numArrayList.add(rng.nextInt(0, 10000));
		} // end for
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime-startTime));
		
		System.out.println("*************** Populate LinkedList ***************");
		// https://byjus.com/gate/difference-between-array-and-linked-list/
		// https://byjus.com/gate/difference-between-singly-linked-list-doubly-linked-list/
		//
		// Java's LinkedList is a doubly linked list
		startTime = System.currentTimeMillis();
		List<Integer> numLinkedList = new LinkedList<Integer>();
		for (int i=0;i<dataSize;i++) {
			numLinkedList.add(rng.nextInt(0, 10000));
		} // end for
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime-startTime));
		
		System.out.println("*************** Populate Vector ***************");
		// https://byjus.com/gate/difference-between-arraylist-and-vector-in-java/
		startTime = System.currentTimeMillis();
		List<Integer> numVector = new Vector<Integer>();
		for (int i=0;i<dataSize;i++) {
			numVector.add(rng.nextInt(0, 10000));
		} // end for
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime-startTime));
		
		System.out.println("*************** Traverse Array Forward ***************");
		startTime = System.currentTimeMillis();
		for (int i=0;i<dataSize;i++) {
			int temp = numArray[i];
		} // end for
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime-startTime));
		
		System.out.println("*************** Traverse ArrayList Forward ***************");
		startTime = System.currentTimeMillis();
		for (int i=0;i<dataSize;i++) {
			int temp = numArrayList.get(i);
		} // end for
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime-startTime));
		
//		System.out.println("*************** Traverse LinkedList Forward ***************");
//		System.out.println("This takes an absolutely crazy amount of time with 1,000,000 elements!");
//		// LinkedList, because it is doubly linked list, will automatically start at the closest end and work to the desired element!
//		startTime = System.currentTimeMillis();
//		for (int i=0;i<dataSize;i++) {
//			int temp = numLinkedList.get(i);
//		} // end for
//		endTime = System.currentTimeMillis();
//		System.out.println("Execution time in milliseconds: " + (endTime-startTime));
		
		System.out.println("*************** Traverse Vector Forward ***************");
		startTime = System.currentTimeMillis();
		for (int i=0;i<dataSize;i++) {
			int temp = numVector.get(i);
		} // end for
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime-startTime));
		
		System.out.println("*************** Traverse Array Backward ***************");
		startTime = System.currentTimeMillis();
		for (int i=dataSize-1;i>0;i--) {
			int temp = numArray[i];
		} // end for
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime-startTime));
		
		System.out.println("*************** Traverse ArrayList Backward ***************");
		startTime = System.currentTimeMillis();
		for (int i=dataSize-1;i>0;i--) {
			int temp = numArrayList.get(i);
		} // end for
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime-startTime));
		
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
		for (int i=dataSize-1;i>0;i--) {
			int temp = numVector.get(i);
		} // end for
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime-startTime));
		
		System.out.println("*************** Traverse Array Random 10% of elements ***************");
		startTime = System.currentTimeMillis();
		for (int i=0;i<dataSize/10;i++) {
			int temp = numArray[rng.nextInt(0, dataSize)];
		} // end for
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime-startTime));
		
		System.out.println("*************** Traverse ArrayList Random 10% of elements ***************");
		startTime = System.currentTimeMillis();
		for (int i=0;i<dataSize/10;i++) {
			int temp = numArrayList.get(rng.nextInt(0, dataSize));
		} // end for
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime-startTime));
		
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
		for (int i=0;i<dataSize/10;i++) {
			int temp = numVector.get(rng.nextInt(0, dataSize));
		} // end for
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime-startTime));
	} // end main
} // end Driver