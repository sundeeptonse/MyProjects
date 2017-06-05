/**
 * 
 */
package com.st.myprojects.main.problems;

import java.util.Stack;

/**
 * @author sundeeptonse
 *
 */
public class BracesCheck {

	public static void main(String... args) {
		String s = "{[()]}";
		System.out.println(checkBracesMatch(s));
		s = "{[(])}";
		System.out.println(checkBracesMatch(s));
		s = "{{[[(())]]}}";
		System.out.println(checkBracesMatch(s));
	}

	public static String checkBracesMatch(String bracesCheck) {
		String returnValue = "NO";
		if (bracesCheck != null && bracesCheck != ""
				&& bracesCheck.length() % 2 == 0) {
			Stack<Character> stackBraces = new Stack<>();
			for (char c : bracesCheck.toCharArray()) {
				if (stackBraces.size() > 0 && stackBraces.peek() == reverse(c)) {
					stackBraces.pop();
					continue;
				}
				stackBraces.push(c);
			}
			if (stackBraces.size() == 0) {
				returnValue = "YES";
			}
		}
		return returnValue;
	}

	public static char reverse(char c) {
		switch (c) {
		case '{':
			return '}';
		case '}':
			return '{';
		case '[':
			return ']';
		case ']':
			return '[';
		case '(':
			return ')';
		case ')':
			return '(';
		default:
			return '0';
		}
	}
}
