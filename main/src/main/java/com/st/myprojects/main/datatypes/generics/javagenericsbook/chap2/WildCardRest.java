/**
 * 
 */
package com.st.myprojects.main.datatypes.generics.javagenericsbook.chap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sundeeptonse Covers any Restrictions on Wildcards
 */
public class WildCardRest {

	public static void main(String... args) {

		// Not Allowed
		// List<?> list = new ArrayList<?>();
		// Map<String,? extends Number> map = new HashMap<String, ? extends
		// Number>();

		// Allowed ?? What is it inferring?
		List<?> list = new ArrayList<>();
		// list.add(1); --> Compile Time Error
		// list.get(1); // --> Allowed

		/**
		 * Only Top Level Paramters in instance creation are prohibited from
		 * containing wildcards. Nested Wildcards are permitted
		 * */
		List<List<?>> lists = new ArrayList<List<?>>();
		lists.add(Arrays.asList(1, 2, 3));
		lists.add(Arrays.asList("four", "five"));
		System.out.println("Lists:" + lists);

		// Legal --> Similar to Inference above
		List<?> list2 = WildCardRest.factory();
		// No Point though
		// list2.add(new Integer(0));

		List<?> list3 = WildCardRest.<Object> factory();
		
		// Illegal
		// List<?> list4 = WildCardRest.<?>factory();
		
		/**
		 * Nested  WildCards are ok
		 * */

		List<List<?>> lists4 = WildCardRest.<List<?>> factory();
		
	}

	public static <T> List<T> factory() {
		return new ArrayList<T>();
	}

}
