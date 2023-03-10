package day21;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Driver {

	public static void main(String[] args) {
		int dataSize = 1_000_000; // what does these _ characters do?
		Random rng = new Random();
		NumberFormat nf = NumberFormat.getIntegerInstance();

		/**
		 *  Lists maintain insertion order by default and when small offer some of the best efficiency characteristics
		 *  There are other categories of data structures beside just lists that are useful for certain situations
		 *  defined by data characteristics, storage requirements, or efficiency requirements
		 *  
		 *  Three main categories: List, Map, Set
		 *  https://www.geeksforgeeks.org/difference-between-list-set-and-map-in-java/
		 *  
		 *  Each category has multiple implementation methods with varying characteristics
		 *  https://www.baeldung.com/cs/binary-trees-vs-linked-lists-vs-hash-tables
		 */
		
		System.out.println("****************************** MAPS ******************************");
		System.out.println("*************** Simple HashMap ***************");
		Map<Integer, String> map = new HashMap<Integer,String>();
		// Maps are defined as unique key, non-unique value pairs and declared using appropriate data types
		// HashMap sorts the keys at each insertion! "Hash" means that the key value is "hashed" and indexed for search speed while
		// "map" refers to the values being "mapped" in memory and referenced by the indexed hash table
		map.put(4, "Jeff");
		map.put(2, "Brigid");
		map.put(1, "Mike");
		map.put(5, "Steven");
		map.put(3, "Joe");
		map.put(6, "Mike");
		map.put(1, "Overwrite!");
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Integer, String> entry: map.entrySet()) {
			sb.append(entry.getKey()).append("-->").append(entry.getValue()).append(",");
		} // end for
		System.out.println(sb.toString().substring(0,sb.toString().length()-1));
		
		// LinkedHashMap provides K,V functionality and maintains insertion order using a LinkedList at its heart, 
		// 	with all the baggage that brings with it from a performance perspective...
		// https://www.baeldung.com/java-linked-hashmap
		
		System.out.println("*************** Simple LinkedHashMap ***************");
		map = new LinkedHashMap<Integer,String>();
		map.put(4, "Jeff");
		map.put(2, "Brigid");
		map.put(1, "Mike");
		map.put(5, "Steven");
		map.put(3, "Joe");
		map.put(6, "Mike");
		map.put(1, "Overwrite!");
		sb = new StringBuilder();
		for (Map.Entry<Integer, String> entry: map.entrySet()) {
			sb.append(entry.getKey()).append("-->").append(entry.getValue()).append(",");
		} // end for
		System.out.println(sb.toString().substring(0,sb.toString().length()-1));
		
		// TreeMap implements a map in a tree structure
		// https://www.javatpoint.com/java-treemap
		
		System.out.println("*************** Simple TreeMap ***************");
		map = new TreeMap<Integer,String>();
		map.put(4, "Jeff");
		map.put(2, "Brigid");
		map.put(1, "Mike");
		map.put(5, "Steven");
		map.put(3, "Joe");
		map.put(6, "Mike");
		map.put(1, "Overwrite!");
		sb = new StringBuilder();
		for (Map.Entry<Integer, String> entry: map.entrySet()) {
			sb.append(entry.getKey()).append("-->").append(entry.getValue()).append(",");
		} // end for
		System.out.println(sb.toString().substring(0,sb.toString().length()-1));
		
		// But because it doesn't sort during insertion, it is quicker to populate!
		System.out.println("*************** Populate HashMap ***************");
		Map<Integer,Integer> map2 = new HashMap<Integer,Integer>();
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < dataSize; i++) {
			map2.put(i, rng.nextInt(0, 10_000));
		} // end for
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime - startTime));
		
		System.out.println("*************** Populate LinkedHashMap ***************");
		map2 = new LinkedHashMap<Integer,Integer>();
		startTime = System.currentTimeMillis();
		for (int i = 0; i < dataSize; i++) {
			map2.put(i, rng.nextInt(0, 10_000));
		} // end for
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime - startTime));

		System.out.println("*************** Populate TreeMap ***************");
		map2 = new LinkedHashMap<Integer,Integer>();
		startTime = System.currentTimeMillis();
		for (int i = 0; i < dataSize; i++) {
			map2.put(i, rng.nextInt(0, 10_000));
		} // end for
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime - startTime));
		
		System.out.println("****************************** SETS ******************************");
		/**
		 *  Sets are defined as groups of values and only contain unique elements, no duplication!
		 *  There is no preservation of insertion order as a part of the basic set definition
		 */
		System.out.println("*************** Simple HashSet ***************");
		// https://www.w3schools.com/java/java_hashset.asp
		Set<String> set = new HashSet<String>();
		set.add("Jeff");
		set.add("Brigid");
		set.add("Mike");
		set.add("Steven");
		set.add("Joe");
		set.add("Mike");
		set.add("Overwrite!");
		sb = new StringBuilder();
		for (String eachOne: set) {
			sb.append(eachOne).append(",");
		} // end for
		System.out.println(sb.toString().substring(0,sb.toString().length()-1));
		
		System.out.println("*************** Simple LinkedHashSet ***************");
		// Does preserve the insertion order if necessary by using a doubly linked list at its heart, again
		// with all the baggage that brings with it!
		//
		// Notice the insertion order of the duplicated element is the 1st instance, not the 2nd duplicate "Mike"!
		//
		// https://www.geeksforgeeks.org/linkedhashset-in-java-with-examples/
		set = new LinkedHashSet<String>();
		set.add("Jeff");
		set.add("Brigid");
		set.add("Mike");
		set.add("Steven");
		set.add("Joe");
		set.add("Mike");
		set.add("Overwrite!");
		sb = new StringBuilder();
		for (String eachOne: set) {
			sb.append(eachOne).append(",");
		} // end for
		System.out.println(sb.toString().substring(0,sb.toString().length()-1));
		
		System.out.println("*************** Simple TreeSet ***************");
		// TreeSet implements a set in a tree structure
		// https://www.geeksforgeeks.org/treeset-in-java-with-examples/
		set = new TreeSet<String>();
		set.add("Jeff");
		set.add("Brigid");
		set.add("Mike");
		set.add("Steven");
		set.add("Joe");
		set.add("Mike");
		set.add("Overwrite!");
		sb = new StringBuilder();
		for (String eachOne: set) {
			sb.append(eachOne).append(",");
		} // end for
		System.out.println(sb.toString().substring(0,sb.toString().length()-1));
		
		System.out.println("*************** Populate HashSet ***************");
		Set<Integer> set2 = new HashSet<Integer>();
		startTime = System.currentTimeMillis();
		for (int i = 0; i < dataSize; i++) {
			set2.add(rng.nextInt(0, 10_000));
		} // end for
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime - startTime));
		
		System.out.println("*************** Populate LinkedHashSet ***************");
		set2 = new LinkedHashSet<Integer>();
		startTime = System.currentTimeMillis();
		for (int i = 0; i < dataSize; i++) {
			set2.add(rng.nextInt(0, 10_000));
		} // end for
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime - startTime));
		
		System.out.println("*************** Populate TreeSet ***************");
		set2 = new TreeSet<Integer>();
		startTime = System.currentTimeMillis();
		for (int i = 0; i < dataSize; i++) {
			set2.add(rng.nextInt(0, 10_000));
		} // end for
		endTime = System.currentTimeMillis();
		System.out.println("Execution time in milliseconds: " + (endTime - startTime));
	} // end main
} // end Driver