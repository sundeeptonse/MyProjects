/**
 * 
 */
package com.st.myprojects.main.lambda.chap1;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author sundeeptonse
 *
 */
public class InternalIteration {
	public static void main(String... args) {

		/*
		 * W/O Consumer
		 */
		InternalIterationWOConsumer.PointArrayList pointArrayList = new InternalIterationWOConsumer.PointArrayList();
		pointArrayList.add(new Point(1, 1));
		pointArrayList.add(new Point(1, 2));
		pointArrayList.add(new Point(3, 2));
		pointArrayList
				.forEach(new InternalIterationWOConsumer.TranslateByOne());
		System.out.println("W/O Consumer:" + pointArrayList);

		/*
		 * With Consumer, since we need to provide Object References, we need to
		 * add this. But we only need the method behavior
		 */
		List<Point> pointList = new ArrayList<>();
		pointList.add(new Point(1, 1));
		pointList.add(new Point(1, 2));
		pointList.add(new Point(3, 2));
		pointList.forEach(new InternalIterationConsumer.TranslateByOne());
		System.out.println("Consumer:" + pointList);

		/*
		 * With Consumer Anonymous Classes
		 */
		pointList.forEach(new Consumer<Point>() {
			public void accept(Point t) {
				t.translate(1, 1);
			}
		});

		/*-
		 * With Lamba Expressions
		 * 
		 * To reduce the verbosity of the above call, we should identify those places where we the compiler can infer
		 * eg: 1) forEach only takes in Consumer
		 *     2) It can also infer the method, since Consumer has only one method, which is public
		 *        --> Known as "One Method Interface" Pattern, also known as a Functional Interface or a SAM interface
		 *      3) Type of Consumer, can be inferred from the type of List it is  i.e List<Point> 
		 */
		pointList.forEach(p -> p.translate(1, 1));
		System.out.println("Lambda:" + pointList);

		// Additional
		// Type Casting
		pointList.forEach((Point p) -> p.translate(1, 1));

		// For each Multiple Lines, can be used with or without typecasting
		pointList.forEach(p ->
		{
			int i = 3;
			while (i-- < 0) {
				System.out.println(p);
			}
		});

		// Print p
		pointList.forEach(p -> System.out.println(p));
		// Print p for static variable or static method
		pointList.forEach(System.out::println);

		// :: Operator --> Removes the brackets for any method and Infer the
		// value from the Collection Type
		// For Static
		System.out.println("Static");
		pointList.forEach(TestPrint::print);

		// For Non Static
		System.out.println("Non Static");
		pointList.forEach(new TestPrint()::printInstance);
		

	}
}

class TestPrint {
	public static void print(Object o) {
		System.out.println(o);
	}

	public void printInstance(Object o) {
		System.out.println(o);
	}
	
	public void printInstance2(Object o, int value) {
		System.out.println(o);
	}

}

class InternalIterationConsumer {
	public static class TranslateByOne implements Consumer<Point> {
		@Override
		public void accept(Point t) {
			t.translate(1, 1);
		}
	}
}

/*
 * Here we are creating our own Command Interface and defining our forEach to
 * have use this command Interface
 */
class InternalIterationWOConsumer {

	/*
	 * Example of creating a for Each
	 */
	@SuppressWarnings("serial")
	public static class PointArrayList extends ArrayList<Point> {
		public void forEach(PointAction t) {
			for (Point p : this) {
				t.doForPoint(p);
			}
		}
	}

	/*
	 * Defining the Command Interface
	 */
	public interface PointAction {
		void doForPoint(Point p);
	}

	public static class TranslateByOne implements PointAction {
		@Override
		public void doForPoint(Point p) {
			p.translate(1, 1);
		}
	}

}
