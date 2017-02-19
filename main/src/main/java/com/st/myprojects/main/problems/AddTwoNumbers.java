/**
 * 
 */
package com.st.myprojects.main.problems;

/**
 * @author sundeeptonse
 * 
 *         You are given two linked lists representing two non-negative numbers.
 *         The digits are stored in reverse order and each of their nodes
 *         contain a single digit. Add the two numbers and return it as a linked
 *         list.
 * 
 *         Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 *
 */
public class AddTwoNumbers {

	public static void main(String... args) {

		int maxLength = 10;
		int multiplier = 10;

		ListNode l1 = DataStructureUtils.createListNodes(maxLength, multiplier,
				9);
		DataStructureUtils.printListNode(l1);
		ListNode l2 = DataStructureUtils.createListNodes(maxLength, multiplier,
				9);
		DataStructureUtils.printListNode(l2);
		DataStructureUtils.printListNode(addTwoNumbers(l1, l2));
	}

	public static ListNode addTwoNumbers_Opt(ListNode l1, ListNode l2) {
		ListNode listNode = null;
		ListNode firstNodeReference = null;
		ListNode node1 = l1;
		ListNode node2 = l2;
		int multipier = 0;
		while (!(node1 == null && node2 == null && multipier <= 0)) {
			int sum = 0;
			if (node1 != null && node2 != null) {
				sum = node1.val + node2.val;
				node1 = node1.next;
				node2 = node2.next;
			} else if (node1 == null && node2 == null) {
			} else if (node1 == null) {
				sum = node2.val;
				node2 = node2.next;
			} else if (node2 == null) {
				sum = node1.val;
				node1 = node1.next;
			}
			sum += multipier;

			int modulo = sum % 10;
			multipier = sum / 10;
			if (firstNodeReference == null) {
				firstNodeReference = new ListNode(modulo);
				listNode = firstNodeReference;
			} else {
				listNode.next = new ListNode(modulo);
				listNode = listNode.next;
			}
		}
		return firstNodeReference;
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode listNode = null;
		ListNode firstNodeReference = null;
		ListNode node1 = l1;
		ListNode node2 = l2;
		int multipier = 0;
		while (!(node1 == null && node2 == null && multipier <= 0)) {
			int sum = 0;
			if (node1 != null && node2 != null) {
				sum = node1.val + node2.val;
				node1 = node1.next;
				node2 = node2.next;
			} else if (node1 == null && node2 == null) {
			} else if (node1 == null) {
				sum = node2.val;
				node2 = node2.next;
			} else if (node2 == null) {
				sum = node1.val;
				node1 = node1.next;
			}
			sum += multipier;

			int modulo = sum % 10;
			multipier = sum / 10;
			if (firstNodeReference == null) {
				firstNodeReference = new ListNode(modulo);
				listNode = firstNodeReference;
			} else {
				listNode.next = new ListNode(modulo);
				listNode = listNode.next;
			}
		}
		return firstNodeReference;
	}
}

class DataStructureUtils {

	public static ListNode createListNodes(int maxLength, int multiplier,
			int... endWith) {

		ListNode lNew = new ListNode((int) (Math.random() * multiplier));
		ListNode currentNode = lNew;
		for (int i = 1; i < maxLength; i++) {
			ListNode newNode = new ListNode((int) (Math.random() * multiplier));
			currentNode.next = newNode;
			currentNode = newNode;
		}
		for (int i = 0; i < endWith.length; i++) {
			ListNode newNode = new ListNode(endWith[i]);
			currentNode.next = newNode;
			currentNode = newNode;
		}
		return lNew;
	}

	public static void printListNode(ListNode parent) {
		ListNode node = parent;
		StringBuilder str = new StringBuilder();
		while (node != null) {
			str.append(node.val + "-->");
			node = node.next;
		}
		System.out.println(str.toString());
	}
}

/**
 * Definition for singly-linked list.
 *
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}