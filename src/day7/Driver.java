package day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Driver {

	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
//		System.out.println(1/0); // this is valid code, yet it doesn't execute, what has occurred and why?
		
		try {
			System.out.println(1/0);
		} catch (Exception e) {
			System.out.println("Oops!");
			e.printStackTrace();
		} finally {
			System.out.println("This block always executes with or without an exception being thrown!");
			// what would this block be useful for?
		} // end finally
		System.out.println("And the program continues!");
		
		do {
			try {
				System.out.println("Enter the final grade.");
				String grade = in.nextLine();
				System.out.println("The grade that you entered was: " + verifiedGrade(Integer.valueOf(grade)));
				break; // why is this needed?
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} // end catch
		} while (true); // how is this not an infinite loop?
		
		try {
			List<Integer> grades = new ArrayList<Integer>(Arrays.asList(
					verifiedGrade(65),verifiedGrade(75), verifiedGrade(85), verifiedGrade(95), verifiedGrade(100)));
			System.out.println("The minimum grade was: " + Utilities.doMin(grades));
			System.out.println("The maximum grade was: " + Utilities.doMax(grades));
			System.out.println("The total points was: " + Utilities.doSum(grades));
			System.out.println("The final average grade was: " + Utilities.doMean(grades));
			System.out.println("The median grade was: " + Utilities.doMedian(grades));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} // end catch
		
		// how can we create a data entry loop with verification that allows an arbitrary number of values until the user signals they are done?
		
		do {
			try {
				System.out.println("Enter a grade value (type Z to exit): ");
				String grade = in.nextLine();
				if (grade.equalsIgnoreCase("z")) {break;};
				System.out.println("The grade that you entered was: " + verifiedGrade(Integer.valueOf(grade)));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} // end catch
		} while (true); // how is this not an infinite loop?
	} // end main
	
	private static int verifiedGrade(int inc) throws RangeCheck {
		if (!RangeCheck.inRange(inc)) {
			throw new RangeCheck("Invalid grade!");
		} //end if
		return inc;
	} // end verifiedGrade
} // end Driver