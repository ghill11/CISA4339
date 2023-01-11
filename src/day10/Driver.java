package day10;

import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		// This is what we did last class
		String possiblePalindrome = "racecar";
		System.out.println("The word " + possiblePalindrome + (isPalindrome(possiblePalindrome)? " is":" is not") + " a palindrome.");
		// This is another way to detect palindromes
		System.out.println("The word " + possiblePalindrome + (isDoubleListPalindrome(possiblePalindrome)? " is":" is not") + " a palindrome.");
		// This is yet another way to detect palindromes
		System.out.println("The word " + possiblePalindrome + (isRecursivePaldinrome(possiblePalindrome)? " is":" is not") + " a palindrome.");
		
		// Which way is the "best"?
	} // end main
	
	private static boolean isPalindrome(String inc) {
		char[] letters = inc.toCharArray();
		boolean palindrome = true;
		for (int i=0;i<letters.length;i++) {
			if (letters[i] != letters[letters.length-1-i]) { // what is the semantic meaning of this code?
				palindrome = false;
			} // end if
		} // end for
		return palindrome;
	} // end isPalindrome
	
	private static boolean isDoubleListPalindrome(String inc) {
		// there isn't a good way to convert a char[] to a List<Character> built into java
		// the stream method we used a few days ago for int[] doesn't work for char[]!
		List<Character> letters = new ArrayList<Character>();
		for (char eachOne: inc.toCharArray()) {
			letters.add(eachOne);
		} // end for
		List<Character> backward = new ArrayList<Character>();
		for (int i=letters.size();i>0;i--) {
			backward.add(letters.get(i-1));
		} // end for
		boolean palindrome = true;
		for (int i=0;i<letters.size();i++) {
			if (letters.get(i)!=backward.get(i)) {
				palindrome = false;
			} // end if
		} // end for
		return palindrome;
	} // end isDoubleListPalindrome
	
	private static boolean isRecursivePaldinrome(String inc) {
		if (inc.length() <= 1) {
			return true; // we're at the end and everything prior matched			
		} else {
			if (inc.charAt(0) == inc.charAt(inc.length() - 1)) {
				return isRecursivePaldinrome(inc.substring(1, inc.length() - 1));				
			} else {
				return false;
			} // end else
		} // end else
	} // end isRecursivePaldinrome
} // end Driver