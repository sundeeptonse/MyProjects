/**
 * 
 */
package com.st.myprojects.main.datastructures.list.queues;

/**
 * @author sundeeptonse
 *
 */
public class QueueTest {

	public static void main(String... args) {
		QueueA<Integer> queue = new QueueA<>(10);

		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);

		for (int i = 0; i < 10; i++) {
			System.out.println(queue.dequeue());
		}

		System.out.println("Enquee2");
		for (int i = 0; i < 22; i++) {
			queue.enqueue(i);
		}

		System.out.println("Deque2");
		for (int i = 0; i < 9; i++) {
			System.out.println(queue.dequeue());
		}

		System.out.println("****");

		QueueL<Integer> queueL = new QueueL<>();
		queueL.enqueue(1);
		queueL.enqueue(2);
		queueL.enqueue(3);
		queueL.enqueue(4);
		queueL.enqueue(5);

		for (int i = 0; i < 10; i++) {
			System.out.println(queueL.dequeue());
		}

		System.out.println("Enquee2");
		for (int i = 0; i < 22; i++) {
			queueL.enqueue(i);
		}

		System.out.println("Deque2");
		for (int i = 0; i < 30; i++) {
			System.out.println(queueL.dequeue());
		}

	}
}
