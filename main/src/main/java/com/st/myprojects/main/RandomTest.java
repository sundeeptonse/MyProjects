/**
 * 
 */
package com.st.myprojects.main;

import java.util.Random;

/**
 * @author sundeeptonse
 *
 */
public class RandomTest {

	private static final Random rnd = new Random();

	static int random(int n) {
		return Math.abs(rnd.nextInt()) % n;
	}

	public static void main(String... args) {
		int n = 2 * (Integer.MAX_VALUE / 3);
		
		int low = 0;
		for (int i = 0; i < 1000000; i++)
			if (random(n) < n / 2)
				low++;

		System.out.println("n:" + n + "::Count of Low:+" + low);

	}

}
