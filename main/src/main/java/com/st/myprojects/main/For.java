/**
 * 
 */
package com.st.myprojects.main;

/**
 * @author sundeeptonse
 *
 */
public class For {

	public static void main(String... args) {

		for (int i = 0, n = test(); i < n; i++) {
			System.out.println("i:" + i);
		}
	}

	public static int test() {
		return 10;
	}

}
