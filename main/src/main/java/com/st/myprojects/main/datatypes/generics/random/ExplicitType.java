/**
 * 
 */
package com.st.myprojects.main.datatypes.generics.random;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sundeeptonse
 *
 */
public class ExplicitType {

	public static void main(String... args) {

		Set<Integer> integerSet = new HashSet<>();
		integerSet.add(1);
		integerSet.add(2);

		Set<Double> doubleSet = new HashSet<>();
		doubleSet.add(1.1);
		doubleSet.add(2.2);

		// Set<Number> finalSet = MySetMethods.union(integerSet, doubleSet);

		// Explicit Type - Even w/o it compiles - May be JDK Version ?
		Set<Number> finalSet = MySetMethods.<Number> union2(integerSet,
				doubleSet);
		for (Number number : finalSet) {
			System.out.println("Number:" + number);
		}
		
		
		List<String> stringList = new ArrayList<>();
		MyTest.blah(stringList);
		
		MyTest.blah2(stringList);
		
		
	}

}

class MySetMethods {

	public static <E> Set<E> union(Set<E> set1, Set<E> set2) {
		Set<E> result = new HashSet<E>(set1);
		result.addAll(set2);
		return result;
	}

	public static <E> Set<E> union2(Set<? extends E> set1, Set<? extends E> set2) {
		Set<E> result = new HashSet<E>(set1);
		result.addAll(set2);
		return result;
	}

}

/*
 * Unbounded Type vs WildCard
 */
class MyTest {

	public static <E> void blah(List<E> myBlah) {
		for (E e : myBlah)
			System.out.println("E" + e);
	}

	public static void blah2(List<?> myBlah) {
		// Pass it along to the more typeSafe Container
		blah(myBlah);
	}

}
