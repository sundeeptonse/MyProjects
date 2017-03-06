/**
 * 
 */
package com.st.myprojects.main.datastructures.list.tree.problems;

/**
 * @author sundeeptonse
 *
 */
public class TreeContainsTree {

	/*-
	 * Given two Trees, check if a belongs in b or b belongs in a
	 */

	public static <E> boolean contains(TreeNode<E> a, TreeNode<E> b) {
		return contains(a, b, a, b);
	}

	public static <E> boolean contains(TreeNode<E> a, TreeNode<E> b,
			TreeNode<E> aNodeRef, TreeNode<E> bNodeRef) {
		if (a == null && b == null) {
			return false;
		} else if ((a != null && a.equals(bNodeRef))
				|| (b != null && b.equals(aNodeRef))) {
			return true;
		}
		
		// Check Right Node && Check Left Node, if not null
		return contains(a == null ? null : a.right, b == null ? null : b.right,
				aNodeRef, bNodeRef)
				&& contains(a == null ? null : a.right, b == null ? null
						: b.left, aNodeRef, bNodeRef);
	}

	private static class TreeNode<E> {
		E data;
		TreeNode<E> left;
		TreeNode<E> right;
		// Fill HashCode
	}

}
