/**
 * 
 */
package com.st.myprojects.main.lambda.chap1;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/*-
 * @author sundeeptonse
 * 
 * Streams represent a way to give  "Data in motion", only providing the data when it is needed
 * This avoids the need of storage.
 * Can be optionally ordered 
 * 
 * Can be imagined as an Iterator with only next and when no more values are present
 * 
 * Stream type
 * 	--> Stream --> Reference Values
 *  --> IntStream
 *  --> LongStream
 *  --> DoubleStream
 *
 */
public class StreamsIntro {

	public static void main(String... args) {
		mapExample();
	}

	/*
	 * From Collections to Streams
	 * Only Collections can be streamed 
	 * */
	public static void mapExample() {
		
		// Finds the Max amongst points
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
		
		List<Point> pointList = new ArrayList<>();
		for (Integer i : intList) {
			pointList.add(new Point(i % 3, i / 3));
		}

		double maxDistance = Double.MIN_VALUE;
		for (Point p : pointList) {
			maxDistance = Math.max(p.distance(0, 0), maxDistance);
		}
		System.out.println(maxDistance);

		// The above can be reduced using a Map Operation
		Stream<Integer> intStream = intList.stream();
		Stream<Point> points = intStream.map(i -> new Point(i % 3, i / 3));
		DoubleStream distances = points.mapToDouble(p -> p.distance(0, 0));
		OptionalDouble maxDistance1 = distances.max();

		System.out.println(maxDistance1);

		// Or
		// These are also known as pipelines
		OptionalDouble maxDistance2 = intList.stream()
				.map(i -> new Point(i % 3, i / 3))
				.mapToDouble(p -> p.distance(0, 0)).max();

		System.out.println(maxDistance2);

		// If we want to make use of parallel processing using Fork Join form
		// Java 1.8
		OptionalDouble maxDistance3 = intList.parallelStream()
				.map(i -> new Point(i % 3, i / 3))
				.mapToDouble(p -> p.distance(0, 0)).max();

		System.out.println(maxDistance3);

	}

}
