/**
 * 
 */
package com.st.myprojects.main.problems;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author sundeeptonse
 * 
 *         Given a string, find the length of the longest substring without
 *         repeating characters.
 * 
 *         Examples:
 * 
 *         Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 *         Given "bbbbb", the answer is "b", with the length of 1.
 * 
 *         Given "pwwkew", the answer is "wke", with the length of 3. Note that
 *         the answer must be a substring, "pwke" is a subsequence and not a
 *         substring.
 * 
 * 
 *
 */
public class LongestSubSequence {

	public static void main(String... args) {
		lengthOfLongestSubstring("abcabcbb");
		lengthOfLongestSubstring("bbbbb");
		lengthOfLongestSubstring("pwwkew");
		lengthOfLongestSubstring("c");
		lengthOfLongestSubstring("abcdefghijklmnopqrstuvwxyz");
		lengthOfLongestSubstring("dvdf");
	}

	public static int lengthOfLongestSubstring(String s) {
		Set<Character> mainSet = new LinkedHashSet<>();
		Set<Character> tempSet = new LinkedHashSet<>();

		for (char c : s.toCharArray()) {
			// If Character not present in Set, Add to Set
			if (!tempSet.contains(c)) {
				tempSet.add(c);
			} else {
				// Find Where it contains and then resize the tempSet
				Set<Character> newSet = new LinkedHashSet<>();
				for (Character ch : tempSet) {
					if (ch == c) {
						break;
					} else {
						newSet.add(ch);
					}
				}
			}

		}

		return mainSet.size();
	}
}
