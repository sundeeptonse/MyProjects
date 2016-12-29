/**
 * 
 */
package com.st.myprojects.main.problems;

import com.st.myprojects.main.util.StringUtil;

/**
 * @author sundeeptonse
 *
 */
public class URLify {

	public static void main(String... args) {
		String originalString = "This is my world";
		System.out.println(StringUtil.replace(originalString, ' ', "'SPACESPACE'"));
	}
	
}
