package com.st.myprojects.main.datatypes.generics.random;

import java.util.List;

//To Set it to a Particular Type as well
public class IsGeneric<K extends Object,V extends Object> {
	
	private K key;
	private V value;
	
	private K[] keyArray;
	private V[] valueArray;
	
	private List<K> keyList;
	private List<V> valueList;
	
	protected IsGeneric(){}
	
	protected IsGeneric(K key, V value){
		this.key = key;
		this.value = value;
	}
	
	public K getKey(){return this.key;}
	
	public V getValue(){return this.value;}
	
	public <T> K getKeyForNumber(T value){
		return this.key;
	}
	
	public <T extends Number> List<K> getKeyListForNumber(T value){
		return this.keyList;
	}
	
	public <T extends Object> List<K> getKeyListForNumber(T value){
		return this.keyList;
	}
	
	public  List<K> getKeyListForNumber( IsGeneric<? extends Number, ? super Object> value){
		return this.keyList;
	}
	
	public <T extends Object> List<K> getKeyListForNumber2( IsGeneric<? super K, ? extends T> value){
		return this.keyList;
	}
	
	public <T> List<K> getKeyListForNumber3( IsGeneric<?, ?> value){
		return this.keyList;
	}
	
	public <T> List<K> getKeyListForNumber4( IsGeneric<T, T> value){
		return this.keyList;
	}
	
	/* Can't be Done , Similar to a Class
	public <T super Number> List<K> getKeyListForNumber(T value){
		return this.keyList;
	}
	*/
	
	public <T> boolean getDifference(T... value){
		return false;
	}
	
	
	
	

}
