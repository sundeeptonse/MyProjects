/**
 * 
 */
package com.st.myprojects.main.recursionndynamicprogramming;

import java.math.BigInteger;

import com.st.myprojects.main.util.DateUtil;
import com.st.myprojects.main.util.DateUtil.Time;

/**
 * @author sundeeptonse
 *
 */
public class FibonacciExample {

	public static void main(String... args) {

		int n = 100;

		long time = System.nanoTime();
		System.out.println(fibM(n));
		DateUtil.printTimeDifference(time, Time.ms);

		time = System.nanoTime();
		System.out.println(fib(n));
		DateUtil.printTimeDifference(time, Time.ms);

	}

	/*-
	 * Run Time is 0(2^n)
	 */
	public static int fib(int n) {
		if (n <= 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}

	/*-
	 * Run Time is 0(n), since once a result has been calculated it is re-used
	 * This is memoization
	 */
	public static BigInteger fibM(int n) {
		BigInteger[] memo = new BigInteger[n + 1];
		return fibM(n, memo);
	}

	private static BigInteger fibM(int n, BigInteger[] memo) {
		if (n <= 0) {
			return BigInteger.valueOf(0);
		} else if (n == 1) {
			return BigInteger.valueOf(1);
		} else if (memo[n] == null) {
			memo[n] = fibM(n - 1, memo).add(fibM(n - 2, memo));
		}
		System.out.println(n + ":" + memo[n]);
		return memo[n];
	}

	public static int fibMInt(int n) {
		int[] memo = new int[n + 1];
		return fibMInt(n, memo);
	}

	private static int fibMInt(int n, int[] memo) {
		if (n <= 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else if (memo[n] == 0) {
			memo[n] = fibMInt(n - 1, memo) + fibMInt(n - 2, memo);
		}
		return memo[n];
	}
}
