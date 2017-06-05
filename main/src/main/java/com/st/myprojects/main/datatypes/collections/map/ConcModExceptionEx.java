/**
 * 
 */
package com.st.myprojects.main.datatypes.collections.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author sundeeptonse
 *
 */
public class ConcModExceptionEx {

	public static void main(String... args) {

		Map<String, Integer> scores = new HashMap<>();
		scores.put("User1", 6);
		scores.put("User1", 12);
		scores.put("User2", 6);
		scores.put("User3", 6);
		scores.put("User4", 6);
		scores.put("User5", 6);
		scores.put("User6", 6);
		scores.put("User7", 6);
		scores.put("User8", 6);

		Iterator<String> scoresIterator = scores.keySet().iterator();
		while (scoresIterator.hasNext()) {
			System.out.println(scores.get(scoresIterator.next()));
			scores.put("User9",7);
		}

		System.out.println("Values Iterator");
		Iterator<Integer> scoresIterator2 = scores.values().iterator();
		while (scoresIterator2.hasNext()) {
			System.out.println(scoresIterator2.next());
		}

	}
}
