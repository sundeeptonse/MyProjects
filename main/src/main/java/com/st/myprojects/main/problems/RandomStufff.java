/**
 * 
 */
package com.st.myprojects.main.problems;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * @author sundeeptonse
 *
 */
public class RandomStufff {

	public static int test() {
		Math.max(10, 20);
		return Integer.MIN_VALUE;

	}

	private static Comparator<Integer> comparator = new Comparator<Integer>() {
		public int compare(Integer o1, Integer o2) {
			return -o1.compareTo(o2);
		}
	};

	private static Comparator<Integer> comparator2 = Collections.reverseOrder();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();
		stack.add(null);

		System.out.println(stack);

		Map<Integer[], Integer> map = new HashMap<>();

		Set<Integer> set = new TreeSet<>();

		Set<Character> set2 = new HashSet<>();
		int n = 3;
		while (n-- > 1) {
		}
		int[] array = { 3, 2, 3 };
		majorityElement(array);

		List list = new ArrayList<>();
		Collections.sort(list);
		BigInteger bi = new BigInteger(Integer.MAX_VALUE * Integer.MAX_VALUE
				+ "");
		System.out.println(bi.toString());

		System.out.println("Avail Processors:"
				+ Runtime.getRuntime().availableProcessors());

		String value = "abcdefghijklmnop";
		int sum = 0;
		for (int i = 0; i < value.length(); i++) {
			char c = value.charAt(i);
			int cI = (int) c;
			System.out.println("c:" + c + ":i:" + cI);
		}

		char c = '\u0030';
		System.out.println(c);

		c = 'a';
		int value2 = Character.getNumericValue(c);

		System.out.println("value2:" + value2 + ":" + (int) c);
		c = 'A';
		System.out.println("value2:" + value2 + ":" + (int) c);

		int size = 0;
		int currentCount = ++size;
		System.out.println("Size:" + size);
		System.out.println("Current:" + currentCount);

		System.out.println("------");

		String[] arr = new String[4];
		arr[0] = "56.6";
		arr[1] = "0000.0000";
		arr[2] = "02.34";
		arr[3] = "2.34";
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return -new BigDecimal(o1).compareTo(new BigDecimal(o2));
			}
		});

	}

	public static List<Integer> majorityElement(int[] nums) {
		Set<Integer> set = new HashSet<>();
		Map<Integer, Integer> numCount = new HashMap<>();
		for (int num : nums) {
			Integer count = numCount.get(num);
			if (count == null) {
				count = 0;
			}
			count++;
			if (count > nums.length / 3) {
				set.add(num);
			}
			numCount.put(num, count);
		}
		System.out.println("Set:" + set);
		return new ArrayList<>(set);
	}

	public static void old() {
		String s = null;
		s.length();
		System.out.println("ab".compareTo("ba"));
		System.out.println("aaa".compareTo("bbb"));

		System.out.println(2306996 & (15));
		Object object = new Object();
		int i;

		int y = (i = object.hashCode());
		System.out.println("y:" + y + ":i:" + i);
		int v = i >>> 16;
		System.out.println(v);
		System.out.println("i^i:" + (v >>> 16));

		System.out.println(65536 >>> 16);

		int value = object == null ? 0 : (i = object.hashCode()) ^ i >>> 16;
		System.out.println("Value:" + value);

		List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		System.out.println(integerList);
		Collections.shuffle(integerList);
		System.out.println(integerList);

		Collections.shuffle(integerList);
		System.out.println(integerList);

		Collections.sort(integerList);
		System.out.println(integerList);

	}
}
