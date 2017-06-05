/**
 * 
 */
package com.st.myprojects.main.problems;

import java.util.Arrays;

import com.st.myprojects.main.util.CommonUtil;

/**
 * @author sundeeptonse
 * 
 *         In an array of Integers, a peak is an element which is > or equal to
 *         the adjacents integers and a valley is which is less than or equal to
 * 
 *         Sort in Peaks and Valley
 * 
 *         5 3 1 2 3 5 1 3 2 3
 *
 */
public class PeakAndValleys {

	public static void main(String... args) {

		Integer[] inputArray = { 5, 3, 1, 2, 3, 5, 1, 2, 3, 4 };
		System.out.println(Arrays.toString(inputArray));
		sortByPeaksAndValleys(inputArray);
		System.out.println(Arrays.toString(inputArray));
		System.out.println();
		Integer[] inputArray2 = { 3, 3, 4, 1, 3, 3, 3, 3, 3, 3 };
		System.out.println(Arrays.toString(inputArray2));
		sortByPeaksAndValleys(inputArray2);
		System.out.println(Arrays.toString(inputArray2));

	}

	/*-
	 * If the Subsequent Peak is higher than the adjacent values, then the valleys are taken care of 
	 * */

	public static void sortByPeaksAndValleys(Integer[] inputArray) {

		// Start with index 1 and look at the subsequent values 1+2/
		for (int i = 1; i < inputArray.length; i += 2) {
			// Get the Larger Value
			int right = i + 1;
			int left = i - 1;
			int largerIndex = left;
			if (right < inputArray.length
					&& inputArray[left] < inputArray[right]) {
				largerIndex = right;
			}

			if (inputArray[i] < inputArray[largerIndex]) {
				CommonUtil.swap(inputArray, i, largerIndex);
			}
		}

	}
}
