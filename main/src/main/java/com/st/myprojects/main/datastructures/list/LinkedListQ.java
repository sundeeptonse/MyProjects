/**
 * 
 */
package com.st.myprojects.main.datastructures.list;

/**
 * @author sundeeptonse
 *
 */
public class LinkedListQ<T> {

	private Node<T> firstNode;
	private Node<T> lastNode;

	/**
	 * To add the first value, add the value to the lastNode.next
	 */
	public void add(T data) {
		Node<T> newNode = new Node<T>(data);
		// If firstNode == null, set the First and Last Node to the newNode
		if (firstNode == null && lastNode == null) {
			firstNode = newNode;
			lastNode = newNode;
		} else {
			// Else, set the lastNode.next as the newNode and set the lastNode
			// to the newNode
			lastNode.next = newNode;
			lastNode = newNode;
		}
	}

	public boolean isEmpty() {
		return (firstNode == null) ? true : false;
	}

	/**
	 * To remove the first value. Change the FirstNode to firstNode.next
	 * 
	 * @return
	 */

	public T removeFirst() {
		// Get the FirstNode Data
		T data = getFirstNodeData();
		if (isEmpty()) {
			// IF the FirstNode is Null, Set the Last Node to Null
			lastNode = null;
		} else {
			firstNode = firstNode.next;
		}
		return data;
	}

	public T getFirstNodeData() {
		return isEmpty() ? null : getFirstNode().data;
	}

	public Node<T> getFirstNode() {
		return this.firstNode;
	}

	public Node<T> getLastNode() {
		return this.lastNode;
	}

	public static class LinkedListUtil {
		public static <T> void printLinkedList(LinkedListQ<T> linkedList) {
			Node<T> node = linkedList.getFirstNode();
			if (node != null) {
				StringBuilder printString = new StringBuilder();
				printString.append(node.data);
				while (node.next != null) {
					printString.append("-->").append(node.next.data);
					node = node.next;
				}
				System.out.println(printString.toString());
			} else {
				System.out.println("Empty");
			}
		}
	}

}
