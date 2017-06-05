/**
 * 
 */
package com.st.myprojects.main.problems;

/**
 * @author sundeeptonse
 * 
 *         There are two sorted arrays nums1 and nums2 of size m and n
 *         respectively.
 * 
 *         Find the median of the two sorted arrays. The overall run time
 *         complexity should be O(log (m+n)).
 *
 */
public class MedianOfSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double median = 0;
		return median;
	}

	public double findMedianSortedArrays(int[] smallerArray, int sStart,
			int sEnd, int[] largerArray, int lStart, int lEnd) {
		int sArraySize = sEnd - sStart + 1;
		int lArraySize = lEnd - lStart + 1;
		int totalSize = sArraySize + lArraySize;
		if (totalSize <= 2) {
			double median = 0;
			if (totalSize == 2) {
				// Either the Larger Array is of size 2 or both are equal
				if (lArraySize == 2) {
					median = ((double) largerArray[lEnd] + largerArray[lStart]) / 2;
				} else {
					median = ((double) largerArray[lStart] + smallerArray[sStart]) / 2;
				}
			} else if (totalSize == 1) {
				median = largerArray[lEnd];
			}
			return median;
		} else {
			// Example 3 elements remaining, we have to remove , 2 elements
			// which is 3/2 = 1.5 --> 2
			int numberOfElementsToRemove = (int) Math.ceil(totalSize / 2);
			int indexMidL = (lStart + lEnd) / 2;

			int counter = numberOfElementsToRemove / 2;
			// Remove all numberOfElementsToRemove/2 <= indexMidL
			while (counter > 0) {
				if (largerArray[lStart] < smallerArray[sStart]) {
					lStart++;
				} else {
					sStart++;
				}
				counter--;
			}

			counter = numberOfElementsToRemove / 2;
			// Remove all numberOfElementsToRemove/2 > indexMidL

			while (counter > 0) {
				if (largerArray[lEnd] > smallerArray[sEnd]) {
					lEnd--;
				} else {
					sEnd--;
				}
				counter--;
			}

			
			return findMedianSortedArrays(smallerArray, sStart, sEnd,
					largerArray, lStart, lEnd);
		}
	}
}
