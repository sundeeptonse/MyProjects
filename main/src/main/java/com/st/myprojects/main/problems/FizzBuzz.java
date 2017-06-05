/**
 * 
 */
package com.st.myprojects.main.problems;

/**
 * @author sundeeptonse
 *
 */
public class FizzBuzz {

	private static String fizz = "fizz";
	private static String buzz = "buzz";

	public static String fizzBuzz(int x) {
		StringBuilder str = new StringBuilder();
		if (x % 3 == 0) {
			str.append(fizz);
		}
		if (x % 5 == 0) {
			str.append(buzz);
		}
		return str.toString();
	}
}
