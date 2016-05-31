/**
 * 
 */
package com.st.myprojects.main.datatypes.generics;

import java.util.ArrayList;
import java.util.List;

/*-
 * Arrays are co-variant, if Sub is a Subtype of Super, then Sub[] is a
 * SubType of Super[]; 
 * 
 * Generics are invariant, List<Sub> is not a SubType of
 * List<Super>
 *
 */
public class Covariant {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		Object[] objectArruy = new Long[1];
		//ArrayStoreException
		//objectArruy[0] = "Hello World";
		
		//Won't Compile.
		//Invariance -- Get to know about it during Compilation
		//List<Object> test = new ArrayList<String>(); 
		
		
		

	}

}
