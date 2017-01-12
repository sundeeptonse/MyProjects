/**
 * 
 */
package com.st.myprojects.main.problems;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/*-
 *			@author sundeeptonse
 *
 *         Given a sorted Array, find the Missing Element in the Sorted Array.
 *
 */
public class MissingElementSortedArray {
	public static void main(String... args) {

		// try {
		// System.setOut(new PrintStream(new File(
		// "/Users/sundeeptonse/Desktop/output-file.txt")));
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// }

		int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11 };
		System.out.println(MissingElement.missingElement(array));

		int[] array2 = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -3 };
		System.out.println(MissingElement.missingElement(array2));

		int[] array3 = { 0, 100, 200, 400, 500, 600 };
		System.out.println(MissingElement.missingElement(array3));
	}
}

class MissingElement {

	/*-
	 * 0 1 2 4 5 6
	 * Missing Element = 3
	 * 
	 * 2 3 4 5 7 8 9
	 * Missing Element = 6
	 * 
	 * */
	public static int missingElement(int[] sortedArray) {
		int minimumDiff = getDiff(sortedArray);
		if (minimumDiff == 0) {
			return -1;
		}
		System.out.println("Minimum Diff:" + minimumDiff);
		return missingElement(sortedArray, 0, sortedArray.length - 1,
				minimumDiff);
	}

	private static int getDiff(int[] sortedArray) {
		int diff = 0;
		if (sortedArray.length > 1) {
			int leftDiff = sortedArray[1] - sortedArray[0];
			int rightDiff = sortedArray[sortedArray.length - 1]
					- sortedArray[sortedArray.length - 2];

			diff = leftDiff;
			if (leftDiff == 0 || Math.abs(leftDiff) > Math.abs(rightDiff)) {
				diff = rightDiff;
			}
		}

		return diff;
	}

	/*-
	 * 0 1 2 4 5 6
	 * Missing Element = 3
	 * 
	 * 2 3 4 5 7 8 9
	 * Missing Element = 6
	 * 
	 * */
	private static int missingElement(int[] sortedArray, int leftIndex,
			int rightIndex, int diff) {

		if (leftIndex >= rightIndex) {
			return -1;
		}
		// If we reach the last two Elements and the SortedArray Right - Left >
		// Diff, then we have found the missing number, hence add leftIndex +
		// diff
		if (rightIndex - leftIndex == 1) {
			System.out.println("Here LeftIndex:" + leftIndex + ":RightIndex:"
					+ rightIndex);
			if (Math.abs(sortedArray[rightIndex] - sortedArray[leftIndex]) > Math
					.abs(diff)) {
				return sortedArray[leftIndex] + diff;
			}
		}
		int mid = (leftIndex + rightIndex) / 2;
		// Check array[mid] - array[leftIndex] / diff != mid - leftIndex
		if ((sortedArray[mid] - sortedArray[leftIndex]) / diff != (mid - leftIndex)) {
			// Left is not good
			// Go Left
			return missingElement(sortedArray, leftIndex, mid, diff);
		} else if ((sortedArray[rightIndex] - sortedArray[mid]) / diff != (rightIndex - mid)) {
			// Check array[rightIndex] - array[mid] / diff != right - mid
			// Right is not good
			// Go Right
			return missingElement(sortedArray, mid, rightIndex, diff);
		}

		// Else both are good, return -1
		return -1;

	}
}
