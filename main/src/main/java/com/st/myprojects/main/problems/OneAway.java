/**
 * 
 */
package com.st.myprojects.main.problems;

import com.st.myprojects.main.util.StringUtil;

/*-
 * @author sundeeptonse
 * There are tree types of edits possible on a String : insert/remove/replace
 * 
 * Given two String, check if they are one or zero edits away
 * 
 * Example
 * pale, ple --> true
 * pales, pale -> true
 * piaa, aaxp --> false
 * pale, bae --> false
 * 
 *
 */
public class OneAway {

	public static void main(String... args) {
		System.out.println(checkIfSingleEdit("pale", "ple"));
		System.out.println(checkIfSingleEdit("pale", "pile"));
		System.out.println(checkIfSingleEdit("pppe", "pile"));
		System.out.println(checkIfSingleEdit("ppp", "ppppp"));
	}

	public static boolean checkIfSingleEdit(String string1, String string2) {
		boolean isSingleEdit = false;
		String stringLarger = string1;
		String stringSmaller = string2;

		int lengthDiff = string1.length() - string2.length();
		if (lengthDiff < 0) {
			stringLarger = string2;
			stringSmaller = string1;
		}
		lengthDiff = Math.abs(lengthDiff);
		
		// If the Mod|Diff| <=1, then continue
		if (lengthDiff <= 1) {
			// int diffCount = 0;
			// Iterate through the Larger String

			int diffCount = 0;
			isSingleEdit = true;
			for (int i = 0, j = 0; i < stringLarger.length()
					&& j < stringSmaller.length();) {
				// If the Characters don't match
				// Compare string1.value(i).compare string2.value(i),

				if (StringUtil.getCharNumber(stringLarger.charAt(i)) != StringUtil
						.getCharNumber(stringSmaller.charAt(j))) {
					// if diff, then diffCount++
					// if diffcount > 1, break
					if (++diffCount > 1) {
						isSingleEdit = false;
						break;
					}
					// If Difference in Length is equal to zero, then increment
					// the smaller one,else don't
					if (lengthDiff == 0) {
						j++;
					}
				}else{
					j++;
				}
				
				// Increment the counter for the larger one
				i++;
				
			}

		}
		return isSingleEdit;
	}
}
