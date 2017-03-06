/**
 * 
 */
package com.st.myprojects.main.datastructures.custom;

import java.util.Iterator;

/*-
 * @author sundeeptonse 
 * 		   Implement a Circular Array class that supports and array
 *         like DS which can be efficiently rotated. Generic + Should support
 *         Iteration
 * 
 *         For Rotation, we can store one index as the Head and shift either
 *         right or left the head value instead of an entire array rotation
 *         
 *         
 *         1 2 3 4 5 6 7 8 9
 *               ^
 *         Rotate:
 *         1 2 3 4 5 6 7 8 9 
 *                 ^       
 *         
 */
public class CircularArray<T> implements Iterable<T> {

	// Instance Variables
	// Object
	private T[] items;
	// Head Value
	private int head = 0;

	@SuppressWarnings("unchecked")
	public CircularArray(int size) {
		items = (T[]) new Object[size];
	}

	// Function to get the Actual Index in reference to the head
	private int getIndex(int index) {
		if (index < 0) {
			// For example if the index is -99 and the size is 10
			// This will yield -9+10 = 1
			index %= items.length;
			index += items.length;
		}
		// Need to worry about neg
		return (head + index) % items.length;
	}

	private void checkIndex(int index) {
		if (index < 0 || index >= items.length) {
			throw new IndexOutOfBoundsException();
		}
	}

	public void rotate(int shiftBy) {
		head = getIndex(shiftBy);
	}

	public T get(int index) {
		checkIndex(index);
		return items[getIndex(index)];
	}

	public void set(int index, T value) {
		checkIndex(index);
		items[getIndex(index)] = value;
	}

	@Override
	public Iterator<T> iterator() {
		return new CircularArrayIterator<T>(this);
	}

	private class CircularArrayIterator<T1> implements Iterator<T1> {
		private int currentIndex;
		CircularArray<T1> cArray;

		CircularArrayIterator(CircularArray<T1> array) {
			currentIndex = 0;
			this.cArray = array;
		}

		@Override
		public boolean hasNext() {
			return currentIndex < this.cArray.items.length;
		}

		@Override
		public T1 next() {
			return cArray.get(currentIndex++);
		}
	}

}
