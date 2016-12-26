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
