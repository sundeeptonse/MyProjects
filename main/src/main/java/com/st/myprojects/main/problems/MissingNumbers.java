/**
 * 
 */
package com.st.myprojects.main.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author sundeeptonse
 * 
 *         Numeros, the Artist, had two lists and , such that was a permutation
 *         of . Numeros was very proud of these lists. Unfortunately, while
 *         transporting them from one exhibition to another, some numbers were
 *         left out of . Can you find the missing numbers?
 * 
 *         Notes
 * 
 *         If a number occurs multiple times in the lists, you must ensure that
 *         the frequency of that number in both lists is the same. If that is
 *         not the case, then it is also a missing number. You have to print all
 *         the missing numbers in ascending order. Print each missing number
 *         once, even if it is missing multiple times. The difference between
 *         maximum and minimum number in is less than or equal to . Input Format
 * 
 *         There will be four lines of input:
 * 
 *         - the size of the first list This is followed by space-separated
 *         integers that make up the first list. - the size of the second list
 *         This is followed by space-separated integers that make up the second
 *         list.
 * 
 *         Constraints
 * 
 *         Output Format
 * 
 *         Output the missing numbers in ascending order.
 * 
 *         Sample Input
 * 
 *         10 203 204 205 206 207 208 203 204 205 206 13 203 204 204 205 206 207
 *         205 208 203 206 205 206 204 Sample Output
 * 
 *         204 205 206 Explanation
 * 
 *         is present in both arrays. Its frequency in is , while its frequency
 *         in is . Similarly, and occur twice in , but thrice in . So, these
 *         three numbers are our output. The rest of the numbers have thesame
 *         frequency in both lists.
 *
 */
public class MissingNumbers {
	public static void main(String[] args) {
		MissingNumbers.start();
	}

	public static void start() {

		Scanner input = new Scanner(System.in).useDelimiter("\\n");
		int array1Size = input.nextInt();

		String line = input.next();
		int[] arrayInt1 = StringtoIntArray(line.split(" "));

		int array2Size = input.nextInt();
		line = input.next();
		int[] arrayInt2 = StringtoIntArray(line.split(" "));
		input.close();

		findMissingNumbers(arrayInt1, arrayInt2);

	}

	public static int[] StringtoIntArray(String[] array) {
		int[] intArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			intArray[i] = Integer.parseInt(array[i]);
		}
		return intArray;
	}

	public static void findMissingNumbers(int[] array1, int[] array2) {
		Map<Integer, Integer> numberCount = new HashMap<>();
		int[] largerArray = array1;
		int[] smallerArray = array2;
		int diff = array1.length - array2.length;
		if (diff < 0) {
			largerArray = array2;
			smallerArray = array1;
		}
		// Get the Absolute Difference, this will tell the count of the Numbers
		// Missing
		diff = Math.abs(diff);

		int i = 0;
		for (; i < smallerArray.length; i++) {
			increaseCount(numberCount, smallerArray[i]);
			decreaseCount(numberCount, largerArray[i]);
		}
		for (; i < largerArray.length;) {
			decreaseCount(numberCount, largerArray[i++]);
		}

		StringBuilder str = new StringBuilder();
		List<Integer> numberList = new ArrayList<>();
		for (Integer key : numberCount.keySet()) {
			if (numberCount.get(key) < 0) {
				numberList.add(key);
			}
		}
		Collections.sort(numberList);

		for (Integer number : numberList)
			str.append(number).append(" ");
		System.out.println(str);

	}

	public static void increaseCount(Map<Integer, Integer> map, Integer number) {
		Integer count = map.get(number);
		if (count == null) {
			count = new Integer(0);
		}
		count++;
		// System.out.println("Increasing Count For Number:" + number +
		// ":Count:" + count);
		map.put(number, count);
	}

	public static void decreaseCount(Map<Integer, Integer> map, Integer number) {
		Integer count = map.get(number);
		if (count == null) {
			count = new Integer(0);
		}
		count--;
		// System.out.println("Decreasing Count For Number:" + number +
		// ":Count:" + count);
		map.put(number, count);
	}
}
