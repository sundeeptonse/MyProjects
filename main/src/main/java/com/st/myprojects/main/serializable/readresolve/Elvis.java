/**
 * 
 */
package com.st.myprojects.main.serializable.readresolve;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Arrays;

/**
 * @author sundeeptonse
 *
 */
public class Elvis implements Serializable {
	public static final Elvis INSTANCE = new Elvis();

	private Elvis() {
	}

	private String[] favoriteSongs = { "Hound Dog", "Heartbreak Hotel" };

	public void printFavorites() {
		System.out.println(Arrays.toString(favoriteSongs));
	}

	private Object readResolve() throws ObjectStreamException {
		System.out.println("In Read Resolve:"+ this.getClass());
		return INSTANCE;
	}
	
	public static Elvis getAnotherInstance(){
		return new Elvis();
	}
}
