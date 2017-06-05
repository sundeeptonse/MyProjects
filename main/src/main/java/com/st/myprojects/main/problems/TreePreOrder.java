/**
 * 
 */
package com.st.myprojects.main.problems;

/**
 * @author sundeeptonse
 *
 */
public class TreePreOrder {

	void preOrder(Node root) {
		String value = printNode(root);
		System.out.println(value);
	}

	private String printNode(Node node) {
		StringBuilder stringBuilder = new StringBuilder();
		if (node != null) {
			stringBuilder.append(node.data);
			stringBuilder.append(printNode(node.left));
			stringBuilder.append(printNode(node.right));
		}
		return stringBuilder.toString();
	}

	void postOrder(Node root) {
		String value = printNodePost(root);
		System.out.println(value);
	}

	private String printNodePost(Node currentNode) {
		StringBuilder stringBuilder = new StringBuilder();
		if (currentNode != null) {
			stringBuilder.append(printNodePost(currentNode.left));
			stringBuilder.append(printNodePost(currentNode.right));
			stringBuilder.append(currentNode.data);
		}
		return stringBuilder.toString();
	}
	
	
	void inOrder(Node root) {
		String value = printNodeIn(root);
		System.out.println(value);
	}

	private String printNodeIn(Node currentNode) {
		StringBuilder stringBuilder = new StringBuilder();
		if (currentNode != null) {
			stringBuilder.append(printNodeIn(currentNode.left));
			stringBuilder.append(currentNode.data);
			stringBuilder.append(printNodeIn(currentNode.right));
		}
		return stringBuilder.toString();
	}
	
	

}

class Node {
	int data;
	Node left;
	Node right;
}
