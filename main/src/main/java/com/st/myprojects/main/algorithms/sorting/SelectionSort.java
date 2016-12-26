/**
 * 
 */
package com.st.myprojects.main.algorithms.sorting;

import java.util.Comparator;

/*-
 * @author sundeeptonse
 *
 * Time Complexity(Best, Average, Worst):
 * θ(n^2), θ(n^2), θ(n^2)
 * 
 * Space Complexity:
 * θ(1) 
 * 
 * Algorithm:
 * 
 * Iteratively
 * Find Min and place at the "i" of the array
 *
 */
public class SelectionSort extends AbstractSort {

	@Override
	public <T> void sort(T[] list, Comparator<? super T> comparator) {
		// Perform till length -1, since the last index will already be the
		// biggest
		for (int i = 0; i < list.length; i++) {
			int minimumIndex = findMinimumIndex(list, i, list.length,
					comparator);
			swap(list, i, minimumIndex);
		}
	}

}
