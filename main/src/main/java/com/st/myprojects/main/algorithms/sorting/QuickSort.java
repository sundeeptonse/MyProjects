/**
 * 
 */
package com.st.myprojects.main.algorithms.sorting;

import java.util.Arrays;
import java.util.Comparator;

import com.st.myprojects.main.util.SortingUtil;

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
			int pivotIndex = SortingUtil.randompartition(list, startIndex,
					endIndex, comparator);
			// Do a Quick Sort on the Left Side
			quicksort(list, startIndex, pivotIndex - 1, comparator);
			// Do a Quick Sort on the Right Side
			quicksort(list, pivotIndex + 1, endIndex, comparator);
		}
	}

	/*
	 * Find Medians for Odd Sized Arrays
	 */

	public <T> T findMedian(T[] list) {
		return findMedian(list, 0, list.length - 1);
	}

	private <T> T findMedian(T[] list, int startIndex, int endIndex) {
		T median = null;
		if (startIndex <= endIndex) {
			System.err.println("B4" + Arrays.toString(list));
			int pivotIndex = SortingUtil.randompartition(list, startIndex,
					endIndex, null);
			System.err.println("After" + Arrays.toString(list));
			System.err.println("StartIndex:" + startIndex + ":EndIndex:"
					+ endIndex + ":PivotIndex:" + pivotIndex + "-"
					+ list[pivotIndex]);
			if (pivotIndex == list.length / 2) {
				median = list[pivotIndex];
			} else {
				if (pivotIndex > (list.length / 2)) {
					median = findMedian(list, startIndex, pivotIndex - 1);
				} else {
					median = findMedian(list, pivotIndex + 1, endIndex);
				}
			}
		}
		return median;
	}

}
