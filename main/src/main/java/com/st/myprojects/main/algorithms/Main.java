/**
 * 
 */
package com.st.myprojects.main.algorithms;

/**
 * @author sundeeptonse
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String... args) {

		ArrayStructures arrayStructures = new ArrayStructures();

		/*-
		// Insert Delete
		arrayStructures.printHorzArray(-1,-1);
		int index = 4;
		arrayStructures.printValueAtIndex(4);
		arrayStructures.deleteIndex(4);
		arrayStructures.printHorzArray(-1,-1);
		arrayStructures.insertValue(20);

		arrayStructures.printHorzArray(-1,-1);
		 */

		/*-
		// Linear Search
		`arrayStructures.insertValue(20);
		arrayStructures.linearSearchForValue(20);
		 */

		/*
		 * Bubble Sort
		 * */
		
		/*
		arrayStructures.printHorzArray(-1,-1);
		arrayStructures.bubbleSort(true);
		arrayStructures.printHorzArray(-1,-1);
		arrayStructures.bubbleSort(false);
		arrayStructures.printHorzArray(-1,-1);
		*/
		
		/*
		 * Selection Sort
		 * */
		
		arrayStructures.printHorzArray(-1,-1);
		arrayStructures.selectionSort(true);
		arrayStructures.printHorzArray(-1,-1);
		arrayStructures.selectionSort(false);
		arrayStructures.printHorzArray(-1,-1);
		
		
		
		arrayStructures.binarySearch(10);
		

	}

}
