/**
 * 
 */
package com.st.myprojects.main.datatypes.generics.javagenericsbook.chap2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sundeeptonse
 *
 */
public class WildCardCapture {

	/*
	public static void reverse(List<?> list) {
		List<Object> tmp = new ArrayList<Object>(list);
		for (int i = 0; i < list.size(); i++) {
			//Can't be done, since we are trying to write from Object to unknown Type
			list.set(i, tmp.get(i));
		}

	}
	*/
	
	public static void reverse(List<?> list) {
		rev(list);
	}
	

	public static <T> void rev(List<T> list) {

		List<T> tmp = new ArrayList<T>(list);
		for (int i = 0; i < list.size(); i++) {
			list.set(i, tmp.get(i));
		}

	}

}
