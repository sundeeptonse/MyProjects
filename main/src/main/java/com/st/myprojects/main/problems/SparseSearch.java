/**
 * 
 */
package com.st.myprojects.main.problems;

/**
 * @author sundeeptonse
 * 
 *         Given a sorted array of strings that is interpersed with empty
 *         strings, write a method to find the location of a given String
 * 
 *         Example :
 * 
 *         Input
 *         :{"at","","","","","","","ball","","","","car","","","dad","",""}
 *         :{"","","","","","","","ball","","","","car","","","dad","",""}
 * 
 *         ball
 *
 */
public class SparseSearch {

	public static void main(String... args) {

		String[] inputArray = { "at", "", "", "", "", "", "", "ball", "", "",
				"", "", "", "ca", "cat","cc", "dog", "", "", "", "" };
		String searchString = "dog";
		int upperIndex = inputArray.length - 1;
		System.out.println("Upper Index:" + upperIndex);
		int searchIndex = search(inputArray, searchString, 0, upperIndex);
		assert (searchIndex != -1 ? (inputArray[searchIndex] == searchString)
				: false);
		System.out.println(searchIndex);

	}

	public static int search(String[] inputString, String searchString,
			int lowerIndex, int upperIndex) {

		if (searchString.equals("")) {
			return -1;
		}
		// If LowerIndex > UpperIndex, return -1
		if (lowerIndex > upperIndex) {
			return -1;
		}

		// Else Continue to find Mid

		// oldMid/newMid - (lower + upperIndex)/2
		int newMid, oldMid;
		newMid = oldMid = (lowerIndex + upperIndex) / 2;

		System.out.println("AALower:" + lowerIndex + ":Upper:" + upperIndex
				+ ":Mid:" + newMid);

		// Check if Value[newMid] == "" and keep reducing newMid till the value
		// reaches lower.
		// while(value[newMid] == "" && newMid > lowerIndex) newMid--;
		// If the value[newMid] == "" after this loop, it means we have
		// exhausted the values and we need to find a newMid Value by
		// incrementing
		// newMid = oldMid
		// while(value[newMid] == "" && newMid < upperIndex) newMid++;
		// If the value[newMid] == "" after this loop, it means we have
		// exhausted all the values and we need to exit with -1

		newMid = findNonEmptyIndex(inputString, oldMid, lowerIndex, false);
		newMid = (newMid == -1 ? findNonEmptyIndex(inputString, oldMid,
				upperIndex, true) : newMid);
		if (newMid == -1) {
			return -1;
		}

		System.out.println("Lower:" + lowerIndex + ":Upper:" + upperIndex
				+ ":Mid:" + newMid);

		// Check if the value of the value[newMid] == string,
		// If so return the index
		int compareValue = searchString.compareTo(inputString[newMid]);
		if (compareValue == 0) {
			return newMid;
		} // If not, compare and rerun the loop
		else if (compareValue < 0) {
			// Lower the newMid Value
			newMid--;
			// if <, then lowerBound = lowerBound( ++ till we reach non zero or
			// mid), UpperBound = Mid
			int nonEmptyLowerBound = findNonEmptyIndex(inputString, lowerIndex,
					newMid, true);
			if (nonEmptyLowerBound == -1) {
				return -1;
			}
			// Use newMid and find the nextNon Empty value by decreasing it till
			// the lowerBound
			int nonEmptyUpperBound = findNonEmptyIndex(inputString, newMid,
					nonEmptyLowerBound, false);
			System.out.println("Lower/UpperBound:" + nonEmptyLowerBound +":" +nonEmptyUpperBound );
			if (nonEmptyUpperBound == -1) {
				return -1;
			}

			return search(inputString, searchString, nonEmptyLowerBound,
					nonEmptyUpperBound);

		} else {

			// Compare and then set Range
			// We can set this range to reduce the Number of iterative loops
			// if >, then lowerBound = Mid, UpperBound = (UpperBound -- till we
			// reach non zero or mid)
			newMid++;
			int nonEmptyUpperBound = findNonEmptyIndex(inputString, upperIndex,
					newMid, false);
			if (nonEmptyUpperBound == -1) {
				return -1;
			}
			// Use newMid and find the nextNon Empty value by increasing it till
			// the upperBound
			int nonEmptyLowerBound = findNonEmptyIndex(inputString, newMid,
					nonEmptyUpperBound, true);
			if (nonEmptyLowerBound == -1) {
				return -1;
			}
			return search(inputString, searchString, nonEmptyLowerBound,
					nonEmptyUpperBound);

		}

	}

	public static int findNonEmptyIndex(String[] array, int value, int minMax,
			boolean increase) {
		// If Value == minMax Index, and value == "", return -1 as there is
		// nothing more to search, else return the value
		if (value == minMax) {
			if (!array[value].equals("")) {
				return value;
			}
		} else {
			// Else do the increment and decrement operation
			if (increase) {
				while (value <= minMax) {
					if (array[value].equals("")) {
						value++;
					} else {
						// Return value is not blank, else operate and continue
						return value;
					}
				}
			} else {
				while (value >= minMax) {
					if (array[value].equals("")) {
						value--;
					} else {
						// Return value is not blank, else operate and continue
						return value;
					}
				}
			}
		}
		return -1;

	}

}
