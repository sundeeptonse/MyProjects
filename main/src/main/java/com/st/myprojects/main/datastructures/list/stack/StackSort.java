/**
 * 
 */
package com.st.myprojects.main.datastructures.list.stack;

import java.awt.font.NumericShaper;
import java.util.Stack;

import com.st.myprojects.main.util.CommonUtil;

/**
 * @author sundeeptonse
 * 
 *         Sort A Stack in order
 *
 */
public class StackSort {

	public <E> void sortStack2(Stack<E> originalStack) {
		Stack<E> stack1 = new Stack<E>();
		Stack<E> stack2 = new Stack<E>();
		// Find Average of the Stack --> O(N)
		// Split up into two Stacks depending on the Average
		// Recurse with the two Seperate Stacks
		// Merge the Two Stacks into One and return
	}

	/*
	 * Bad Efficiency - O(n pow 2)
	 */
	public <E> void sortStack(Stack<E> originalStack) {
		Stack<E> finalStack = new Stack<E>();
		while (!originalStack.isEmpty()) {
			// Pop the ELement and store in a Temp Variable
			E temp = originalStack.pop();

			// Compare Value with the Value in the finalStack.

			// Till FinalStack is Empty or the TopElement Of the Original is
			// lesser than the value FinalStack
			while (!finalStack.isEmpty()
					|| CommonUtil.compare(temp,
							finalStack.peek(), null) < 1) {
				originalStack.push(finalStack.pop());
			}
			// Once we Reach the Place to insert, we push the Value
			finalStack.push(temp);

		}

	}

}
