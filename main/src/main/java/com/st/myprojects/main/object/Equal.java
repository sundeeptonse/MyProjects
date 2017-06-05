package com.st.myprojects.main.object;

import java.util.Arrays;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PointWithHashCode other = (PointWithHashCode) obj;
		if (!Arrays.equals(arrInt, other.arrInt))
			return false;
		if (booleanValue != other.booleanValue)
			return false;
		if (byteValue != other.byteValue)
			return false;
		if (charValue != other.charValue)
			return false;
		if (Double.doubleToLongBits(doubleValue) != Double
				.doubleToLongBits(other.doubleValue))
			return false;
		if (Float.floatToIntBits(floatValue) != Float
				.floatToIntBits(other.floatValue))
			return false;
		if (longValue != other.longValue)
			return false;
		if (map == null) {
			if (other.map != null)
				return false;
		} else if (!map.equals(other.map))
			return false;
		if (objValue == null) {
			if (other.objValue != null)
				return false;
		} else if (!objValue.equals(other.objValue))
			return false;
		if (shortValue != other.shortValue)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	/*
	 * Bad HashCode function
	 */
	/*
	 * @Override public int hashCode() { return 42; }
	 */

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(arrInt);
		result = prime * result + (booleanValue ? 1231 : 1237);
		result = prime * result + byteValue;
		result = prime * result + charValue;
		long temp;
		temp = Double.doubleToLongBits(doubleValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(floatValue);
		result = prime * result + (int) (longValue ^ (longValue >>> 32));
		result = prime * result + ((map == null) ? 0 : map.hashCode());
		result = prime * result
				+ ((objValue == null) ? 0 : objValue.hashCode());
		result = prime * result + shortValue;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public String toString() {
		return String.format("(%03d) %03d-%04d", 224, 829, 5061);
	}

}