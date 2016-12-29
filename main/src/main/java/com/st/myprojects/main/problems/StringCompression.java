/**
 * 
 */
package com.st.myprojects.main.problems;

import com.st.myprojects.main.util.StringUtil;

/**
 * @author sundeeptonse
 * 
 *         Implement a method to do basic String compression aaaabbccddd :
 *         a4b2c2d3
 *
 */
public class StringCompression {

	public static void main(String... args) {

		System.out.println(compressString("aaaabbccddd"));
		System.out
				.println(compressString("zzzzzzzzzzzzzzzzzzzzzzzzzyyyyyyyyyyyyyyy"));

	}

	public static String compressString(String string) {
		StringBuilder compressedString = new StringBuilder();
		int length = StringUtil.length(string);
		if (length > 0) {
			int i = 0;
			int alphabetCounter = 0;
			while (i < length) {
				char charAtI = string.charAt(i++);
				// Increment the counter
				alphabetCounter++;
				if (i >= length || charAtI != string.charAt(i)  ) {
					compressedString.append(charAtI).append(alphabetCounter);
					alphabetCounter = 0;
				}
			}

		}
		return compressedString.toString();
	}
}
