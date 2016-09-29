/**
 * 
 */
package com.st.myprojects.main.util;

/**
 * @author sundeeptonse
 *
 */
public class PrintUtil {

	public static void repeatPrintLn(String s, int repeatNumber) {
		StringBuilder finalString = new StringBuilder();
		if (!StringUtil.isNullOrBlank(s)) {
			for (int i = 0; i < repeatNumber; i++)
				finalString.append(s);
			System.out.println(finalString);
		}
	}

}
