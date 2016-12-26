/**
 * 
 */
package com.st.myprojects.main.algorithms.sorting;

import java.util.Arrays;

/**
 * @author sundeeptonse
 *
 */
public class MainClass {

	public static void main(String... args) {

		/*
		 * Selection Sort
		 */
		SortingContext sortContext = new SortingContext();
		sortContext.setSortingStrategy(new QuickSort());
		Integer[] array = { 7, 6, 9, 4 , 11, 22, 1, 2, 3};
		System.out.println(Arrays.toString(array));
		sortContext.sort(array);
		System.out.println(Arrays.toString(array));
		

	}
}
