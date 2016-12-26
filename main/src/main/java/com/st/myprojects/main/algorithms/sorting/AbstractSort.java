/**
 * 
 */
package com.st.myprojects.main.algorithms.sorting;

import java.util.Comparator;

/*-
 * @author sundeeptonse
 * 
 * Sorting is arranging the elements in increasing or decreasing order
 * θ, Ω
 * Sorting Algorithms:
 * Algorithm				
 * QuickSort 
 * MergeSort ✔
 * TimSort(Used in Java a version of MergeSort) ✔
 * HeapSort
 * Bubble Sort
 * Insertion Sort
 * Selection Sort
 * Tree Sort
 * Shell Sort
 * Bucket Sort
 * Radix Sort ✔
 * Counting Sort
 * Cubesort
 * 
 * Classification:
 * 	a) Time Complexity
 *  b) Space Complexity
 *  c) Stability
 *  d) Internal(RAM) vs External(Disk)
 *  e) Recursive vs Non-Recursive
 *  
 *  In-place Sorting Algorithm takes constant amount of memory
 * 
 */
public abstract class AbstractSort {

	public abstract <T> void sort(T[] inputList,
			Comparator<? super T> comparator);

	public <T> void sort(T[] list) {
		this.sort(list, null);
	}

	@SuppressWarnings("unchecked")
	<T> int compare(T[] list, int index1, int index2,
			Comparator<? super T> comparator) {
		return comparator == null ? ((Comparable<T>) list[index1])
				.compareTo(list[index2]) : comparator.compare(list[index1],
				list[index2]);
	}

	@SuppressWarnings("unchecked")
	<T> int compare(T value1, T value2, Comparator<? super T> comparator) {
		return comparator == null ? ((Comparable<T>) value1).compareTo(value2)
				: comparator.compare(value1, value2);
	}

	<T> void swap(T[] list, int index1, int index2) {
		T temp = list[index1];
		list[index1] = list[index2];
		list[index2] = temp;
	}

	<T> int findMinimumIndex(T[] list, int startIndex, int endIndex,
			Comparator<? super T> comparator) {
		int minimum = startIndex;
		for (int i = startIndex + 1; i < endIndex; i++) {
			if (compare(list, minimum, i, comparator) > 0) {
				minimum = i;
			}
		}
		return minimum;
	}

}
