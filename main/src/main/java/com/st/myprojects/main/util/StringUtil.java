/**
 * 
 */
package com.st.myprojects.main.util;


/**
 * @author sundeeptonse
 *
 */
public class StringUtil {

	public static boolean isNullOrBlank(String stringValue) {
		return stringValue == null ? true : (stringValue.trim().equals(
				Constants.STR_BLANK) ? true : false);
	}
	

}
