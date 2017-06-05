/**
 * 
 */
package com.st.myprojects.main.util;

/**
 * @author sundeeptonse
 *
 */
public class BitUtil {

	/*
	 * Returns true if the Bit at the ith Bit is 1, else false
	 */
	public static boolean getBit(int num, int i) {

		/*-
		 * 000001 << i
		 * 
		 * 001000 & num --> All Values apart from the ith bit If 0 then return
		 * false If 1 then returns true
		 */

		return (num & (0b1 << i)) != 0;
	}

	/*
	 * Sets the Bit at the ith position
	 */
	public static int setBit(int num, int i) {

		/*-
		 * 000001 << i
		 * 
		 * 001000
		 * OR
		 * 010111
		 * ------
		 * 011111
		 */

		return num | (0b1 << i);
	}

	/*-
	 * clearBit
	 * Move 1 to the concerned bit and reverse it
	 * Everything gets reversed inclusive of the signed bit
	 * 
	 */
	public static int clearBit(int num, int i) {
		int mask = ~(0b1 << i);
		// System.out.println(Integer.toBinaryString(mask));
		return num & mask;
	}

	/*-
	 * clearBit
	 * From the MSB to the ith bit --> We need all those values as 0
	 * 
	 * 00010000
	 * -1
	 * ===
	 * 
	 * --------
	 * 00010000
	 * 11111111
	 * --------
	 * 00001111
	 * --------
	 * 
	 * 
	 */
	public static int clearBitsMSBToI(int num, int i) {
		int mask = (0b1 << i) - 0b1;
		// System.out.println(Integer.toBinaryString(mask));
		return num & mask;
	}

	/*-
	 * clearBitfromIto0
	 * 
	 * --------
	 * 00010000
	 * 11111111
	 * --------
	 * 11100000
	 * --------
	 * 
	 * 
	 */
	public static int clearBitITo0(int num, int i) {
		int mask = -1 << i + 1;
		System.out.println(Integer.toBinaryString(mask));
		return num & mask;
	}

	public static int updateBit(int num, int i, boolean bitIs1) {
		if (bitIs1) {
			return setBit(num, i);
		} else {
			return clearBit(num, i);
		}
	}

	public static int toggle(int num, int i) {
		return updateBit(num, i, !getBit(num, i));
	}

	/*-
	 * Checks if only 1 bit is set
	 * 
	 * Example:
	 * Num : 000010000
	 * 
	 * Minus1 First
	 *      000001111
	 * 
	 * This is an exact Inverse in case only 1 bit is set
	 * Hence & them and if 0, then only 1 bit is set
	 * 
	 * */
	public static boolean checkExactlyOneBitSet(int num) {
		return (num - 1 & num) == 0 ? true : false;
	}

	public static void main(String... args) {
		int num = 0b1;
		System.out.println(Integer.toBinaryString(num));
		for (int i = 0; i < 31; i++) {
			System.out.println("BeforeToggle:" + i + ":"
					+ Integer.toBinaryString(num));
			num = BitUtil.toggle(num, i);
			System.out.println("AfterToggle1:" + i + ":"
					+ Integer.toBinaryString(num));
			num = BitUtil.toggle(num, i);
			System.out.println("AfterToggle2:" + i + ":"
					+ Integer.toBinaryString(num));
		}

	}
}
