package com.st.myprojects.main.datatypes.array;

public class NumberTest {

	
	public static void main(String... args){
		System.out.println(":: ");
		int i = 10;
		System.out.println(i);
		++i;
		System.out.println(i);
		i++;
		System.out.println(i);
		
		int x = i++;
		//Equivalent to 
		// int x = i
		// i = i  + 1 ;
		System.out.println(x);
		
		x = ++i;
		//Equivalent to 
		// i = i  + 1 ;
		// int x = i
		System.out.println(x);
		
		System.out.println("Cur Value:" + i);
		System.out.println("i++:"+ i++ + ":i:"+ i);
		
		System.out.println("Cur Value:" + i);
		System.out.println("++i:"+ ++i + ":i:" + i);
	}
	
}
