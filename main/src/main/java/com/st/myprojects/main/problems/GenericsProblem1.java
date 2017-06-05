/**
 * 
 */
package com.st.myprojects.main.problems;

/*-
 * @author sundeeptonse
 * 
 * Generic methods are a very efficient way to handle multiple datatypes using a single method. This problem will test your knowledge on Java Generic methods.
 * Let's say you have an integer array and a string array. You have to write a single method printArray that can print all the elements of both arrays. The method should be able to accept both integer arrays or string arrays.
 * You are given code in the editor. Complete the code so that it prints the following lines:
 * 
 * 1
 * 2
 * 3
 * Hello
 * World
 *
 */
public class GenericsProblem1 {

	public static void main(String... args) {

		Integer[] intArr = { 0, 1, 2, 3 };
		String[] stringArray = { "1a", "2a", "3a" };
		printArray(intArr);
		printArray(stringArray);

	}

	public static <E> void printArray(E[] arrays) {
		StringBuilder printedString = new StringBuilder();
		for (E arrayValue : arrays) {
			printedString.append(arrayValue).append("\n");
		}
		System.out.println(printedString.toString());
	}

}
