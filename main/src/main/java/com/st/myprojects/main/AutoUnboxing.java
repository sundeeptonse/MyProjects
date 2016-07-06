/**
 * 
 */
package com.st.myprojects.main;

import java.util.Comparator;

/**
 * @author sundeeptonse
 *
 */
public class AutoUnboxing {
	


	public static void main(String... args) {

		Comparator<Integer> naturalOrder = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 < o2 ? -1 : (o1 == o2 ? 0 : 1);
			}
		};

		System.out.println("Value::" + naturalOrder.compare(new Integer(42), new Integer(42)));
		
	}
}
