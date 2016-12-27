/**
 * 
 */
package com.st.myprojects.main.algorithms.sorting;

import java.util.Comparator;

import com.st.myprojects.main.util.CommonUtil;

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
			int minimumIndex = CommonUtil.findMinimumIndex(list, i,
					list.length, comparator);
			CommonUtil.swap(list, i, minimumIndex);
		}
	}

}
