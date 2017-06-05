/**
 * 
 */
package com.st.myprojects.main.datatypes.generics.javagenericsbook.chap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author sundeeptonse Covers ? extends E and ? super E, E and ? examples
 * 
 *         Get Extends, Put Super
 */

public class WildCards {

	public static void main(String... args) {

		List<Number> nums = new ArrayList<Number>();
		List<Integer> ints = Arrays.asList(1, 2);
		List<Double> dbls = Arrays.asList(2.4, 2.6);

		List<Object> objs = Arrays.asList(new Integer(2), new Integer(2));
		// This is allowed since, ? extends Number
		// public boolean addAll(Collection<? extends E> c)
		nums.addAll(ints);
		nums.addAll(dbls);

		// This is allowed due to the same reason
		// This will allow anything that extends Number like Integer etc
		List<? extends Number> eNums = ints;

		List<? super Number> sNumber = objs;
		List<?> sNumber2 = objs;
		List<Number> sNumber3 = nums;

		// Doesn't allow
		// eNums = objs;

		/**
		 * Super Test
		 * */
		List<Object> obj = Arrays.<Object> asList(2, 3.14, "four");
		List<Integer> ints2 = Arrays.asList(5, 6);
		WildCards.copy(obj, ints2);
		System.out.println("Obj::" + obj);

		obj = Arrays.<Object> asList(2, 3.14, "four");
		WildCards.<Object> copy(obj, ints2);
		System.out.println("Obj::" + obj);

		obj = Arrays.<Object> asList(2, 3.14, "four");
		WildCards.<Number> copy(obj, ints2);
		System.out.println("Obj::" + obj);

		obj = Arrays.<Object> asList(2, 3.14, "four");
		WildCards.<Integer> copy(obj, ints2);
		System.out.println("Obj::" + obj);

	}

	/**
	 * Get/Put Principle Get Extends , Put Super If both then Type has be T If
	 * none then ?
	 * */
	public static <T> void copy(List<? super T> dst, List<? extends T> src) {
		System.out.println("DST:" + dst.get(0).getClass());
		System.out.println("SRC:" + src.get(0).getClass());
		for (int i = 0; i < src.size(); i++) {
			dst.set(i, src.get(i));
		}
	}

	public static double sum(Collection<? extends Number> nums) {
		double s = 0.0;
		for (Number num : nums)
			s += num.doubleValue();
		return s;
	}

	public static double sum2(Collection<?> nums) {
		double s = 0.0;
		for (Object num : nums)
			System.out.println(num);
		return s;
	}

}
