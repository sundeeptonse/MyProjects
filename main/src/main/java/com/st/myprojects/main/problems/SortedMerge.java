/**
 * 
 */
package com.st.myprojects.main.problems;

import java.util.Arrays;

import com.st.myprojects.main.algorithms.sorting.MergeSort;

/*-
 * @author sundeeptonse
 * 
 * You are given two sorted arrays, A & B,where A has a large enough buffer to store b.
 * rite a method to merge B into A in a sorted order 
 *
 */
public class SortedMerge {

	public static void main(String arg1, String arg2, String... args) {
		boolean odd = true;
		int numberOfElements = 5;

		Integer[] arrayA = Generator.generateIntegerArray(numberOfElements,
				true);
		Integer[] arrayB = Generator.generateIntegerArray(numberOfElements,
				false);

		MergeSort ms = new MergeSort();
		System.out.println(Arrays.toString(arrayA));
		System.out.println(Arrays.toString(arrayB));
		ms.merge(arrayA, arrayB);
		System.out.println(Arrays.toString(arrayA));

	}

}

class Generator {

	/*
	 * If Odd, it will generate an array of size 2 times for buffer and add only
	 * odd values
	 */
	public static Integer[] generateIntegerArray(int numberofElements,
			boolean odd) {
		Integer[] integerArray;
		if (odd) {
			integerArray = new Integer[numberofElements * 2];
		} else {
			integerArray = new Integer[numberofElements];
		}
		for (int i = 0; i < numberofElements; i++) {
			if (odd) {
				integerArray[i] = i * 2 + 1;
			} else {
				integerArray[i] = i * 2;
			}
		}
		return integerArray;
	}

}
