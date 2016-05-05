package com.st.myprojects.main.datatypes.generics;

import java.util.ArrayList;

public class CustomExtendsA<T> extends ArrayList<T> {

	public static <Z> Z getType(Z z){
		return z;
	}
	
	public static final <Z> Z getType2(Z z){
		return z;
	}
	
}
