package day24;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		List<Book> library = new ArrayList<Book>();
		library.add(new Book("Economics in One Lesson: The Shortest and Surest Way to Understand Basic Economics",
				"Henry Hazlitt","978-0517548233","Economics",218, 1988));
		library.add(new Book("I, Pencil: My Family Tree",
				"Leonard E. Read","978-1-63069-700-6","Economics",15,1958));
		library.add(new Book("That Which is Seen, and That Which is Not Seen: An Economic Essay",
				"Frédéric Bastiat","978-1557420657","Economics",48,1850));
		
		for (Book eachOne: library) {
			System.out.println(eachOne.toString());
		} // end for
		
		/**
		 * This is a standard example of instantiating objects and outputting the object state ("serializing" the field values)
		 *  as a series of String objects. This works perfectly well...
		 * 
		 * But what if we don't like the format provided by the .toString() method implementation and we don't control
		 *  the underlying source code? (e.g. we bought a library for its functionality but want the output in a 
		 *  slightly different format)
		 *  
		 * We could capture the String value(s) and using various string manipulation functions force what we want...
		 * But there is a better way... Reflection!
		 * 
		 * Reflection allows us to bypass encapsulation and directly read fields and values within objects!
		 * Note: This would NEVER be supported by a 3rd party vendor, do not expect them to support your efforts
		 *  to bypass the encapsulation on their objects if you run into problems or difficulties
		 * 
		 * Note: Reflection can be blocked by 3rd party vendors by use of SecurityManager
		 * https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/SecurityManager.html
		 */
		
		for (Book eachOne: library) {
	        Field[] allFields = eachOne.getClass().getDeclaredFields();
	        for (Field each : allFields) {
                try {
                	Field field = eachOne.getClass().getDeclaredField(each.getName());
                    field.setAccessible(true);
    	        	System.out.print(field.getName()+"=");
                    field.setAccessible(true);
                    System.out.print(field.get(eachOne)+"//");
                } catch (Exception e) {
                	e.printStackTrace();
                } // end catch
	        } // end for
            System.out.println();
		} // end for
	} // end main
} // end Driver