package day5;

import java.util.Scanner;

public class FutureValueCalculator {

/**
	https://www.investopedia.com/terms/f/futurevalue.asp
*/
	
	private static Scanner in = new Scanner(System.in);
	
	// define the 4 necessary variables
	private static int years;
	private static int amount;
	private static double interestRate;
	
	public static void main(String[] args) {
		getCalculatorValues();
		System.out.println(doFV());
	} // end main
	
	private static void getCalculatorValues() {
		System.out.println("Number of years?");
		String temp = in.nextLine();
		years = Integer.valueOf(temp);
		System.out.println("Investment amount?");
		temp = in.nextLine();
		amount = Integer.valueOf(temp);
		System.out.println("Interest rate?");
		temp = in.nextLine();
		interestRate = Double.valueOf(temp);
	} // end getCalculatorValues
	
	private static String doFV() {
		/**
		 	FV formula: Initial Investment × (1 + Interest Rate) ^ Years
		 
		 	What is the order of operations on this complex formula?
		 */
		StringBuilder sb = new StringBuilder();
		sb.append("The future value of an initial investment of ");
		sb.append(amount);
		sb.append(" at a rate of ");
		sb.append(interestRate);
		sb.append("% for ");
		sb.append(years);
		sb.append(" years is: ");
		double result = 0;
		result = amount * Math.pow((1+interestRate),years); // What is Math.pow()?
		sb.append(result);
		return sb.toString();
	} // end doFV
} // end FutureValueCalculator