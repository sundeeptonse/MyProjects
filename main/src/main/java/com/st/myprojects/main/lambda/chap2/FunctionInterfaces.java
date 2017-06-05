/**
 * 
 */
package com.st.myprojects.main.lambda.chap2;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/*-
 * @author sundeeptonse
 * 
 *  Function Type -> The one that gives the name
 *  
 *  Example: List<E>.replaceAll(UnaryOperator<E>)
 *  pointList.replaceAll((Point p) -> new Point(p));
 *  	--> Target Typing --> Provide enough information for Type Inference
 *  
 *  The Lambda has to match UnaryOperator<Point>, which is of type method
 *  public Point apply(Point p); 
 *  
 *  4 Basic Type of Functional Interfaces from which ~40 types are defined in java.util.function 
 *  Interface           Args   Returns  UseCase									Example
 *	Consumer<T>          T     void     Using Objects  							s-> System.out.println(s);
 *  Predicate<T>         T     bool     Filtering Values						s -> s.isEmpty()
 *  Supplier<T>          none  T        Factory Methods    						() -> new String();
 *  Function<T, U>       T     U        Transforming or Selecting from Objects  s -> new Integer(s);
 *  
 *  Derived from these are specializations
 *  --> LongFunction<R>
 *  --> BiConsumer, BiFunction
 *  --> SameType Function --> UnaryOperator<T>
 *    
 *  The lib is a starter kit and can be used for most FucntionalInterfaces
 *  Good Practice to annotate with @FunctionalInterface --> JVM Checks for one abstract method
 *  --> Does it have to be an interface  to be used as a lambda 
 *  	--> Yes, you have to use FunctionalInterface to use Lambda
 *
 */
public class FunctionInterfaces {
	public static void main(String... args) {
		List<Point> list = new ArrayList<Point>();
		list.replaceAll(p -> new Point(p));

		// OR

		// list.replaceAll(new UnaryOperator<Point>() {
		// public Point apply(Point p) {
		// return new Point((int) p.getX() * 2, (int) p.getY() * 2);
		// }
		// });
	}
}

class AbstractClassTest {

	public void testClass() {
		Test<Integer> x = t -> System.out.println(t);
	}

	@FunctionalInterface
	interface Test<T> {
		abstract void accept(T t);
	}
}

@FunctionalInterface
interface Test<T> {
	boolean equals(Object obj);

	int compare(T o1, T o2);

	default void reversed() {
		System.out.println("Test");
	}
	
}

@FunctionalInterface
interface UnaryOperator2<T> extends Function<T, T> {
	static <T> UnaryOperator2<T> identity() {
		return new UnaryOperator2<T>() {
			@Override
			public T apply(T t) {
				return t;
			}
		};
	};

	// OR --> Which is what the UnaryOperator does
	static <T> UnaryOperator2<T> identity2() {
		return t -> t;
	};
}
