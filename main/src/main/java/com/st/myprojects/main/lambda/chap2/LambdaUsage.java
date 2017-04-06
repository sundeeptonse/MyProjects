/**
 * 
 */
package com.st.myprojects.main.lambda.chap2;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;

/*-
 * @author sundeeptonse
 * Lambda's can be used in six kind of contexts
 * 1) Method or Constructor Arguments
 *		intStream.map(i->blah)
 * 2) Variable declarations and assignment
 * 		Examples:
 * 			Comparator<String> cc = (s1,s2) -> s1.compareToIgnoreCase(s2);
 * 		
 *		Array Type
 * 		IntBinaryOperator[] intBinaryOperator = new IntBinaryOperator[]{
 * 			(x,y) -> x+y , (x,y) -> x-y, (x,y) -> x*y, (x,y) -> x/y;
 * 		}  
 * 3) Return Statements
 * 		Runnable returnDatePrinter(){
 * 			return () -> System.out.println(new Date());
 * 		}
 * 
 * 4) Lambda Expression Bodies for which target type is the type expected for the body which is derived from the other target type
 *  	Callable<Runnable> c = () -> () -> System.out.println("hi");
 * 
 * 5) Ternary Conditional Expressions
 * 		Callable<Integer> c = flag ? (() -> 23) : (() -> 42);
 * 
 * 6) Cast Expressions, which provide the type explicitly
 * 
 * 		Object o = () -> "hi" --> Illegal
 * 		Object s = (Supplier) () -> "hi";
 * 		Object c = (Callable) () -> "hi";
 * 
 * 		Callable c1 = (Callable) s; --> Compile, but ClassCastException during Runtime
 * 
 *
 */
public class LambdaUsage {

	public static void main(String... args) throws Exception {

		// Array assignment
		IntBinaryOperator[] intBinaryOperator = new IntBinaryOperator[] {
				(x, y) -> x + y, (x, y) -> x - y, (x, y) -> x * y,
				(x, y) -> x / y };

		// Return Statement
		new Thread(returnDatePrinter()).start();
		// Or Either
		new Thread(() -> System.out.println(new Date())).start();

		// Nested
		Callable<Runnable> c = () -> () -> System.out.println("hi");

		// Equivalent to
		Callable<Runnable> c1 = new Callable<Runnable>() {
			@Override
			public Runnable call() throws Exception {
				return new Runnable() {
					public void run() {
						System.out.println("hi");
					}
				};
			}
		};

		// Casting () -> "hi" equivalent to () -> return "hi";
		Object sup = (Supplier<String>) () -> "hi";
		Object cal = (Callable<String>) () -> "hi";
		Object run = (Runnable) () -> System.out.println("hi Runnable");
		new Thread((Runnable) run).start();

		someMusings();
		
	}

	public static void someMusings() {
		// A Supplier of Runnable ? Not needed, I can pass the runnable itself ?
		Supplier<Runnable> supplier = () -> () ->
		{
			try {
				Thread.sleep(1000);
				System.out.println("Hi Supplier:"
						+ Thread.currentThread().getName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		};

		System.out.println("Supplier.get():" + supplier.get());
		int x = 5;
		Runnable runner = supplier.get();
		while (x-- > 0) {
			Thread newThread = new Thread(runner, x + "");
			newThread.start();
		}
		createThreads(supplier, 10);

		// /
	}

	public static void createThreads(Supplier<? extends Runnable> supplier,
			int n) {
		Runnable run = supplier.get();
		while (n-- > 0) {
			Thread newThread = new Thread(run);
			newThread.start();
		}
	}

	public static Runnable returnDatePrinter() {
		return () -> System.out.println(new Date());
	}

}
