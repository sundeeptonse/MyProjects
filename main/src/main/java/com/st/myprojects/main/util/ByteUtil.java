/**
 * 
 */
package com.st.myprojects.main.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

/**
 * @author sundeeptonse
 *
 */
public class ByteUtil {

	// Returns the object with the specified serialized form
	public static Object objectOfByteArray(byte[] sf) {
		try {
			InputStream is = new ByteArrayInputStream(sf);
			ObjectInputStream ois = new ObjectInputStream(is);
			Object obj = ois.readObject();
			return obj;
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static <T> byte[] getByteArrayOfObject(T object) {
		byte[] byteArray = {};
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(object);

			byteArray = bos.toByteArray();

			oos.close();
			bos.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return byteArray;
	}

	public static void printByteArray(byte[] arrayPrint) {
		System.out.println(Arrays.toString(bytearray2intarray(arrayPrint)));
	}

	public static int[] bytearray2intarray(byte[] barray) {
		int[] iarray = new int[barray.length];
		int i = 0;
		for (byte b : barray) {
			iarray[i] = b & 0xff;
			i++;
		}
		// "and" with 0xff since bytes are signed in java
		return iarray;
	}
}
