/**
 * 
 */
package com.st.myprojects.main.datastructures.list.queues;

/*-
 * @author sundeeptonse
 * Queue : FIFO as opposed to Stack(LIFO)
 * 
 * Inserting at tail, and removal  at head
 * List which is restriction of insertion at one end and deletion at other end 
 * 
 * Scenarios:
 * 		a) Printer
 * 		b) Processing Scheduling 
 * 		c) Simulating Wait
 */
public interface QueueI<E> {

	/*-
	 * Insert Records
	 * 0(1)
	 * */
	void enqueue(E e);

	/*-
	 * Return & Remove Record at the Head
	 * 0(1)
	 * */
	E dequeue();

	/*-
	 * Return Record at Head
	 * 0(1)
	 * */
	E front();

	
	/*-
	 * isEmpty
	 * */
	boolean isEmpty();

}
