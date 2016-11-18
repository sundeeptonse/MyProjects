/**
 * 
 */
package com.st.myprojects.main.datastructures.list;

/**
 * @author sundeeptonse
 *
 */
public class LinkedListB {

	private Node firstNode;
	
	// add(int number)
	// O(n)
	public void add(int number) {

		Node newNode = new Node(number);
		if (firstNode == null) {
			firstNode = newNode;
			return;
		}

		Node node = firstNode;
		while (node.next != null) {
			node = node.next;
		}
		node.next = newNode;
	}

	// Remove(Node node)
	// O(n)
	public void remove(int number) {

		/*-If the First Node is same as the Node to remove, make the 2nd Node as the FirstNode
		 */

		int counter = 1;
		if (number == counter) {
			firstNode = firstNode.next;
			return;
		}

		Node node = firstNode;
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
	public void addAfter(int nodeNumber, int number) {

		Node newNode = new Node(number);
		Node node = firstNode;
		int counter = 1;

		if (number == counter) {
			Node temp = node.next;
			node.next = newNode;
			newNode.next = temp;
			return;
		}

		while (node.next != null) {
			counter++;
			if (counter == nodeNumber) {
				Node temp = node.next;
				node.next = newNode;
				newNode.next = temp;
				return;
			}
			node = node.next;
		}
		node.next = newNode;
	}

	public Node getFirstNode() {
		return this.firstNode;
	}

	public static void printLinkedList(Node node) {
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

	private static class Node {
		// The data being stored in the node
		public int data;
		// A reference to the next node, null for last node
		public Node next;

		public Node(int data) {
			this.data = data;
		}
	}
}
