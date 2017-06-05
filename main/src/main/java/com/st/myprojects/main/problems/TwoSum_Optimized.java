/**
 * 
 */
package com.st.myprojects.main.problems;

import java.util.HashMap;
import java.util.Map;

import com.st.myprojects.main.util.DateUtil;
import com.st.myprojects.main.util.DateUtil.Time;

/**
 * @author sundeeptonse
 *
 */
public class TwoSum_Optimized {

	private static int arraySize = 1000;
	private static int counter = 1000;

	public static void main(String... args) {

		int nums[] = Utils.generateIncrementalArray(arraySize);
		int target = nums[nums.length - 1] + nums[nums.length - 2];
		long averageTime = 0;
		for (int i = 0; i < counter; i++) {
			// int target = nums[(int) (Math.random() * arraySize)];

			long currentTime = System.nanoTime();
			int value[] = twoSum_TwoPassHashTable(nums, target);
			averageTime += DateUtil.getTimeDifference(currentTime, Time.mis);
		}
		System.out.println("Average Time Taken is:" + (averageTime / counter)
				+ " microseconds");

		averageTime = 0;
		for (int i = 0; i < counter; i++) {
			// int target = nums[(int) (Math.random() * arraySize)];
			long currentTime = System.nanoTime();
			int value[] = twoSum_SinglePassHashTable(nums, target);
			averageTime += DateUtil.getTimeDifference(currentTime, Time.mis);
		}
		System.out.println("Average Time Taken is:" + (averageTime / counter)
				+ " microseconds");

		averageTime = 0;
		for (int i = 0; i < counter; i++) {
			// int target = nums[(int) (Math.random() * arraySize)];
			long currentTime = System.nanoTime();
			int value[] = twoSum(nums, target);
			averageTime += DateUtil.getTimeDifference(currentTime, Time.mis);
		}
		System.out.println("Average Time Taken is:" + (averageTime / counter)
				+ " microseconds");

	}

	/**
	 * (Two-pass Hash Table) & (Single-pass Hash Table)
	 * 
	 * To improve our run time complexity, we need a more efficient way to check
	 * if the complement exists in the array. If the complement exists, we need
	 * to look up its index. What is the best way to maintain a mapping of each
	 * element in the array to its index? A hash table.
	 * 
	 * We reduce the look up time from O(n) to O(1) by trading space for speed.
	 * A hash table is built exactly for this purpose, it supports fast look up
	 * in near constant time. I say "near" because if a collision occurred, a
	 * look up could degenerate to O(n)O(n) time. But look up in hash table
	 * should be amortized O(1)O(1) time as long as the hash function was chosen
	 * carefully.
	 * 
	 * A simple implementation uses two iterations. In the first iteration, we
	 * add each element's value and its index to the table. Then, in the second
	 * iteration we check if each element's complement (target - nums[i]) exists
	 * in the table. Beware that the complement must not be nums[i] itself!
	 * 
	 * Complexity Analysis:
	 * 
	 * Time complexity : O(n). We traverse the list containing n elements
	 * exactly twice. Since the hash table reduces the look up time to O(1), the
	 * time complexity is O(n).
	 * 
	 * Space complexity : O(n). The extra space required depends on the number
	 * of items stored in the hash table, which stores exactly n elements.
	 */

	public static int[] twoSum_TwoPassHashTable(int[] nums, int target) {
		Map<Integer, Integer> numsMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			numsMap.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (numsMap.containsKey(complement) && numsMap.get(complement) != i) {
				return new int[] { i, numsMap.get(complement) };
			}
		}
		return new int[] { 0, 0 };
	}

	public static int[] twoSum_SinglePassHashTable(int[] nums, int target) {
		Map<Integer, Integer> numsMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (numsMap.containsKey(complement) && numsMap.get(complement) != i) {
				return new int[] { i, numsMap.get(complement) };
			}
			numsMap.put(nums[i], i);
		}
		return new int[] { 0, 0 };
	}

	/**
	 * The brute force approach is simple. Loop through each element xx and find
	 * if there is another value that equals to target - xtarget−x.
	 * 
	 * Time complexity : O(n^2). For each element, we try to find its complement
	 * by looping through the rest of array which takes O(n) time. Therefore,
	 * the time complexity is O(n^2).
	 * 
	 * Space complexity : O(1).
	 */
	public static int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == target - nums[i]) {
					return new int[] { i, j };
				}
			}
		}
		return new int[] { 0, 0 };
	}

}
