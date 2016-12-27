/**
 * 
 */
package com.st.myprojects.main.algorithms.sorting;

import java.util.Comparator;

import com.st.myprojects.main.util.CommonUtil;

/*-
 * @author sundeeptonse
 * 
 * Sorting is arranging the elements in increasing or decreasing order
 * θ, Ω
 * Sorting Algorithms:
 * ✔ QuickSort ✔ 
 * ✔ MergeSort ✔
 * ✔ TimSort(Used in Java a version of MergeSort) ✔
 * ✔ Radix Sort ✔
 * 
 * HeapSort
 * Bubble Sort
 * ✔ Insertion Sort
 * ✔ Selection Sort
 * Tree Sort
 * Shell Sort
 * Bucket Sort
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

}
