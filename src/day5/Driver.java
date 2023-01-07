package day5;

import java.util.Scanner;

public class Driver {
	/**
	 * Create a program for a simple everyday task: go to class
	 */
	
	// why are these variables defined 'globally'? What programming concept is this associated with?
	
	// Define a Scanner object for use throughout the program
	private static Scanner in = new Scanner(System.in);
	
	// Programmatically describe the classroom
	private static boolean[] occupiedSeats = new boolean[] {false,false,false,false,false};
	private static String professor = "Dr. Hill";
	private static boolean profIsPresent = true;
	
	// Programmatically describe the course you are attending
	private static String courseBuilding;
	private static int courseRoomNumber;
	
	public static void main(String[] args) {
		readSchedule();
		System.out.println(checkCorrectBuilding());
		System.out.println(checkCorrectRoom());
		System.out.println(takeYourSeat());
		// Why does the above keep going if you enter things other than COB and room 310? Is this correct processing?
		
//		// why don't we need to invoke readShedule() again?
//		String results = checkCorrectBuilding(); // why capture the method's results into a temporary variable?
//		System.out.println(results);
//		if (results.contains("aren't at the right building")) {
//			return; // what is the semantic meaning of the return keyword here?
//		} // end if
//		results = checkCorrectRoom();
//		System.out.println(results);
//		if (results.contains("aren't at the right room")) {
//			return;
//		} // end if
//		System.out.println(takeYourSeat()); // why don't we need to check the results of this method?
	} // end main
	
	public static void readSchedule() {
		courseBuilding = "College of Business";
		courseRoomNumber = 310;
	} // end readSchedule
	
	public static String checkCorrectBuilding() {
		String result = "";
		System.out.println("What building are you at?");
		String bldg = in.nextLine();
		if (bldg.equals(courseBuilding)) { // why can't we use: if (bldg == courseBuilding)?
			result += "You are at the right place, proceed to the right classroom.";
		} else {
			result += "You aren't at the right building, go to the " + courseBuilding + "!";
		} // end else
		return result;
	} // end checkCorrectBuilding
	
	public static String checkCorrectRoom() {
		StringBuilder sb = new StringBuilder(); // What is this StringBuilder and why would we use this instead?
		System.out.println("What room are you at?");
		String room = in.nextLine();
		if (Integer.valueOf(room) == courseRoomNumber) {
			sb.append("You are in the right room, proceed to your seat.");
		} else {
			sb.append("You aren't at the right room, go to room number "); // why not use string concatenation to simplify these 3 lines?
			sb.append(courseRoomNumber);
			sb.append("!");
		} // end else
		return sb.toString();
	} // end checkCorrectRoom
	
	public static String takeYourSeat() {
		StringBuilder sb = new StringBuilder();
		sb.append(greetProfessor()); // what is the technical term for this method invocation inside another method invocation?
		for (int i=0;i<occupiedSeats.length;i++) {
			if (!occupiedSeats[i]) { // what is the semantic meaning of the ! symbol?
				occupiedSeats[i] = true; // what is the purpose of this line?
				sb.append("Sit in seat number ");
				sb.append(i+1); // why is this i+1?
				break; // what is the point of this break keyword?
			} // end if
		} // for
		return sb.toString();
	} // end takeYourSeat
	
	public static String greetProfessor() {
		StringBuilder sb = new StringBuilder();
		if (profIsPresent) {
			sb.append("Hi ");
			sb.append(professor);
			sb.append("! ");
		} else {
			// do nothing! Is this else block required in Java?
		} // end else
		return sb.toString();
	} // end greetProfessor
} // end Driver