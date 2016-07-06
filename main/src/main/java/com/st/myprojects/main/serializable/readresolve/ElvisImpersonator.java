/**
 * 
 */
package com.st.myprojects.main.serializable.readresolve;

/**
 * @author sundeeptonse
 *
 */
import com.st.myprojects.main.util.ByteUtil;

public class ElvisImpersonator {
	// Byte stream could not have come from real Elvis instance!
	private static  byte[] serializedForm =  ByteUtil.getByteArrayOfObject(Elvis.getAnotherInstance());

	public static void main(String[] args) {
		
		// Initializes ElvisStealer.impersonator and returns
		// the real Elvis (which is Elvis.INSTANCE)
		Elvis elvis = (Elvis) ByteUtil.objectOfByteArray(serializedForm);
		Elvis impersonator = ElvisStealer.impersonator;

		elvis.printFavorites();
		impersonator.printFavorites();
	}

}
