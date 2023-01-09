package day8;

import java.util.Scanner;

public class Driver {
	
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		// It is important to know the built-in features of any language you program in
		System.out.println("5 to the 6th power is: " + Math.pow(5,6));
		// But also remember basic math, not all languages support mathematical functions when there are simple alternatives. Why?
		System.out.println("5 to the 6th power is: " + 5*5*5*5*5*5);
		
		/*
		 * https://www.cuemath.com/tangent-formulas/
		 */
		System.out.println("The tangent of an angle of 36.87° with an opposite length of 3 and an adjacent length of 4 is: " 
				+ Math.tan(Math.toRadians(36.87)));
		System.out.println("The tangent of an angle of 36.87° with an opposite length of 3 and an adjacent length of 4 is: " 
				+ 3.0/4.0);

		/*
		 * Repetition is something that is common in mathematical functions, multiple ways to implement this
		 */
		
		System.out.println("What is the base?");
		String base = in.nextLine();
		System.out.println("What is the exponent?");
		String exponent = in.nextLine();
		int answer = Integer.valueOf(base);
		for (int i=1;i<Integer.valueOf(exponent);i++) {
			answer *= Integer.valueOf(base);
		} // end for
		System.out.println("The number " + base + " raised to the " + exponent + " power is: " + answer);
		
		// Or we can use a technique known as recursion
		System.out.println("The number " + base + " raised to the " + exponent + " power is: " 
				+ doExponent(Integer.valueOf(base), Integer.valueOf(exponent)));
	} // end main
	
	private static int doExponent(int base, int exponent) {
		if (exponent != 0) { // why do we need to do this?
			// explain the method call stack, recursive invocations, stack overflow, stack unwinding
			return base * doExponent(base, exponent-1);
		} else {
			return 1;
		} // end else
		
		// what happens if we just do this?
//		return base * doExponent(base, exponent-1);
	} // end doExponent
} // end Driver