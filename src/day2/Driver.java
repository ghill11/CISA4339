package day2;

public class Driver {
	public static void main(String[] args) {
		String fName = "Jeff"; // why is this variable named like this?
		String lName = "Hill"; // why is this variable named like this?
		int age = 40; // why is this variable named like this?
		
		System.out.println("Nice to meet you " + fName + " " + lName + " who is " + age + " years old.");
		System.out.println("In 5 years you will be: " + age+5); // why is this incorrect?
		System.out.println("In 5 years you will be: " + (age+5)); // why is this correct?
		
		System.out.println("The magic crystal ball says that in 10 years you will be: " + doCrystalBall(age)); // why is this correct?
		
		int numberOne = 5;
		int numberTwo = 6;
		int numberThree = 8;
		
		// how would we change this to get results with decimal values?
		System.out.println("The average of those 3 numbers is: " + doAverage(numberOne, numberTwo, numberThree)); 
	} // end main
	
	public static int doCrystalBall(int age) { // why is this static?
		// how could I simplify this code?
		int futurePerson = 0;
		futurePerson = age + 10;
		return futurePerson;
	} // end doCrystalBall
	
	public static int doAverage(int numberOne, int numberTwo, int numberThree) {
		int total = 0;
		total += numberOne; // what is the semantic meaning of the += symbols?
		total += numberTwo;
		total += numberThree;
		return total/3;
	} // end doAverage
} // end Driver