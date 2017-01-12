/**
 * 
 */
package com.st.myprojects.main.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sundeeptonse
 *
 */
public class MapUtil {

	public static <K, V extends Comparable<? super V>> Map<K, V> sortMapByValues(
			final Map<K, V> mapToSort) {

		List<Map.Entry<K, V>> entries = new ArrayList<>(mapToSort.size());
		entries.addAll(mapToSort.entrySet());
		
		Collections.sort(entries, new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare(final Map.Entry<K, V> entry1,
					final Map.Entry<K, V> entry2) {
				return -entry1.getValue().compareTo(entry2.getValue());
			}
		});

		Map<K, V> newMap = new LinkedHashMap<>();
		for (Map.Entry<K, V> entry : entries) {
			newMap.put(entry.getKey(), entry.getValue());
		}

		return newMap;
	}

}
