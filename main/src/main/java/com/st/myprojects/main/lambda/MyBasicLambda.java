package com.st.myprojects.main.lambda;

import java.util.Arrays;

public class MyBasicLambda {

	private static String gvar = MyBasicLambda.class.getName();

	public static void main(String[] args) {

		// Basic
		Arrays.asList("a", "b", "d").forEach(e -> System.out.println(e));

		// Type Casting
		Arrays.asList("a", "b", "d").forEach(
				(String e) -> System.out.println(e));

		// Numeric Type casting
		Arrays.asList(1, 2, 3).forEach((Number e) -> System.out.println(e));

		// Usage of Class Member Variables
		final String test1 = "test1";

		// Needs to be final or effectively Final
		// Shouldn't change
		String test2 = "test2";

		// Class Variables can choose not to be final --> Why ?
		gvar = "Update";
		Arrays.asList("a", "b", "d").forEach(e -> {
			System.out.println(e + ":" + test1);
			System.out.println(e + ":" + test2);
			System.out.println(e + ":" + gvar);
		});
		gvar = "Update2";

		/*
		 * Lambdas may return a value. The type of the return value will be
		 * inferred by compiler. The return statement is not required if the
		 * lambda body is just a one-liner.
		 */

		System.out.println("Return Value");
		Arrays.asList("d", "c", "e").sort((e1, e2) -> e1.compareTo(e2));

		Arrays.asList("a", "b", "d").sort((x1, x2) -> x1.compareTo(x2));

		Arrays.asList("a", "b", "d").sort((e1, e2) -> {
			int result = e1.compareTo(e2);
			System.out.println("Result:" + result);
			return result;
		});

	}

}
