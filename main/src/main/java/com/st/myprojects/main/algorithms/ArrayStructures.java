/**
 * 
 */
package com.st.myprojects.main.algorithms;

/**
 * @author sundeeptonse
 *
 */
public class ArrayStructures extends ArrayStructuresBase {

	/*
	 * Search Algorithm's
	 */
	public void linearSearchForValue(int value) {
		boolean valueInArray = false;

		StringBuilder indexsWithString = new StringBuilder("Indexes:");
		for (int i = 0; i < arraySize; i++) {
			if (value == theArray[i]) {
				indexsWithString.append(i).append(",");
				valueInArray = true;
			}
			printHorzArray(i, -1);
		}

		if (!valueInArray) {
			indexsWithString.append("None");
		}
		System.out.print(indexsWithString.toString());
	}

	public void binarySearch(int value) {

		int lowIndex = 0;
		int highIndex = arraySize - 1;

		while (lowIndex <= highIndex) {
			int middleIndex = (lowIndex + highIndex) / 2;
			printHorzArray(middleIndex, -1);
			if (value < theArray[middleIndex])
				lowIndex = ++middleIndex;
			else if (value > theArray[middleIndex])
				highIndex = --middleIndex;
			else {
				System.out.println("Value:" + value + ":Found at: "
						+ middleIndex);
				break;
			}

		}

	}

	/*-
	 * Sort Algorithms 
	 * Bubble Sort
	 * 
	 */
	public void bubbleSort(boolean ascending) {

		for (int i = arraySize - 1; i > 1; i--) {
			for (int j = 0; j < i; j++) {
				printHorzArray(j, i);
				swapAscDesc(j, j + 1, ascending);
				printHorzArray(j, i);
			}
		}
	}

	/*-
	 * Selection Sort 
	 * Similar to Bubble Sort, without the Inner Loop Decreasing in Size 
	 * Swap Happens only 1 Time as opposed to in every iteration in Bubble Sort
	 */
	public void selectionSort(boolean ascending) {

		for (int i = 0; i < arraySize; i++) {
			int minimum = i;
			for (int j = i; j < arraySize; j++) {
				if (theArray[minimum] > theArray[j]) {
					minimum = j;
				}
			}
			printHorzArray(i, -1);
			swap(i, minimum);
			printHorzArray(i, -1);
		}
	}

	public void swapAscDesc(int index1, int index2, boolean ascending) {
		boolean swap = false;
		if (ascending) {
			if (theArray[index1] > theArray[index2]) {
				swap = true;
			}
		} else {
			if (theArray[index1] < theArray[index2]) {
				swap = true;
			}
		}
		if (swap) {
			swap(index1, index2);
		}
	}

	public void swap(int index1, int index2) {
		int temp = theArray[index1];
		theArray[index1] = theArray[index2];
		theArray[index2] = temp;
	}
}
