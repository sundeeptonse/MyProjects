/**
 * 
 */
package com.st.myprojects.main.datatypes.rest;

import java.util.Arrays;

import com.st.myprojects.main.util.StringUtil;

/*-
 * @author sundeeptonse
 *
 *        Own Implementation of a StringBuilder class
 *
 */
public class StringBuilder{


	public static void main(String... args) {

		StringBuilder str = new StringBuilder("");
		str.append("Sundeep").append("Tonse").append("Apple")
				.append("Get Creative");

		System.out.println(str.toString());
	}

	private char[] value;
	private final int defaultInitialSize = 16;
	private final int defaultGrowthFactor = 2;
	private int size = 0;

	/*-
	 * 
	 */
	public StringBuilder() {
		this.value = new char[defaultInitialSize];
	}

	public StringBuilder(int size) {
		this.value = new char[size];
	}

	/*-
	 * Creates a new Instance of the Builder
	 */
	public StringBuilder(String value) {
		this();
		append(value);
	}

	/*-
	 * Appends a String to another String and returns the Current Object
	 */
	public StringBuilder append(String newString) {
		if (StringUtil.isNullOrBlank(newString)) {
			return this;
		}
		int length = newString.length();
		ensureCapacity(length);

		System.out.println("String:" + newString + ":Length:" + length
				+ ":this.value:" + this.value.length + ":Size:" + this.size);
		System.arraycopy(newString.toCharArray(), 0, this.value,
				this.size, length);
		incrementSize(length);
		return this;
	}

	private void ensureCapacity(int length) {
		System.out.println("Old Length:" + this.value.length);
		int availableSpace = this.value.length - this.size;
		// If Length is Sufficient, then return
		if (length > availableSpace) {
			// Calculate New Size
			int newSize = (this.value.length + length) * defaultGrowthFactor;
			this.value = Arrays.copyOf(this.value, newSize);
		}
		System.out.println("New Length:" + this.value.length);

	}


	private void incrementSize(int length) {
		System.out.println("Old Size:" + this.size);
		this.size += length;
		System.out.println("New Size:" + this.size);
	}

	public String toString() {
		return new String(this.value);
	}

}
