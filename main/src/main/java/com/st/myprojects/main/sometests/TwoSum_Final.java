/**
 * 
 */
package com.st.myprojects.main.sometests;

import java.util.Arrays;

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

public class TwoSum_Final {

	private static int arraySize = 1000;

	// Take the last two numbers sum as the target

	public static void main(String... args) {
		//int nums[] = Utils_Final.generateIncrementalArray(arraySize);
		
		int nums[] = {-3,4,3,90};
		int target = 0;
		long currentTime = System.nanoTime();
		int value[] = twoSum(nums, target);
		System.out.println(target + " is sum of " + nums[value[0]] + ","
				+ nums[value[1]]);
		DateUtil.printTimeDifference(currentTime, Time.ms);
		
		/*
		for (int i = 0; i < 1000; i++) {
			int target = nums[(int) (Math.random() * arraySize)];
			Utils_Final.printArray(nums);
			Utils_Final.printArray(nums);
			
			System.out.println("Target is :" + target);
			
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

			int[] newNums = new int[nums.length];
			Arrays.fill(newNums, -1);
			int counter = 0;
			// N
			for (int i = 0; i < nums.length; i++) {
				int sumCheck = Utils_Final.sumCheck(target, nums[i]);
				System.out.println(sumCheck);
				if (sumCheck >= 0) {
					newNums[counter++] = i;
				}
			}
			
			System.out.println("Array is:");
			Utils_Final.printArray(newNums);

			// N*(N-1) Worst, Best Based on the number of Elements removed
			// N/2*N/2
			// if -1 is reached, that is End of Array, End Loop
			for (int i = 0; i < nums.length; i++) {
				if(newNums[i] == -1){
					break;
				}
				// if -1 is reached, that is End of Array, End Loop
				for (int j = i + 1; j < nums.length; j++) {
					if(newNums[j] == -1){
						break;
					}
					int sumCheck = Utils_Final.sumCheck(target,
							nums[newNums[i]], nums[newNums[j]]);
					if (sumCheck == 0) {
						value[0] = newNums[i];
						value[1] = newNums[j];
						return value;
					}
				}
			}
		}
		return value;
	}

}

class Utils_Final {
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
