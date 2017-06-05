package com.st.myprojects.main.streams;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

		int result = 0;
		for (Integer i : list) {
			if (i % 2 == 0) {
				result += i;
			}
		}

		System.out.println("Result is:" + result);
		
		

	}

}
