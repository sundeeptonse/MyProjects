/**
 * 
 */
package com.st.myprojects.main.problems;

import java.util.ArrayDeque;

/**
 * @author sundeeptonse
 * 
 *         Maximum of all subarrays of size k (Added a O(n) method) Given an
 *         array and an integer k, find the maximum for each and every
 *         contiguous subarray of size k.
 * 
 *         array : 0, 2, 2, 3, 454, 5454, 6554, k: 3
 * 
 *         O/P : 2,3,454,5454,6554
 * 
 *         Current Efficiency : O(n)
 *
 */
public class MaxSubArray {

	public static void main(String... args) {
		int[] inputArray = { 7, 2, 100, 6, 7, 1, 1 };
		int[] outputArray = maxSubArrays(inputArray, 3);
		// Utils.printArray(outputArray);
	}

	public static int[] maxSubArrays(int[] inputArray, int k) {
		int[] op = null;

		ArrayDeque<Integer> dequeArray = new ArrayDeque<>();
		dequeArray.push(inputArray[0]);
		for (int i = 1; i < k; i++) {
			Integer lastEnteredValue = dequeArray.peekFirst();
			System.out.println("lastEnteredValue:" + lastEnteredValue
					+ ":inputArray[i]" + inputArray[i]);
			if (inputArray[i] > lastEnteredValue) {
				dequeArray.pollFirst();
				System.out.println("Adding" + inputArray[i]);
				dequeArray.push(inputArray[i]);
			}
			System.out.println("Adding" + inputArray[i]);
			dequeArray.push(inputArray[i]);

		}

		while (!dequeArray.isEmpty()) {
			System.out.println("de:" + dequeArray.pop());
		}

		// 5454, 4, 4

		// 5454
		// 6
		// 7
		// 7,7

		return op;
	}

}
