/**
 * 
 */
package com.st.myprojects.main.datastructures.list;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.st.myprojects.main.util.CommonUtil;
import com.st.myprojects.main.util.NumberUtil;

/**
 * @author sundeeptonse
 *
 */
public class LinkedList<T> {

	private Node<T> firstNode;
	private int size = -1;

	// add(int number)
	// O(n)
	public void add(T data) {

		Node<T> newNode = new Node<T>(data);
		if (firstNode == null) {
			firstNode = newNode;
			return;
		}

		Node<T> node = firstNode;
		while (node.next != null) {
			node = node.next;
		}
		node.next = newNode;
	}

	// Remove(int number)
	// O(n)
	public void remove(int number) {

		/*-If the First Node is same as the Node to remove, make the 2nd Node as the FirstNode
		 */

		int counter = 1;
		if (number == counter) {
			firstNode = firstNode.next;
			return;
		}

		Node<T> node = firstNode;
		while (node.next != null) {
			counter++;
			if (number == counter) {
				// If the next node is same as the not we want to remove
				// Then make the next node as the next.next and break loop
				node.next = node.next.next;
				break;
			}
			node = node.next;
		}
	}

	// addAfter(Node node1, Node node2)
	public void addAfter(int nodeNumber, T data) {

		Node<T> newNode = new Node<T>(data);
		Node<T> node = firstNode;
		int counter = 1;

		if (nodeNumber == counter) {
			Node<T> temp = node.next;
			node.next = newNode;
			newNode.next = temp;
			return;
		}

		while (node.next != null) {
			counter++;
			if (nodeNumber == counter) {
				Node<T> temp = node.next;
				node.next = newNode;
				newNode.next = temp;
				return;
			}
			node = node.next;
		}
		node.next = newNode;
	}

	public Node<T> getFirstNode() {
		return this.firstNode;
	}

	public static class LinkedListUtil {

		public static <T> void reverseLinkedListN(LinkedList<T> linkedList) {
			Node<T> currentNode = linkedList.getFirstNode();
			Node<T> nextNode;

			// Create a Previous Value and Set the Previous Value to null
			Node<T> previous = null;
			while (currentNode != null) {
				// Store the nextNode in a Value to be re-used later
				nextNode = currentNode.next;
				// Set the Next Node to the Previous Value
				currentNode.next = previous;
				// Set the Previous to the Current Node
				previous = currentNode;
				// Set the Node Value to node.next
				currentNode = nextNode;
			}

			// Set the First Node to the last Node
			linkedList.firstNode = previous;

		}

		public static <T> void reverseLinkedListS(LinkedList<T> linkedList) {

			Node<T> node = linkedList.getFirstNode();
			if (node == null) {
				return;
			}
			Stack<Node<T>> tempStack = new Stack<>();
			while (node != null) {
				tempStack.push(node);
				node = node.next;
			}
			// Set the First Node to the Last In
			linkedList.firstNode = node = tempStack.pop();
			while (!tempStack.isEmpty()) {
				// Pop and set the current node.next to the popped element
				// Move the pointer
				node = node.next = tempStack.pop();
			}
			node.next = null;
		}

	}
}

class Node<T> {
	// The data being stored in the node
	public T data;
	// A reference to the next node, null for last node
	public Node<T> next;

	public Node(T data) {
		this.data = data;
	}

	public T getData() {
		return this.data;
	}
}

class LinkedListCommonUtil {

	public static <T> int getSize(LinkedList<T> linkedList) {
		int size = 0;
		Node<T> node = linkedList.getFirstNode();
		while (node != null) {
			node = node.next;
			size++;
		}
		return size;
	};

	public static <T> void printLinkedList(LinkedList<T> linkedList) {
		Node<T> node = linkedList.getFirstNode();
		if (node != null) {
			StringBuilder printString = new StringBuilder();
			printString.append(node.data);
			while (node.next != null) {
				printString.append("-->").append(node.next.data);
				node = node.next;
			}
			System.out.println(printString.toString());
		}
	}

	/*
	 * Store two pointers p1 and p2,
	 * 
	 * Move p1 to k times, then move both pointer till we reach the end
	 */

	public static <T> T getElementKToLast(LinkedList<T> linkedList, int k) {
		Node<T> p1, p2;
		p1 = p2 = linkedList.getFirstNode();

		int counter = 1;
		while (counter++ <= k) {
			if (p1 == null) {
				return null;
			}
			p1 = p1.next;
		}

		while (p1 != null) {
			System.out.println("P1:" + p1.data +"P2:" + p2.data);
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p2.data;

	}

	public static <T> boolean isPalindrome(LinkedList<T> linkedList) {
		boolean isPalindrome = true;
		int size = getSize(linkedList);
		int mid = size / 2;
		// If Even, then Size is odd, then we skip the Mid
		boolean skipMid = !NumberUtil.isEven(size);

		// Push the First Half Elements in to the Stack
		// After that pop, the elements and compare till the end
		Stack<T> stack = new Stack<>();

		Node<T> node = linkedList.getFirstNode();
		int count = 0;
		while (node != null) {
			if (count < mid) {
				stack.push(node.data);
			} else {
				if (!(skipMid && count == mid)) {
					T data = stack.pop();
					System.out.println("pop :" + data + ":Node Data:"
							+ node.data);

					if (CommonUtil.compare(node.data, data) != 0) {
						isPalindrome = false;
						break;
					}
				}
			}
			count++;
			node = node.next;
			System.out.println(stack + ":" + count);
		}
		return isPalindrome;
	}
}
