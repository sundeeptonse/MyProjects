/**
 * 
 */
package com.st.myprojects.main.lambda.chap1;

import java.util.Arrays;
import java.util.List;

/**
 * @author sundeeptonse
 *
 */
public class SimpleClassCheck {

	public static void main(String... args) {

		List<Integer> list = Arrays.asList(1, 2, 2, 3453, 5435, 4);
		list.forEach(System.out::println);
	}

}
