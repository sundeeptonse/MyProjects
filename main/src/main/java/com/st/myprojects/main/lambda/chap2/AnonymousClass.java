/**
 * 
 */
package com.st.myprojects.main.lambda.chap2;

import java.util.Comparator;

/**
 * @author sundeeptonse
 *
 */
public class AnonymousClass {

	public static void main(String... args) {

		int value = 0;
		final int value2;
		Comparator<Integer> intComp = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				//value++;
				//value2++;
				return value;
			}
		};

	}
}
