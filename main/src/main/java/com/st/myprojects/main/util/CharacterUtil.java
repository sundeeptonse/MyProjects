/**
 * 
 */
package com.st.myprojects.main.util;

/**
 * @author sundeeptonse
 *
 */
public class CharacterUtil {

	private static int min = Character.getNumericValue('a');
	private static int max = Character.getNumericValue('z');

	public static boolean isEnglishAlphabet(char character) {
		int value = Character.getNumericValue(character);
		return value >= min && value <= max;
	}

}
