/**
 * 
 */
package com.st.myprojects.main.recursionndynamicprogramming;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*-
 * @author sundeeptonse
 * 
 *         Given a number of dollars, , and a list of dollar values for distinct
 *         coins, , find and print the number of different ways you can make
 *         change for dollars if each coin is available in an infinite quantity.
 * 
 *         Hints:
 * 
 *         You can solve this problem recursively, but you must optimize your
 *         solution to eliminate overlapping subproblems using Dynamic
 *         Programming if you wish to pass all test cases. More specifically,
 *         think of ways to store the checked solutions and use the stored
 *         values to avoid repeatedly calculating the same values. Think about
 *         the degenerate cases: How many ways can you make change for dollars?
 *         How many ways can you make change for less than dollars if you have
 *         no coins? If you are having trouble defining the storage for your
 *         precomputed values, then think about it in terms of the base case .
 *         Input Format
 * 
 *         The first line contain two space-separated integers describing the
 *         respective values of and . The second line contains space-separated
 *         integers describing the respective values of , where each integer
 *         denotes the dollar value of a distinct coin available in an infinite
 *         quantity.
 * 
 *         Constraints
 * 
 *         The list of coins contains distinct integers where each integer
 *         denotes the dollar value of a coin available in an infinite quantity.
 *         Output Format
 * 
 *         Print a single integer denoting the number of ways we can make change
 *         for dollars using an infinite supply of our types of coins.
 * 
 *         Sample Input 0
 * 
 *         4 3 
 *         1 2 3 
 *         
 *         Sample Output - 4
 * 
 *         4 Explanation 0 For and there are four solutions:
 *         1,1,1,1
 *         1,1,2
 *         1,3
 *         2,2
 *         
 */
public class CoinChange {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int coins[] = new int[m];
		for (int coins_i = 0; coins_i < m; coins_i++) {
			coins[coins_i] = in.nextInt();
		}
		long changes = makeChange(coins, n, 0, new HashMap<>());
		System.out.println(changes);
	}

	public static long makeChange(int[] coins, int money, int index,
			Map<Remaining, Long> map) {
		if (money == 0) {
			return 1;
		}
		if (index >= coins.length) {
			return 0;
		}

		Remaining remainingObj = new Remaining(money, index);
		if (map.containsKey(remainingObj)) {
			return map.get(remainingObj);
		} else {
			// int amountInCoin = 0;
			// long ways = 0;
			// while (amountInCoin <= money) {
			// // Count down
			// int remaining = money - amountInCoin;
			// // Send the Remaining Money with the index
			// ways += makeChange(coins, remaining, index + 1, map);
			// amountInCoin += coins[index];
			// }

			long ways = 0;
			while (money >= 0) {
				ways += makeChange(coins, money, index + 1, map);
				money -= coins[index];
			}
			map.put(remainingObj, ways);
			return ways;
		}

	}

	static class Remaining {
		private int money;
		private int index;

		public Remaining(int money, int index) {
			this.money = money;
			this.index = index;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + index;
			result = prime * result + money;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Remaining other = (Remaining) obj;
			if (index != other.index)
				return false;
			if (money != other.money)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return this.index + ":" + this.money;
		}

	}
}
