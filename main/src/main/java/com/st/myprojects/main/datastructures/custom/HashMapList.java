/**
 * 
 */
package com.st.myprojects.main.datastructures.custom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author sundeeptonse
 *
 */
public class HashMapList<K, V> {
	private Map<K, List<V>> map = new HashMap<>();

	public HashMapList() {
		map = new HashMap<>();
	}

	public List<V> get(K key) {
		return map.get(key);
	}

	public void put(K key, V value) {
		List<V> list = map.get(key);
		if (list == null) {
			list = new ArrayList<>();
		}
		list.add(value);
		map.put(key, list);
	}

	public Set<K> keySet() {
		return map.keySet();
	}
}
