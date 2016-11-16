/**
 * 
 */
package com.st.myprojects.main.datastructures;

/**
 * @author sundeeptonse
 *
 */
public class LinkedList<T> {
	
	private Node<T> firstNode;

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

	public void printLinkedList(Node<T> node) {
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

	private static class Node<T> {
		// The data being stored in the node
		public T data;
		// A reference to the next node, null for last node
		public Node<T> next;

		public Node(T data) {
			this.data = data;
		}
	}
}
