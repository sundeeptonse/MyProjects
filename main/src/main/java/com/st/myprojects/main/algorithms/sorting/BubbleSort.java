/**
 * 
 */
package com.st.myprojects.main.algorithms.sorting;

import java.util.Comparator;

/*-
 * @author sundeeptonse
 * Scan over the array and compare adjacent elements.
 * If greater, then swap
 * 
 * At the end of the 1st Iteration, the last Index will have the greatest value, that can be skipped in the next Iteration.
 * If at the end of any pass
 * 
 * Time Complexity(Best, Average, Worst):
 * θ(n), θ(n^2), θ(n^2)
 * 
 * Space Complexity:
 * θ(1) 
 * 
 */
public class BubbleSort extends AbstractSort {

	/*
	 * @see
	 * com.st.myprojects.main.algorithms.sorting.AbstractSort#sort(java.lang
	 * .Object[], java.util.Comparator)
	 */
	@Override
	public <T> void sort(T[] list, Comparator<? super T> comparator) {
		for (int i = list.length - 1; i >= 0; i--) {
			boolean sorted = true;
			for (int j = 0; j < i; j++) {
				if (compare(list, j, j + 1, comparator) > 0) {
					swap(list, j, j + 1);
					sorted = false;
				}
			}
			// If sorted after any Iteration, break
			if (sorted) {
				break;
			}
		}
	}
}
