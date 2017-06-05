/**
 * 
 */
package com.st.myprojects.main.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sundeeptonse
 *
 */
public class TreeHeight {

	private int getHeight(Node node) {
		int height = -1;
		if (node != null) {
			int leftHeight = getHeight(node.left);
			int rightHeight = getHeight(node.right);
			height = (leftHeight > rightHeight) ? leftHeight : rightHeight;
			height++;
		}
		return height;

	}

	/*
	 * You are given a pointer to the root of a binary tree. Print the top view
	 * of the binary tree. You only have to complete the function.
	 */

	void top_view(Node root) {

		StringBuilder str = new StringBuilder();
		if (root != null) {
			str.append(printOuterMostNode(root.left, true)).append(root.data)
					.append(" ").append(printOuterMostNode(root.right, false));
		}
		System.out.println(str.toString());
	}

	private String printOuterMostNode(Node node, boolean left) {
		StringBuilder str = new StringBuilder();
		if (node != null) {
			if (left) {
				str.append(printOuterMostNode(node.left, left));
				str.append(node.data).append(" ");
			} else {
				str.append(node.data).append(" ");
				str.append(printOuterMostNode(node.right, left));
			}
		}
		return str.toString();
	}

	/*-
	You are given a pointer to the root of a binary tree. You need to print the level order traversal of this tree. In level order traversal, we visit the nodes level by level from left to right. 
	You only have to complete the function. 
	For example:

	         3
	       /   \
	      5     2
	     / \    /
	    1   4  6
	For the above tree, the level order traversal is 3 -> 5 -> 2 -> 1 -> 4 -> 6.
	 */
	void LevelOrder(Node root) {
		List<Node> rootList = new ArrayList<Node>();
		rootList.add(root);
		String out = printLevel(rootList);
		System.out.println(out);
	}

	private String printLevel(List<Node> listofNodes) {
		List<Node> nextNodes = new ArrayList<>();
		StringBuilder str = new StringBuilder();
		for (Node currentNode : listofNodes) {
			if (currentNode != null) {
				str.append(currentNode.data).append(" ");
				nextNodes.add(currentNode.left);
				nextNodes.add(currentNode.right);
			}
		}
		if (nextNodes.size() > 0) {
			str.append(printLevel(nextNodes));
		}
		return str.toString();
	}

}
