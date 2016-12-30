/**
 * 
 */
package com.st.myprojects.main.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author sundeeptonse
 *
 */
public class ThreadLocks {

	public static void main(String... args) {
		ThreadsLocksExamples.testMethods();
	}
}

class ThreadsLocksExamples {

	static Counter counter;

	static abstract class Counter {
		int count;

		public abstract int getCount();

		public abstract void setCount(int count);

		public abstract void incrementCount();
	}

	/*
	 * Here It gives reads and writes equal priority
	 */
	static class CounterReadEntrantLock extends Counter {
		Lock lock = new ReentrantLock();

		public int getCount() {
			int returnCount;
			lock.lock();
			returnCount = count;
			lock.unlock();
			return returnCount;
		}

		public void setCount(int count) {
			lock.lock();
			this.count = count;
			lock.unlock();
		}

		public void incrementCount() {
			lock.lock();
			this.count++;
			lock.unlock();
		}
	}

	/*
	 * Writes are up prioritized
	 */
	static class CounterRWEntrantLock extends Counter {
		ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

		public int getCount() {
			int returnCount;
			lock.readLock().lock();
			returnCount = count;
			lock.readLock().unlock();
			return returnCount;
		}

		public void setCount(int count) {
			lock.writeLock().lock();
			this.count = count;
			lock.writeLock().unlock();
		}

		public void incrementCount() {
			lock.writeLock().lock();
			this.count++;
			lock.writeLock().unlock();
		}
	}

	static class MyRunnableRead implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				System.out.println("Reads:" + i + ":Count:"
						+ +counter.getCount());
			}
		}
	}

	static class MyRunnableWrite implements Runnable {
		@Override
		public void run() {
			counter.incrementCount();
			for (int i = 0; i < 100; i++) {
				System.out.println("Reads:" + i + ":Count:"
						+ +counter.getCount());
			}
		}
	}

	static void testMethods() {
		// Create the Object Required
		// counter = new CounterReadEntrantLock();
		// createAndExecuteThreads();

		counter = new CounterRWEntrantLock();
		createAndExecuteThreads();
	}

	static void createAndExecuteThreads() {
		int count = 1_000;
		// Schedule Thread to run after 10 second
		ScheduledExecutorService execService = Executors
				.newScheduledThreadPool(count);
		long delay = 3_000;
		for (int i = 0; i < count; i++) {
			Thread rct;
			if (i % 2 == 0) {
				rct = new Thread(new MyRunnableRead());
			} else {
				rct = new Thread(new MyRunnableWrite());
			}
			execService.schedule(rct, delay, TimeUnit.MILLISECONDS);
		}
		execService.shutdown();
		while (!execService.isTerminated()) {
		}
	}

}
