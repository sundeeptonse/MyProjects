/**
 * 
 */
package com.st.myprojects.main.patterns.singleton;

import com.st.myprojects.main.util.CharacterUtil;
import com.st.myprojects.main.util.CommonUtil;

/**
 * @author sundeeptonse
 * 
 *         Reverse an array without affecting special characters Given a string,
 *         that contains special character together with alphabets (‘a’ to ‘z’
 *         and ‘A’ to ‘Z’), reverse the string in a way that special characters
 *         are not affected.
 * 
 *         Examples:
 * 
 *         Input: str = "a,b$c" Output: str = "c,b$a" Note that $ and , are not
 *         moved anywhere. Only subsequence "abc" is reversed
 * 
 *         Input: str = "Ab,c,de!$" Output: str = "ed,c,bA!$"
 *
 */
public class ReverseString {

	public static void main(String... args) {
		System.out.println(reverseSkipSpecialCharacters("a,b$c"));
		System.out.println(reverseSkipSpecialCharacters("Ab,c,de!$"));
	}

	public static String reverseSkipSpecialCharacters(String source) {
		char[] sourceArray = source.toCharArray();
		int startIndex = 0;
		int lastIndex = source.length() - 1;

		int i = startIndex;
		int j = lastIndex;

		while (i < j) {

			System.out.println("i:" + i + "j:" + j);
			// Get i & j to the next set of Valid Characters
			while (!CharacterUtil.isEnglishAlphabet(sourceArray[i])) {
				System.out.println("1i:" + i + "j:" + j);
				i++;
			}
			while (!CharacterUtil.isEnglishAlphabet(sourceArray[j])) {
				System.out.println("2i:" + i + "j:" + j);
				j--;
			}

			if (i < j) {
				CommonUtil.swapCh(sourceArray, i++, j--);
			}

		}
		return new String(sourceArray);
	}
}
