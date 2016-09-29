/**
 * 
 */
package com.st.myprojects.main.algorithms;

import com.st.myprojects.main.util.Constants;
import com.st.myprojects.main.util.PrintUtil;

/**
 * @author sundeeptonse
 *
 */
public class ArrayStructuresBase {

	/**
	 * Create an array with size 50
	 */
	private int initialArraySize = 10;
	private int maxArraySize = 50;
	int displayNo = 5;

	protected int[] theArray = new int[maxArraySize];
	protected int arraySize = initialArraySize;

	public ArrayStructuresBase() {
		generateRandomArray();
	}

	/**
	 * @return the theArray
	 */
	public int[] getTheArray() {
		return theArray;
	}

	/**
	 * @param theArray
	 *            the theArray to set
	 */
	public void setTheArray(int[] theArray) {
		this.theArray = theArray;
	}

	private void generateRandomArray() {
		for (int i = 0; i < arraySize; i++) {
			theArray[i] = (int) (Math.random() * 10 + 10);
		}
	}

	public void printValueAtIndex(int arrayIndex) {
		System.out.println("Value at Index:" + arrayIndex + ":"
				+ getValueAtIndex(arrayIndex));
	}

	public int getValueAtIndex(int arrayIndex) {
		return arrayIndex < arraySize ? theArray[arrayIndex]
				: Constants.INT_NEG1;
	}

	public void printHorzArray(int a, int b) {

		/*
		 * PrintUtil.repeatPrintLn("-", displayNo * arraySize);
		 * System.out.println("Array Size:" + arraySize);
		 */
		PrintUtil.repeatPrintLn("-", displayNo * arraySize);

		StringBuilder strFLine = new StringBuilder();
		StringBuilder strSLine = new StringBuilder();
		for (int i = 0; i < arraySize; i++) {
			strFLine.append(Constants.STR_SPACE).append(theArray[i])
					.append(Constants.STR_SPACE).append("|");
			strSLine.append(Constants.STR_SPACE).append(Constants.STR_SPACE)
					.append(i).append(Constants.STR_SPACE).append("|");
		}
		System.out.println(strFLine.toString());
		System.out.println(strSLine.toString());

		PrintUtil.repeatPrintLn("-", displayNo * arraySize);

		// ADDED FOR BUBBLE SORT

		if (a != -1) {
			// ADD THE +2 TO FIX SPACING
			for (int k = 0; k < ((a * displayNo) + 2); k++)
				System.out.print(" ");
			System.out.print(a);
		}

		// THEN ADD THIS CODE
		if (b != -1) {
			// ADD THE -1 TO FIX SPACING
			for (int l = 0; l < (displayNo * (b - a) - 1); l++)
				System.out.print(" ");
			System.out.print(b);
		}
		System.out.println();

	}

	public void deleteIndex(int index) {
		if (index < arraySize) {
			for (int i = index; i < arraySize; i++) {
				theArray[i] = theArray[i + 1];
			}
			arraySize--;
		}
	}

	public void insertValue(int value) {
		if (arraySize < maxArraySize) {
			theArray[arraySize++] = value;
		}
	}

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

}
