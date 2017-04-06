/**
 * 
 */
package com.st.myprojects.main.lambda.chap3;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*-
 * @author sundeeptonse
 *
 */
public class StreamsFundamentals {

	public static void main(String... args) {
		boxingExamples();
	}

	public static void boxingExamples() {
		// For non Collection Source
		DoubleStream.iterate(1, i -> Math.pow(i, 2)).limit(10)
				.forEach(System.out::println);
		// Primitive Streams
		Optional<Integer> max = Arrays.asList(1, 2, 3, 4, 5).stream()
				.map(i -> i + 1).max(Integer::compareTo);
		System.out.println("max:" + max);

		OptionalInt max2 = IntStream.rangeClosed(1, 5).map(i -> i + 1).max();
		System.out.println("max2:" + max2);

		// To Convert to DoubleStream
		OptionalDouble max3 = IntStream.rangeClosed(1, 5).asDoubleStream()
				.map(i -> Math.pow(i * 5, 2)).max();
		System.out.println("max3:" + max3);

		// For Boxing
		Stream<Integer> is = IntStream.rangeClosed(1, 10).boxed();

		// For UnBoxing
		Stream<Integer> integerStream = Stream.of(1, 2);
		
		IntStream intStream = integerStream.mapToInt(Integer::intValue);
		intStream.forEach(System.out::println);
	}

}
