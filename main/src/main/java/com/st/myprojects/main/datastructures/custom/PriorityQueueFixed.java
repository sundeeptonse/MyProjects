/**
 * 
 */
package com.st.myprojects.main.datastructures.custom;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author sundeeptonse
 *
 */
public class PriorityQueueFixed<E> extends PriorityQueue<E> {

	private static final long serialVersionUID = -7253518936210562797L;

	private final Comparator<? super E> comparator;
	private final int maxSize;

	public PriorityQueueFixed(int maxSize) {
		this(maxSize, null);
	}

	public PriorityQueueFixed(int maxSize, Comparator<? super E> comparator) {
		super(maxSize, comparator);
		this.comparator = comparator;
		this.maxSize = maxSize;
	}

	// Add -- Not Done
	public boolean add(E e) {
		return false;
	}

	// Poll

	public E poll() {
		return super.peek();
	}

}
