/**
 * 
 */
package com.st.myprojects.main.datastructures.list.array;

/*-
 * 
 * @author sundeeptonse
 * 
 * Current Index = i
 * Next Index = (i+N)%N
 * Previous Index = (i+(N-1))%N
 *
 */
public class CircularArray<E> {

	private Object[] a;
	private int size;

	public CircularArray(int size) {
		this.size = size;
		a = new Object[size];
	}

	/*-
	 * Returns the next value;
	 *  9 --> 0
	 * */
	public int getIndexPlus(int index) {
		return (index + 1) % this.size;
	}

	public int getIndexMinus(int index) {
		return (index + (this.size - 1)) % this.size;
	}

	public void set(E object, int index) {
		this.a[index] = object;
	}

	@SuppressWarnings("unchecked")
	public E get(int index) {
		return (E) a[index];
	}

	/*-
	 * In the context of this Circular Array, checks if two value a and b are
	 * next to each other 
	 * Example in a 10 size array, {9,0} , {0,1}, {2,3} ,
	 * {8,9}
	 * 
	 * a --> 9 b --> 0
	 * 
	 * a+1 % 10 = 0 & b = 0, since both the values are the same return
	 */
	public boolean checkNextToEachOther(int a, int b) {
		return ((a + 1) % this.size == b) ? true : false;
	}
}
