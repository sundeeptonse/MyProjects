/**
 * 
 */
package com.st.myprojects.main.thread.locks;

/**
 * @author sundeeptonse
 *
 */
public class ReEntrantLock implements Lock {
	boolean isLocked = false;
	Thread lockedBy = null;
	int lockedCount = 0;

	@Override
	public synchronized void lock() throws InterruptedException {
		Thread currentThread = Thread.currentThread();
		while (isLocked && lockedBy != currentThread) {
			wait();
		}
		lockedBy = currentThread;
		isLocked = true;
		lockedCount++;
	}

	@Override
	public synchronized void unlock() {
		if (Thread.currentThread() == lockedBy) {
			lockedCount--;
			if (lockedCount == 0) {
				isLocked = false;
				notify();
			}
		}
	}

}
