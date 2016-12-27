/**
 * 
 */
package com.st.myprojects.main.algorithms.sorting;

import java.util.Comparator;

import com.st.myprojects.main.util.CommonUtil;

/*-
 * @author sundeeptonse
 * 
 * Split a List into 2 parts left and right all the way till the left and right is 1.
 * Merge them in recursion by using the Merge Logic
 * 
 * Analysis:
 * Divide and Conquer
 * Recursive Algo
 * Stable since the value will be retained as original
 * Not In Place
 * 
 * Time Complexity(Best, Average, Worst):
 * θ(n log(n)), θ(n log(n) ) ,θ(n log(n)) 
 * 
 * Space Complexity:
 * θ(n) 
 * 
 * Number of Steps to reach the bottom : log n --> Similar to a Tree
 * 
 */
public class MergeSort extends AbstractSort {

	/*-
	 * 
	 * Efficiency for each Iteration:
	 * 	 T(N) = θ(N) +2*T(N/2)
	 * 
	 * 	T(N/2) = (θ(N/2) + T(N/4))
	 *  ..
	 *  ..
	 *  
	 *  T(N) = θ(N) + θ(N) + 2T(N/4) = 2θ(N)  + 2T(N/4)
	 *  T(N) = 3θ(N) + 4T(N/8)
	 *  T(N) = 4θ(N) + 8T(N/16)
	 *  
	 *  If N = 16 --> 4*θ(16)
	 *  If N = 32 --> 8*θ(32)
	 *  
	 *  T(N) = θ(N)*logN
	 *  
	 *  Similar to Binary Tree
	 *  
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <T> void sort(T[] list, Comparator<? super T> comparator) {
		int length = list.length;
		if (length < 2) {
			return;
		}
		int mid = length / 2;

		T[] left = (T[]) new Object[mid];
		T[] right = (T[]) new Object[length - mid];

		/*
		 * Time Complexity : θ(N)
		 */
		for (int i = 0; i < mid; i++) {
			left[i] = list[i];
		}
		for (int i = mid; i < length; i++) {
			right[i - mid] = list[i];
		}

		/*
		 * Time Complexity : T(n/2) + T(n/2) = 2T(n/2)
		 */
		sort(left, comparator);
		sort(right, comparator);

		/*
		 * Time Complexity : θ(N)
		 */
		merge(list, left, right, comparator);

	}

	/*-
	 * Merge Logic List Array --> Main, Left Array --> Left, Right Array -->
	 * Right
	 * If the first Element in Main is picked. Take first Element which
	 * from left/right and if smaller move to Picked Section
	 * 
	 * 5 4 8 7
	 * 
	 * 4 5 |  7 8
	 * Move 4 to the First Element
	 * 4 4 8 7
	 * 
	 * 5 | 7 8
	 * Move 5 to the Second Element
	 * 4 5 8 7
	 * 4 5 7 7
	 * 4 5 7 8
	 * 
	 * Time Complexity : θ(N)
	 * 
	 */

	private <T> void merge(T[] list, T[] left, T[] right,
			Comparator<? super T> comparator) {
		int i, j, k;
		i = j = k = 0;

		while (i < left.length && j < right.length) {
			if (CommonUtil.compare(left[i], right[j], comparator) < 0) {
				list[k++] = left[i++];
			} else {
				list[k++] = right[j++];
			}
		}

		// For the Left over Elements in either left or right
		while (i < left.length) {
			list[k++] = left[i++];
		}

		while (j < right.length) {
			list[k++] = right[j++];
		}
	}

	/*-
	 * Merges right list into left as long as there is enough buffer space
	 * 
	 * Solution: Since there is sufficient space at the end, start with the end
	 * and go from there
	 * 
	 * Since the left Array is already sorted, only using the index of B will suffice
	 * and the left over values are already sorted
	 * 
	 * Time Complexity : O(n)
	 * Space Complexity : O(1)
	 */

	public <T> void merge(T[] left, T[] right) {
		merge(left, right, null);
	}

	private <T> void merge(T[] left, T[] right, Comparator<? super T> comparator) {

		int lastIndexRight = right.length - 1;
		int lastIndexLeft = left.length - right.length - 1;
		int indexTobeInserted = left.length - 1;

		// While lastIndexRight >= 0
		while (lastIndexRight >= 0) {

			// Compare the lastValue , if value of either is greater then, move
			// to
			// the indexTobeInserted

			// Deduct the value of indexTobeInserted
			// Deduct the value of the Index which was moved

			if (lastIndexLeft >= 0
					&& CommonUtil.compare(left[lastIndexLeft], right[lastIndexRight], null) > 0) {
				left[indexTobeInserted--] = left[lastIndexLeft--];
			} else {
				left[indexTobeInserted--] = right[lastIndexRight--];
			}

			// Repeat till the lastIndex of Right Reaches zero after which the
			// array is sorted

		}

	}
}
