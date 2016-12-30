/**
 * 
 */
package com.st.myprojects.main.thread.locks;

/**
 * @author sundeeptonse
 *
 */
public class SimpleLock implements Lock {

	boolean isLocked = false;

	@Override
	public synchronized void lock() throws InterruptedException {
		while (isLocked) {
			wait();
		}
		isLocked = true;
	}

	@Override
	public synchronized void unlock() {
		isLocked = false;
		notify();
	}

}
