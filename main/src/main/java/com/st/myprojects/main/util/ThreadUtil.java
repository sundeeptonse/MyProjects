/**
 * 
 */
package com.st.myprojects.main.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author sundeeptonse
 *
 */
public class ThreadUtil {

	/*
	 * Creates and Executes new Instances of a Thread After a delay Returns only
	 * after the thread has been terminated
	 * 
	 * [TONSE] To be finished
	 */
	public static void createAndExecuteThreads(Class classType,
			int numberofThreads, long delay, TimeUnit timeUnit) {

		if (Runnable.class.isAssignableFrom(classType)) {
			// Schedule Thread to run after 10 second
			ScheduledExecutorService execService = Executors
					.newScheduledThreadPool(numberofThreads);
			for (int i = 0; i < numberofThreads; i++) {
				Thread rct;
				try {
					rct = new Thread((Thread) classType.newInstance());
					execService.schedule(rct, delay, timeUnit);
				} catch (InstantiationException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			execService.shutdown();
			while (!execService.isTerminated()) {
			}
		}

	}

}
