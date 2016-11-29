/**
 * 
 */
package com.st.myprojects.main.datastructures.list.queues;

import com.st.myprojects.main.datastructures.list.array.CircularArray;

/**
 * @author sundeeptonse
 *
 */
public class QueueA<E> implements QueueI<E> {

	private int front;
	private int rear;
	private int size;
	private CircularArray<E> array;

	/*
	 * Initialize the front == -1 && rear == -1 Create a CircularArray Object
	 */
	public QueueA(int size) {
		this.rear = this.front = -1;
		this.array = new CircularArray<>(size);
	}

	@Override
	public void enqueue(E e) {
		// If Full, then return as it cannot be take care of.
		if (isFull()) {
			return;
		} else if (isEmpty()) {
			// If Empty, then set the Value to 0, front and rear
			this.rear = this.front = 0;
		} else {
			// Increment the rear Value to the next Index
			this.rear = this.array.getIndexPlus(this.rear);
		}
		this.array.set(e, this.rear);
	}

	@Override
	public E dequeue() {

		// If Empty, then return
		if (isEmpty()) {
			return null;
		} else {
			// Set the Front Value to the front+1, in circular terms
			front = this.array.getIndexPlus(front);
			// Get the Value and Store it
			E e = front();
			// If Front == Rear Value, then set the Value as -1
			if (front == rear) {
				front = rear = -1;
			}
			return e;
		}

	}

	@Override
	public E front() {
		return this.array.get(front);
	}

	/*
	 * If the front == -1 && rear == -1, then the queue is empty
	 */
	@Override
	public boolean isEmpty() {
		return (front == -1 && rear == -1) ? true : false;
	}

	/*
	 * In the context of this array, check if the rear and front based values
	 * are next to each other
	 */
	private boolean isFull() {
		return this.array.checkNextToEachOther(rear, front);
	}

}
