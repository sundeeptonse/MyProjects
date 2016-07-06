/**
 * 
 */
package com.st.myprojects.main.serializable.readresolve;

import java.io.Serializable;

/**
 * @author sundeeptonse
 *
 */
public class ElvisStealer implements Serializable {
	static Elvis impersonator;
	private Elvis payload;

	private Object readResolve() {
		
		System.out.println("In Read Resolve:"+ this.getClass());
		
		// Save a reference to the "unresolved" Elvis instance
		impersonator = payload;

		// Return an object of correct type for favorites field
		return new String[] { "A Fool Such as I" };
	}

	private static final long serialVersionUID = 0;
}