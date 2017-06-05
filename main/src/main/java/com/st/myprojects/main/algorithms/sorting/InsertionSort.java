/**
 * 
 */
package com.st.myprojects.main.algorithms.sorting;

import java.util.Comparator;

import com.st.myprojects.main.util.CommonUtil;

/*-
 * @author sundeeptonse
 * 
 * Insertion sort basically splits the array into two bits, a sorted bit and an unsorted bit.
 * The Elements are the Unsorted Area is picked and moved to the sorted Area
 * The Elements in the sorted area are shifted to make place for the New Element
 * 
 * Time Complexity(Best, Average, Worst):
 * θ(n), θ(n^2), θ(n^2)
 * 
 * Space Complexity
 * θ(1) 
 * 
 */
public class InsertionSort extends AbstractSort {

	/*
	 * @see
	 * com.st.myprojects.main.algorithms.sorting.AbstractSort#sort(java.lang
	 * .Object[], java.util.Comparator)
	 */
	@Override
	public <T> void sort(T[] list, Comparator<? super T> comparator) {
		// Start with 1, since 0 will be the sorted at the Starting
		for (int i = 1; i < list.length; i++) {
			T value = list[i];
			int hole = i;
			// If value[hole-1] > value, then move it over and decrement the
			// value of the Hole
			while (hole > 0 && CommonUtil.compare(list[hole - 1], value, comparator) > 0) {
				list[hole] = list[hole - 1];
				hole--;
			}
			// At the end of it store the value in the hole or last hole
			list[hole] = value;
		}
	}
}
