/**
 * 
 */
package com.st.myprojects.main.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author sundeeptonse
 * 
 *         Given 7 letter tiles and a dictionary of valid words, return the set
 *         of words that can be generated using 1-7 of those tiles. Example:
 *         letter tiles: SAPAPER word dictionary: A AA AAA APE PEA PARE PEAR
 *         FEAR SPARE APPEARS REAPPEARS would return: A AA APE PEA PARE PEAR
 *         SPARE APPEARS
 * 
 * 
 *
 */
public class LetterTiles {

	public static void main(String... args) {
		String value = "SAPAPER";
		Set<String> set = new HashSet<>();
		set.add("A");
		set.add("AA");
		set.add("AAA");
		set.add("APE");
		set.add("PEA");
		set.add("PARE");
		set.add("PEAR");
		set.add("REAPPEARS");
		set.add("SPARE");
		System.out.println(getValidStrings(value, set));
		
		List<String> list = new ArrayList();
		Collections.sort(list);
		
	}

	public static Set<String> getValidStrings(String string, Set<String> set) {
		Set<String> returnString = new HashSet<>();
		// O(n)
		Map<Character, Integer> mainStringCharCount = getCharacterCount(string);
		// K*2*O(n)
		for (String s : set) {
			if (isPartofString(mainStringCharCount, getCharacterCount(s))) {
				returnString.add(s);
			}
		}
		return returnString;
	}

	public static boolean isPartofString(Map<Character, Integer> bigger,
			Map<Character, Integer> smaller) {
		for (Character c : smaller.keySet()) {
			if (smaller.get(c) > bigger.get(c)) {
				return false;
			}
		}
		return true;
	}

	/* O(n) */
	public static Map<Character, Integer> getCharacterCount(String s) {
		Map<Character, Integer> count = new HashMap<>();
		for (char c : s.toCharArray()) {
			if (!count.containsKey(c)) {
				count.put(c, 0);
			}
			Integer value = count.get(c);
			count.put(c, ++value);
		}
		return count;
	}
}
