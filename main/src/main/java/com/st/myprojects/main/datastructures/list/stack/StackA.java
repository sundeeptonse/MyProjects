/**
 * 
 */
package com.st.myprojects.main.datastructures.list.stack;

/**
 * @author sundeeptonse Array Implementation
 * 
 * Need to add resizing i/p's
 * Need to implement List
 * 
 */
public class StackA<E> implements StackI<E> {

	private Object[] elementData;
	private int defaultSize = 10;
	private int top = -1;

	public StackA() {
		elementData = new Object[defaultSize];
	}

	/*
	 * 
	 * 
	 * @see
	 * com.st.myprojects.main.datastructures.stack.StackI#push(java.lang.Object)
	 */
	@Override
	public void push(E e) {
		elementData[++top] = e;
	}

	/*
	 * 
	 * @see
	 * com.st.myprojects.main.datastructures.stack.StackI#pop(java.lang.Object)
	 */
	@Override
	public E pop() {
		E element = peek(top);
		top--;
		return element;
	}

	@SuppressWarnings("unchecked")
	private E peek(int index) {
		if (size() >= 0) {
			return (E) elementData[index];	
		}else{
			return null;
		}
		
	}

	/*
	 * 
	 * @see com.st.myprojects.main.datastructures.stack.StackI#top()
	 */
	@Override
	public E top() {
		return peek(top);
	}

	/*
	 * 
	 * @see com.st.myprojects.main.datastructures.stack.StackI#size()
	 */
	@Override
	public int size() {
		return top;
	}
	
	
	/*
	 * 
	 * @see com.st.myprojects.main.datastructures.stack.StackI#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return size() < 0 ? false : true;
	}
	
	

}
