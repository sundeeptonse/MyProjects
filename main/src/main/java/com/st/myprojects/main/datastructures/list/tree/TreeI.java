/**
 * 
 */
package com.st.myprojects.main.datastructures.list.tree;

/*-
 * @author sundeeptonse
 * 
 * Tree as a non-linear hierarchical data structure
 * Used to Store Hierachical Data
 * 
 * Recursive Data Structure with Tree as Child
 * 
 * root --> First Element
 * children --> Child of any Element
 * parent --> Parent of any Element
 * sibling --> Children with same parent
 * leaf --> has no child
 * ancestor --> Parent of Parent etc
 * descendant -->
 *
 * For a N-Node Tree, there will be N edges
 * 
 * Depth of x :No of Edges from Root or Length from Root
 * 	--> Depth of Root is 0
 * Height of x: No of Edges in Longest Path from x to Leaf
 *	--> Height of the Leaf Node is zero
 * Height of Tree : Height of Root Node
 * Height of Empty Tree : -1
 * 
 * Binary Tree:
 * 		A tree in which each node can have at most 2 children
 * 
 * 	BinaryNode {
 * 		int data;
 * 		Node left;
 * 		Node right;
 *  }
 *  
 *  Applications:
 *  	a) Storing Hierachical Data : File System
 *      b) Organize Data for Quick Search , insertion & deletion
 *      c) Trie --> Dictionary
 *      d) Network Routing Algorithm
 * 
 * 
 * Binary Tree:
 * Complete Binary Tree : Binary Tree with Leaf elements being the left most filled
 * Perfect Binary Tree : Binary Tree with all Elements apart from Leaf having two children
 * 
 * 	   Max Number of Elements at a particular Level to 2^i
 * 	   Max Number of Elements(n) : 2^0 + 2^1 + 2^h = 2^(h+1) -1 or 2^(levels) -1
 *     Max Height with n nodes (perfect Binary Tree)
 *        n = 2^(h+1) - 1 
 *        h = (log (n+1) to the base 2) -1
 *        
 *     Height with n node for a complete Binary tree
 *         Min(h) = log(n) to the base 2 
 *         Max(h) = n-1
 *         
 *    	Operation order directory proportional to h.
 *    	Example if n  = 2^(100)
 *    	Best Case is log(2^100) to the base 2, which is 100
 *      Worst Case is 2^100, which is very big.      
 *         
 *         
 *  Balanced Tree : 
 *     --> Difference between height of the left tree and right tree for ever node 
 *     is no more than k(mostly 1)
 *     ->  This helps reduce the Worst Case and sticks by the Best Case
 *     
 *  diff = | h (left)  - h (right) |
 *  
 *          
 *  Implementation :
 *  a) dynamically created nodes
 *  b) arrays :
 *      
 *      
 *      
 *  Binary Search Tree:
 *  --> A binary tree in which for each node, value of 
 *  all the nodes in the left is lesser or equal to value of all the nodes in the right tree
 *      Node  
 *  Left   Right
 *  (LT)   (GT)
 *  
 *                15
 *             1   |  10
 *          2  |  4  6  |  24     
 *         
 */
public interface TreeI<E> {
	public void insert(E data);
	//public void remove(E data);
	//public void search(E data);
}


