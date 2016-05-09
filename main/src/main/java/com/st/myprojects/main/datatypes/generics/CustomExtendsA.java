package com.st.myprojects.main.datatypes.generics;

import java.util.ArrayList;

public class CustomExtendsA<T> extends ArrayList<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7839678646462336602L;

	//Static Generics
	public static <Z> Z getType(Z z){
		return z;
	}
	
	public static final <Z> Class<?> getType2(Z z){
		return z.getClass();
	}
	
	public static final <Z> Class<?> getType2(Z... z){
		return z[0].getClass();
	}
	
	//Mutliple Generic Types
	public final <Z> Class<?> getType3(T test, Z... z){
		return z[0].getClass();
	}
	
	public static final <A> Class<?> getA(A a){
		return a.getClass();
	}
	
	public static final <A> A getAa(A a){
		return a;
	}
	
	
	public static final <A> Object getAaa(A a){
		return new Integer(1);
	}
	
	/*Can't work as it is all about the Scope
	public static final <B> Class<?> getBA(A a, B b){
		return getA(a);
	}
	*/
	
	
	public static void main(String[] args){
		
		System.out.println(getType2("Hello").getName());
		System.out.println(getType2(5).getName());
		System.out.println(getType2(5.14f).getName());
		
		int testValue = 112;
		System.out.println(getType2(testValue).getName());
		
	}
	
	
}
