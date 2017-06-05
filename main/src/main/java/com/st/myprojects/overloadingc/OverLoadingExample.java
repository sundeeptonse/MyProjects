/**
 * 
 */
package com.st.myprojects.overloadingc;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sundeeptonse
 *
 */
public class OverLoadingExample {

	public static String  classify(Collection<?> c){
		return "Collection";
	}
	
	public static String  classify(Set<?> c){
		return "Set";
	}
	
	public static String  classify(List<?> c){
		return "List";
	}
	
	
	public static void main(String... args) {
		Collection<?>[] collections = {
				new HashSet<String>(),
				new ArrayList<BigInteger>(),
				new HashMap<String,String>().values()
		};
		
		
		for(Collection<?> c: collections){
			//Decided at Compile Time, Looks at the Type
			System.out.println(classify(c));
		}
		
	}
	
	
}
