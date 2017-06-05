/**
 * 
 */
package com.st.myprojects.main.recursionndynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sundeeptonse
 * 
 *         A child is running up a staircase with n steps and can hop either 1,
 *         2 or 3 steps at a time.
 * 
 *         Implement a method to count how many possible way the child can run
 *         up the stairs
 *
 */
public class TripleStep {

	public static void main(String... args) {
		// int[] array = { 1, 2, 3 };
		//sint[] array = { 3, 1, 2 };
		// System.out.println(countWays(6, array));

		System.out.println(countWays2(6));
	}

	public static long countWays2(int n) {
		long[] memo = new long[n + 1];
		Arrays.fill(memo, -1);
		return countWays2(n, memo);
	}

	public static long countWays2(int n, long[] memo) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			if (memo[n] == -1) {
				memo[n] = countWays2(n - 1, memo) + countWays2(n - 2, memo)
						+ countWays2(n - 3, memo);
			}
			return memo[n];
		}
	}

	//
	//
	// public static long countWays(int n, int[] stepCounts) {
	// // Start with 0
	// return countWays(n, stepCounts, 0, new HashMap<Step, Long>());
	// }
	//
	// private static long countWays(int remainingsteps, int[] stepCounts,
	// int index, Map<Step, Long> map) {
	//
	// // If No More remainingSteps, then we have reached the end for that
	// // number and hence # of ways is 1
	// if (remainingsteps == 0) {
	// return 1;
	// }
	//
	// // If index is more than the length, then return 0 as we can make the n
	// // number
	// if (index == stepCounts.length || remainingsteps < 0) {
	// return 0;
	// }
	//
	// System.out.println("Remaining Step:" + remainingsteps + ":index:"
	// + index);
	// // If remaining steps were 10
	// // and current step was 3
	// // remainingsteps = 10, 7, 4, 1
	//
	// // If remaining steps were 9
	// // and current step was 3
	// // remainingsteps = 9, 6, 3, 0
	//
	// Step currentStep = new Step(remainingsteps, index);
	// int currentStepNumber = stepCounts[index];
	// if (!map.containsKey(currentStep)) {
	// long numberOfWays = 0;
	// while (remainingsteps >= 0) {
	// // Recurse and send ahead to the next Index
	// numberOfWays += countWays(remainingsteps, stepCounts,
	// index + 1, map);
	// remainingsteps -= currentStepNumber;
	// }
	// map.put(currentStep, numberOfWays);
	// }
	// return map.get(currentStep);
	// }
	//
	// private static class Step {
	// int remainingsteps;
	// int index;
	//
	// public Step(int remainingsteps, int index) {
	// super();
	// this.remainingsteps = remainingsteps;
	// this.index = index;
	// }
	//
	// @Override
	// public int hashCode() {
	// final int prime = 31;
	// int result = 1;
	// result = prime * result + index;
	// result = prime * result + remainingsteps;
	// return result;
	// }
	//
	// @Override
	// public boolean equals(Object obj) {
	// if (this == obj)
	// return true;
	// if (obj == null)
	// return false;
	// if (getClass() != obj.getClass())
	// return false;
	// Step other = (Step) obj;
	// if (index != other.index)
	// return false;
	// if (remainingsteps != other.remainingsteps)
	// return false;
	// return true;
	// }
	// }
}
