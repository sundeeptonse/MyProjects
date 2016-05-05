package com.st.myprojects.main.datatypes.generics;

import java.util.ArrayList;
import java.util.List;

public class PECSExample {

	//Producer can be seen as a Read 
	//Consumer can be seen as a write
	
	public static void main(String[] args) {

		//Neither Producing nor consuming
		//List<?> number = new ArrayList<>();
		
		//Producer as in Get is allowed
		//List<? extends Number> number = new ArrayList<>();
		
		//Consumer as in add is allowed
		//List<? super Number> number = new ArrayList<>();
		List<Number> number = new ArrayList<>();
		//Equivalent to above List<T> number = new ArrayList<>();
		
		
		System.out.println("Adding Integer:");
		number.add(new Integer(4));
		System.out.println("Retreiving:");
		Number numericValue = number.get(0);
		
		
		number.size();
		
		//Compile Time Errors
		/*
		List<Number> number1 = new ArrayList<Float>();
		List<? super Number> number3 = new ArrayList<Float>();
		*/
		
		//
		List<? extends Number> number2 = new ArrayList<Float>();
		List<?> number4 = new ArrayList<Float>();

	}

}
