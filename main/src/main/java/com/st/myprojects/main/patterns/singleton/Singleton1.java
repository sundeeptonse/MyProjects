package com.st.myprojects.main.patterns.singleton;

import java.io.Serializable;

public class Singleton1{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3418211353371630183L;
	
	private static final Singleton1 INSTANCE = new Singleton1();
	private Singleton1(){}
	
	public static <T extends Object> T getInstance(Class<T> type){
		return type.cast(INSTANCE);
	}
	
	public static void main(String[] args){
		System.out.println("Instance"  + Singleton1.getInstance(Singleton1.class));
		System.out.println("Instance"  + Singleton1.getInstance(Singleton1.class));
		System.out.println("Instance"  + Singleton1.getInstance(Singleton1.class));
	}
	
}
