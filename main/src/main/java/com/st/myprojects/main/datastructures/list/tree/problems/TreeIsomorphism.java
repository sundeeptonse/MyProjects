/**
 * 
 */
package com.st.myprojects.main.datastructures.list.tree.problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sundeeptonse
 * 
 *         Tree Isomorphism Problem Write a function to detect if two trees are
 *         isomorphic. Two trees are called isomorphic if one of them can be
 *         obtained from other by a series of flips, i.e. by swapping left and
 *         right children of a number of nodes. Any number of nodes at any level
 *         can have their children swapped. Two empty trees are isomorphic.
 *
 */
public class TreeIsomorphism {

	public static <E> boolean areTreesIsomorphic(TreeNode<E> a, TreeNode<E> b) {
		// Base Condition, if a is null && b is null, then return a match
		// If a is null && b is not null, then return false
		// If b is null && a is not null, then return false
		if (a == null && b == null) {
			return true;
		} else if (a == null) {
			return false;
		} else if (b == null) {
			return false;
		}

		// Check if CurrentNode data is same
		// Check if Left Node is Isomorphic
		return a.data.equals(b.data) && areTreesIsomorphic(a.left, b.right)
				&& areTreesIsomorphic(a.right, b.left);
	}

	public static <E> boolean areTreesIsomorphicLevelOrder(TreeNode<E> a,
			TreeNode<E> b) {
		boolean isomorphic = true;

		Deque<TreeNode<E>> queueA = new ArrayDeque<>();
		queueA.add(a);

		Deque<TreeNode<E>> queueB = new ArrayDeque<>();
		queueB.add(b);

		while (!queueA.isEmpty()) {
			Deque<TreeNode<E>> parentQueueA = queueA;
			Deque<TreeNode<E>> parentQueueB = queueB;
			queueA = new ArrayDeque<>();
			queueB = new ArrayDeque<>();

			/*-
			 * Check the Size, if size doesn't match after each level, then Houston we have a problem
			 */
			if (parentQueueA.size() != parentQueueB.size()) {
				isomorphic = false;
				break;
			}
			while (!parentQueueA.isEmpty()) {
				// One Side Poll First
				TreeNode<E> parentA = parentQueueA.pollFirst();
				// Other Side Poll Last
				TreeNode<E> parentB = parentQueueB.pollLast();
				if (!parentA.equals(parentB)) {
					isomorphic = false;
					break;
				}

				if (parentA.right != null) {
					queueA.add(parentA.right);
				}
				if (parentA.left != null) {
					queueA.add(parentA.left);
				}
				if (parentB.right != null) {
					queueB.add(parentB.right);
				}
				if (parentA.left != null) {
					queueB.add(parentB.left);
				}

			}

		}
		// Add Each Level to a Queue, push all from a to Queue
		// Poll Each Level from the Queue, and compare to the value b

		return isomorphic;

	}

	private static class TreeNode<E> {
		E data;
		TreeNode<E> left;
		TreeNode<E> right;
		// Fill HashCode
	}
}
