/**
 * 
 */
package com.st.myprojects.main.datatypes.collections.map;


import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author sundeeptonse
 *
 */

public class WeakHashMapEx {

	public static void main(String... args) {

		/*
		 * class Entry<K, V> extends WeakReference<Object>
		 * */
		Map<Object, Integer> weakHashMap = new WeakHashMap<>();

		// Weak References
		weakHashMap.put(new Object(), 1);
		weakHashMap.put(new Object(), 2);
		weakHashMap.put(new Object(), 2);

		// Strong References
		Object object = new Object();
		weakHashMap.put(object, 2);

		System.out.println(weakHashMap.size());
		System.out.println(weakHashMap.size());
	}
}
