package day3;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// what is this technique called?
		System.out.println("This is line one.");
		System.out.println("This is line two.");
		System.out.println("This is line three.");
		System.out.println("This is line four.");
		System.out.println("This is line five.");
		
		// what is this technique called?
		int number = 4;
		if (number==1) {
			System.out.println("This is line one.");
		} else if (number==2) {
			System.out.println("This is line two.");
		} else if (number==3) {
			System.out.println("This is line three.");
		} else if (number==4) {
			System.out.println("This is line four.");
		} else { // why is there no conditional statement here, why just the 'else' keyword?
			System.out.println("This is line five.");
		} // end else
		
		// what is this technique called?
		switch(number) {
			case 1: System.out.println("This is line one."); break;
			case 2: System.out.println("This is line two."); break;
			case 3: System.out.println("This is line three."); break;
			case 4: System.out.println("This is line four."); break;
			default: System.out.println("This is line five."); break; // why is there no number here, why just the 'default' keyword?
		} // end switch
		
		// what is this technique called?
		for (int i=1;i<=5;i++) {
			System.out.println("(for) This is line " + i + ".");
		} // end for
		
		// what is this technique called?
		int i = 1;
		while (i<=5) {
			System.out.println("(while) This is line " + i++ + "."); // what is the semantic meaning of the ++ symbols?
		} // end while
		
		// what is this technique called?
		i = 1; // why is there no data type specified on this line?
		do {
			System.out.println("(do) This is line " + i++ + ".");
		} while (i<=5);
		
		Scanner in = new Scanner(System.in);
		System.out.println("What is your first name?");
		String fName = in.nextLine();
		System.out.println("What is your last name?");
		String lName = in.nextLine();
		System.out.println("What is your age?");
		String age = in.nextLine();  // why is this using a String data type? Does it have to?
		System.out.println("Nice to meet you " + fName + " " + lName + " who is " + age + " years old.");
		System.out.println("In 20 years you will be " + (Integer.valueOf(age)+20) + " years old.");
	} // end main
} // end Driver