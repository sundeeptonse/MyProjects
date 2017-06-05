/**
 * 
 */
package com.st.myprojects.main.serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author sundeeptonse
 *
 */
public class DeSerializeTest {

	private static String location = "/Users/sundeeptonse/tmp/name.ser";

	public static void main(String... args) {
		Name name = null;
		try {
			FileInputStream fileIn = new FileInputStream(location);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			System.out.println("Before Read");
			name = (Name) in.readObject();

			System.out.println("Trying to Read Outside" + name);
			
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Name class not found");
			c.printStackTrace();
			return;
		}
		

		System.out.println("Deserialized Name...");
		System.out.println("FName: " + name.firstName);
		System.out.println("FName: " + name.middleName);
		System.out.println("FName: " + name.lastName);

	}
}
