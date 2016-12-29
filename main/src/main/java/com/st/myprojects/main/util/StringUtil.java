/**
 * 
 */
package com.st.myprojects.main.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sundeeptonse
 *
 */
public class StringUtil {

	// Create a ignore List
	private static Map<Character, Integer> ignoreMap = new HashMap<>();
	static {
		ignoreMap.put(' ', (int) ' ');
		ignoreMap.put('.', (int) '.');
		ignoreMap.put(',', (int) ',');
		ignoreMap.put('a', (int) 'a');
		ignoreMap.put('e', (int) 'e');
		ignoreMap.put('i', (int) 'i');
		ignoreMap.put('o', (int) 'o');
		ignoreMap.put('u', (int) 'u');
	}

	// Character.getNumeric doesn't consider case
	private static int numeric_a = Character.getNumericValue('a');
	private static int numeric_z = Character.getNumericValue('z');

	public static void main(String... args) {
		System.out
				.println(isPermutationOfPalindrome("abcdefghijklmnopqrstuvwxyzabcdefghijkl"));
		System.out.println(isPermutationOfPalindrome("aadd"));
		System.out.println(isPermutationOfPalindrome("aaedd"));
	}

	public static boolean isNullOrBlank(String stringValue) {
		return stringValue == null ? true : (stringValue.trim().equals(
				Constants.STR_BLANK) ? true : false);
	}

	public static boolean isNull(String stringValue) {
		return stringValue == null ? true : false;
	}

	/*
	 * Returns true is all the Characters in the String are unique Ignores
	 * Spaces
	 * 
	 * Case Sensitive
	 */

	public static boolean isStringUnique(String stringValue) {
		return isStringUnique(stringValue, false);
	}

	/*
	 * Returns true is all the Characters in the String are unique Ignores
	 * Spaces
	 * 
	 * Has an option to check if the case the same
	 */
	public static boolean isStringUnique(String stringValue, boolean ignoreCase) {

		/*
		 * Algorithm to check if Characters in the String is unique
		 */
		boolean isUnique = true;

		// Initial Size = 127
		Map<Character, Integer> characterMap = new HashMap<>();
		for (int i = 0; i < stringValue.length(); i++) {
			Character character = stringValue.charAt(i);
			if (ignoreCase) {
				character = Character.toLowerCase(character);
			}
			// If the Character isn't present in the ignore List
			if (ignoreMap.get(character) == null) {
				// If the CharacterList has the character,then break
				Integer currentCount = characterMap.get(character);
				if (currentCount != null && currentCount > 1) {
					isUnique = false;
					break;
				} else {
					characterMap.put(character, 1);
				}
			}
		}

		return isUnique;
	}

	/*
	 * Returns true is strings are permutations of each other - i.e Anagram
	 */
	public final static boolean areStringsAnagram(String string1, String string2) {
		return (StringUtil.length(string1) == StringUtil.length(string2)) ? (sortChars(
				string1).compareTo(sortChars(string2)) == 0 ? true : false)
				: false;
	}

	/*
	 * Sort the Characters if not null, returns null if blank
	 */
	public final static String sortChars(String string) {
		if (StringUtil.isNull(string)) {
			return "";
		}
		char[] charArray = string.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}

	/*
	 * Returns the Length of the String, if string is null, returns 0;
	 */
	public final static int length(String string) {
		return StringUtil.isNull(string) ? 0 : string.length();
	}

	/*-
	 * Checks if String is Palindrome 
	 * 
	 * A Palindrome is a String if it can read
	 * the same way from the start and the end
	 * 
	 */
	public final static boolean isPalindrome(String string) {
		boolean isPalindrome = false;
		int stringLength = StringUtil.length(string);
		if (stringLength > 0) {

			int mid = stringLength / 2;
			int leftStart = mid - 1;
			int rightStart = NumberUtil.isEven(stringLength) ? mid : mid + 1;

			isPalindrome = true;
			while (leftStart > -1) {
				if (string.charAt(leftStart--) != string.charAt(rightStart++)) {
					isPalindrome = false;
					break;
				}
			}
		}
		return isPalindrome;
	}

	/*-
	 * Checks if String is Permutation of a Palindrome 
	 * 
	 * A Palindrome is a String if it can read
	 * the same way from the start and the end
	 * 
	 * Example 
	 * acdca is a palindrome
	 * Permutation cadac
	 * 
	 * Options:
	 * We need to count the values of the Characters, example 2 A, 2 B, 3C.
	 * A palindrome will contain a max of only 1 odd sequence
	 * 
	 * 1) We can build the char frequency table and store that # of times each repeats and then iterate over it
	 * 		If more than 1 positive we can exit
	 * :: O(n)
	 * 2) We can keep a counter of the number of Odds in 1 loop
	 * :: O(n)
	 * 3) Since only 26 characters are possible and one of two states of a character i.e either odd or even, 
	 * we can use a bit vector hence reduce space
	 */
	public final static boolean isPermutationOfPalindrome(String string) {

		boolean isPermutationOfaPalindrome = false;

		if (StringUtil.length(string) > 0) {

			// Create a Integer will all zeros
			int bitVector = 0b0;
			// Iterate over the String
			// Get the character Numeric
			// Toggle the Bit in the Integer Matching to the Number.
			for (int i = 0; i < string.length();) {
				char charAtI = string.charAt(i++);
				int charNumber = getCharNumber(charAtI);
				if (charNumber >= 0) {
					bitVector = BitUtil.toggle(bitVector, charNumber);
				}
			}
			// If at the end of it there is more than 1 bit toggle, then it is
			// false
			isPermutationOfaPalindrome = BitUtil
					.checkExactlyOneBitSet(bitVector);
		}

		return isPermutationOfaPalindrome;
	}

	/*
	 * Return the Character Number Differential as defined by the character.
	 * This is not case sensitive
	 * 
	 * Returns -1 if not a character between a & z
	 */
	public final static int getCharNumber(Character c) {
		int numeric_c = Character.getNumericValue(c);
		return (numeric_c >= numeric_a && numeric_c <= numeric_z) ? (numeric_c - numeric_a)
				: -1;
	}

	/*
	 * Replaces the character with a string in the OriginalString
	 */
	public static String replace(String originalString, char character,
			String replacedString) {
		String newString = originalString;
		if (!StringUtil.isNull(originalString)
				&& !StringUtil.isNull(replacedString)) {
			// Count # of Occurences
			int noOfOccurences = 0;

			int nextIndex = 0;
			do {
				nextIndex = originalString.indexOf(character, nextIndex) + 1;
				noOfOccurences++;
			} while (nextIndex > 0);

			int newSize = originalString.length() + noOfOccurences
					* (replacedString.length() - 1);
			char[] charArray = new char[newSize];

			for (int i = 0, j = 0; i < originalString.length() && j < newSize;) {
				char charValueAtI = originalString.charAt(i++);
				// If it matches, now start replacing
				if (charValueAtI == character) {
					for (int k = 0; k < replacedString.length();) {
						charArray[j++] = replacedString.charAt(k++);
					}
				} else {
					charArray[j++] = charValueAtI;
				}
			}
			newString = new String(charArray);
		}
		return newString;
	}

	/*
	 * Replaces the string1 with a string2 in the OriginalString
	 */
	public static void replace(String originalString, String string1,
			String string2) {
	}
	
	/*-
	 * Checks to see if two Strings are rotated
	 * Example: Sundeep deepSun psundee
	 * */

	public static boolean checkIfRotated(String string1, String string2) {
		boolean rotated = false;
		
		return rotated;
	}

}
