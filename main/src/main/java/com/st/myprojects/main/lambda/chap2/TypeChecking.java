/**
 * 
 */
package com.st.myprojects.main.lambda.chap2;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author sundeeptonse
 *
 */
public class TypeChecking {

	public static void main(String... args) {
		executeFileOp(new File(""), File::delete);

		TypeChecking myObject = new TypeChecking();
		myObject.foo(Exception::new);
		// To Explicitly call foo with Supplier
		myObject.<Exception> foo(Exception::new);
		// To Explicitly call foo with Supplier
		myObject.<String, Exception> foo(Exception::new);
		//Can't be done here  
		staticFoo(Exception::new);
		
	}

	/*
	 * Overloading with Method References
	 */

	<T> void foo(Supplier<T> factory) {
		System.out.println("Supplier");
	}

	<T, U> void foo(Function<T, U> factory) {
		System.out.println("Function");
	}

	static <T> void staticFoo(Supplier<T> factory) {
		System.out.println("Static Supplier");
	}

	static <T, U> void staticFoo(Function<T, U> factory) {
		System.out.println("Static Function");
	}

	/*
	 * Centralized Exception Handling
	 */

	// To Handle FileExceoptions - Since never Thrown

	// private static <U> void executeFileOp(File f, Function<File, U> fileOp) {
	// try {
	// fileOp.apply(f);
	// } catch (IOException ex) {
	// }
	// }

	// Better way -->Can be centralized for any operation
	private static <U> void executeFileOp(File f, IOFunction<File, U> fileOp) {
		try {
			fileOp.apply(f);
		} catch (IOException ex) {
			// Blah
		}
	}
}

@FunctionalInterface
interface IOFunction<T, R> {
	R apply(T t) throws IOException;
}

// Function Type

@FunctionalInterface
interface Foo1 {
	void bar(List<String> args);
}

@FunctionalInterface
interface Foo2 {
	void bar(List args);
}

@FunctionalInterface
interface Foo3 {
	// void bar(String args);
	void barring(String args);
}

// @FunctionalInterface
// Not able to do it since it is not able to figure out
interface Foo extends Foo1, Foo2, Foo3 {
}

// Able to do it here
@FunctionalInterface
interface FooN extends Foo1, Foo2 {
	// Doesn't allow methods to be created as there is already 1 abstract method
	// void test(String args);
}