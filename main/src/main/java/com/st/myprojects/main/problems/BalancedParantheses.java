/**
 * 
 */
package com.st.myprojects.main.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author sundeeptonse
 *
 */
public class BalancedParantheses {

	public static void main(String... args) {
		String value = "[]{}()[{()}]";
		System.out.println("Value:" + value + ":"
				+ BalancedParanthesesUtil.balancedCheck(value));
		value = "][}{)([{()}]";
		
		value = "[[[[[";
		System.out.println("Value:" + value + ":"
				+ BalancedParanthesesUtil.balancedCheck(value));
	}

	private static class BalancedParanthesesUtil {
		private static Map<Character, Character> map = new HashMap<>();
		static {
			map.put(')', '(');
			map.put('}', '{');
			map.put(']', '[');
		}

		private static boolean balancedCheck(String string) {
			Stack<Character> parantheses = new Stack<>();
			char[] valueArray = string.toCharArray();
			for (char value : valueArray) {
				// If Value Matches Opening Expression, Add to Stack
				if (map.containsValue(value)) {
					parantheses.add(value);
				} else if (map.containsKey(value)) {
					// If Empty, then break;
					// Check the Top of Stack, if not reverse, break,
					if (parantheses.isEmpty()
							|| !parantheses.peek().equals(map.get(value))) {
						return false;
					} else {
						parantheses.pop();
					}

				}
			}
			return parantheses.isEmpty() ? true : false;
		}

	}
}
