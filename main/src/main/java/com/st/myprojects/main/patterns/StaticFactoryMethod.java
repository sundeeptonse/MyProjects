package com.st.myprojects.main.patterns;


	public class StaticFactoryMethod {
	
	private StaticFactoryMethod(){
		
	}
	
	public static StaticFactoryMethod getInstance(){
		return new StaticFactoryMethod();
	}
	
	public static Boolean valueOf(boolean b){
		return b ? Boolean.TRUE : Boolean.FALSE;
		
	}
	
	public static void main(String[] args){
		System.out.println(StaticFactoryMethod.valueOf(true));
		System.out.println(StaticFactoryMethod.valueOf(false));
	}

}
