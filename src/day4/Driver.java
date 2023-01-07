package day4;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Person firstPerson = new Person("Jeff","Hill"); // what is the technical term for what is happening here?
		System.out.println(firstPerson.toString()); // what is the technical term for what is happening here?
		firstPerson.setfName("George");
		System.out.println(firstPerson.toString());
		
		Scanner in = new Scanner(System.in);
		System.out.println("What is the person's first name?");
		firstPerson.setfName(in.nextLine());
		System.out.println("What is the person's last name?");
		firstPerson.setlName(in.nextLine());
		System.out.println(firstPerson.toString());
		
		System.out.println("What is the student's first name?");
		String fName = in.nextLine();
		System.out.println("What is the student's last name?");
		String lName = in.nextLine();
		Student studentOne = new Student(fName, lName);
		System.out.println(studentOne.toString()); // how can we make this output "Student" instead of "Person"?
		
		System.out.println("What is the professor's title?");
		String profTitle = in.nextLine();
		System.out.println("What is the professor's first name?");
		String profFirstName = in.nextLine();
		System.out.println("What is the professor's last name?");
		String profLastName = in.nextLine();
		System.out.println("How many years of experience does this professor have?");
		String profExperience = in.nextLine(); // why is this a String data type for a number data value?
	
		Professor professorOne = new Professor(profTitle, profFirstName, profLastName, profExperience);
		System.out.println(professorOne); // why isn't the .toString() method explicitly invoked?
		// how can we make this output "Professor" and also appropriately add the title and years of experience?
		
		Person personOne = studentOne; // what fundamental OOP technique are these examples of?
		Person personTwo = professorOne;
		System.out.println(personOne);
		System.out.println(personTwo);
		Person[] people = new Person[2];
		people[0] = studentOne;
		people[1] = professorOne;
		for (int i=0;i<=1;i++) {
			System.out.println(people[i]);
		} // end for
	} // end main
} // end Driver