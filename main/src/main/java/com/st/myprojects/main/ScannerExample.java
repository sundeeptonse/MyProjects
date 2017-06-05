/**
 * 
 */
package com.st.myprojects.main;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author sundeeptonse
 *
 */
public class ScannerExample {
	public static void main(String... args) {

		Scanner in = new Scanner(System.in);
		BigInteger integer1 = new BigInteger(in.nextLine());
		BigInteger integer2 = new BigInteger(in.nextLine());
		in.close();

		BigInteger sum = integer1.add(integer2);
		BigInteger multi = integer1.multiply(integer2);

		System.out.println(sum);
		System.out.println(multi);

	}
}
