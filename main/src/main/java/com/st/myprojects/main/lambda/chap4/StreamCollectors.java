/**
 * 
 */
package com.st.myprojects.main.lambda.chap4;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.*;

/*-
 * @author sundeeptonse
 *
 *
 * 
 */
public class StreamCollectors {

	public static void main(String... args) {

		List<Point> list = new ArrayList<>();
		list.stream().collect(groupingBy((p) -> p.getX()));

	}
}
