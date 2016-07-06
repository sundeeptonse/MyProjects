/**
 * 
 */
package com.st.myprojects.main.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author sundeeptonse
 *
 */
public class StopThread {

	
	private static volatile boolean stopThreadRequested;
	
	public static void main(String... args) throws InterruptedException{
		
		/*
		 * This get converted to, due to VM Optimization known as a hoisting 
		 * if(!stop){
		 * 	while(true){
		 * 	  i++;
		 *  }
		 * }
		 * */
		
		
		Thread bgThread = new Thread(new Runnable(){
			public void run(){
				int i = 0;
				while(!stopThreadRequested){
					i++;
				}
				System.out.println("Done From BG Thread");
			}
		});
		
		bgThread.start();
		TimeUnit.SECONDS.sleep(1);
		stopThreadRequested = true;
		
		
		System.out.println("Done");
		
		// To make it visible we need to synchronize the access to the field 
		
		// Or Make the variable Volatile,so it is viewed
		
		
		
	}
	
}
