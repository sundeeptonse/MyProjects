/**
 * 
 */
package com.st.myprojects.main.datastructures.list.queues;

import com.st.myprojects.main.datastructures.list.LinkedListQ;
import com.st.myprojects.main.datastructures.list.array.CircularArray;

/**
 * @author sundeeptonse
 *
 */
public class QueueL<E> implements QueueI<E> {

	private LinkedListQ<E> linkedListStorage;

	/*
	 * 
	 */
	public QueueL() {
		linkedListStorage = new LinkedListQ<>();
	}

	@Override
	public void enqueue(E e) {
		linkedListStorage.add(e);
	}

	@Override
	public E dequeue() {
		return linkedListStorage.removeFirst();
	}

	@Override
	public E front() {
		return linkedListStorage.getFirstNodeData();
	}

	/*
	 * 
	 */
	@Override
	public boolean isEmpty() {
		return linkedListStorage.isEmpty();
	}

}
