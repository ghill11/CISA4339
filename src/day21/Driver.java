package day21;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Driver {

	public static void main(String[] args) {
		int dataSize = 1_000_000; // what does these _ characters do?
		Random rng = new Random();
		NumberFormat nf = NumberFormat.getIntegerInstance();

		/**
		 *  Lists maintain insertion order by default and when small offer some of the best efficiency characteristics
		 *  There are other categories of data structures beside just lists
		 *  
		 *  https://www.baeldung.com/cs/binary-trees-vs-linked-lists-vs-hash-tables
		 */
		
		System.out.println("*************** Simple HashMap ***************");
		Map<Integer, String> map = new HashMap<Integer,String>();
		// Maps are defined as unique key, non-unique value pairs and declared using appropriate data types
		// HashMap sorts the keys at each insertion! "Hash" means that the key value is "hashed" and indexed for search speed
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
		
		// TreeMap is a merger of the tree and map concepts
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
	} // end main
	
	private static long getUsedMemory() {
		// this calculates used memory based on the maximum amount available to the JVM
		// compared to the amount the JVM is using right now
		return Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory();
	} // end getUsedMemory
} // end Driver