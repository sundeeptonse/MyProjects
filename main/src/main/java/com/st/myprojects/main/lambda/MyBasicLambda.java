package com.st.myprojects.main.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MyBasicLambda {

	private static String gvar = MyBasicLambda.class.getName();

	public static void main(String[] args) {

		List<String> list = Arrays.asList("a", "b", "d");
		List<Number> list2 = Arrays.asList(1, 2, 2, 3);

		// Foreach provided by Iterable
		// Basic ForEach
		System.out.println("-----Basic For Each");
		list2.forEach(new Consumer<Number>() {
			@Override
			public void accept(Number t) {
				System.out.println("Value:" + t.intValue());
			}
		});

		System.out.println("-----Lambda");

		// Type Casting
		list.forEach((String e) -> System.out.println(e));

		// Basic
		list.forEach(e -> System.out.println(e));

		// Numeric Type casting
		list2.forEach((Number e) -> System.out.println(e));

		// Without Doing Anything - Woah
		System.out.println("-----Woah");
		//Basically Letting the compiler know that function needs to be passed along 
		//Method Reference Syntax
		list.forEach(System.out::println);
		System.out.println("-----Woah");

		// Usage of Class Member Variables
		final String test1 = "test1";

		// Needs to be final or effectively Final
		// Shouldn't change
		String test2 = "test2";

		// Class Variables can choose not to be final --> Why ?
		gvar = "Update";
		list.forEach(e -> {
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
