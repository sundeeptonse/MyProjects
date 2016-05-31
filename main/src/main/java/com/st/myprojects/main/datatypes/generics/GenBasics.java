/**
 * 
 */
package com.st.myprojects.main.datatypes.generics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sundeeptonse
 *
 */
public class GenBasics {

	public static void main(String... args) {

		List<String> stringList = new ArrayList<>();
		unsafeAdd(stringList, "Heelo");
		String s1 = stringList.get(0);

		unsafeAdd(stringList, new Integer(25));
		// Class Cast Exception
		// String s2 = stringList.get(1);

		// Not Possible Since it List<String> isn't a List<Objects>
		// unsafeAdd2(stringList, new Integer(25));
		// String s3 = stringList.get(1);

		Set<String> set1 = new HashSet<>();
		set1.add("11");
		set1.add("22");

		Set<String> set2 = new HashSet<>();
		set2.add("111");
		set2.add("11");

		System.out.println(numofElements(set1, set2));

		Set<Integer> set3 = new HashSet<>();
		set3.add(11);
		set3.add(12);
		// Ok, but doesn't work.
		System.out.println(numofElements(set1, set3));

		
		System.out.println("Unbounded num Of Elements:"
				+ numofElementsG(set1, set2));

		System.out.println("Unbounded num Of Elements:"
				+ numofElementsG(set1, set3));


	}

	public static void unsafeAdd(List list, Object o) {
		list.add(o);
	}

	public static void unsafeAdd2(List<Object> list, Object o) {
		list.add(o);
	}

	public static int numofElements(Set s1, Set s2) {
		int result = 0;
		for (Object object : s1)
			if (s2.contains(object))
				result++;
		return result;
	}

	// Unbounded WildCard Type - Type Safe and Flexible
	public static int numofElementsG(Set<?> s1, Set<?> s2) {
		int result = 0;
		for (Object object : s1)
			if (s2.contains(object))
				result++;
		return result;
	}

}
