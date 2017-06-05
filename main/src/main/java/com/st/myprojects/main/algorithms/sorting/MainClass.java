/**
 * 
 */
package com.st.myprojects.main.algorithms.sorting;



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
		 //Integer[] array = { 7, 6, 9, 4 , 11, 22, 1, 2, 3};
		Integer[] array = { 0, 1, 2, 4, 6, 5, 3 };

		// System.out.println(Arrays.toString(array));
		System.out.println(new QuickSort().findMedian(array));

	}
}
