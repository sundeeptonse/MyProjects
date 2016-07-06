/**
 * 
 */
package com.st.myprojects.main.datatypes.enumt;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author sundeeptonse
 *
 */
public class ExtensibleEnum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double x = 10;
		double y = 20;

		System.out.println("------------------------------------------------------");
		
		test(BasicOperation.class, x, y);
		test(ExtendedOperation.class, x, y);
		System.out.println("------------------------------------------------------");

		test2(Arrays.asList(BasicOperation.values()), x, y);
		test2(Arrays.asList(ExtendedOperation.values()), x, y);
		
		System.out.println("------------------------------------------------------");

	}

	// **T is of Type MyOperation
	private static <T extends Enum<T> & MyOperation> void test(Class<T> opSet,
			double x, double y) {
		for (T op : opSet.getEnumConstants()) {
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
		}

	}

	// **T is of Type MyOperation
	private static void test2(Collection<? extends MyOperation> opSet,
			double x, double y) {
		for (MyOperation op : opSet) {
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
		}
	}
}

interface MyOperation {
	double apply(double x, double y);
}

enum BasicOperation implements MyOperation {
	PLUS("+") {
		public double apply(double x, double y) {
			return x + y;
		}
	},
	MINUS("-") {
		public double apply(double x, double y) {
			return x - y;
		}
	};

	final String symbol;

	/**
	 * 
	 */
	private BasicOperation(String symbol) {
		this.symbol = symbol;
	}
}

enum ExtendedOperation implements MyOperation {
	EXP("^") {
		public double apply(double x, double y) {
			return Math.pow(x, y);
		}
	};

	final String symbol;

	/**
	 * 
	 */
	private ExtendedOperation(String symbol) {
		this.symbol = symbol;
	}
}