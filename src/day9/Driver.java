package day9;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Driver {

	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Please enter a sentence.");
		//           The quick brown fox jumped over the lazy dog.       
		String input = in.nextLine();
		
		System.out.println("Here is the sentence showing the leading and trailing spaces: \"" + input + "\"");
		System.out.println("Here is the sentence without leading and trailing spaces: " + input.trim());
		String[] words = input.trim().split(" ");
		System.out.println("Here is a list of each word in the entered sentence.");
		for (int i=0;i<words.length;i++) {
			System.out.println(words[i]);
		} // end for
		
		words = input.trim().replace(".", " ").split(" ");
		System.out.println("Here is a list of each word in the entered sentence without the trailing period.");
		for (int i=0;i<words.length;i++) {
			System.out.println(words[i]);
		} // end for
		
		System.out.println("Here is a list of each word in the entered sentence with varying effects applied.");
		for (int i=0;i<words.length;i++) {
			System.out.println(words[i].toUpperCase());
			System.out.println(words[i].toLowerCase());
		} // end for
		
		System.out.println("Enter a word.");
		// circumlocution
		String word = in.nextLine();
		System.out.println("The first letter in " + word + " is: " + word.substring(0,1));
		System.out.println("The last letter in " + word + " is: " + word.substring(word.length()-1,word.length())); // why use the .length property?
		System.out.println("This word contains the character sequence 'loc': " + word.contains("loc"));
		System.out.println("This word contains the character sequence 'loc' starting at index number: " + word.indexOf("loc")); // why is this 6?
		System.out.println("This word is the word circumlocution: " + (word == "circumlocution")); // why doesn't this work?
		System.out.println("This word is the word circumlocution: " + word.equals("circumlocution"));
		System.out.print("The letters in this word are: ");
		char[] letters = word.toCharArray();
		for (int i=0;i<letters.length;i++) {
			System.out.print(letters[i] + " ");
		} // end for
		System.out.println();
		
		// Thought experiment, how to detect if a word is a palindrome?
		
		String possiblePalindrome = "racecar";
		System.out.println("The word " + possiblePalindrome + (isPalindrome(possiblePalindrome)? " is":" is not") + " a palindrome.");
		
	} // end main
	
	private static boolean isPalindrome(String inc) {
		char[] normal = inc.toCharArray();
		boolean palindrome = true;
		for (int i=0;i<normal.length;i++) {
			if (normal[i] != normal[normal.length-1-i]) { // what is the semantic meaning of this code?
				palindrome = false;
			} // end if
		} // end for
		return palindrome;
	} // end isPalindrome
} // end Driver