package com.st.myprojects.main.patterns.singleton;

public enum SingletonEnum {
	INSTANCE;
	
	public String getValue(){
		return "Value is Set";
	}
	
	public static void main(String [] args){
		System.out.println(SingletonEnum.INSTANCE.getValue());		
	}

}
