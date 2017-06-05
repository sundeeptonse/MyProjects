/**
 * 
 */
package com.st.myprojects.main.datastructures.custom;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

/**
 * @author sundeeptonse
 *
 */
public class TestClass {

	private static Comparator<Integer> descendingComparator2 = Collections
			.reverseOrder();

	public static void main(String... args) throws FileNotFoundException {
		System.setOut(new PrintStream(
				"/Users/sundeeptonse/Desktop/output-file.txt"));
		Set<Integer> fixedTreeSet = new TreeSetFixed<>(10,
				descendingComparator2);
		int i = 100;
		while (i-- > 0) {
			int random = (int) (Math.random() * 100);
			System.out.println(i + ":" + random);
			fixedTreeSet.add(random);
		}
	}
}
