/**
 * 
 */
package com.st.myprojects.main.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.st.myprojects.main.util.DateUtil;
import com.st.myprojects.main.util.DateUtil.Time;

/*-
 * @author sundeeptonse
 * A race condition is a special condition that may occur inside a critical section. 
 * A critical section is a section of code that is executed by multiple threads and where the sequence of execution for the threads makes a difference in the result of the concurrent execution of the critical section.
 * When the result of multiple threads executing a critical section may differ depending on the sequence in which the threads execute, the critical section is said to contain a race condition. The term race condition stems from the metaphor that the threads are racing through the critical section, 
 * and that the result of that race impacts the result of executing the critical section.
 *
 * Running more than one thread inside the same application does not by itself cause problems. 
 * The problems arise when multiple threads access the same resources. 
 * For instance the same memory (variables, arrays, or objects), systems (databases, web services etc.) or files.
 * In fact, problems only arise if one or more of the threads write to these resources. I
 * It is safe to let multiple threads read the same resources, as long as the resources do not change.
 */
public class ThreadRace {

	public static void main(String... args) {

		long timeInNano = System.nanoTime();
		RaceCondition.testRaceMethod(false);
		long timeA = DateUtil.getTimeDifference(timeInNano, Time.ns);
		System.out.println(timeA);

		/*
		 * long timeInNano = System.nanoTime();
		 * RaceCondition.testRaceMethod(true); long timeB =
		 * DateUtil.getTimeDifference(timeInNano, Time.ms);
		 * System.out.println(timeB);
		 */

	}
}

/*
 * Generating a Race Condition.
 * 
 * Imagine if two threads, A and B, are executing the add method on the same
 * instance of the Counter class. There is no way to know when the operating
 * system switches between the two threads. The code in the add() method is not
 * executed as a single atomic instruction by the Java virtual machine. Rather
 * it is executed as a set of smaller instructions, similar to this:
 * 
 * Read this.count from memory into register. Add value to register. Write
 * register to memory.
 * 
 * To prevent race conditions from occurring you must make sure that the
 * critical section is executed as an atomic instruction. That means that once a
 * single thread is executing it, no other threads can execute it until the
 * first thread has left the critical section.
 * 
 * Race conditions can be avoided by proper thread synchronization in critical
 * sections. Thread synchronization can be achieved using a synchronized block
 * of Java code. Thread synchronization can also be achieved using other
 * synchronization constructs like locks or atomic variables like
 * java.util.concurrent.atomic.AtomicInteger.
 * 
 * 
 * Code that is safe to call by multiple threads simultaneously is called thread
 * safe. If a piece of code is thread safe, then it contains no race conditions.
 * Race condition only occur when multiple threads update shared resources.
 * Therefore it is important to know what resources Java threads share when
 * executing.
 */

class RaceCondition {
	@SuppressWarnings("rawtypes")
	static Counter rc;
	static boolean useFJ = false;

	static abstract class Counter<T> {
		T count;

		public abstract void add(long value);
	}

	static class RaceCounter extends Counter<Long> {
		RaceCounter() {
			this.count = new Long(0);
		}

		public void add(long value) {
			this.count += value;
		}
	}

	static class RaceCounterFixed extends Counter<AtomicLong> {
		RaceCounterFixed() {
			this.count = new AtomicLong();
		}

		public void add(long value) {
			count.getAndAdd(value);
		}
	}

	static class RaceCounterFixed2 extends Counter<Long> {
		RaceCounterFixed2() {
			this.count = new Long(0);
		}

		public synchronized void add(long value) {
			this.count += value;
		}
	}

	static class RaceCounterFixedLocks extends Counter<Long> {
		Lock lock = new ReentrantLock();

		RaceCounterFixedLocks() {
			this.count = new Long(0);
		}

		public void add(long value) {
			lock.lock();
			this.count += value;
			lock.unlock();
		}
	}

	static class RaceCounterThread implements Runnable {
		/*
		 * Adds 1 to the RaceCounter.
		 */
		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				rc.add(1);
			}
		}
	}

	static void testRaceMethod(boolean forkJoin) {
		useFJ = forkJoin;
		rc = new RaceCounter();
		createAndExecuteThreads();
		System.out.println("Count is:" + rc.count);

		rc = new RaceCounterFixed();
		createAndExecuteThreads();
		System.out.println("Count is:" + rc.count);

		rc = new RaceCounterFixed2();
		createAndExecuteThreads();
		System.out.println("Count is:" + rc.count);

		rc = new RaceCounterFixedLocks();
		createAndExecuteThreads();
		System.out.println("Count is:" + rc.count);
	}

	static void createAndExecuteThreads() {
		int count = 1_000_000;
		if (useFJ) {
			// Schedule Thread to run after 10 second
			ExecutorService execService = Executors.newWorkStealingPool();
			for (int i = 0; i < count; i++) {
				Thread rct = new Thread(new RaceCounterThread());
				execService.submit(rct);
			}
			execService.shutdown();
			while (!execService.isTerminated()) {
			}
		} else {
			// Schedule Thread to run after 10 second
			// ScheduledExecutorService execService = Executors
			// .newScheduledThreadPool(100);
			// long delay = 3_000;
			//
			// for (int i = 0; i < count; i++) {
			// Thread rct = new Thread(new RaceCounterThread());
			// execService.schedule(rct, delay, TimeUnit.MILLISECONDS);
			// }

			ExecutorService execService = Executors.newFixedThreadPool(500);
			for (int i = 0; i < count; i++) {
				Thread rct = new Thread(new RaceCounterThread());
				execService.submit(rct);
			}
			execService.shutdown();
			while (!execService.isTerminated()) {
			}
		}

	}

}

/*
 * 
 * Code that is safe to call by multiple threads simultaneously is called thread
 * safe. If a piece of code is thread safe, then it contains no race conditions.
 * Race condition only occur when multiple threads update shared resources.
 * Therefore it is important to know what resources Java threads share when
 * executing.
 * 
 * Local variables are stored in each thread's own stack. That means that local
 * variables are never shared between threads. That also means that all local
 * primitive variables are thread safe. Here is an example of a thread safe
 * local primitive variable
 * 
 * Local Object References Local references to objects are a bit different. The
 * reference itself is not shared. The object referenced however, is not stored
 * in each threads's local stack. All objects are stored in the shared heap.
 * 
 * If an object created locally never escapes the method it was created in, it
 * is thread safe. In fact you can also pass it on to other methods and objects
 * as long as none of these methods or objects make the passed object available
 * to other threads.
 * 
 * The Thread Control Escape Rule When trying to determine if your code's access
 * of a certain resource is thread safe you can use the thread control escape
 * rule:
 * 
 * If a resource is created, used and disposed within the control of the same
 * thread, and never escapes the control of this thread, the use of that
 * resource is thread safe. Resources can be any shared resource like an object,
 * array, file, database connection, socket etc. In Java you do not always
 * explicitly dispose objects, so "disposed" means losing or null'ing the
 * reference to the object.
 * 
 * Even if the use of an object is thread safe, if that object points to a
 * shared resource like a file or database, your application as a whole may not
 * be thread safe. For instance, if thread 1 and thread 2 each create their own
 * database connections, connection 1 and connection 2, the use of each
 * connection itself is thread safe. But the use of the database the connections
 * point to may not be thread safe. For example, if both threads execute code
 * like this:
 * 
 * check if record X exists if not, insert record X If two threads execute this
 * simultaneously, and the record X they are checking for happens to be the same
 * record, there is a risk that both of the threads end up inserting it. This is
 * how:
 * 
 * Thread 1 checks if record X exists. Result = no Thread 2 checks if record X
 * exists. Result = no Thread 1 inserts record X Thread 2 inserts record X This
 * could also happen with threads operating on files or other shared resources.
 * Therefore it is important to distinguish between whether an object controlled
 * by a thread is the resource, or if it merely references the resource (like a
 * database connection does).
 */
class ThreadSafety {

	static class ThreadSafe {

		public void threadSafeVariable() {
			long threadSafeInt = 0;
			threadSafeInt++;
		}

		public void threadSafeObject() {
			Object object = new Object();
			threadSafeObjectCall(object);
		}

		public void threadSafeObjectCall(Object object) {
			object.toString();
		}
	}

	static class NotThreadSafe {
		StringBuilder builder = new StringBuilder();

		public void add(String text) {
			this.builder.append(text);
		}
	}
}

/*
 * Race conditions occur only if multiple threads are accessing the same
 * resource, and one or more of the threads write to the resource. If multiple
 * threads read the same resource race conditions do not occur.
 * 
 * We can make sure that objects shared between threads are never updated by any
 * of the threads by making the shared objects immutable, and thereby thread
 * safe. Here is an example:
 * 
 * If you need to perform operations on the ImmutableValue instance you can do
 * so by returning a new instance with the value resulting from the operation.
 * Here is an example of an add operation:
 */

class Immutability {
	private int value = 0;

	public Immutability(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public Immutability add(int valueToAdd) {
		return new Immutability(this.value + valueToAdd);
	}

}