/**
 * 
 */
package com.st.myprojects.main.datastructures.list.tree;

import java.util.HashMap;
import java.util.Map;

import com.st.myprojects.main.util.Constants;

/*-
 * @author sundeeptonse
 * 
 * Trie is a form of a Tree, generally used to store characters
 * Characters starting from the root can form 1 word or more, similar to having a dictionary
 * 
 * Good for Word Validation Problems
 *
 */
public class Trie {

	private boolean prefixCheck = true;
	private TrieNode root = new TrieNode();

	Trie(boolean prefixCheck) {
		this.prefixCheck = prefixCheck;
	}

	public int getNoOfWords() {
		return this.root.size;
	}

	/*-
	 * Adds a String to the Trie
	 * */
	public void add(String string) {
		if (!StringUtil.isNullOrBlank(string)) {
			add(root, string, 0);
		}
	}

	/*-
	 * Finds the Count of Strings that matches the Trie
	 * */

	public int findCount(String string) {
		return findCount(root, string, 0);
	}

	private void add(TrieNode node, String string, int index) {

		boolean isLastIndex = string.length() - 1 == index;

		// Add the Character at the Index if it is absent
		TrieNode child = node.addChildIfAbsent(string.charAt(index));

		/*- If Prefix Check is True 
		 * If child.size > 1 && this child no Children, This a Leaf Node, whose size > 1
		 * 		 : example hack, hacker, k is leaf Node and size is > 1
		 * If child.size > 1 && isLastIndex, which means it has reached the end of the String which means it is a prefix
		 * 		: example hacker, hack, k will be last index and the size > 1
		 */
		if (prefixCheck && child.size > 1) {
			if (!child.hasChildren()) {
				throw new PrefixCheckException();
			} else if (isLastIndex) {
				throw new PrefixCheckException();
			}
		}

		if (isLastIndex) {
			return;
		}
		// Go to the next index
		add(child, string, ++index);
	}

	public int findCount(TrieNode node, String string, int index) {

		TrieNode childNode = node.getChild(string.charAt(index));
		/*-
		 * If Child is Present 
		 *    If String Length is complete, then return the size of the Child
		 *    Else Recurse
		 * Else
		 * 	 Return 0
		 */
		if (childNode != null) {
			if (string.length() - 1 == index) {
				return childNode.size;
			} else {
				return findCount(childNode, string, ++index);
			}
		}
		return 0;
	}

}

/*
 * A Trie Node will have a Reference to its Children A List will do good, but a
 * hashMap better in case of searching for a particular character
 */
class TrieNode {

	// Store the Children
	Map<Character, TrieNode> children = new HashMap<>();

	// Prefix Check Exception
	boolean prefixCheck = false;

	// Stores the Size of this particular Node
	// Initialize with 1 as when a new Instance of a Character is created,
	// it will have 1
	int size;

	TrieNode() {
	}

	public TrieNode addChildIfAbsent(Character c) {

		TrieNode childNode = getChild(c);
		if (childNode == null) {
			childNode = new TrieNode();
			children.put(c, childNode);
		}
		childNode.size++;

		/*
		 * Return the child
		 */
		return childNode;
	}

	public TrieNode getChild(Character c) {
		return children.get(c);
	}

	public boolean hasChildren() {
		return children.size() > 0 ? true : false;
	}
}

class PrefixCheckException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}

class StringUtil {

	public static boolean isNullOrBlank(String stringValue) {
		return stringValue == null ? true : (stringValue.trim().equals(
				Constants.STR_BLANK) ? true : false);
	}

}
