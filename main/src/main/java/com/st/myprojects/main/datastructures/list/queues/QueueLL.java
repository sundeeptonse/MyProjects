/**
 * 
 */
package com.st.myprojects.main.datastructures.list.queues;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * @author sundeeptonse
 *
 */
@SuppressWarnings("serial")
public class QueueLL<T> extends LinkedList<T> {

	public T peek() {
		T value = super.get(0);
		nullCheck(value);
		return value;
	}

	public T poll() {
		peek();
		return super.removeFirst();
	}

	@Override
	public boolean add(T data) {
		return super.add(data);
	}

	private void nullCheck(T data) throws NoSuchElementException {
		if (data == null) {
			throw new NoSuchElementException();
		}
	}
}
