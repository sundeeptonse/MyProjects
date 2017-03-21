/**
 * 
 */
package com.st.myprojects.main.algorithms.sorting;

import java.util.Collections;
import java.util.Comparator;

import com.st.myprojects.main.util.SortingUtil;

/*-
 * @author:sundeeptonse
 *
 *                      Given an unsorted Array Finds the Kth Smallest/Largest
 *                      Element in a Array
 * 
 *                      Using this element as pivot, places elements smaller
 *                      than it on the left side and greater than it on the
 *                      right side or vice versa
 * 
 *                      From Wiki:
 * 
 *                      In computer science, quickselect is a selection
 *                      algorithm to find the kth smallest element in an
 *                      unordered list. It is related to the quicksort sorting
 *                      algorithm. Like quicksort, it was developed by Tony
 *                      Hoare, and thus is also known as Hoare's selection
 *                      algorithm.[1] Like quicksort, it is efficient in
 *                      practice and has good average-case performance, but has
 *                      poor worst-case performance. Quickselect and its
 *                      variants are the selection algorithms most often used in
 *                      efficient real-world implementations.
 * 
 *                      Quickselect uses the same overall approach as quicksort,
 *                      choosing one element as a pivot and partitioning the
 *                      data in two based on the pivot, accordingly as less than
 *                      or greater than the pivot. However, instead of recursing
 *                      into both sides, as in quicksort, quickselect only
 *                      recurses into one side – the side with the element it is
 *                      searching for. This reduces the average complexity from
 *                      O(n log n) to O(n), with a worst case of O(n2).
 * 
 *                      As with quicksort, quickselect is generally implemented
 *                      as an in-place algorithm, and beyond selecting the k'th
 *                      element, it also partially sorts the data. See selection
 *                      algorithm for further discussion of the connection with
 *                      sorting.
 * 
 */
public class QuickSelectPartition {

	public static void main(String... args) {
		Integer[] list = { 4, 56, 6, 6, 6, 6, 12, 34, 90, 1, -1, 2 };
		for (int i = 0; i < list.length;) {
			System.out.println(new QuickSelectPartition().quickSelect(list,
					i++, Collections.reverseOrder()));
		}

	}

	public <T> T quickSelect(T[] list, int k) {
		return quickSelect(list, k, null);
	}

	public <T> T quickSelect(T[] list, int k, Comparator<? super T> comparator) {
		return quickSelect(list, 0, list.length - 1, k, comparator);
	}

	/*-
	 * 
	 *  Time Complexity Best Case : 0(n)
	 *  
	 *  // Returns the k-th smallest element of list within left..right inclusive
	 *	// (i.e. left <= k <= right).
	 *	// The search space within the array is changing for each round - but the list
	 *	// is still the same size. Thus, k does not need to be updated with each round.
	 *
	 *	function select(list, left, right, k)
	 * 		if left = right        // If the list contains only one element,
	 *     	return list[left]  // return that element
	 *		pivotIndex  := ...     // select a pivotIndex between left and right,
	 *                        // e.g., left + floor(rand() % (right - left + 1))
	 * 		pivotIndex  := partition(list, left, right, pivotIndex);
	 * 		//The pivot is in its final sorted position
	 * 		if k = pivotIndex
	 *    		return list[k];
	 * 		else if k < pivotIndex
	 *     		return select(list, left, pivotIndex - 1, k);
	 * 		else
	 *     	return select(list, pivotIndex + 1, right, k);
	 * */
	private <T> T quickSelect(T[] list, int startIndex, int endIndex, int k,
			Comparator<? super T> comparator) {
		if (startIndex == endIndex) {
			return list[startIndex];
		}

		/*
		 * n + n/2 + n/4 + n/8 n/(1-1/2) —> 2n —> O(N)
		 * 
		 * a/(1-r)
		 */
		int pivotIndex = SortingUtil.randompartition(list, startIndex,
				endIndex, comparator);
		if (k == pivotIndex) {
			return list[pivotIndex];
		} else if (k < pivotIndex) {
			// Go Left
			return quickSelect(list, startIndex, pivotIndex - 1, k, comparator);
		} else {
			// Go Right
			return quickSelect(list, pivotIndex + 1, endIndex, k, comparator);
		}
	}

}
