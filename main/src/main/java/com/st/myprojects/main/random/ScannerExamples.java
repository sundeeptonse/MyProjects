/**
 * 
 */
package com.st.myprojects.main.random;

import java.util.Scanner;

/**
 * @author sundeeptonse
 *
 */
public class ScannerExamples {

	public static void main(String... args) {
		Scanner consoleScanner = new Scanner(System.in);
		String[] inputArray = new String[2];
		for (int i = 0; i < 2; i++) {
			inputArray[i] = consoleScanner.next();
		}

		consoleScanner.close();

		Scanner in = new Scanner(System.in).useDelimiter("\\n");
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			String sentence = in.next();
		}

		in.close();
	}
}
