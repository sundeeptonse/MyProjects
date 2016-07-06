/**
 * 
 */
package com.st.myprojects.main.datatypes.generics.javagenericsbook.chap1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sundeeptonse
 *
 */
public class Lists {

	public static <T> List<T> toList(T... args) {
		System.out.println("args Type:" + args.getClass());
		List<T> list = new ArrayList<>();
		for(T arg : args)
			list.add(arg);
		return list;	
	}

	public static <T> List<T> addAll(List<T> list, T... args){
		System.out.println("args Type:" + args.getClass());
		list.addAll(toList(args));
		
		// Throws Compilation Error
		//list.addAll(<Integer>toList(args));
		
		return list;	
	}
	
	public static void main(String... args) {
		
		//Being Inferred
		Lists.toList(new Integer[]{1,23,3});
		Lists.toList(new String[]{"1","23","3"});
		Lists.toList(1,2);
		
		//Can choose any of the Types, like Serializable/Comparable instead of Object
		//Prints Serializable
		Lists.toList(1,"3");
		
		//Explicit Type
		Lists.<Object>toList(1,"3");
		
		//Infers from the List Type
		List<Object> obj = Lists.toList(1,"3");
		
		System.out.println("Bye");
	}	
	

}
