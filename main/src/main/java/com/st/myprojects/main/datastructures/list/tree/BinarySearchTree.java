/**
 * 
 */
package com.st.myprojects.main.datastructures.list.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.st.myprojects.main.util.CommonUtil;

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
public class BinarySearchTree<E extends Comparable<E>> implements TreeI<E> {

	private BstNode<E> root;

	/**
	 * @return the root
	 */
	public BstNode<E> getRoot() {
		return root;
	}

	public void insert(E data) {
		root = insert(root, data);
	};

	public void delete(E data) {
		root = delete(root, data);
	};

	/*-
	 * Node to be deleted is
	 * Case 1 : Leaf Node 
	 * 	- Delete the Node and remove the Reference
	 * Case 2 : Node has only one side - left or right 
	 * -  Point the Node's Parent to the Node's Child (Basically removing the reference)
	 * Case 3 : Node has both sides
	 * 	Approach 1 : 
	 *   a) Find Min on the Right Side of the Node
	 *   b) Copy its Value to the Node to be deleted
	 *   c) Delete the Min Node
	 *   
	 *   Approach 2:
	 *   a) Find Max on the Left Side of the Node
	 *   b) Copy its Value to the Node to be deleted
	 *   c) Delete the Max Node
	 *   
	 *   Min on Left and Max on Right makes sure the tree is still a BST 		  
	 * */
	private BstNode<E> delete(BstNode<E> node, E data) {

		// If Node is null, return null
		if (node != null) {

			int compareValue = CommonUtil.compare(data, node.data, null);
			if (compareValue > 0) {
				node.right = delete(node.right, data);
			} else if (compareValue < 0) {
				node.left = delete(node.left, data);
			} else {
				// Node data Matches
				if (node.left == null && node.right == null) {
					// Case 1, mark the current Node value to null
					node = null;
				} else if (node.left == null) {
					// Case2 - // If Node.left == null, mark node as node.right
					node = node.right;
				} else if (node.right == null) {
					// Case2 - // If Node.Right == null, mark node as node.left
					node = node.left;
				}// Case3
				else {
					/*- 
					 * Find the Minimum Node(Right Sub Tree), in the current Tree and assign the data Value to that Node
					 */
					node.data = findMin(node.right).data;

					/*-
					 * Delete that Node with the "Right" Node, starting with the
					 */
					node.right = delete(node.right, node.data);
				}
			}
		}
		return node;
	}

	/*-
	 * Given any Tree, gets the In-order Successor to a given node 
	 * Case1 : If Right SubTree is present, find the Minimum Element in the Right Sub Tree
	 * Case2 : If the Right Sub Tree is null,
	 * 		Walk the Tree and find the Deepest Left Most Ancestor
	 */
	public E getInOrderSuccessor(E data) {
		E inOrderSuccessorValue = null;
		BstNode<E> inOrderSuccessorNode = null;
		// If Current Node is not found
		BstNode<E> currentNode = findNode(root, data);
		if (currentNode != null) {
			if (currentNode.right != null) {
				inOrderSuccessorNode = findMin(currentNode.right);
			} else {
				BstNode<E> ancestor = root;
				// Walking the Line till the Current Node
				while (ancestor != currentNode) {
					// If Current Node is Greater than the Ancestor, go right
					if (CommonUtil.compare(currentNode.data, ancestor.data,
							null) > 0) {
						ancestor = ancestor.right;
					} else {
						// This will store the Value if we taking a left,
						// Over time, till we reach the Current Node this will
						// store the Last Left Ancestor
						inOrderSuccessorNode = ancestor;
						ancestor = ancestor.left;
					}
				}
			}
		}
		if (inOrderSuccessorNode != null) {
			inOrderSuccessorValue = inOrderSuccessorNode.data;
		}
		return inOrderSuccessorValue;
	}

	/*
	 * Given any Tree, finds the Node with the corresponding data
	 */
	private BstNode<E> findNode(BstNode<E> node, E data) {
		BstNode<E> returnNode = null;
		if (node != null) {
			int compare = CommonUtil.compare(node.data, data, null);
			if (compare > 0) {
				returnNode = findNode(node.left, data);
			} else if (compare < 0) {
				returnNode = findNode(node.right, data);
			} else {
				returnNode = node;
			}
		}
		return returnNode;
	}

	public static class Result<E extends Comparable<E>> {
		BstNode<E> node;
		boolean isAncestor;

		public Result() {
			this(null, false);
		}

		public Result(BstNode<E> node) {
			this(node, false);
		}

		public Result(BstNode<E> node, boolean isAncestor) {
			this.node = node;
			this.isAncestor = isAncestor;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return node + ":" + isAncestor;
		}
	}

	public E findCommonAncestor(E data1, E data2) {
		Result<E> result = findCommonAncestorHelper(this.root, data1, data2);
		return result != null && result.node != null
				&& result.node.data != null && result.isAncestor ? result.node.data
				: null;
	}

	public Result<E> findCommonAncestorHelper(BstNode<E> node, E data1, E data2) {

		Result<E> result = new Result<>();
		if (node != null) {

			int compareData1 = CommonUtil.compare(node.data, data1);
			int compareData2 = CommonUtil.compare(node.data, data2);

			// If the node equals both a and b, return the same node with the
			// same value as ancestor
			if (compareData1 == 0 && compareData2 == 0) {
				result = new Result<>(node, true);
			} else {
				// If Not,
				// Go Left
				Result<E> leftResult = findCommonAncestorHelper(node.left,
						data1, data2);

				if (leftResult.isAncestor) {
					return leftResult;
				}

				// If Not,
				// Go Left
				Result<E> rightResult = findCommonAncestorHelper(node.right,
						data1, data2);

				if (rightResult.isAncestor) {
					return rightResult;
				}

				if (leftResult.node != null && rightResult.node != null) {
					result = new Result<>(node, true);
				} else if (compareData1 == 0 || compareData2 == 0) {

					// If I'm at the either of the two values,
					// If there is a node below me
					// Then I'm the Ancestor
					boolean isAncestor = leftResult.node != null
							|| rightResult.node != null;
					result = new Result<>(node, isAncestor);
				} else {
					// Else
					result = rightResult.node != null ? rightResult
							: leftResult;
				}
			}
		}

		System.out.println("Node:" + (node != null ? node.data : null)
				+ ",Data1:" + data1 + ",Data2:" + data2 + ",result:" + result);
		return result;
	}

	/*
	 * Given any Tree, find and get the Minimum Value in the Tree
	 */
	public E getMinData(BstNode<E> node) {
		E data = null;
		if (node != null) {
			data = findMin(node).data;
		}
		return data;
	}

	/*
	 * Given any Tree, find the Maximum Node Value in the Tree
	 */

	private BstNode<E> findMin(BstNode<E> node) {
		if (node.left == null) {
			return node;
		} else {
			node = findMin(node.left);
		}
		return node;
	}

	/*
	 * Given any Tree, find and get the Minimum Value in the Tree
	 */
	public E getMaxData(BstNode<E> node) {
		E data = null;
		if (node != null) {
			data = findMax(node).data;
		}
		return data;
	}

	/*
	 * Given any Tree, find the Maximum Node Value in the Tree
	 */
	private BstNode<E> findMax(BstNode<E> node) {
		if (node.right == null) {
			return node;
		} else {
			node = findMax(node.right);
		}
		return node;
	}

	/*
	 * Prints Level Order of the Tree based on the order Level Order is Breadth
	 * First Traversal
	 */
	public void printLevelOrder() {
		if (root != null) {
			ArrayDeque<BstNode<E>> queue = new ArrayDeque<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				BstNode<E> currentNode = queue.pollFirst();
				System.out.print(currentNode.data + "-->");
				if (currentNode.left != null) {
					queue.add(currentNode.left);
				}
				if (currentNode.right != null) {
					queue.add(currentNode.right);
				}
			}
		}
	}

	/*
	 * Create Linked List of Levels
	 */
	public List<LinkedList<BstNode<E>>> getLevelOrderLinkedList() {
		// Create an Array List of LinkedList
		List<LinkedList<BstNode<E>>> list = new ArrayList<>();
		if (root != null) {

			// Put into Queue
			ArrayDeque<BstNode<E>> queue = new ArrayDeque<>();
			queue.add(root);
			LinkedList<BstNode<E>> resultLevel;

			while (!queue.isEmpty()) {

				ArrayDeque<BstNode<E>> parentQueue = queue;
				queue = new ArrayDeque<>();
				resultLevel = new LinkedList<>();

				while (!parentQueue.isEmpty()) {
					BstNode<E> currentNode = parentQueue.pollFirst();
					resultLevel.add(currentNode);
					if (currentNode.left != null) {
						queue.add(currentNode.left);
					}
					if (currentNode.right != null) {
						queue.add(currentNode.right);
					}
				}

				list.add(resultLevel);
			}
		}

		return list;
	}

	public enum Order {
		PREORDER, POSTORDER, INORDER
	}

	public boolean isBinarySearchTree() {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBST(BstNode<E> node, int minValue, int maxValue) {
		if (node == null) {
			return true;
		}
		Integer nodeData = (Integer) node.data;
		if (nodeData > minValue && nodeData < maxValue
				&& isBST(node.right, nodeData, maxValue)
				&& isBST(node.left, minValue, nodeData)) {
			return true;
		} else {
			return false;
		}
	}

	public void printDepthFirst(Order orderType) {
		printDepthFirst(root, orderType);
	}

	/*
	 * In Order Traversal is also Sorted Order
	 */
	private void printDepthFirst(BstNode<E> node, Order orderType) {
		if (node != null) {
			if (orderType.equals(Order.PREORDER)) {
				visit(node);
				printDepthFirst(node.left, orderType);
				printDepthFirst(node.right, orderType);
			} else if (orderType.equals(Order.POSTORDER)) {
				printDepthFirst(node.left, orderType);
				printDepthFirst(node.right, orderType);
				visit(node);
			} else if (orderType.equals(Order.INORDER)) {
				printDepthFirst(node.left, orderType);
				visit(node);
				printDepthFirst(node.right, orderType);
			}
		}
	}

	private void visit(BstNode<E> node) {
		System.out.print(node.data + " ");
	}

	private BstNode<E> insert(BstNode<E> node, E data) {
		/*- 
		 * If the current Number is greater than root, then go to right
		 * Else go to Left
		 * If the nextNode(which is currentnode.right or currentnode.left) is
		 * null, then 
		 */

		if (node == null) {
			node = getNewNode(data);
		} else if (CommonUtil.compare(node.data, data, null) <= 0) {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return data.toString();
	}

}