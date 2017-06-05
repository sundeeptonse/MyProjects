/**
 * 
 */
package com.st.myprojects.main.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

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
 * 
 *         array : 100, 2, 4, 500, 54, 14, 6554, k: 3
 * 
 *         O/P :100,500,500,500,6554,
 * 
 * 
 *
 */
public class MaxSubArray {

	public static void main(String... args) {

		int[] inputArray = { 4, 3, 1, 2, 7, 1, 1 };
		System.out.println(Arrays.toString(maxSubArrays(inputArray, 3)));
	}

	// (n-k)log(k); = n*log(k) = n
	public static int[] maxSubArrays(int[] a, int k) {

		int[] maxSubArray = new int[a.length - k + 1];
		// If we use a Max Heap with Size k
		// The Largest will bubble to the top

		// Have a PQ with a fixed Size
		PriorityQueue<Integer> pq = new PriorityQueue<>(
				Collections.reverseOrder());

		// Fill the PQ with the first k numbers
		int i = 0;
		for (; i < k - 1;) {
			pq.add(a[i++]);
		}

		int j = 0;
		// max = pq.peek();
		// counter1 = startIndex, start with 0;
		// counter2 = nextIndex;, start with k,

		// Keep Sliding the window ahead till counter2<length

		// ProcessNextRow
		// Remove1st and AddNext
		// log(k)
		// pq.remove(counter1++);
		// log(k)
		// pq.add(counter2++);
		// Since we are removing and adding log(k)

		for (; i < a.length;) {
			// Add/Peek/Remove
			pq.add(a[i++]);
			maxSubArray[j] = pq.peek();
			pq.remove(a[j++]);
		}

		return maxSubArray;

	}
}
