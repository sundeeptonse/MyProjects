/**
 * 
 */
package com.st.myprojects.main.thread.locks;

/**
 * @author sundeeptonse
 *
 */
public interface Lock {

	public void lock() throws InterruptedException;

	public void unlock();

}
