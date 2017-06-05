/**
 * 
 */
package com.st.myprojects.main.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.st.myprojects.main.thread.RaceCondition.RaceCounterThread;

/**
 * @author sundeeptonse
 * 
 *         The ThreadLocal class in Java enables you to create variables that
 *         can only be read and written by the same thread. Thus, even if two
 *         threads are executing the same code, and the code has a reference to
 *         a ThreadLocal variable, then the two threads cannot see each other's
 *         ThreadLocal variables.
 * 
 *         InheritableThreadLocal The InheritableThreadLocal class is a subclass
 *         of ThreadLocal. Instead of each thread having its own value inside a
 *         ThreadLocal, the InheritableThreadLocal grants access to values to a
 *         thread and all child threads created by that thread.
 *
 */
public class ThreadLocalExample {
	public static void main(String... args) {
		ThreadLocalE.createAndExecuteThreads();
	}
}

class ThreadLocalE {
	public static class MyRunnable implements Runnable {
		
		/*
		 * This basically looks at the Thread.currentThread and stores the values there
		 * */
		private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

		@Override
		public void run() {
			int setValue = (int) (Math.random() * 100D);
			threadLocal.set(setValue);
			int getValue = threadLocal.get();
			System.out.println("ThreadLocalObject:" + threadLocal
					+ ":SetValue:" + setValue + ":Get Value:" + getValue);

		}
	}

	static void createAndExecuteThreads() {
		int count = 1_000;
		Runnable myRunnableInstance = new MyRunnable();
		
		// Schedule Thread to run after 10 second
		ScheduledExecutorService execService = Executors
				.newScheduledThreadPool(count);
		long delay = 3_000;
		for (int i = 0; i < count; i++) {
			Thread rct = new Thread(myRunnableInstance);
			execService.schedule(rct, delay, TimeUnit.MILLISECONDS);
		}
		execService.shutdown();
		while (!execService.isTerminated()) {
		}
	}


}