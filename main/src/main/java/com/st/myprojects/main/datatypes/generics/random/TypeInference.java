package com.st.myprojects.main.datatypes.generics.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//Not Required in Java 1.7
public class TypeInference {

	private TypeInference(){}
	
	public static void main(String[] args){
		//Before
		HashMap<String, List<String>> myGenericHashMap  = new HashMap<String, List<String>>();
		//After
		Map<String, List<String>> myNewGenericHashMap  = TypeInference.newInstance();

		List<String> myNewArrayList = TypeInference.getArrayList();
	
		System.out.println(new HashMap<>());
	}
	
	
	public static <K> List<K> getArrayList(){
		return new ArrayList<K>();
	}
	
	//Type Inference --> Basically Infers the Type on Base
	public static <K,V> Map<K,V> newInstance(){
		return new HashMap<K,V>();
	}
	
	public static <K,V> Map<K,V> get2ndInstance(){
		return new HashMap<K,V>();
	}
	
}
