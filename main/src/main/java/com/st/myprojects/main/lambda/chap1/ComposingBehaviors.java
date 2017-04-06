/**
 * 
 */
package com.st.myprojects.main.lambda.chap1;

import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * @author sundeeptonse
 *
 */
public class ComposingBehaviors {

	public static void main(String... args) {
		comparatorComposition();
	}

	public static void comparatorComposition() {

		// A Simple Comparator using Anonymous classes, but you get stuck onto
		// the compareby X
		Comparator<Point> compByX = new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				return Double.compare(p1.getX(), p2.getX());
			}
		};

		// Using Lamda's
		Comparator<Point> compByX2 = (p1, p2) -> Double.compare(p1.getX(),
				p2.getX());

		// The above is simple, but it can simplified further by taking the
		// KeyExtractor
		// Get the KeyExtractor as a Function

		// Function of Type Point with a return value Double
		/*-
		 *{code}
		 *  Function<Point, Double> keyExtractorOrig = new Function<Point, Double>(){
		 *		public Double apply(Point p) {
		 *			return p.getX();
		 *		};
		 *	};
		 */

		Function<Point, Double> keyExtractor = (p) -> p.getX();
		Comparator<Double> keyComparer = (d1, d2) -> Double.compare(d1, d2);
		Comparator<Point> compareByXNew = (p1, p2) -> keyComparer.compare(
				keyExtractor.apply(p1), keyExtractor.apply(p2));

		// This can be reduced further by removing the Comparator<Double> and
		// using the Comparable
		Comparator<Point> compareByXNew2 = (p1, p2) -> keyExtractor.apply(p1)
				.compareTo(keyExtractor.apply(p2));

		// This can be reduced further by giving a method that accepts any Type
		// and it keyExtractor to give a Compartor
		Comparator<Point> compareByXNew3 = compare((p) -> p.getX());

		// This is also provided by Comparator
		Comparator<Point> compareByXNew4 = Comparator
				.comparing((p) -> p.getX());

		// Example to sort by distance by origin
		Comparator<Point> compareByXNew5 = Comparator.comparing((p) -> p
				.distance(0, 0));

		// Reversed
		Comparator<Point> compareByXNew6 = compareByXNew5.reversed();

		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
		intList.stream()
				.map(i -> new Point(i % 3, i / 3))
				.sorted(Comparator.comparing(p -> p.distance(0, 0)))
				.forEach(
						p -> System.out.printf("(%f, %f2)", p.getX(), p.getY()));

	}

	public static <T, R extends Comparable<R>> Comparator<T> compare(
			Function<T, R> keyExtractor) {
		return (c1, c2) -> keyExtractor.apply(c1).compareTo(
				keyExtractor.apply(c2));
	}
}
