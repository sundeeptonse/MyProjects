package com.st.myprojects.main.bitmanipulators;

/*
 * The Java programming language also provides operators that perform bitwise and bit shift operations on integral types. 
 * The operators discussed in this section are less commonly used. 
 * Therefore, their coverage is brief; the intent is to simply make you aware that these operators exist.

 * The unary bitwise complement operator "~" inverts a bit pattern; 
 * it can be applied to any of the integral types, making every "0" a "1" and every "1" a "0". 
 * For example, a byte contains 8 bits; applying this operator to a value whose bit pattern is "00000000" would change its pattern to "11111111".

 * Arithmetic(>>) vs Logical(>>>)
 * Arithmetic -- Doesn't erase the Signed Bit, retains and considers it while right shifting
 * Arithmetic -- Doesn't erase the Signed Bit, retains it while lefts shifting after all the bits are shifted 
 * 
 * Logical Right --> Doesn't erase the Signed Bit, retains and doesn't consider it while right shifting
 * No Left Shifting logical Right
 * 
 * The bitwise & operator performs a bitwise AND operation.
 * The bitwise ^ operator performs a bitwise exclusive OR operation.
 * The bitwise | operator performs a bitwise inclusive OR operation.
 * 
 * 0x--> Radix Prefix
 * Hex Literal 0xFF
 * Stands for the below Integer
 * 00000000 00000000 00000000 11111111
 * 
 * Hex Literal 0xFFFFFFFF
 * Stands for the below Integer
 * 11111111 11111111 11111111 11111111, which is -1
 * 
 * Hex Literal 0x7FFFFFFF
 * Stands for the below Integer
 * 01111111 11111111 11111111 11111111, which is Max Integer -> 2 power 31 -1
 * 
 * 0x80000000
 * 10000000 00000000 00000000 00000000, which is Min Integer --> - 2 power 31
 * 
 * Binary Representation
 * * 0b11010;
 * -0b1  = -1 , 111111
 * 
 * Int|Float : 32 bits
 * Long|Double :: 64 bits
 * 
 * For Long/Double :
 * long longV = 0xFFFFFFFFFFFFFFFFL;
 * double double = 0xFFFFFFFFFFFFFFFFd; --> Doesn't work, so won't float

 * */
public class ShiftOps {

	public static void main(String... args) {

		

	}
	
	public static  void arithmeticLogicTest(){
		for (int i = 0; i < 40; i++) {
			int value = 1 << i;
			System.out.println("Number:" + value + ":HexRepresentation:"
					+ Integer.toBinaryString(value));
		}

		System.out.println("---Arithmetic Right ---");

		for (int i = 0; i < 32; i++) {
			int value = 0x80000000 >> i;
			System.out.println("Number:" + value + ":HexRepresentation:"
					+ Integer.toBinaryString(value));
		}

		System.out.println("---Arithmetic Left---");

		for (int i = 0; i < 32; i++) {
			int value = -0b1 << i;
			System.out.println("Number:" + value + ":HexRepresentation:"
					+ Integer.toBinaryString(value));
		}
		System.out.println("---Logical Right ---");

		for (int i = 0; i < 32; i++) {
			int value = 0x80000000 >>> i;
			System.out.println("Number:" + value + ":HexRepresentation:"
					+ Integer.toBinaryString(value));
		}
	}
	
}
