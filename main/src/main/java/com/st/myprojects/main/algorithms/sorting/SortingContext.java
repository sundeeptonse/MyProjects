/**
 * 
 */
package com.st.myprojects.main.algorithms.sorting;

import java.util.Comparator;

/**
 * @author sundeeptonse
 *
 */
public class SortingContext {

	private AbstractSort sortingStrategy;

	/**
	 * @param sortingStrategy
	 *            the sortingStrategy to set
	 */
	public void setSortingStrategy(AbstractSort sortingStrategy) {
		this.sortingStrategy = sortingStrategy;
	}

	public <T> void sort(T[] inputList) {
		this.sortingStrategy.sort(inputList);
	}

	public <T> void sort(T[] inputList, Comparator<? super T> c) {
		this.sortingStrategy.sort(inputList, c);
	}

}
