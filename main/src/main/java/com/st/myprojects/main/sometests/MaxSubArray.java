/**
 * 
 */
package com.st.myprojects.main.sometests;

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
		int[] inputArray = { 5454, 2, 2, 3, 6, 2, 1 };
		maxSubArrays(inputArray, 3);
		//Utils.printArray(maxSub);
	}

	public static void maxSubArrays(int[] inputArray, int subArraySize) {

		ArrayDeque<Integer> ab = new ArrayDeque<Integer>();
		int[] arr = { 12, 1, 78, 90, 57, 89, 56 };
		int k = 3;
		int i;
		for (i = 0; i < k; ++i) {
			while (!ab.isEmpty() && arr[i] >= arr[ab.getLast()]) {
				ab.removeLast();
			}
			ab.addLast(i);
		}
		for (; i < arr.length; ++i) {
			System.out.print(arr[ab.getFirst()] + " ");
			while (!ab.isEmpty() && i - k >= ab.getFirst()) {
				ab.removeFirst();
			}
			while (!ab.isEmpty() && arr[i] >= arr[ab.getLast()]) {
				ab.removeLast();
			}
			ab.addLast(i);
		}
		System.out.print(arr[ab.getFirst()]);

		/*
		 * int[] returnArray = new int[inputArray.length]; for (int i = 0, max =
		 * 0; i < inputArray.length; i++) {
		 * 
		 * returnArray[i] = inputArray[i]; if (i > 0 & subArraySize > 0) { if
		 * ((i - subArraySize) > 0) if (inputArray[i] > returnArray[i - 1]) {
		 * returnArray[i - 1] = inputArray[i]; } }
		 * 
		 * } return returnArray;
		 */
	}

}
