package com.st.myprojects.main.datatypes.enumt;

import java.security.GuardedObject;

//Outside Class Enum Example
enum Company2 {

}

class Test {

}

public class EnumTest {
	public enum Company {
		EBAY(30), PAYPAL(10, 20), GOOGLE(15, 20), YAHOO(20, 20), ATT(25, 25), SUNDEEP(
				50, 60, 70);
		private int value1;
		private int value2;
		private int value3;

		private Company(int value1) {
			this.value1 = value1;
		}

		private Company(int value1, int value2) {
			this(value1);
			this.value2 = value2;
		}

		private Company(int value1, int value2, int value3) {
			this(value1, value2);
			this.value3 = value3;
		}
	}

	public enum Values {
		GO, EXIT, START
	}

	public static void main(String[] args) {

		for (Company cName : Company.values()) {
			System.out.println("Company Value1: " + cName.value1
					+ "cName.value2:" + cName.value2 + ":cName.value3:"
					+ cName.value3 + " - Comapny Name: " + cName);
		}

		if (Company.EBAY.equals("EBAY")) {
			System.out.println("Ehll");
			System.out
					.println(Company.EBAY.value1 + "::" + Company.EBAY.value2);
		}

		Values value = Values.GO;
		switch (value) {
		case GO:
			System.out.println("GO GO GO");
			break;
		default:
			break;
		}

	}
}
