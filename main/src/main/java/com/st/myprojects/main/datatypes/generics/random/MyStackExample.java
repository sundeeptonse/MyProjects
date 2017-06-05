/**
 * 
 */
package com.st.myprojects.main.datatypes.generics.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;
import java.util.List;

/*-
 * @author sundeeptonse
 * Non-Thread Safe version of a stack
 */
public class MyStackExample {
	public static void main(String... args) {

		MyStackG<String> stringStack = new MyStackG<>();
		for (String arg : args)
			stringStack.push(arg);

		while (!stringStack.isEmpty())
			System.out.println(stringStack.pop().toUpperCase());

		MyStackG<Number> numberStack = new MyStackG<>();
		List<Integer> integers = new ArrayList<>();
		integers.add(1);
		integers.add(2);
		integers.add(3);

		// Works only because Push Accepts ? extends E, which is Number in this
		// case
		numberStack.pushAll(integers);
		
		//Consumer ??

		List<Integer> integerColl = new ArrayList<>();
		numberStack.popAll(integerColl);

		List<Object> objectAll = new ArrayList<>();
		// This doesn't work, since u are trying to Add Number to Object
		// Object doesn't Extends Number ***
		// numberStack.popAll(objectAll);
		
		List<Object> integerColl2 = new ArrayList<>();
		numberStack.popAllF(integerColl2);

				
		
	}
}

class MyStack {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INTITIAL_CAPACITY = 16;

	public MyStack() {
		elements = new Object[DEFAULT_INTITIAL_CAPACITY];
	}

	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}

	public Object pop() {
		if (isEmpty())
			throw new EmptyStackException();
		Object result = elements[--size];
		elements[size] = null;
		return result;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private void ensureCapacity() {
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
}

class MyStackG<E> {
	private E[] elements;
	private int size = 0;
	private static final int DEFAULT_INTITIAL_CAPACITY = 16;

	@SuppressWarnings("unchecked")
	public MyStackG() {
		// Have Typecasted it and suppresed the warnings ont this
		// You can't crate an array of an non-reifable type such as E
		elements = (E[]) new Object[DEFAULT_INTITIAL_CAPACITY];
	}

	public void push(E e) {
		ensureCapacity();
		elements[size++] = e;
	}

	public E pop() {
		if (isEmpty())
			throw new EmptyStackException();
		E result = elements[--size];
		elements[size] = null;
		return result;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private void ensureCapacity() {
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}

	public void pushAll(Iterable<? extends E> src) {
		for (E e : src)
			push(e);
	}

	/**
	 * This doesn't work, since u are trying to Add Number to Integer
	 * 
	 * */
	public void popAll(Collection<? extends E> dest) {

		while (!isEmpty()) {
			// Error in Code
			// dest.add(pop());
		}
	}

	/**
	 * This works only if the Collecion is an Object , not an Integer like List<Integer>
	 * 
	 * */
	public void popAllF(Collection<? super E> dest) {

		while (!isEmpty())
			dest.add(pop());

	}
}
