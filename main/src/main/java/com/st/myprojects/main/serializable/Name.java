/**
 * 
 */
package com.st.myprojects.main.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author sundeeptonse
 *
 */
public class Name implements Serializable {

	private static final long serialVersionUID = 461829524326698943L;
	public String lastName;
	public String firstName;
	public String middleName;

	public void mailCheck() {
		System.out.println("Mailing a check to " + firstName + " " + lastName);
	}

	private void writeObject(ObjectOutputStream s)throws IOException{
		System.out.println("Enter Write Object:" + this);
		s.defaultWriteObject();
		s.writeObject(this.firstName);
		System.out.println("Leaving Write Object:" + this);
	}
	
	
	private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
		System.out.println("Enter Read Object:" + this);
		in.defaultReadObject();
		System.out.println("ReadObject From Stream:" + in.readObject());
		System.out.println("Leaving Read Object:" + this);
	}
	
}
