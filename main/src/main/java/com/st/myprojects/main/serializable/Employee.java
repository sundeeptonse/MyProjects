/**
 * 
 */
package com.st.myprojects.main.serializable;

/**
 * @author sundeeptonse
 *
 */
public class Employee implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1528895966064125920L;
	public String name;
	public String address;
	public transient int SSN;
	public int number;

	public void mailCheck() {
		System.out.println("Mailing a check to " + name + " " + address);
	}
}
