/**
 * 
 */
package com.st.myprojects.main.datastructures.list.tree;

import java.util.Comparator;

/*-
 * @author sundeeptonse
 * 
 * Binary Search Tree:
 *  --> A binary tree in which for each node, value of 
 *  all the nodes in the left is lesser or equal to value of all the nodes in the right tree
 *      Node  
 *  Left      Right
 *  (LT,EQ)   (GT)
 *  
 *  Search/Insert/Delete for a balanced Search Tree is
 *  log(n)
 *
 */
public class BinarySearchTree<E extends Number & Comparable<E>> implements
		TreeI<E> {

	private BstNode<E> root;

	public void insert(E data) {
		root = insert(root, data);
	};

	private BstNode<E> insert(BstNode<E> node, E data) {
		/*- 
		 * If the current Number is greater than root, then go to right
		 * Else go to Left
		 * If the nextNode(which is currentnode.right or currentnode.left) is
		 * null, then 
		 */

		if (node == null) {
			node = getNewNode(data);
		} else if (node.compare(data) <= 0) {
			node.right = insert(node.right, data);
		} else {
			node.left = insert(node.left, data);
		}
		return node;

	}

	private BstNode<E> getNewNode(E data) {
		BstNode<E> newNode = new BstNode<E>();
		newNode.data = data;
		return newNode;
	}

}

class BstNode<E extends Comparable<E>> {
	E data;
	BstNode<E> left, right;

	public int compare(BstNode<E> b) throws ClassCastException {
		return this.data.compareTo(b.data);
	}

	public int compare(E data) throws ClassCastException {
		return this.data.compareTo(data);
	}
}