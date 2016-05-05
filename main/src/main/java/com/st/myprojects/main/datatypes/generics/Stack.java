package com.st.myprojects.main.datatypes.generics;

import java.util.Collection;
import java.util.Iterator;

public class Stack<E> implements Collection{

	Class class2;
	//Type Inference
	public static <K> Stack<K> getStack(){
		return new Stack<K>();
	}
	
	public static <V> Stack<V> getStackV(){
		return new Stack<V>();
	}
	
	public static <T> Stack<T> getStackT(){
		return new Stack<T>();
	}
	
	public static <E> Stack<E> getStackE(){
		return new Stack<E>();
	}
	
	
	public static void main(String[] args){
		Stack<Long> stackLong = Stack.getStack();
		System.out.println(stackLong.getClass().getName());
		stackLong.pushAll(stackLong);
		stackLong.popAll(stackLong);
	}
	
	//PECS, Producer Extends, Consumer Super
	//In this method, we want to 
	public void pushAll(Collection<? extends E> source){
		
	}
	
	public void popAll(Collection<? super E> destination){
		
	}

	
	
	// Doesnt' Work.
	/*
	public void pushAll(Collection<E> src){
		
	}
	
	public void popAll(Collection<E> dst){
		
	}
	*/
	
	
	
	
	//Un-Implemented Methods
	
	
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean add(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}
}
