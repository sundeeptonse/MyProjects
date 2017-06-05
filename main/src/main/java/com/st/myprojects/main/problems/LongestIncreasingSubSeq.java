/**
 * 
 */
package com.st.myprojects.main.problems;

import java.util.Arrays;

/**
 * @author sundeeptonse
 * 
 *         Given an unsorted array of integers, find the length of longest
 *         increasing subsequence.
 * 
 *         For example, Given [10, 9, 2, 5, 3, 7, 101, 18], The longest
 *         increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
 *         Note that there may be more than one LIS combination, it is only
 *         necessary for you to return the length.
 * 
 *         Your algorithm should run in O(n2) complexity.
 * 
 *         Follow up: Could you improve it to O(n log n) time complexity?
 *
 */
public class LongestIncreasingSubSeq {

	public static void main(String... args) {
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(lengthOfLIS(nums));
	}

	public static int lengthOfLISOpt(int[] nums) {
		int[] resultArray = new int[nums.length];
		Arrays.fill(resultArray, 1);
		for (int i = 1; i < nums.length; i++) {
			// Add to a PQ with Min Heap
			// If the Value at the Top is lesser than currentValue
						
			
		}
		Arrays.sort(resultArray);
		return resultArray[resultArray.length - 1];
	}

	public static int lengthOfLIS(int[] nums) {
		int[] resultArray = new int[nums.length];
		Arrays.fill(resultArray, 1);
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] < nums[i]) {
					resultArray[i] = Math.max(resultArray[i],
							resultArray[j] + 1);
				}
			}
		}
		Arrays.sort(resultArray);
		return resultArray[resultArray.length - 1];
	}
}
