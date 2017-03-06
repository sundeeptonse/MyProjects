/**
 * 
 */
package com.st.myprojects.main.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*-
 * @author sundeeptonse
 *
 *         Given three Sorted Arrays, merge them into one array
 *         {1,4,6}, {2,5,8} , {3,6,9}
 */
public class MergeKSortedArrays {

	public static void main(String... args) {
		int[][] arrayOfArray = { { 1, 100, 101 }, { 2, 3, 5, 6 }, { 7, 8 },
				{ 10, 11, 12, 13, 14 } };
		Integer[] mergedArray = mergeKSortedArrays(arrayOfArray);
		System.out.println(Arrays.toString(mergedArray));
	}

	public static Integer[] mergeKSortedArrays(int[][] arrayOfArray) {
		List<Integer> list = new ArrayList<>();
		PriorityQueue<CustomObject> pq = new PriorityQueue<>();
		// Visit all the Nth Column Elements of the Array
		// Add them to a Priority Queue,
		// After Each Visit, get the minimum Element and add to list
		// int pointer[][] = getRowLengthArr(arrayOfArray);

		// Initially add the first k Elements to the PQ

		int row;
		row = 0;
		int[][] pointer = getRowLengthArr(arrayOfArray);

		for (; row < arrayOfArray.length; row++) {
			CustomObject number = new CustomObject(
					arrayOfArray[row][pointer[row][1]++], row);
			pq.add(number);
		}

		while (!pq.isEmpty()) {
			// For rest of the Columns, keep adding till we reach max Length
			// Poll the element, if the Element belongs to Array K, then add to
			// List and Increase the Pointer
			CustomObject nextNumber = pq.poll();
			list.add(nextNumber.value);

			int numberRow = nextNumber.arrayOf;
			// If the Value is lesser than the length, then increment
			if (pointer[numberRow][1] < pointer[numberRow][0]) {
				CustomObject newObject = new CustomObject(
						arrayOfArray[numberRow][pointer[numberRow][1]],
						numberRow);
				// Then Add to PQ
				pq.add(newObject);
				// Increment to next value
				pointer[numberRow][1]++;
			}
			// If Pointer Maxes Out, then it will move the next Array
		}
		Integer[] integerArray = Arrays.copyOf(list.toArray(), list.size(),
				Integer[].class);
		return integerArray;
	}

	static class CustomObject implements Comparable<CustomObject> {
		int value;
		int arrayOf;

		public CustomObject(int value, int arrayOf) {
			this.value = value;
			this.arrayOf = arrayOf;
		}

		@Override
		public int compareTo(CustomObject o) {
			return Integer.compare(value, o.value);
		}

		@Override
		public String toString() {
			return this.value + ":" + this.arrayOf;
		}

	}

	private static int[][] getRowLengthArr(int[][] array) {
		int lengthOfRow[][] = new int[array.length][2];
		int i = 0;
		for (int[] arrayVal : array) {
			// Store the Length in the First Column
			lengthOfRow[i][0] = arrayVal.length;
			// Store the Pointer Count in the Second Column
			lengthOfRow[i++][1] = 0;
		}
		return lengthOfRow;
	}

}
