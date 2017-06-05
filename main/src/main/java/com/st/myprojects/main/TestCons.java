/**
 * 
 */
package com.st.myprojects.main;

/**
 * @author sundeeptonse
 *
 */
public class TestCons {

	TestCons() throws ArithmeticException {
		throw new ArithmeticException("");
	}

	public static void testMethod() throws ArithmeticException {
		throw new ArithmeticException("");
	}

	public static void main(String... args) {
		TestCons testCons = new TestCons();
		TestCons.testMethod();
	}
}
