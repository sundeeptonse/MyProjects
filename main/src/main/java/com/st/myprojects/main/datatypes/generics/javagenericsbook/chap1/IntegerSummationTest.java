/**
 * 
 */
package com.st.myprojects.main.datatypes.generics.javagenericsbook.chap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.st.myprojects.main.util.DateUtil;
import com.st.myprojects.main.util.DateUtil.Time;

/**
 * @author sundeeptonse
 *
 */
public class IntegerSummationTest {

	private static int maxCount = 1000;

	public static void main(String... args) {
		List<Integer> intList = new ArrayList<>();

		Random random = new Random();
		System.out.println("MaxCount:" + maxCount);
		for (int i = 0; i < maxCount; i++) {
			intList.add(random.nextInt());
		}

		long time = System.nanoTime();
		sumInteger(intList);
		long integerTime = DateUtil.getTimeDifference(time, Time.ns);

		time = System.nanoTime();
		sumInt(intList);

		long intTime = DateUtil.getTimeDifference(time, Time.ns);

		System.out.println("integerTime is:" + integerTime);
		System.out.println("intTime is:" + intTime);
		System.out.println("Improvement is:" + integerTime / intTime);

		// Iterator Test
		System.out.println(intList.size());
		for (Iterator<Integer> it = intList.iterator(); it.hasNext();)
			if (it.next() < 1000)
				it.remove();

		System.out.println(intList.size());
		System.out.println(intList);

		
		Arrays.asList(new Integer[]{1,2});
		Arrays.asList(new String[]{"1","2"});
		

	}

	// Basic Sum - Contains Boxing + Unboxing, due to + opertor
	private static Integer sumInteger(List<Integer> intList) {
		Integer s = 0;

		// Unboxing + Boxing
		for (Integer n : intList)
			s += n;
		return s;
	}

	private static Integer sumInt(List<Integer> intList) {
		int s = 0;
		// UnBoxing
		for (int n : intList)
			s += n;
		return s;
	}


}
