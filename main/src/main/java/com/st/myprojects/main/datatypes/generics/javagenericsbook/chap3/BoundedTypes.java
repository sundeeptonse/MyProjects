/**
 * 
 */
package com.st.myprojects.main.datatypes.generics.javagenericsbook.chap3;

import java.util.Collection;

/**
 * @author sundeeptonse
 *
 */
public class BoundedTypes<E> {

	// Example Integer extends Comparable<Integer>
	// public final class Integer extends Number implements Comparable<Integer>
	public static <T extends Comparable<T>> T max(Collection<T> coll) {
		T candidate = coll.iterator().next();
		for (T colValues : coll)
			if (candidate.compareTo(colValues) < 0)
				candidate = colValues;

		return candidate;
	}

	public static <T extends Object> void test(T value) {

	}

	public <T extends E> void test2(T value) {

	}

	/**
	 * Not Allowed
	 * */

	// public static <T super Object> void test(T value) {}
	// public static <T extends E> void test2(T value) {} --> Since Static, Non
	// - Static is ok
}

class BoundedTypeExtended<K, V> {
	
	public <T extends K> void test2(V value) {

	}
	
}
