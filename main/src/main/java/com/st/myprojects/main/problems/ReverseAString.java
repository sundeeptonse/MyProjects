/**
 * 
 */
package com.st.myprojects.main.problems;

import java.util.Stack;

/**
 * @author sundeeptonse
 *
 */
public class ReverseAString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = new String("Sundeep Tonse");

		System.out.println(str);
		System.out.println(ReverseAStringUsingArray.reverseAString(str));
		System.out.println(ReverseAStringUsingStack.reverseAString(str));

	}

	private static class ReverseAStringUsingArray {
		/*
		 * O(n)
		 */
		private static String reverseAString(String string) {
			String returnString;
			char[] charArray = string.toCharArray();
			int i = 0;
			int j = charArray.length - 1;
			while (i < j) {
				swap(charArray, i, j);
				i++;
				j--;
			}
			returnString = new String(charArray);
			return returnString;
		}

		public static void swap(char[] array, int index1, int index2) {
			char temp = array[index1];
			array[index1] = array[index2];
			array[index2] = temp;
		}
	}

	private static class ReverseAStringUsingStack {

		/*
		 * O(n)
		 */
		private static String reverseAString(String string) {
			String returnString;
			char[] charArray = string.toCharArray();

			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < charArray.length; i++) {
				stack.push(charArray[i]);
			}

			int j = 0;
			while (!stack.isEmpty()) {
				charArray[j] = stack.pop();
				j++;
			}
			returnString = new String(charArray);
			return returnString;
		}

	}

}
