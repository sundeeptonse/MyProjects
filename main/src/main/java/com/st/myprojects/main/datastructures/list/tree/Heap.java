/**
 * 
 */
package com.st.myprojects.main.datastructures.list.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*-
 * @author sundeeptonse
 * 
 * Heap is a type of Tree, where the Elements are ordered in levels based on their Number
 * Min Heap --> Top Level Elements are the lowest 
 * Max Heap --> Top Level Elements are the highest 
 * Java implementation : Priority Queue
 * 
 * Inserting an Element
 * Insert at the End and then compare with parent if lesser swap
 * 
 * Deleting the Min Element
 * Replace the Element with the last element and then compare with child and swap with the smaller of the two
 * 
 * Using an Array:
 * index
 * Parent = RoundUp [ (index-2)/2 ]
 * Left = index*2 + 1
 * Left = index*2 + 2
 * 
 *        0
 *    1      2
 *  3 4     5 6   
 *  
 *  TBD - Comparator vs Comparable Need to be added in
 * 
 */
public class Heap<E> {

	List<E> heap;
	private final Comparator<? super E> comparator;

	public static void main(String... args) {
		Heap<Integer> heap = new Heap<>();
		heap.add(10);
		heap.add(15);
		heap.add(22);
		heap.add(5);
		heap.add(182);
		heap.add(3);
		heap.add(1);
		heap.add(0);
		heap.add(189);
		heap.add(15);
		heap.add(4);
		System.out.println(heap.heap);

	}

	public Heap() {
		this(0, null);
	}

	public Heap(int initialCapacity) {
		this(initialCapacity, null);
	}

	public Heap(int initialCapacity, Comparator<? super E> comparator) {
		this.heap = new ArrayList<E>(initialCapacity);
		this.comparator = comparator;
	}

	public E peek() {
		return heap.get(0);
	}

	public E poll() {

		int lastElementIndex = getLastElementIndex();
		// Get the Top Element
		E topElement = heap.get(0);

		// Set the Top Element with the Element at the Last Index
		// Remove the Last Element
		heap.set(0, heap.remove(lastElementIndex));

		// heapifyDown
		heapifyDown();

		// Return the Top Element
		return topElement;
	}

	public void add(E element) {
		// Add the Element to the end
		heap.add(element);
		// heapifyUp
		heapifyUp();

	}

	// If Parent Value is greater than last Index Value, then swap
	@SuppressWarnings("unchecked")
	private void heapifyUp() {
		int currentIndex = getLastElementIndex();
		Comparable<? super E> currentIndexKey = (Comparable<? super E>) heap
				.get(currentIndex);

		while (hasParent(currentIndex)
				&& currentIndexKey.compareTo(getParent(currentIndex)) < 0) {
			int parentIndex = getParentIndex(currentIndex);
			// If Current index < Parent, then Swap
			swap(currentIndex, parentIndex);

			currentIndex = parentIndex;
			currentIndexKey = (Comparable<? super E>) heap.get(currentIndex);
		}
	}
	
	/*
	 * Comparator vs Comparable Need to be added in
	 * */

	@SuppressWarnings("unchecked")
	private void heapifyDown() {
		int currentIndex = 0;

		while (hasLeftChild(currentIndex)) {
			int smallerChildIndex = getLeftChildIndex(currentIndex);
			Comparable<? super E> smallerChildIndexKey = (Comparable<? super E>) heap
					.get(smallerChildIndex);

			// If Right is Smaller, then store the value in the
			// smallerChildIndex
			if (hasRightChild(currentIndex)
					&& smallerChildIndexKey
							.compareTo(getRightChild(currentIndex)) < 0) {
				smallerChildIndex = getRightChildIndex(currentIndex);
				smallerChildIndexKey = (Comparable<? super E>) heap
						.get(smallerChildIndex);
			}

			// If Current Index is bigger than the child, then swap, else break
			if (smallerChildIndexKey.compareTo(heap.get(currentIndex)) < 0) {
				swap(smallerChildIndex, currentIndex);
				currentIndex = smallerChildIndex;
			} else {
				break;
			}
		}

	}

	private int getLastElementIndex() {
		return heap.size() - 1;
	}

	private int getLeftChildIndex(int index) {
		return (2 * index + 1);
	}

	private int getRightChildIndex(int index) {
		return (2 * index + 2);
	}

	private int getParentIndex(int index) {
		return (int) Math.round(((double) (index - 2)) / 2);
	}

	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < heap.size();
	}

	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < heap.size();
	}

	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	private E getLeftChild(int index) {
		return heap.get(getLeftChildIndex(index));
	}

	private E getRightChild(int index) {
		return heap.get(getRightChildIndex(index));
	}

	private E getParent(int index) {
		return heap.get(getParentIndex(index));
	}

	private void swap(int index1, int index2) {
		E temp = heap.get(index1);
		heap.set(index1, heap.get(index2));
		heap.set(index2, temp);
	}

}
