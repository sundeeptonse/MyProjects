/**
 * 
 */
package com.st.myprojects.main.problems;

import java.util.concurrent.ThreadLocalRandom;

import com.st.myprojects.main.util.CommonUtil;

/*-
 * @author sundeeptonse
 *
 *	Given a sorted Rotated array, get the index of a number inside it
 *
 *
 * Example:
 * 20 21 22 33 45 66 0 1 2 3 4 5 6 7 8 9 10 11
 * 
 * 33, 
 * Index : 4
 * 
 * 3
 * Index : 9
 * 
 */
public class SearchInRotatedArray {

	public static void main(String... args) {
		Integer[] array = { 20, 21, 22, 33, 45, 66, 0, 1, 2, 3, 4, 5, 6, 7, 8,
				9, 10, 11 };
		int indexValue = ThreadLocalRandom.current().nextInt(0, array.length);
		assert search(array, array[indexValue]) == indexValue;

		indexValue = ThreadLocalRandom.current().nextInt(0, array.length);
		assert search(array, array[indexValue]) == indexValue;

		indexValue = ThreadLocalRandom.current().nextInt(0, array.length);
		assert search(array, array[indexValue]) == indexValue;

		indexValue = ThreadLocalRandom.current().nextInt(0, array.length);
		assert search(array, array[indexValue]) == indexValue;

		indexValue = ThreadLocalRandom.current().nextInt(0, array.length);
		assert search(array, array[indexValue]) == indexValue;

		indexValue = ThreadLocalRandom.current().nextInt(0, array.length);
		assert search(array, array[indexValue]) == indexValue;

		indexValue = ThreadLocalRandom.current().nextInt(0, array.length);
		assert search(array, array[indexValue]) == indexValue;

		indexValue = ThreadLocalRandom.current().nextInt(0, array.length);
		assert search(array, array[indexValue]) == indexValue;

		indexValue = ThreadLocalRandom.current().nextInt(0, array.length);
		assert search(array, array[indexValue]) == indexValue;

		indexValue = ThreadLocalRandom.current().nextInt(0, array.length);
		assert search(array, array[indexValue]) == indexValue;

		indexValue = ThreadLocalRandom.current().nextInt(0, array.length);
		assert search(array, array[indexValue]) == indexValue;

		indexValue = ThreadLocalRandom.current().nextInt(0, array.length);
		assert search(array, array[indexValue]) == indexValue;

		indexValue = ThreadLocalRandom.current().nextInt(0, array.length);
		assert search(array, array[indexValue]) == indexValue;

		System.out.println("Pass");

		Integer[] array2 = { 2, 2, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 113,
				2 };
		indexValue = ThreadLocalRandom.current().nextInt(0, array.length);
		assert search(array2, array2[indexValue]) == indexValue;

		indexValue = 4;
		assert search(array2, array2[indexValue]) == indexValue;

		indexValue = 5;
		assert search(array2, array2[indexValue]) == indexValue;
		indexValue = 6;
		assert search(array2, array2[indexValue]) == indexValue;

		System.out.println("Pass");

	}

	public static <T> int search(T[] array, T value) {
		int searchIndex = search(array, value, 0, array.length - 1);
		return searchIndex;
	}

	/*
	 * Gets the Index of a Value in a Rotated Array of Type T
	 */
	public static <T> int search(T[] array, T value, int left, int right) {

		int mid = (left + right) / 2;
		int compareValueToMid = CommonUtil.compare(value, array[mid]);
		// System.out.println("left:" + left + ":right:" + right + ":mid:" +
		// mid);
		if (compareValueToMid == 0) {
			return mid;
		}
		if (left > right) {
			return -1;
		}

		int leftMidCompare = CommonUtil.compare(array[left], array[mid]);
		// Check If Left Side is Sorted
		// If Left Side is Sorted, then array[left] < array[mid]
		if (leftMidCompare < 0) {
			// If Left is Sorted and the value is lesser than mid Value, then go
			// left
			if (CommonUtil.compare(value, array[left]) >= 0
					&& compareValueToMid < 0) {
				return search(array, value, left, mid - 1);
			} else {
				return search(array, value, mid + 1, right);
			}
		}
		// Check If Right Side is Sorted
		// If Right Side is Sorted, then array[right] > array[Mid]
		else if (leftMidCompare > 0) {
			if (CommonUtil.compare(value, array[right]) <= 0
					&& compareValueToMid > 0) {
				// If Right is Sorted and the value is greater than mid Value,
				// then
				// go right
				return search(array, value, mid + 1, right);

			} else {
				// If Right is Sorted and the value is lesser than mid Value,
				// then go left
				return search(array, value, left, mid - 1);

			}
		} else {
			// If both sides are sorted --> In case we have duplicates like
			// 3 3 3 3 0 1 2 4
			// Check the Right Side First
			if (CommonUtil.compare(array[mid], array[right]) != 0) {
				// If Right Side is Different, then since all Left Side #'s are
				// same, the number has to reside in the right Side
				return search(array, value, mid + 1, right);
			} else {
				// 3 3 3 3 0 1 2 3
				// If both values are the same, we have to search both ways
				int leftSearchResult = search(array, value, left, mid - 1);
				if (leftSearchResult != -1) {
					return leftSearchResult;
				} else {
					return search(array, value, mid + 1, right);
				}
			}
		}
	}
}
