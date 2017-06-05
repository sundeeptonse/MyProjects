/**
 * 
 */
package com.st.myprojects.main;

/**
 * @author sundeeptonse
 *
 */
public class ClassforName {

	public static void main(String... args) {
		Class<?> cl = null;
		try {
	        // returns the Class object for the class with the specified name
			cl = Class.forName("java.lang.ClassLoader");
	         
	        // returns the name and package of the class
	        System.out.println("Class found = " + cl.getName());
	        System.out.println("Package = " + cl.getPackage());
	     }
	     catch(ClassNotFoundException ex) {
	        System.out.println(ex.toString());
	     }
	}
	
	
	public void test(){
		throw new Error();
		//throw new RuntimeException("Ola");
		
	}
	
	public void test2() throws Exception{
		throw new Exception();
	}
}
