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
 *         contiguous sub-array of size k.
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
		int[] inputArray = { 4, 3, 1, 2, 7, 1, 1 };
		maxSubArrays(inputArray, 3);
		// Utils.printArray(outputArray);
	}

	public static void maxSubArrays(int[] a, int k) {
		int n = a.length;

		// Create a Double Ended Queue, Q that will store indexes of array
		// elements
		// The queue will store indexes of useful elements in every window and
		// it will
		// maintain decreasing order of values from front to rear in Q, i.e.,
		// a[Q.front[]] to a[Q.rear()] are sorted in decreasing order

		ArrayDeque<Integer> Q = new ArrayDeque<Integer>();

		// Process first k (or first window) elements of array
		int i;
		for (i = 0; i < k; i++)
		{

			while (!Q.isEmpty() && a[i] >= a[Q.size() - 1])
				Q.pollLast();
			// Remove from rear
			// Add new element at rear of queue
			Q.add(i);
		}

		
		// Process rest of the elements, i.e., from a[k] to a[n-1]

		for (; i < n; ++i) {
			System.out.print(a[Q.peek()] + " ");
			while (!Q.isEmpty() && Q.peek() <= i - k)
				Q.pop();

			while (!Q.isEmpty() && a[i] >= a[Q.peekLast()])
				Q.pollLast();
			// Add current element at the rear of Q
			Q.add(i);
		}
		// Print the maximum element of last window
		System.out.print(a[Q.peek()] + " ");
	}

}
