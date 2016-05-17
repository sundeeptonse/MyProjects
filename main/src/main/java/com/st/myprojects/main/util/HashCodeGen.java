package com.st.myprojects.main.util;

import java.lang.reflect.Field;

/*-
 Create a int result and assign a non-zero value.
 For every field f tested in the equals() method, calculate a hash code c by:
 If the field f is a boolean: calculate (f ? 0 : 1);
 If the field f is a byte, char, short or int: calculate (int)f;
 If the field f is a long: calculate (int)(f ^ (f >>> 32));
 If the field f is a float: calculate Float.floatToIntBits(f);
 If the field f is a double: calculate Double.doubleToLongBits(f) and handle the return value like every long value;
 If the field f is an object: Use the result of the hashCode() method or 0 if f == null;
 If the field f is an array: see every field as separate element and calculate the hash value in a recursive fashion and combine the values as described next.
 */
public final class HashCodeGen {

	private HashCodeGen() {
	}

	private enum HASHCODECONSTANTS {
		MULTIPLIER(31), INITIALIZER(17);
		int value;

		private HASHCODECONSTANTS(int value) {
			this.value = value;
		}
	}

	public static <T> int hashCode(T object) {

		Class<?> mainClass = object.getClass();
		Field[] fieldArray = mainClass.getDeclaredFields();

		// Need to Sort by Type
		int hashCode = HASHCODECONSTANTS.INITIALIZER.value;

		for (Field field : fieldArray) {
			try {
				// Set Accessible
				field.setAccessible(true);

				// If Annotations are set , go ahead.
				// There must be a better way
				if (isValid(field)) {
					String name = field.getType().getName();
					Object value = field.get(object);
					hashCode = hashCode * HASHCODECONSTANTS.MULTIPLIER.value
							+ getHashCodeBasedonType(name, value);
				}
			} catch (IllegalAccessException iae) {
				iae.printStackTrace();
			}
		}
		return hashCode;
	}

	private static boolean isValid(Field field) {

		/*
		 * System.out.println(field.getAnnotations().length);
		 * Arrays.asList(field.getDeclaredAnnotations()).forEach( e ->
		 * System.out.println("Yola:" + e.annotationType().getCanonicalName()));
		 */

		if (field.isAnnotationPresent(Significant.class)) {
			return true;
		}
		return false;
	}

	private static int getHashCodeBasedonType(String name, Object object) {

		int hashCode = 0;
		// Need to make this better
		switch (name) {
		case "boolean":
			hashCode = getHashCode((boolean) object);
			return hashCode;
		case "byte":
			byte b = (byte) object;
			hashCode = getHashCode((int) b);
			return hashCode;
		case "char":
			char c = (char) object;
			hashCode = getHashCode((int) c);
			return hashCode;
		case "int":
			return getHashCode((int) object);
		case "short":
			short s = (short) object;
			hashCode = getHashCode((int) s);
			return hashCode;
		case "long":
			hashCode = getHashCode((long) object);
			return hashCode;
		case "double":
			hashCode = getHashCode((double) object);
			return hashCode;
		default:
			hashCode = getHashCode(object);
			return hashCode;
		}

	}

	private static int getHashCode(boolean value) {
		return value ? 1 : 0;
	}

	private static int getHashCode(int value) {
		return value;
	}

	private static int getHashCode(long value) {
		return (int) (value ^ value >>> 32);
	}

	private static int getHashCode(float value) {
		return Float.floatToIntBits(value);
	}

	private static int getHashCode(double value) {
		return getHashCode(Double.doubleToLongBits(value));
	}

	private static int getHashCode(Object value) {
		return value.hashCode();
	}

}
