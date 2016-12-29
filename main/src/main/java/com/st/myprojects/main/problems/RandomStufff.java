/**
 * 
 */
package com.st.myprojects.main.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author sundeeptonse
 *
 */
public class RandomStufff {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String value = "abcdefghijklmnop";
		int sum = 0;
		for (int i = 0; i < value.length(); i++) {
			char c = value.charAt(i);
			int cI = (int)c;
			System.out.println("c:" + c +":i:" + cI);
		}
		
		char c ='\u0030';
		System.out.println(c);
		
		c ='a';
		int value2 = Character.getNumericValue(c);
		
		System.out.println("value2:" + value2 + ":"  + (int)c);
		c ='A';
		System.out.println("value2:" + value2 + ":"  + (int)c);
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
