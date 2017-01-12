/**
 * 
 */
package com.st.myprojects.main.datastructures.list.tree;

import com.st.myprojects.main.datastructures.list.tree.BinarySearchTree.Order;

/**
 * @author sundeeptonse
 *
 */
public class BSTTest {

	public static void main(String[] args) {

		/*-
		 *        15
		 *  13         20 
		 *11  14   18      26
		 *       17	 19   24   27
		 *            
		 */
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(15);
		tree.insert(13);
		tree.insert(11);
		tree.insert(14);
		tree.insert(20);
		tree.insert(18);
		tree.insert(19);
		tree.insert(17);
		tree.insert(26);
		tree.insert(26);
		tree.insert(24);
		tree.insert(24);
		tree.insert(27);
		tree.printLevelOrder();
		System.out.println();

		System.out.println("Common Ancestor:" + tree.findCommonAncestor(15,15));

//		System.out.println("IsBinaryTree" + tree.getLevelOrderLinkedList());
//
//		System.out.println("IsBinaryTree" + tree.isBinarySearchTree());
//		tree.printLevelOrder();
//		System.out.println();
//		System.out.println("In Order:");
//		tree.printDepthFirst(Order.INORDER);
//		System.out.println();
//		tree.printDepthFirst(Order.POSTORDER);
//		System.out.println();
//		tree.printDepthFirst(Order.PREORDER);
//		System.out.println();
//
//		System.out.println("Min Data:" + tree.getMinData(tree.getRoot()));
//		System.out.println("Max Data:" + tree.getMaxData(tree.getRoot()));
//
//		// Delete Operation
//		tree.delete(15);
//		System.out.println("IsBinaryTree" + tree.isBinarySearchTree());
//
//		tree.printLevelOrder();
//		System.out.println();
//		System.out.println("In Order Successors");
//
//		System.out.println(14 + ":" + tree.getInOrderSuccessor(14));
//		System.out.println(13 + ":" + tree.getInOrderSuccessor(13));
//		System.out.println(11 + ":" + tree.getInOrderSuccessor(11));
//		System.out.println(27 + ":" + tree.getInOrderSuccessor(27));
//		System.out.println(26 + ":" + tree.getInOrderSuccessor(26));
//		System.out.println(19 + ":" + tree.getInOrderSuccessor(19));
//		System.out.println(244 + ":" + tree.getInOrderSuccessor(244));

	}

}
