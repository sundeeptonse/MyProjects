package com.st.myprojects.main;

/*
 * It solves the problem of the sub-class forgetting to call the finalize method of the super-class. 
 * This pattern works by attaching an extra instance with overridden finalize to your super-class. 
 * This way, if the super-class goes out of scope,
 * even the attached instance would go out of scope which would trigger the execution of its finalize 
 * which would in turn call the finalize of the container class.
 */
public class FinalizerGuradian {

	public static void main(final String[] args) throws Exception {
		doIt();
		Thread.sleep(5000); // 5 sec sleep
		System.gc();
		Thread.sleep(5000); // 5 sec sleep
	}

	@SuppressWarnings("unused")
	private final Object guardian = new Object() {
		@Override
		protected void finalize() throws Throwable {
			doFinalize();
			super.finalize();
		}
	};

	private void doFinalize() {
		System.out.println("Finalize of class Parent");
	}

	public static void doIt() {
		Child c = new Child();
		System.out.println(c);
	}

}

class Child {

	// Note, Child class does not call super.finalize()
	@Override
	protected void finalize() {
		System.out.println("Finalize of class Child");
	}

}
