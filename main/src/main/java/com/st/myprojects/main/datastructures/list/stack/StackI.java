/**
 * 
 */
package com.st.myprojects.main.datastructures.list.stack;

/*-
 * @author sundeeptonse
 * 
 * LIFO (Last in First Out)
 * A "list" with the restriction that insertion and deletion can happen only from one end
 * 
 * Example : 
 * Towers of Hanoi
 * Stack of Plates
 * 
 * Uses :
 * 	Function Calls/Recursion
 *  Undo in Editor
 *  Balanced Parantheses
 * 
 */
public interface StackI<E> {

	/*
	 * O(1)
	 */
	public void push(E e);

	/*
	 * O(1)
	 */
	public E pop();

	/*
	 * O(1)
	 */
	public E top();

	/*
	 * O(1)
	 */
	public int size();
	
	public boolean isEmpty();

}
