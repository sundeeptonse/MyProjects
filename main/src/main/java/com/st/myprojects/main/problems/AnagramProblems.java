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

final class Anagram {

	private Anagram() {
	}

	/*-
	 * Compares two Strings and checks if they are anagrams of each other
	 * Time Complexity : O(26) + O(n) --> O(n)
	 */

	public final static boolean isAnagram(String anagramString1,
			String anagramString2) {
		boolean isAnagram = false;
		if (!StringUtils.isNullorBlank(anagramString1)
				&& !StringUtils.isNullorBlank(anagramString2)) {
			if (anagramString1.length() == anagramString2.length()) {
				Map<Character, Integer> map1 = generateCharFrequency(anagramString1);
				Map<Character, Integer> map2 = generateCharFrequency(anagramString2);
				isAnagram = isMapIdentical(map1, map2);
			}
		}
		return isAnagram;
	}

	/*-
	 * Compares the frequency Distribution of the Maps and returns back
	 */
	public final static boolean isMapIdentical(Map<Character, Integer> map1,
			Map<Character, Integer> map2) {
		boolean isAnagram = false;
		if (map1.size() == map2.size()) {
			isAnagram = true;
			for (Character key : map1.keySet()) {
				if (!map2.containsKey(key) || (map1.get(key) != map2.get(key))) {
					// Set is Anagram to false and break loop
					isAnagram = false;
					break;
				}
			}
		}
		return isAnagram;
	}

	/*-
	 * Generates and stores the CharacterFrequencyMap for the two Strings
	 * Compares and fetches the frequencyAnalysis Numeric
	 * 
	 * Time Complexity : O(26) + O(n) --> O(n)
	 */
	public final static int frequencyAnalysis(String anagramString) {
		int frequencyAnalysis = -1;
		if (!StringUtils.isNullorBlank(anagramString)
				&& NumberUtils.isEven(anagramString.length())) {

			String anagramString1 = anagramString.substring(0,
					anagramString.length() / 2);
			String anagramString2 = anagramString.substring(
					anagramString.length() / 2, anagramString.length());

			Map<Character, Integer> map1 = generateCharFrequency(anagramString1);
			Map<Character, Integer> map2 = generateCharFrequency(anagramString2);

			frequencyAnalysis = calculateFrequencyAnalysis(map1, map2);

		}
		return frequencyAnalysis;
	}

	/*-
	 * Generate the number of Deletions to be made to make two Strings Anagrams of each other
	 * Time Complexity : O(26) + O(2*n) --> O(n)
	 */

	public final static int numberOfDeletions(String anagramString1,
			String anagramString2) {
		Map<Character, Integer> map1 = generateCharFrequency(anagramString1);
		Map<Character, Integer> map2 = generateCharFrequency(anagramString2);
		return calculateNumberofDeletions(map1, map2);
	}

	/*-
	 * Generates the Character Frequency Map of the two Strings and
	 * stores in the Map
	 * 
	 * Time Complexity --> O(n)
	 */
	private final static Map<Character, Integer> generateCharFrequency(
			String anagramString) {
		Map<Character, Integer> charFreqMap = new HashMap<>();
		for (int i = 0; i < anagramString.length(); i++) {
			updateCharacterCountInMap(charFreqMap, anagramString.charAt(i));
		}
		return charFreqMap;
	}

	/*-
	 * Updates the Character Count in the corresponding HashMap
	 * Time Complexity --> O(1), since HashMap operations are 0(1)
	 * */
	private final static void updateCharacterCountInMap(
			Map<Character, Integer> map, Character character) {
		if (map.containsKey(character)) {
			Integer countOfCharacter = map.get(character);
			map.put(character, ++countOfCharacter);
		} else {
			map.put(character, 1);
		}
	}

	/*-
	 * Create a Map which stores the Mod(Difference) of the Characters 
	 * Iterate through both the Maps with the larger one first and then complete the left over Values
	 * Sum up on the Map which stores the Mod(Difference) to get the deletions.
	 */
	private final static int calculateNumberofDeletions(
			Map<Character, Integer> map1, Map<Character, Integer> map2) {
		int numberofDeletions = 0;

		/*-
		 * Two Maps 
		 * 1) Iterative Map :: Map with the Larger Size 
		 * 2) Compare Map
		 * :: Map with which to Compare
		 */
		Map<Character, Integer> iterativeMap = map1;
		Map<Character, Integer> compareMap = map2;

		Map<Character, Integer> deletionsMap = new HashMap<>();

		/*
		 * Make the Iterative Map the Greater of the two Maps to improve upon
		 * the Performance
		 */
		if (map2.size() > map1.size()) {
			iterativeMap = map2;
			compareMap = map1;
		}

		/*
		 * O(26) --> For both the below methods
		 */

		/*-
		 * 
		 * Add the Absolute(Difference)  of the Iterative Map with the Comparison Map 
		 *    FrequencyAnalysis += Difference
		 * 
		 */
		for (Character key : iterativeMap.keySet()) {
			Integer value1 = iterativeMap.get(key);
			Integer value2 = compareMap.containsKey(key) ? compareMap.get(key)
					: 0;
			int absoluteDifference = Math.abs(value1 - value2);
			numberofDeletions += absoluteDifference;
			deletionsMap.put(key, absoluteDifference);
		}

		/*
		 * Iterate over the rest of the Keys
		 */
		for (Character key : compareMap.keySet()) {
			/*
			 * If the key has already been iterated over skip and add the value
			 * directly to the Map and increment the number of Deletions
			 */
			if (!deletionsMap.containsKey(key)) {
				Integer value = compareMap.get(key);
				numberofDeletions += value;
				deletionsMap.put(key, value);
			}
		}

		return numberofDeletions;
	}

	/*-
	 * 
	 * Calculation:
	 * If Count(Character) in Map1 > Count(Character) in Map2 
	 * 		Add to frequenceAnalysisNumber
	 * 
	 */
	private final static int calculateFrequencyAnalysis(
			Map<Character, Integer> map1, Map<Character, Integer> map2) {

		/*
		 * Two Maps 1) Iterative Map :: Map with the Smaller Size 2) Compare Map
		 * :: Map with which to Compare
		 */
		Map<Character, Integer> iterativeMap = map1;
		Map<Character, Integer> compareMap = map2;

		/*
		 * Make the Iterative Map the Lesser of the two Maps to improve upon the
		 * Performance
		 */
		if (map2.size() < map1.size()) {
			iterativeMap = map2;
			compareMap = map1;
		}
		int frequencyAnalysis = 0;

		/*-
		 * O(26) --> Max
		 * 
		 * Checks the Difference of Count of the Keys of the Iterative Map with the Comparison Map 
		 * and adds only Positive Differences to the FrequencyAnalysis 
		 * If(Diff > 0){
		 *    FrequencyAnalysis += Difference
		 * }
		 */
		for (Character key : iterativeMap.keySet()) {
			Integer value1 = iterativeMap.get(key);
			Integer value2 = compareMap.containsKey(key) ? compareMap.get(key)
					: 0;
			int difference = value1 - value2;
			if (difference >= 0) {
				frequencyAnalysis += difference;
			}
		}
		return frequencyAnalysis;
	}

}

final class NumberUtils {
	public static final boolean isEven(int number) {
		return (number % 2 == 0) ? true : false;
	}
}

final class StringUtils {
	public static final boolean isNullorBlank(String stringValue) {
		return stringValue == null ? true : stringValue
				.equals(Constants.EMP_STR);
	}
}

final class Constants {
	public static final String EMP_STR = "";
}