/**
 * 
 */
package com.st.myprojects.main.problems;

import java.util.Map;

/**
 * @author sundeeptonse
 *
 */
public class ReverseArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * Scanner in = new Scanner(System.in); in.useDelimiter("\\n");
		 * System.out.println("Enter N"); int n = in.nextInt();
		 * System.out.println("Enter Values"); String sentence = in.next();
		 * RUtils.reverseArray(sentence);
		 */
		for (char ch = 'a'; ch <= 'z'; ch++)
			System.out.println(ch);
	}

}

class RUtils {
	public static int[] reverseArray(String arrayValues) {
		String[] array = arrayValues.split(" ");
		int[] finalarray = new int[array.length];
		StringBuilder strBuilder = new StringBuilder();
		for (int i = array.length - 1, j = 0; i >= 0; i--, j++) {
			try {
				finalarray[j] = Integer.parseInt(array[i]);
				strBuilder.append(finalarray[j]).append(" ");
			} catch (NumberFormatException nfe) {
				System.err.println("Exception in Values");
			}
		}
		System.out.println(strBuilder.toString());
		return finalarray;
	}
}
