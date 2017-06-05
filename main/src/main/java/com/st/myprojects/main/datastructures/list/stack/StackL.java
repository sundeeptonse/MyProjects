/**
 * 
 */
package com.st.myprojects.main.datastructures.list.stack;

import java.util.LinkedList;

/**
 * @author sundeeptonse Array Implementation
 * 
 *         Need to add resizing i/p's Need to implement List
 * 
 */
public class StackL<E> implements StackI<E> {

	private LinkedList<E> elementData = new LinkedList<>();

	/*
	 * 
	 * 
	 * @see
	 * com.st.myprojects.main.datastructures.stack.StackI#push(java.lang.Object)
	 */
	@Override
	public void push(E e) {
		elementData.add(e);
	}

	/*
	 * 
	 * @see
	 * com.st.myprojects.main.datastructures.stack.StackI#pop(java.lang.Object)
	 */
	@Override
	public E pop() {
		E e = peek(size());
		elementData.removeLast();
		return e;
	}

	@SuppressWarnings("unchecked")
	private E peek(int index) {
		return elementData.get(index);
	}

	/*
	 * 
	 * @see com.st.myprojects.main.datastructures.stack.StackI#top()
	 */
	@Override
	public E top() {
		E e = peek(size());
		return e;
	}

	/*
	 * 
	 * @see com.st.myprojects.main.datastructures.stack.StackI#size()
	 */
	@Override
	public int size() {
		return elementData.size();
	}

	/*
	 * 
	 * @see com.st.myprojects.main.datastructures.stack.StackI#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return elementData.size() < 0 ? false : true;
	}

}
