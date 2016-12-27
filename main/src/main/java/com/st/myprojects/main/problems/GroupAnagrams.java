/**
 * 
 */
package com.st.myprojects.main.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.st.myprojects.main.algorithms.sorting.QuickSort;
import com.st.myprojects.main.datatypes.collections.HashMapList;

/*-
 * 
 * @author sundeeptonse
 * Write  method to sort an Array of Strings so that all the Anagrams are next to each other
 */
public class GroupAnagrams {

	public static Comparator<String> anagramComparator = new Comparator<String>() {
		public int compare(String string1, String string2) {
			return Anagram.sortChars(string1).compareTo(
					Anagram.sortChars(string2));
		}
	};

	public static void main(String... args) {
		String[] array = GroupAnagramsGenerator.generateString();
		System.out.println(Arrays.toString(array));
		sortHashMapList(array);
		System.out.println(Arrays.toString(array));
	}

	public static void sort(String[] array) {

		// List<String> arrayList = Arrays.asList(array);
		// Collections.sort(arrayList, anagramComparator);
		// array = (String[]) arrayList.toArray();

		new QuickSort().sort(array, anagramComparator);

	}

	public static void sortHashMapList(String[] array) {

		HashMapList<String, String> hashMapList = new HashMapList<>();
		for (String s : array) {
			String key = Anagram.sortChars(s);
			hashMapList.put(key, s);
		}

		// Get the Array now
		int index = 0;
		for (String key : hashMapList.keySet()) {
			List<String> arrayList = hashMapList.get(key);
			for (String string : arrayList) {
				array[index++] = string;
			}
		}
	}
}

class GroupAnagramsGenerator {
	public static String[] generateString() {
		String[] str = { "c", "d", "acc", "cca", "cac", "e", "n", "za", "az" };
		// return str;,
		return str;
	};
}