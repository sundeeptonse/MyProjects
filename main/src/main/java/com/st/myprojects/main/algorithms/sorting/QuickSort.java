/**
 * 
 */
package com.st.myprojects.main.algorithms.sorting;

import java.util.Arrays;
import java.util.Comparator;

/*-
 * @author sundeeptonse
 * 
 * Find a Pivot(First or Last Part of the Array)
 * Move around the Array, so that left part is smaller and right part is bigger than the pivot
 * Run the Logic Again with the left Part and the right Part  - recursively till you reach size = 2,
 * If size ==2, then after moving around, the array is sorted
 * 
 * Property
 * Divide and Conquer
 * Recursive
 * Not Stable
 * 
 * Time Complexity(Best, Average, Worst):
 * θ(nlogn), θ(nlogn) θ(n^2)
 * 
 * Space Complexity:
 * θ(logn) 
 * 
 * 
 * 
 */
public class QuickSort extends AbstractSort {

	@Override
	public <T> void sort(T[] list, Comparator<? super T> comparator) {
		quicksort(list, 0, list.length - 1, comparator);
	}

	/*-
	 * 
	 * Partitions the Block and gets the Pivot Index
	 * Does a Qcsort on the Left Side (pIndex -1)
	 * 
	 * Does a Qcsort on the Right Side (pIndex +1)
	 * 
	 * If Balanced, then 
	 * θ(nlogn)
	 * 
	 * If not,
	 * θ(n^2)
	 * 
	 * */
	private <T> void quicksort(T[] list, int startIndex, int endIndex,
			Comparator<? super T> comparator) {
		if (startIndex < endIndex) {
			// int pivotIndex = parition(list, startIndex, endIndex,
			// comparator);
			int pivotIndex = randomparition(list, startIndex, endIndex,
					comparator);
			// Do a Quick Sort on the Left Side
			quicksort(list, startIndex, pivotIndex - 1, comparator);
			// Do a Quick Sort on the Right Side
			quicksort(list, pivotIndex + 1, endIndex, comparator);
		}
	}

	/*
	 * Re-arranges the array, so that the list has smaller elements on the left
	 * side of the pivot and larger elements on the right side
	 * 
	 * Returns the Pivot Index
	 * 
	 * Time Complexity : θ(n)
	 */
	private <T> int parition(T[] list, int startIndex, int endIndex,
			Comparator<? super T> comparator) {

		// Store the Pivot as the Last Value
		T pivot = list[endIndex];
		int pivotIndex = startIndex;
		// End at EndIndex - 1, as that stores the pivot
		for (int i = startIndex; i < endIndex; i++) {
			// If Current Value is lesser than the pivot
			// Then swap and Increment the Pivot Index Value to the next Value
			if (compare(list[i], pivot, comparator) < 0) {
				swap(list, i, pivotIndex);
				pivotIndex++;
			}
		}

		// Finally Swap the value of the pivot with the pivotIndex
		swap(list, pivotIndex, endIndex);
		return pivotIndex;
	}

	/*
	 * Uses a Random Pivot Index, which makes the average case θ(n) for the
	 * quickSort 
	 * 
	 * 
	 * Time Complexity : θ(n)
	 */
	private <T> int randomparition(T[] list, int startIndex, int endIndex,
			Comparator<? super T> comparator) {

		int pivotIndex = (int) ((Math.random() * endIndex) + startIndex);
		// Swap randomPivotIndex with the endIndex
		swap(list, pivotIndex, endIndex);
		return parition(list, startIndex, endIndex, comparator);
	}
}
