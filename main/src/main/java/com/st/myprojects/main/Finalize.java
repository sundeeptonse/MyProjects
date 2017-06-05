/**
 * 
 */
package com.st.myprojects.main;

import java.util.HashSet;



/**
 * @author sundeeptonse
 * Finally block doesn't guarantee when* it is called.
 * It may cause performance issues
 * If not, Explicit Terminate Pattern should be invoke
 *
 */
public class Finalize extends Object{

	HashSet<?> ss;
	
	/**
	 * @param args
	 */
	public static void main(final String[] args) throws Throwable{
		System.out.println("Here");
		doIt();
		System.gc();
		
		Thread.sleep(5000); // 5 sec sleep
		System.out.println("Here2");
	}
	
	public static void doIt(){
		Test fn = new Test();
		System.out.println(fn);
		
	}
	

}

class Test{
	@Override
	protected void finalize() throws Throwable{
		System.out.println("Hello1");
		super.finalize();
		System.out.println("Hello2");
	}
}
