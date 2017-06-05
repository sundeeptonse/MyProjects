/**
 * 
 */
package com.st.myprojects.main.lambda.chap2;

import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

/*-
 * @author sundeeptonse
 * 
 * When a lambda expression is simply a way of calling a named method of an existing class.
 * A better way of writing it may be just using the existing name
 * 
 * pointList.forEach(s-> System.out.println(s));
 * 
 * pointList.forEach(System.out::print);
 * 
 * Type
 * 
 * Name					Syntax					LamdaEquivalent
 * ------------------ 	----------------------	----------------------
 * Static				RefType::staticMethod	(args) -> RefTyoe.staticMethod(args);
 * Bound Instance		expr::instMethod		(args) -> expr.instMethod(args);
 * Unbound Instance		RefType::instMethod		(arg0,rest) -> arg0.instMethod(rest);
 * Constructor			ClsName::new			(args) -> new ClsName(args);
 *
 *
 *Problem is method with Parameter where you want to be explicit
 */
public class MethodReferences {

	public static void main(String... args) {
		List<Point> list = new ArrayList<>();
		list.forEach(s -> System.out.println(s));
		// Or
		list.forEach(System.out::println);
		staticMethodReferences();
		instanceMethodReferences();
		constructorReferences();

	}

	public static void constructorReferences() {

		// Example - These are also function
		// ArrayList::new
		// File::new

		Stream<String> stringStream = Stream.of("a.txt", "b.txt", "c.txt");
		// Orig
		Stream<File> stream = stringStream.map(f -> new File(f));
		// New
		Stream<File> stream2 = stringStream.map(File::new);

	}

	// Bound and Unbound
	// Unbound - RefType::instMethod
	// Bound - exp::instMethod --> Same Receiver

	public static void instanceMethodReferences() {

		// Unbound --> Different receiver hence we don't hard code the Object
		// Unbound Instance RefType::instMethod (arg0,rest) ->
		// arg0.instMethod(rest);
		Comparator<Point> pComp = Comparator.comparing(p -> p.getX());
		// RefType::instMethod --> point.getX();
		Comparator<Point> pComp2 = Comparator.comparing(Point::getX);

		// Differences -- Bound
		Map<String, String> map = new TreeMap<>();
		map.put("Alpha", "X");
		map.put("Bravo", "Y");
		map.put("Charlie", "C");

		System.out.println("Map:" + map);
		String str = "Alpha-Bravo-Charlie";
		// String replace , replacing the string with the value which matches
		// the first value and returns its
		// First Iteration alpha with x, bravo with y , charlie with c.
		map.replaceAll(str::replace);
		System.out.println("Map:" + map);

		// Unbound
		Map<String, String> map2 = new TreeMap<>();
		map2.put("Alpha", "X");
		map2.put("Bravo", "Y");
		map2.put("Charlie", "C");
		System.out.println("Map2:" + map2);

		// Strange to be using a one argument instance method
		// But going back to the equivalent in lambda
		// (arg0,rest) -> arg0.instMethod(rest);
		// which is key.concat(value) in this case

		// map.replaceAll((k, v) -> k.concat(v));
		// OR
		map2.replaceAll(String::concat);
		System.out.println("Map2:" + map2);

	}

	// Also similar to Bound --> Same receiver
	public static void staticMethodReferences() {
		// Example -
		// String::valueOf
		// Integer::compare

		// Example --> Multiple Variables
		Comparator<Integer> cc = (x, y) ->
		{
			return -Integer.compareUnsigned(x, y);
		};
		Integer[] array = { 1, 3, 4, 5, -1, 0, 4 };
		Arrays.sort(array, (x, y) -> Integer.compareUnsigned(x, y));

		Arrays.sort(array, (x, y) -> -Integer.compareUnsigned(x, y));
		Arrays.sort(array, Integer::compareUnsigned);
		Arrays.sort(array, Integer::compare);

		// Negation
		Arrays.sort(array, (x, y) -> -Integer.compareUnsigned(x, y));
		Arrays.sort(array, (x, y) ->
		{
			return -Integer.compareUnsigned(x, y);
		});
		// Not Possible
		// Arrays.sort(array, -Integer::compareUnsigned);

	}
}
