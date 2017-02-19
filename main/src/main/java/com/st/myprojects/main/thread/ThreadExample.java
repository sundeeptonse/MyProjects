/**
 * 
 */
package com.st.myprojects.main.thread;

import java.util.concurrent.ThreadPoolExecutor;

/*-
 * @author sundeeptonse
 *
 * A thread is a n execution of a program within the same process.
 * Threads will have access to the same resources as the original process.
 * 
 * Since there are multi-processors in each Machine.
 * A Thread Execution can go to either of the processors.
 * For better execution,Each thread in the processors will have a Memory - CPU Cache.
 * This however isn't the main Memory which is the RAM.
 * 
 * The Thread will constantly read and write to the Main Memory.
 * To make a variable write to the main memory we need to define it "volatile".
 * As per Java docs, volatile defines a "happens before" guarantee.
 * 
 * MultiThreading Costs:
 * 
 * Context Switching
 * When a CPU switches from executing one thread to executing another, 
 * the CPU needs to save the local data, program pointer etc. of the current thread, 
 * and load the local data, program pointer etc. of the next thread to execute. 
 * This switch is called a "context switch". 
 * The CPU switches from executing in the context of one thread to executing in the context of another.
 * Context switching isn't cheap. You don't want to switch between threads more than necessary
 * 
 * Increased Resource Consumption
 * A thread needs some resources from the computer in order to run. 
 * Besides CPU time a thread needs some memory to keep its local stack. 
 * It may also take up some resources inside the operating system needed to manage the thread. 
 * Try creating a program that creates 100 threads that does nothing but wait, and see how much memory the application takes when running.
 * 
 * 
 */
public class ThreadExample {

	public static void main(String... args) {
		ThreadImplementation.RunnableExamples.TestMethods.testRunnable1();
		// ThreadImplementation.ThreadExtendExamples.TestMethods
		// .testThreadAnonymous();
	}
}

/*-
 * A Thread can be Implemented by Implementing the Runnable Interface or Extending the Thread Class(Which implements Runnable)
 * 
 *  If Runnable --> call the Start Method to Start
 *  If Thread Extends --> call the Start Method to Start
 *  
 *  The start() call will return as soon as the thread is started. 
 *  It will not wait until the run() method is done. 
 *  The run() method will execute as if executed by a different CPU. 
 *  When the run() method executes it will print out the text "MyThread running".
 * */

class ThreadImplementation {

	/*
	 * All the Runnable Examples
	 */
	static class RunnableExamples {
		static long sleepTime = 1_000_000;

		static class MyThreadRunnable implements Runnable {
			int threadNo;

			MyThreadRunnable(int threadNo) {
				this.threadNo = threadNo;
			}

			public void run() {
				System.out.println("Entered" + this.threadNo);
				try {
					System.out.println("Sleeping MyThreadRunnable Thread:"
							+ threadNo);
					// wait();
					Thread.sleep(sleepTime);
					System.out.println("Running MyThreadRunnable Thread:"
							+ threadNo);

					// Doesn't have access to Thread Object*
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		static class TestMethods {
			static void testRunnable1() {
				for (int i = 0; i < 100; i++) {
					Thread thread = new Thread(new MyThreadRunnable(i),
							"Runnable Thread" + i);
					thread.start();
					System.out.println("Name:" + thread.getName());
				}
			}

			static void testRunnable2() {
				for (int i = 0; i < 100; i++) {
					Runnable myRunnable = new Runnable() {
						public void run() {
							System.out.println("Runnable running");
						}
					};
					Thread thread2 = new Thread(myRunnable);
					thread2.start();
				}
			}

			/*
			 * This doesn't thread it -- "Don't do"
			 */
			static void testRunnableWrong() {
				for (int i = 0; i < 100; i++) {
					MyThreadRunnable runnableThread = new MyThreadRunnable(i);
					runnableThread.run();
				}
			}
		}

	}

	static class ThreadExtendExamples {
		static long sleepTime = 1_000;

		static class MyThreadExtends extends Thread {
			int threadNo;

			MyThreadExtends() {
			}

			public void run() {
				System.out.println("Entered Thread:" + getName());
				try {
					System.out.println("Sleeping Thread:" + getName());
					Thread.sleep(sleepTime);
					System.out.println("Running Thread:" + getName());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		static class TestMethods {
			static void testThread1() {
				for (int i = 0; i < 100; i++) {

					/*
					 * Similar to Runnable Way
					 */
					Thread extendedThread = new Thread(new MyThreadExtends(),
							"MyThreadExtends:" + i);
					extendedThread.start();
					

				}
			}

			/*
			 * Not Recommended
			 */
			static void testThread2() {
				for (int i = 0; i < 100; i++) {
					// Or
					Thread extendedThread2 = new MyThreadExtends();
					extendedThread2.start();

					// Or
					// MyThreadExtends extendedThread3 = new MyThreadExtends(i);
					// extendedThread3.start();

				}
			}

			/*
			 * DON'T DO This calls the Thread's Run Method, which in-turn
			 * doesn't thread it
			 */
			static void testThreadWrong() {
				for (int i = 0; i < 100; i++) {

					Thread extendedThread = new Thread(new MyThreadExtends(),
							"MyThreadExtends:" + i);
					extendedThread.run();

				}
			}

			static void testThreadAnonymous() {
				System.out.println("Current Thread:"
						+ Thread.currentThread().getName());
				for (int i = 0; i < 100; i++) {
					Thread thread = new Thread("My Thread:" + i) {
						public void run() {
							System.out.println("Running Anonymous SubClass:"
									+ this.getName());
						}
					};
					thread.start();
				}
			}
		}

	}
}
