/**
 * 
 */
package com.st.myprojects.main.datastructures.list.tree;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/*-
 * @author sundeeptonse
 * Find the Running Median
 * The median of a set of integers is the midpoint value of the data set for which an equal number of integers are less than and greater than the value. To find the median, you must first sort your set of integers in non-decreasing order, then:
 * If your set contains an odd number of elements, the median is the middle element of the sorted sample. In the sorted set ,  is the median.
 * If your set contains an even number of elements, the median is the average of the two middle elements of the sorted sample. In the sorted set ,  is the median.
 * Given an input stream of  integers, you must perform the following task for each  integer:

 * Add the  integer to a running list of integers.
 * Find the median of the updated list (i.e., for the first element through the  element).
 * Print the list's updated median on a new line. The printed value must be a double-precision number scaled to decimal place (i.e.,  format).
 * Input Format

 * The first line contains a single integer, , denoting the number of integers in the data stream. 
 * Each line  of the  subsequent lines contains an integer, , to be added to your list.

 * Constraints
 * Output Format
 * After each new integer is added to the list, print the list's updated median on a new line as a single double-precision number scaled to  decimal place (i.e.,  format).

 * Sample Input

 * 6
 * 12
 * 4
 * 5
 * 3
 * 8
 * 7
 * Sample Output

 * 12.0
 * 8.0
 * 5.0
 * 4.5
 * 5.0
 * 6.0
 * 
 */
public class RunningMedian {

	PriorityQueue<Integer> lowers;
	PriorityQueue<Integer> highers;

	RunningMedian() {
		// Max Heap with lower Set of Values
		lowers = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return -o1.compareTo(o2);
			};
		});

		// Min Heap with Higher Set of Values
		highers = new PriorityQueue<>();
	}

	/*-
	 * Add/Delete --> Add/Delete O(log n) + Order O(log n ) -> log(n)
	 * */

	public static void main(String... args) {

		// Get the Values
		Scanner input = new Scanner(System.in);
		int numberOfValues = input.nextInt();

		int[] inputArray = new int[numberOfValues];
		for (int i = 0; i < numberOfValues; i++) {
			inputArray[i] = input.nextInt();
		}
		input.close();

		// Print the Running Median
		RunningMedian rm = new RunningMedian();
		double[] medianArray = rm.getMedian(inputArray);
		for (double median : medianArray) {
			System.out.println(median);
		}

	}

	public double[] getMedian(int[] numbersArray) {
		double[] medianArray = new double[numbersArray.length];
		for (int i = 0; i < numbersArray.length; i++) {
			// Add Number to Priority Queue
			addNumber(numbersArray[i]);
			// Balance the Queue
			reBalance();
			// Get Median
			medianArray[i] = getMedian();
		}
		return medianArray;
	}

	public void addNumber(int number) {
		/*-
		 * If Number is lesser than the Biggest Number in the Lower Bucket, add to this bucket
		 * Else Add to the Highers Bucket
		 */
		if (lowers.size() == 0 || lowers.peek() > number) {
			lowers.add(number);
		} else {
			highers.add(number);
		}
	}

	public void reBalance() {

		/*-
		 * In the two buckets if the sizeDiff is > 1,then reorder
		 * Poll from the Bigger Queue and add to the smaller Queue
		 * */

		if (Math.abs(lowers.size() - highers.size()) > 1) {
			PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers
					: lowers;
			PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers
					: highers;
			smallerHeap.add(biggerHeap.poll());
		}

	}

	public double getMedian() {
		int compare = highers.size() - lowers.size();
		return compare == 0 ? ((double) highers.peek() + lowers.peek()) / 2
				: (compare > 0 ? highers.peek() : lowers.peek());
	}
}
