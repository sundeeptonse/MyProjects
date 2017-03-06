/**
 * 
 */
package com.st.myprojects.main.problems;

import java.util.Map;

/*-
 * @author sundeeptonse
 *
 * Given a knapsack of Capacity C
 * And An Array of Weights/$Value
 * 
 * Choose a List of Values where the $OutCome is the best
 * 
 * Example
 * W   1, 2, 4, 2, 5
 * V   5, 3, 5, 3, 2
 * 
 */
public class KnapSackProblem {

	// Similar to Coin Change Problem
	// Recurse Using Problem
	// Example
	// If you add value at Index 1,

	public static void main(String... args) {

	}

	public static int knapSack(int[][] possibleLoot, int availWeight,
			int index, Map<Remaining, Integer> memo) {

		// Base Cases
		if (availWeight <= 0 || index >= possibleLoot[0].length) {
			return 0;
		} else {
			Remaining remainingValue = new Remaining(index, availWeight);
			if (memo.get(remainingValue) == null) {

				// Main Logic - Recursive
				// If Value not in Map, then find value
				// While the availWeight >= 0, keep subtracting the weight of
				// Current
				// Index and adding the dollar Value

				int itemsAtCurrentIndex = 0;
				int maxDollarValue = 0;
				int currentIndexDollarValue = possibleLoot[index][1];
				int currentIndexWeight = possibleLoot[index][0];

				while (availWeight >= 0) {
					int dollarValue = knapSack(possibleLoot, availWeight,
							index + 1, memo)
							+ itemsAtCurrentIndex++
							* currentIndexDollarValue;
					// Max Dollar Value = Value1 + Value2
					maxDollarValue = Math.max(dollarValue, maxDollarValue);
					// Reduce the AvailWeight from the Items at Current Index
					availWeight -= currentIndexWeight;
				}
				memo.put(remainingValue, maxDollarValue);
			}
			// Return the Best Dollar Value
			return memo.get(remainingValue);
		}
	}

	static class Remaining {
		private int index;
		private int weight;

		Remaining(int index, int weight) {
			this.index = index;
			this.weight = weight;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + index;
			result = prime * result + weight;
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
			if (weight != other.weight)
				return false;
			return true;
		}

	}

}
