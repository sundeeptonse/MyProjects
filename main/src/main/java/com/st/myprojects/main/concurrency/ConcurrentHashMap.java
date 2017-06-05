/**
 * 
 */
package com.st.myprojects.main.concurrency;

import java.util.Map;

/**
 * @author sundeeptonse
 *
 */
public class ConcurrentHashMap {

	public static void main(String... args) {
		
		Map<String,String> x = new java.util.concurrent.ConcurrentHashMap<String,String>();
		x.putIfAbsent("1","2");
		
		
	}
	
}
