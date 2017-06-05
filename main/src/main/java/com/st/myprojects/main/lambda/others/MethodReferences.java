package com.st.myprojects.main.lambda.others;

import java.util.Arrays;
import java.util.List;

/*
 *	Method References
 *	$Pass as an Argument
 *  $Pass as an Argument to a Static Method
 * 	$Pass as an Target 
 *  $Two Parameters as an Argument
 */
public class MethodReferences {

	public static void main(String... args) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

		numbers.forEach(t -> System.out.println(t));

		// $Pass as an Argument
		numbers.forEach(System.out::println);

		// $Pass as an Argument to a Static Method
		numbers.forEach(MethodReferences::getString);

		// Target --> To Do

	}

	public static <E> void getString(E value) {
		System.out.println(String.valueOf(value));
	}

}
