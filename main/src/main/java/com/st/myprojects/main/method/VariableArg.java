package com.st.myprojects.main.method;

public class VariableArg {

	public static void main(String[] args){
		
		int[] value  = {1,2,3,4,4};
		System.out.println(sum(value));
		
		//Variable args
		//Can be called via an Array or via a Set of Values of Type Int
		System.out.println(sumV(value));
		System.out.println(sumV(20,1,2,3,4));
		System.out.println(sum(10,value));
		System.out.println(sum(10,1,2,3,4));
		
	}
	
	public static int sum(int[] args){
		int i = 0;
		for(int value : args)
			i+=value;
		return i;
	}
	
	//Variable Args
	public static int sumV(int... args){
		int i = 0;
		for(int value : args)
			i+=value;
		return i;
	}
	
	//Variable Args with Compile Time Safety of having atleast one Number
	public static int sum(int arg0, int... args){
		int i = arg0;
		for(int value : args)
			i+=value;
		return i;
	}
	
	//TONSE
	/*
	public static <T extends Number> T sum(T  ... args){
		T i;
		for(T value : args)
			i+=value;
		return i;
	}
	*/
	
	
}
