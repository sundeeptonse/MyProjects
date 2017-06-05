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
public class SerializableTest {

	private static String location = "/Users/sundeeptonse/tmp/name.ser";
	public static void main(String... args) {
		Name name = new Name();
		name.firstName = "Sundeep";
		name.middleName = "B";
		name.lastName = "Tonse";
	
		try {
			FileOutputStream fileOut = new FileOutputStream(location);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			
			System.out.println("Before Write Object Call:" + name);
			out.writeObject(name);
			System.out.println("After Write Object Call:" + name);
			out.close();
			fileOut.close();
			System.out.println("Serialized data is saved in " + location);
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
}
