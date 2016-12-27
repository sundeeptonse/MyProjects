/**
 * 
 */
package com.st.myprojects.main.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author sundeeptonse
 *
 */
public class AnagramProblems {

	public static void main(String args[]) throws Exception {

		/*
		 * Scanner consoleScanner = new Scanner(System.in); int numberOfValues =
		 * consoleScanner.nextInt(); String[] inputArray = new
		 * String[numberOfValues]; for (int i = 0; i < numberOfValues; i++) {
		 * inputArray[i] = consoleScanner.next(); } consoleScanner.close();
		 */

		/*
		 * String[] inputArray = { "aaabbb" };
		 * 
		 * for (String inputString : inputArray) { int frequencyAnalysisValue =
		 * Anagram.frequencyAnalysis(inputString);
		 * System.out.println(frequencyAnalysisValue); }
		 */

		/*
		 * Scanner consoleScanner = new Scanner(System.in); String[] inputArray
		 * = new String[2]; for (int i = 0; i < 2; i++) { inputArray[i] =
		 * consoleScanner.next(); } int numberofDeletions =
		 * Anagram.numberOfDeletions(inputArray[0],inputArray[1]);
		 * System.out.println(numberofDeletions);
		 */

		String[] inputArray2 = { "anagram", "margana" };
		System.out.println(Anagram.isAnagram(inputArray2[0], inputArray2[1]));
	}
}
