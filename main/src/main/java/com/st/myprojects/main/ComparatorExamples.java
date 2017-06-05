/**
 * 
 */
package com.st.myprojects.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sundeeptonse
 *
 */
public class ComparatorExamples {

	private static Comparator<Integer> ascendingComparator = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}
	};

	private static Comparator<Integer> descComparator = Collections
			.reverseOrder(ascendingComparator);

	private static Comparator<Integer> descendingComparator2 = Collections
			.reverseOrder();

	private static Map<Integer, Integer> syncMap = Collections
			.synchronizedMap(new HashMap<Integer, Integer>());

	private static List<Integer> syncList = Collections
			.synchronizedList(new ArrayList<Integer>());
}
