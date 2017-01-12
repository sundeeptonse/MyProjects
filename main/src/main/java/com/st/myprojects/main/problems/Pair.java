/**
 * 
 */
package com.st.myprojects.main.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sundeeptonse
 * 
 *         Given integers, count the number of pairs of integers whose
 *         difference is .
 * 
 *         Input Format
 * 
 *         The first line contains and . The second line contains numbers of the
 *         set. All the numbers are unique.
 * 
 *         Constraints
 * 
 *         Each integer will be greater than and at least smaller than . Output
 *         Format
 * 
 *         An integer that tells the number of pairs of integers whose
 *         difference is .
 * 
 *         Sample Input
 * 
 *         5 2
 * 
 *         1 5 3 4 2
 * 
 *         Sample Output
 * 
 *         3
 * 
 *         Explanation
 * 
 *         There are 3 pairs of integers in the set with a difference of 2.
 *
 */
public class Pair {

	public static void main(String... args) {

	}

	private static int pairs(int[] numberArray, int difference) {
		int numberOfPairs = 0;
		// Contains the Number and it's matching pair (Incremented)
		// Example 2, will have 5, if the difference is 3
		Map<Integer, Integer> countMap = new HashMap<>(numberArray.length);
		int maxNumber = Integer.MAX_VALUE - difference;
		for (int number : numberArray) {
			// Only the Values which are lesser which have an equivalent pair,
			// for the others the matching pair is -1
			if (number < maxNumber) {
				// The Matching Pair is the number plus the difference
				int matchingPair = number + difference;
				countMap.put(number, matchingPair);
			} else {
				countMap.put(number, -1);
			}
		}
		/*
		 * Iterate over the  Map
		 */
		for (Integer key : countMap.keySet()) {
			// If the Map contains the Equivalent Number, then increment, else
			// skip
			if (countMap.containsKey(countMap.get(key))) {
				numberOfPairs++;
			}
		}
		return numberOfPairs;
	}
}
