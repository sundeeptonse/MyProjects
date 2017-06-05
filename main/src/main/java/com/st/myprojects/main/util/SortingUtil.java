/**
 * 
 */
package com.st.myprojects.main.util;

import java.util.Comparator;

/**
 * @author sundeeptonse
 *
 */
public class SortingUtil {

	/*
	 * Uses a Random Pivot Index, which makes the average case θ(n) for the
	 * quickSort
	 * 
	 * 
	 * Time Complexity : θ(n)
	 */
	public static <T> int randompartition(T[] list, int startIndex,
			int endIndex, Comparator<? super T> comparator) {

		int pivotIndex = (int) ((Math.random() * (endIndex - startIndex)) + startIndex);
		// Swap randomPivotIndex with the endIndex
		CommonUtil.swap(list, pivotIndex, endIndex);
		return partition(list, startIndex, endIndex, comparator);
	}

	/*
	 * Re-arranges the array, so that the list has smaller elements on the left
	 * side of the pivot and larger elements on the right side
	 * 
	 * Returns the Pivot Index
	 * 
	 * Time Complexity : θ(n)
	 */
	public static <T> int partition(T[] list, int startIndex, int endIndex,
			Comparator<? super T> comparator) {

		// Store the Pivot as the Last Value
		T pivot = list[endIndex];

		int pivotIndex = startIndex;
		// End at EndIndex - 1, as that stores the pivot
		for (int i = startIndex; i < endIndex; i++) {
			// If Current Value is lesser than the pivot
			// Then swap and Increment the Pivot Index Value to the next Value
			if (CommonUtil.compare(list[i], pivot, comparator) < 0) {
				CommonUtil.swap(list, i, pivotIndex);
				pivotIndex++;
			}
		}

		// Finally Swap the value of the pivot with the pivotIndex
		CommonUtil.swap(list, pivotIndex, endIndex);
		return pivotIndex;
	}

}
