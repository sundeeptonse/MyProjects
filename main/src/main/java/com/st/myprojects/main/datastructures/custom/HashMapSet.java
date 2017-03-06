/**
 * 
 */
package com.st.myprojects.main.datastructures.custom;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author sundeeptonse
 *
 */
public class HashMapSet<K, V> {
	private Map<K, Set<V>> map;

	public HashMapSet() {
		map = new HashMap<>();
	}

	public Set<V> get(K key) {
		return map.get(key);
	}

	public void put(K key, V value) {
		Set<V> set = map.get(key);
		if (set == null) {
			set = new HashSet<>();
		}
		set.add(value);
		map.put(key, set);
	}

}
