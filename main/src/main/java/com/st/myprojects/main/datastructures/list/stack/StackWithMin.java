/**
 * 
 */
package com.st.myprojects.main.datastructures.list.stack;

import java.util.Stack;

import com.st.myprojects.main.util.CommonUtil;

/**
 * @author sundeeptonse
 * 6 , Min 6
 * 7, 6,  Min 6
 * 3, 7, 6 , Min 3 
 *
 */
@SuppressWarnings("serial")
public class StackWithMin<E> extends Stack<E> {

	Stack<E> minStack;

	public StackWithMin() {
		minStack = new Stack<E>();
	}

	/*
	 * Pushes the Value to the MinStack if the Value is lesser than the Current
	 * Min
	 */
	public E push(E item) {
		E currentMin = min();
		// If Item is Lesser than Current Min, then add to Stack or the new
		// Value is Lesser than the MinValue
		if (currentMin == null
				|| CommonUtil.compare(item, currentMin, null) < 1) {
			minStack.push(item);
		}
		return super.push(item);
	}

	/*
	 * Pop the Value if the Value Being Popped is the min Value
	 */
	public E pop() {
		E value = super.pop();
		E currentMin = min();
		if (currentMin != null && value == currentMin) {
			minStack.pop();
		}
		return value;
	}

	public E min() {
		if (isEmpty()) {
			return null;
		} else {
			return minStack.peek();
		}
	}
}
