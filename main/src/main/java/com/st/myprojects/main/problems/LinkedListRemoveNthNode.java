/**
 * 
 */
package com.st.myprojects.main.problems;

/**
 * @author sundeeptonse
 *
 */
public class LinkedListRemoveNthNode {

	public static void main(String... args) {
		int maxLength = 10;
		int multiplier = 10;
		ListNode l1 = DataStructureUtils.createListNodes(maxLength, multiplier);
		DataStructureUtils.printListNode(l1);
		l1 = removeNthFromEnd(l1, 4);
		DataStructureUtils.printListNode(l1);
		
		ListNode l2 = DataStructureUtils.createListNodes(1, multiplier);
		DataStructureUtils.printListNode(l2);
		l2 = removeNthFromEnd(l2, 1);
		DataStructureUtils.printListNode(l2);
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {

		// 1->2->3->4
		// 1

		// N = 1, is the first Element from the End
		// N = length, is the last Element from the End, i.e the first Element

		// Two Pointer's - Fast/Slow
		// Fast Pointer goes forward n-1 steps
		// Example if 2, then it moves forward 1 step
		// Slow Pointer stays

		ListNode fastPointer = head;
		ListNode slowPointer = head;

		// If n = 1, then we don't move the pointer or the next Value is Null
		// Both the fast & slow point to the same point
		while (n-- > 1) {
			fastPointer = fastPointer.next;
		}

		// Store a reference to the Parent as null
		// Move Fast/Slow Pointer till we reach the end of loop
		// Update the Parent before moving to next
		// The Slow Pointer will be the Element we want to delete
		ListNode parent = null;
		while (fastPointer.next != null) {
			parent = slowPointer;
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next;
		}
		return deleteChild(head, parent, slowPointer);
	}

	/*
	 * Given a Parent Node and Child Node, deletes its Child In Case the Parent
	 * is null, then set the Value to the Child
	 */
	private static ListNode deleteChild(ListNode head, ListNode parent, ListNode child) {
		if (parent != null) {
			parent.next = child.next;
		} else {
			head = child.next;
		}
		return head;
	}
}
