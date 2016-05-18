package com.st.myprojects.main.string;

public class StringFormatExample {

	
	public static void main(String[] args) {

		System.out.printf("Integer : %d\n", 15);
		System.out.printf(
				"Floating point number with 3 decimal digits: %.3f\n",
				1.21312939123);
		System.out.printf(
				"Floating point number with 8 decimal digits: %.8f\n",
				1.21312939123);

		System.out.printf("String: %s, integer: %06d, float: %.2f",
				"Hello World", 89, 9.231435);

		System.out.println("------");
		System.out.printf("1:%6d, 2:%-6d,3:%06d", 89, 89, 89, 89);
	}
}