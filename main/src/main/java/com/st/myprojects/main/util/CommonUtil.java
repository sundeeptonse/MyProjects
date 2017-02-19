/**
 * 
 */
package com.st.myprojects.main.util;

import java.util.Comparator;

/**
 * @author sundeeptonse
 *
 */
public class CommonUtil {

	public static <T> int findMinimumIndex(T[] list, int startIndex,
			int endIndex, Comparator<? super T> comparator) {
		int minimum = startIndex;
		for (int i = startIndex + 1; i < endIndex; i++) {
			if (CommonUtil.compare(list, minimum, i, comparator) > 0) {
				minimum = i;
			}
		}
		return minimum;
	}

	public static <T> void swap(T[] list, int index1, int index2) {
		T temp = list[index1];
		list[index1] = list[index2];
		list[index2] = temp;
	}

	public static void swapCh(char[] list, int index1, int index2) {
		char temp = list[index1];
		list[index1] = list[index2];
		list[index2] = temp;
	}

	public static <T> int compare(T value1, T value2) {
		return compare(value1, value2, null);
	}

	public static <T> int compare(T[] list, int index1, int index2) {
		return compare(list, index1, index2, null);
	}

	/*
	 * Need to add Null Checks and Check if Type is Comparable
	 */
	@SuppressWarnings("unchecked")
	public static <T> int compare(T value1, T value2,
			Comparator<? super T> comparator, boolean reverse) {
		int compare = 0;
		if (comparator == null) {
			compare = ((Comparable<T>) value1).compareTo(value2);
		} else {
			compare = comparator.compare(value1, value2);
		}
		return reverse ? -compare : compare;
	}

	@SuppressWarnings("unchecked")
	public static <T> int compare(T value1, T value2,
			Comparator<? super T> comparator) {
		return compare(value1, value2, comparator, false);
	}

	@SuppressWarnings("unchecked")
	public static <T> int compare(T[] list, int index1, int index2,
			Comparator<? super T> comparator) {
		return comparator == null ? ((Comparable<T>) list[index1])
				.compareTo(list[index2]) : comparator.compare(list[index1],
				list[index2]);
	}

}