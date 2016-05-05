package com.st.myprojects.main.patterns;

import java.lang.reflect.Field;

public class STObject {
	
	public void print(){
		for (Field field : this.getClass().getDeclaredFields()) {
		    field.setAccessible(true);
		    String name = field.getName();
		    try{
		    	Object value = field.get(this);
		    	System.out.printf("Field name: %s, Field value: %s%n", name, value);
		    }catch(IllegalAccessException ex){
		    	
		    }
		}
	}

}
