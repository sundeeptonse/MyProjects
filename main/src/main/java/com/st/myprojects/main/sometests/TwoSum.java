/**
 * 
 */
package com.st.myprojects.main.sometests;

import com.st.myprojects.main.util.DateUtil;
import com.st.myprojects.main.util.DateUtil.Time;

/**
 * @author sundeeptonse
 * 
 *         Given an array of integers, return indices of the two numbers such
 *         that they add up to a specific target.
 * 
 *         You may assume that each input would have exactly one solution.
 *         Example: Given nums = [2, 7, 11, 15], target = 9, Because nums[0] +
 *         nums[1] = 2 + 7 = 9, return [0, 1].
 * 
 *
 *         Example: Given nums = [444, 11, 1, 3], target = 12, Because nums[0] +
 *         nums[1] = 11 + 1 = 12, return [1, 2].
 */

public class TwoSum {

	private static int arraySize = 1000;

	// Take the last two numbers sum as the target

	public static void main(String... args) {
		
		
		int nums[] = {150,24,79,50,88,345,3};
		int target = 200;
		long currentTime = System.nanoTime();
		int value[] = twoSum(nums, target);
		System.out.println(target + " is sum of " + nums[value[0]] + ","
				+ nums[value[1]]);
		DateUtil.printTimeDifference(currentTime, Time.ms);
		
		/*
		for (int i = 0; i < 1000; i++) {
			int target = nums[(int) (Math.random() * arraySize)];
			long currentTime = System.nanoTime();
			System.out.println("Target is :" + target);
			int value[] = twoSum(nums, target);
			System.out.println(target + " is sum of " + nums[value[0]] + ","
					+ nums[value[1]]);
			DateUtil.printTimeDifference(currentTime, Time.ms);
		}
		*/

	}

	public static int[] twoSum(int[] nums, int target) {
		// Default value set to null
		int[] value = { 0, 0 };
		if (nums.length > 2) {

			int[][] nums2 = Sort.bubbleSort(nums, true);
			// One Counter starts from one side.
			for (int i = nums2.length - 1; i > 0; i--) {
				// The other from the other side with a max of i-1

				// If the Current Counter Loop Number is > target, then the sum
				// any other other number won't be greater than this
				if (Utils.sumCheck(target, nums2[i][0]) > 1) {
					continue;
				} else {
					value = checkRecursive(nums2, target, 0, i - 1, i);
					if (value[0] != 0 || value[1] != 0) {
						break;
					}
				}
			}
		}
		return value;
	}

	public static int[] checkRecursive(int[][] nums, int target, int min,
			int max, int currentLoopIndex) {
		int diff = max - min;

		double currentD = (min + max) / 2;
		int current = (int) Math.ceil(currentD);
		int sumCheck = Utils.sumCheck(target, nums[current][0],
				nums[currentLoopIndex][0]);
		if (diff > 1) {
			if (sumCheck != 0) {
				if (sumCheck == -1) {
					// If Lesser than, then set the max at current-1;
					max = current--;
				} else if (sumCheck == 1) {
					// If Greater than, then set min at current+1;
					min = current++;
				}
				return checkRecursive(nums, target, min, max, currentLoopIndex);
			} else {
				int[] value = { nums[current][1], nums[currentLoopIndex][1] };
				/*
				 * System.out.println("CurrentLoopIndex:" + currentLoopIndex +
				 * "-" + nums[currentLoopIndex] + ":Number at current:" +
				 * current + "-" + nums[current] + ":Max:" + max + ":Min:" + min
				 * + ":Diff:" + diff);
				 */
				return value;
			}
		} else {
			/*
			 * System.out.println("CurrentLoopIndex:" + currentLoopIndex + "-" +
			 * nums[currentLoopIndex] + ":Number at current:" + current + "-" +
			 * nums[current] + ":Max:" + max + ":Min:" + min + ":Diff:" + diff);
			 */
			if (Utils.sumCheck(target, nums[min][0], nums[currentLoopIndex][0]) == 0) {
				int[] value = { nums[min][1], nums[currentLoopIndex][1] };
				return value;
			} else if (Utils
					.sumCheck(target, nums[max][0], nums[currentLoopIndex][0]) == 0) {
				int[] value = { nums[max][1], nums[currentLoopIndex][1] };
				return value;
			} else {
				int[] value = { 0, 0 };
				return value;
			}
		}
	}
}

class Utils {
	public static int[] generateIncrementalArray(int count) {
		int value[] = new int[count];
		for (int i = 0; i < count; i++) {
			if (i == 0) {
				value[i] = 1;
			} else {
				value[i] = i * 2;
			}

		}
		return value;
	}

	// if target = sum of the number's array , returns 0 is equal,
	// -1 if target < sum
	// and 1 if target > sum
	public static int sumCheck(int target, int... numberArr) {
		int sum = 0;
		for (int number : numberArr) {
			sum += number;
		}
		return target == sum ? 0 : ((target < sum) ? -1 : 1);
	}

	public static void printArray(int[] array) {
		StringBuilder strFLine = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			strFLine.append(",").append(array[i]);
		}
		System.out.println(strFLine.toString());
	}
}

class Sort {
	public static int[][] bubbleSort(int[] nums, boolean ascending) {
		int[][] newNums = new int[nums.length][2];
		for (int i = 0; i < nums.length; i++) {
			newNums[i][0] = nums[i];
			newNums[i][1] = i;
		}

		for (int i = newNums.length - 1; i > 1; i--) {
			for (int j = 0; j < i; j++) {
				swapAscDesc(newNums, j, j + 1, ascending);
			}
		}
		return newNums;
	}

	public static void swapAscDesc(int[][] newNums, int index1, int index2,
			boolean ascending) {
		boolean swap = false;
		if (ascending) {
			if (newNums[index1][0] > newNums[index2][0]) {
				swap = true;
			}
		} else {
			if (newNums[index1][0] < newNums[index2][0]) {
				swap = true;
			}
		}
		if (swap) {
			swap(newNums, index1, index2);
		}
	}

	public static void swap(int[][] nums, int index1, int index2) {
		int temp = nums[index1][0];
		int temp2 = nums[index1][1];

		nums[index1][0] = nums[index2][0];
		nums[index1][1] = nums[index2][1];

		nums[index2][0] = temp;
		nums[index2][1] = temp2;
	}
}