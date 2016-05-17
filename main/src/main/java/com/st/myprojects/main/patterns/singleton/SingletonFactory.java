package com.st.myprojects.main.patterns.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.st.myprojects.main.util.DateUtil;
import com.st.myprojects.main.util.DateUtil.Time;

public class SingletonFactory {
	
	private static volatile Map<Class<?>,Object> singletonMap = new ConcurrentHashMap<>();
	private static boolean stats = false;
	private static Time statsTime = Time.ms;
	
	private enum Message{
		NULL("Class Type can't be null"),
		CREATIONFAILED("Unable to Create the Singleton Object Successfully"),
		PRIVATECONST("Singleton can't have any non-private Constructors");
		String message;
		Message(String pMessage){
			this.message = pMessage;
		}
	}
	
	private SingletonFactory(){
	};
	
	public static final <T> T getSingletonInstance(Class<T> classType) throws SingletonCreationException{
		//Date to Measure Performance
		long time = System.nanoTime();
		
		if(classType == null){
			throw new NullPointerException(Message.NULL.message);
		}
		Object singletonObj = singletonMap.get(classType);
		
		//DOUBLE - CHECKED 
		if(singletonObj == null){
			try{
				//Check if Class Matches Expectations
				validateClass(classType);
				//Call the Declared Constructor
				Constructor<T> constructor =  classType.getDeclaredConstructor();
				
				//Override it
				constructor.setAccessible(true);
				//Generate Instance on a Synchronized Block
				synchronized (SingletonFactory.class) {
					//Double Check to Avoid Race Condition
					singletonObj = singletonMap.get(classType);
					if(singletonObj == null){
						singletonObj = constructor.newInstance();
					
					}
					//Put Instance into the Concurrent Map
					singletonMap.put(classType,singletonObj);					
				}
				if(singletonObj == null){
					throw new SingletonCreationException(Message.CREATIONFAILED.message);
				}
			}catch(NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException ex){
				throw new SingletonCreationException(new Throwable(ex));
			}
		}
		if(stats){
			DateUtil.printDateDifference(time, statsTime);
		}
		return classType.cast(singletonObj);
	}
	
	public static void setStats(boolean pStats, Time pTime){
		stats = pStats;
		statsTime = pTime;
	}
	
	
	private static <T> void validateClass(Class<T> classType) throws SingletonCreationException{
		Constructor<?>[] constructorArr = classType.getDeclaredConstructors();
		for(Constructor<?> constructor : constructorArr){
			if(constructor.getModifiers() != Modifier.PRIVATE){
				throw new SingletonCreationException(Message.PRIVATECONST.message);
			}
		}
	}

}


class SingletonCreationException extends Exception  {
	private static final long serialVersionUID = -2965779113260499613L;
	public SingletonCreationException(String message){	super(message); }
	public SingletonCreationException(Throwable cause){  super(cause); }
}


