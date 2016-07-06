/**
 * 
 */
package com.st.myprojects.main.datatypes.generics.random;

/**
 * @author sundeeptonse
 *
 */
public class MMC2 {

	public static void main(String... args) {

		CustomExtendsA<String> str = new CustomExtendsA<>();

		System.out.println(str.getType2("Hello").getName());
	}
}
