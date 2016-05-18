package com.st.myprojects.main.object;

import java.util.HashMap;
import java.util.Map;

public class Equal {

	private static Map<? super Object, String> testMap = new HashMap<>();

	public static void main(String... args) throws Throwable {

		testMap.put(new PointWOHashCode(10, 11), "111");
		System.out.println(testMap.get(new PointWOHashCode(10, 11)));

		/*
		 * testMap.put(new PointWithHashCode(10, 11), "2222");
		 * System.out.println(testMap.get(new PointWithHashCode(10, 11)));
		 * 
		 * System.out.println(new PointWithHashCode(10, 11).hashCode());
		 * System.out.println(new PointWithHashCode(10, 11).hashCode());
		 * System.out.println(new PointWithHashCode(10, 11).hashCode());
		 * System.out.println(new PointWithHashCode(10, 12).hashCode());
		 */

		System.out.println(new PointWithHashCode(10, 12).hashCode());

		System.out.println("Test:" + new PointWithHashCode(10, 12));

	}

}

/*-
 * Relfexive : An Object must be equal to itself. 
 * Symmetry : If an Object is
 * equal to another Object, the Other Object must be equal to the Object
 * Transivity : 1st object is equal to 2nd, 2nd equal to 3rd , then 3rd equals the first
 * Consistency : Should be same, unless the Significant bits are changed
 * Non-Nullity : Unequal to null
 * 
 * Others:
 * Always Override : hashCode when you override equals 
 */

class PointWOHashCode {
	private final int x;
	private final int y;

	public PointWOHashCode(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof PointWOHashCode)) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		PointWOHashCode point = (PointWOHashCode) obj;
		return (this.x == point.x) && (this.y == point.y);
	}

}

class PointWithHashCode {

	//Set Significant
	private final int x;
	private final int y;
	private boolean booleanValue = false;

	private byte byteValue = 1;
	private short shortValue = 2;
	private char charValue = 'C';

	private long longValue = 44444444;
	private double doubleValue = 44444444444444444.4d;
	private float floatValue = 1.1f;
	private Object objValue = new Object();
	private int[] arrInt = { 0, 1, 0 };

	private HashMap<?, ?> map = new HashMap<>();

	public PointWithHashCode(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof PointWithHashCode)) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		PointWithHashCode point = (PointWithHashCode) obj;
		return (this.x == point.x) && (this.y == point.y);
	}

	/*
	 * Bad HashCode function
	 */
	/*
	 * @Override public int hashCode() { return 42; }
	 */

	@Override
	public int hashCode() {
		// return HashCodeGen.hashCode(this);
		return 42;
	}

	@Override
	public String toString() {
		return String.format("(%03d) %03d-%04d", 224, 829, 5061);
	}

}