package com.st.myprojects.main.streams;

import java.util.Arrays;
import java.util.List;

public class StreamsBasic {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

		// Without Streams
		int result = 0;
		for (Integer i : list) {
			if (i % 2 == 0) {
				result += i * 2;
			}
		}
		System.out.println("Result is:" + result);

		// With Streams
		int result2 = list.stream().filter(e -> e % 2 == 0)
				.mapToInt(e -> e * 2).sum();

		System.out.println("Result is:" + result2);

	}
}
