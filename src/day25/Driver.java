package day25;

import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import day24.Book;

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
		
		for (Book eachOne: library) {
			System.out.println(toJSON(eachOne));
		} // end for
		// Validate output formatting using JSON validator: https://www.jsonlint.com/
		
		for (Book eachOne: library) {
			System.out.println(toXML(eachOne));
		} // end for		
	} // end main
	
	private static <E> String toJSON(E inc) {
		// This works for simple POJO classes using only embedded primitive and String data type fields
		// Can add code to allow for embedded custom classes and collections, but the complexity goes up significantly
		StringBuilder sb = new StringBuilder();
		// Class name generally provides name of enclosing JSON element for each object
		// The "value" will be all the enclosed fields!
		sb.append("{\"").append(inc.getClass().getSimpleName().toLowerCase()).append("\":{");
        Field[] allFields = inc.getClass().getDeclaredFields();
        int fieldCounter=1;
        for (Field each : allFields) {
            try {
            	Field field = inc.getClass().getDeclaredField(each.getName());
                field.setAccessible(true);
                sb.append("\"").append(field.getName().toLowerCase()).append("\":");
            	if (field.getType().toString().equals("class java.lang.String")) { // JSON strings need quotations
                    sb.append("\"").append(field.get(inc)).append("\"");            		
            	} else if (field.getType().toString().equals("int") // JSON numbers & booleans do not need quotations
            			|| field.getType().toString().equals("double") 
            			|| field.getType().toString().equals("boolean")) {
                    sb.append(field.get(inc));     
            	} // end if
                if (fieldCounter++ < allFields.length) { // add comma after each field except the last one
            		sb.append(",");
                } // end if
            } catch (Exception e) {
            	e.printStackTrace();
            } // end catch
        } // end for
        sb.append("}}");
		return sb.toString();
	} // end toJSON
	
	private static <E> String toXML(E inc) {
		// We can do the same thing to serialize into XML format as well
		StringBuilder sb = new StringBuilder();
		sb.append("<").append(inc.getClass().getSimpleName().toLowerCase()).append(">");
		Field[] allFields = inc.getClass().getDeclaredFields();
		 for (Field each : allFields) {
	            try {
	            	Field field = inc.getClass().getDeclaredField(each.getName());
	                field.setAccessible(true);
	                sb.append("<").append(field.getName().toLowerCase()).append(">");
	                sb.append(field.get(inc));
	                sb.append("</").append(field.getName().toLowerCase()).append(">");
	            } catch (Exception e) {
	            	e.printStackTrace();
	            } // end catch
		 } // end for
		sb.append("</").append(inc.getClass().getSimpleName().toLowerCase()).append(">");
		return sb.toString();
	} // end toXML
} // end Driver