package com.st.myprojects.main;


public class SomeTests {

	public static void main(String... args) throws Throwable {

		// Some Random Stuff
		if (null instanceof Object) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}

		int result = 10;
		int commonMultiplier = 5;
		int x = 1;
		int y = 2;
		int z = 3;
		
		result = (result *= commonMultiplier) + x;

		System.out.println("Result:" + result);
	}
}
