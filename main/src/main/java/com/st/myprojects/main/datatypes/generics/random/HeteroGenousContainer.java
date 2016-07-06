package com.st.myprojects.main.datatypes.generics.random;

import java.util.HashMap;
import java.util.Map;

import com.st.myprojects.main.util.CollectionsUtil;

public class HeteroGenousContainer {

	public static void main(String[] args){
		Favorites fav = new Favorites();
		
		fav.putFavorite(String.class, "Hello");
		fav.putFavorite(Integer.class, 123);
		fav.putFavorite(Integer.class, 456);
		fav.putFavorite(Float.class,2345.4f);
		
		
		int[] arr = {0,1,1};
		
		//Compile Time Error - Doesn't work
		//fav.putFavorite(float.class,2345.4);
		//fav.putFavorite(Integer.class,"23232");
		
		//Run Time Exception
		//fav.putFavorite(null,null); 
				
		
		System.out.println(fav.getFavorite(String.class));
		System.out.println(fav.getFavorite(Integer.class));
		System.out.println(fav.getFavorite(Integer.class));
		System.out.println(fav.getFavorite(Float.class));
		//System.out.println(fav.getFavorite(null));
				
	}
	
}

//Put Data of any Type
//Get Data of any Type
//Store Data of any Type

class Favorites{
	
	private Map<Class<?>,Object> favorites = CollectionsUtil.newHashMap();
	
	//??, what is being Inferred here ?
	private Map<?,?> favorites2 = CollectionsUtil.newHashMap();
	
	private Map<?,?> favorites3 = new HashMap<>();
	
	public <T> void putFavorite(Class<T> type ,T object){
		if(type== null || object == null)
			throw new NullPointerException("Type or Object is null");
		System.out.println("Adding:" + type + ":" + object);
		favorites.put(type, object);
	}
	
	public <T> T getFavorite(Class<T> type){
		System.out.println("Retreiving:" + type + "" + favorites.get(type).getClass().getName());
		return type.cast(favorites.get(type));
	}
}
