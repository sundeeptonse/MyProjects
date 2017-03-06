/**
 * 
 */
package com.st.myprojects.main.datastructures.custom;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author sundeeptonse
 * 
 *         Extends the LinkedHashMap. Provides a Fixed size LinkedHashMap, based
 *         on the size. Removes oldest Entries if the size is maxed out
 * 
 *         The ordering of the Map is based out of the entry made or the
 *         accessOrder which is the number of gets
 * 
 *         Can behave like a Fixed Sized Cache with entries getting to the end
 *         of the list based on how frequently they were accessed
 *
 */
@SuppressWarnings("serial")
public class LinkedHashMapFixed<K, V> extends LinkedHashMap<K, V> {
	public static void main(String... args) {
		Map<String, Integer> fixedMap = new LinkedHashMapFixed<>(4);
		int i = 100;
		while (i-- > 0) {
			String intValue = Integer.toString(i);
			fixedMap.put(intValue, (int) (Math.random() * 1000));
		}
		System.out.println(fixedMap);
		fixedMap.get("0");
		System.out.println(fixedMap);
		fixedMap.get("1");
		System.out.println(fixedMap);
		fixedMap.get("2");
		System.out.println(fixedMap);
		fixedMap.get("3");
		System.out.println(fixedMap);
	}

	private int maxSize;
	private static int DEFAULT_MAX_SIZE = 10;
	private static final float DEFAULT_LOAD_FACTOR = 0.75f;
	private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

	public LinkedHashMapFixed() {
		this(DEFAULT_MAX_SIZE, false);
	}

	public LinkedHashMapFixed(int maxSize) {
		this(maxSize, false);
	}

	public LinkedHashMapFixed(int maxSize, boolean accessOrder) {
		super(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR, accessOrder);
		this.maxSize = maxSize;
	}

	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		return size() > this.maxSize;
	}
}
