package com.st.myprojects.main.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Only for Version <1.7, 1.7 on has by default Type Inference
public final class CollectionsUtil {

	private CollectionsUtil(){}
	
	public static <K> List<K> getArrayList(){
		return new ArrayList<K>();
	}
	
	//Type Inference --> Basically Infers the Type on Base
	public static <K,V> Map<K,V> newHashMap(){
		return new HashMap<K,V>();
	}
	
	public static <K,V> Map<K,V> get2ndInstance(){
		return new HashMap<K,V>();
	}
	
}
