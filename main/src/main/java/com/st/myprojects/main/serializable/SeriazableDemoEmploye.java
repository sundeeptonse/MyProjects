/**
 * 
 */
package com.st.myprojects.main.serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author sundeeptonse
 *
 */
public class SeriazableDemoEmploye {

	private static String location = "/Users/sundeeptonse/tmp/emp.ser";

	public static void main(String[] args) {
		
		Employee e = new Employee();
		e.name = "Reyan Ali";
		e.address = "Phokka Kuan, Ambehta Peer";
		e.SSN = 11122333;
		e.number = 101;

		try {
			FileOutputStream fileOut = new FileOutputStream(location);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(e);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in /tmp/employee.ser");
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

}
