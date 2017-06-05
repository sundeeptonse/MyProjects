/**
 * 
 */
package com.st.myprojects.main.problems;

/**
 * @author sundeeptonse
 * 
 *         Find the contiguous subarray within an array (containing at least one
 *         number) which has the largest sum.
 * 
 *         For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous
 *         subarray [4,-1,2,1] has the largest sum = 6.
 * 
 */
public class MaxSubArray2 {

	public static void main(String... args) {

		MaxSubArray2 maxSubArray = new MaxSubArray2();
		int nums[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

		int nums2[] = { -2, -3, 4, 4, 4, 5, 6 };
		System.out.println(maxSubArray.maxSubArrayIterative(nums2));
		System.out.println(maxSubArray.maxSubArrayRecursive(nums2));

		System.out.println(maxSubArray.maxSubArrayIterative(nums));
		System.out.println(maxSubArray.maxSubArrayRecursive(nums));
	}

	// -2,-3,4,4,4,5,6
	// -2,-5
	// maxSum = -2, prevMaxSum = -2
	// prevMaxSum = Max(currentNum, prevMaxSum + currentNumber)
	// maxSum = Max(maxSum, currentNumber + maxSum) = -2,

	// -2,1,-3,4,-1,2,1,-5,4
	// -1, 1

	public int maxSubArrayIterative(int[] nums) {
		int maxSum, prevMaxSum;
		prevMaxSum = maxSum = nums[0];
		for (int i = 1; i < nums.length;) {
			int currentNumber = nums[i++];
			// Prev Max Sum is the greater of the two numbers
			// Example -2 + -3 = -5 or -3, we choose -3
			prevMaxSum = Math.max(prevMaxSum + currentNumber, currentNumber);
			// We keep storing the maxSumValue in this Variable
			maxSum = maxSum < prevMaxSum ? prevMaxSum : maxSum;
		}
		return maxSum;
	}

	int maxSum;

	public int maxSubArrayRecursive(int[] nums) {
		maxSum = 0;
		maxSubArrayRecursive(nums, nums.length - 1);
		return maxSum;
	}

	public int maxSubArrayRecursive(int[] nums, int index) {
		if (index == 0) {
			return nums[0];
		}
		int prevMax = maxSubArrayRecursive(nums, index - 1);
		prevMax = Math.max(nums[index], prevMax + nums[index]);
		maxSum = maxSum < prevMax ? prevMax : maxSum;
		return prevMax;
	}
}
