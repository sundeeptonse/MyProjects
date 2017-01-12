/**
 * 
 */
package com.st.myprojects.main.nestedclasses;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author sundeeptonse
 *
 */
public class NestedClasses {

	public String myInstance;

	private void whyPrintAgain(String test) {
		System.out.println("whyPrintAgain" + test);

	}

	private static void whyPrintAgainStatic(String test) {
		System.out.println("whyPrintAgainStatic" + test);
	}

	public static void main(String... args) {

		// For Static
		// Calling the Static Method of the Static Class
		NestedClasses.StaticClass.printStatic("Hello");
		// Calling the Non-Static Method of the Static Class, by creating an
		// instance
		new NestedClasses.StaticClass().print("Hello");

		// For Non-Static
		NestedClasses nc = new NestedClasses();
		// Woah Weird Syntax
		NestedClasses.NonStaticClass nc2 = nc.new NonStaticClass();

		// Anonymous Classes
		Arrays.parallelSort(args, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});

		
		
	}

	/*
	 * Can Implement If declared private, then only accessible within this class
	 * Can be Instantiated, Doesn't have access to the Main Class Instance
	 * Variable's and Functions
	 * 
	 * Has access to the Class Variables and Functions
	 */

	public static class StaticClass implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void print(String value) {
			System.out.println(value);
			// Has Access to this, when the object is created
			System.out.println(this.getClass().getName());

			whyPrintAgainStatic(value);

		}

		public static void printStatic(String value) {
			System.out.println(value);

			// Doesn't have Access to this--> Expected, since it is a static
			// method
			/*
			 * System.out.println(this);
			 */

		}
	}

	/*
	 * Can Implement If declared private, then only accessible within this class
	 * Can be Instantiated, Has Access to the Main Class Instance Variable's and
	 * Functions
	 * 
	 * Doesn't have access to the Class Variables and Functions since it can't
	 * have Static Members.
	 */

	public class NonStaticClass implements innerInterface {

		public void print(String value) {
			System.out.println(value);
			System.out.println(myInstance);
			whyPrintAgain(value);
			
			
			//Local Classes
			class EnglishGoodbye {
	            public void sayGoodbye() {
	                System.out.println("Bye bye");
	            }
	        }
	        new EnglishGoodbye().sayGoodbye();
		}

		/*
		 * Since this is a non-static Context - think variable , it cannot have
		 * static methods
		 */

		/*
		 * public static void printStatic(String value){
		 * System.out.println(value); }
		 */
	}

	public interface innerInterface {
		int a = 0;
		int b = 0;
	}

}
