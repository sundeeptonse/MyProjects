/**
 * 
 */
package com.st.myprojects.main.problems;

/*-
 * @author sundeeptonse
 *Huffman coding assigns variable length codewords to fixed length input characters based on their frequencies. More frequent characters are assigned shorter codewords and less frequent characters are assigned longer codewords. A Huffman tree is made for the input string and characters are decoded based on their position in the tree. We add a '0' to the codeword when we move left in the binary tree and a '1' when we move right in the binary tree. We assign codes to the leaf nodes which represent the input characters.

 For example :

 {ϕ,5}
 0 /     \ 1
 {ϕ,2}   {A,3}
 0/   \1
 {B,1}  {C,1}  
 Input characters are only present on the leaves. Internal nodes have a character value of ϕ. Codewords:

 A - 1
 B - 00
 C - 01
 No codeword appears as a prefix of any other codeword. Huffman encoding is a prefix free encoding technique.

 Encoded String "1001011" represents the string "ABACA"

 You have to decode an encoded string using the Huffman tree.

 You are given pointer to the root of the Huffman tree and a binary coded string. You need to print the actual string.

 {ϕ,5}
 0 /     \ 1
 {ϕ,2}   {A,3}
 0/   \1
 {B,1}  {C,1}  
 S="1001011"
 ABACA

 S="1001011"
 Processing the string from left to right.
 S[0]='1' : we move to the right child of the root. We encounter a leaf node with value 'A'. We add 'A' to the decoded string.
 We move back to the root.

 S[1]='0' : we move to the left child. 
 S[2]='0' : we move to the left child. We encounter a leaf node with value 'B'. We add 'B' to the decoded string.
 We move back to the root.

 S[3] = '1' : we move to the right child of the root. We encounter a leaf node with value 'A'. We add 'A' to the decoded string.
 We move back to the root.

 S[4]='0' : we move to the left child. 
 S[5]='1' : we move to the right child. We encounter a leaf node with value C'. We add 'C' to the decoded string.
 We move back to the root.

 S[6] = '1' : we move to the right child of the root. We encounter a leaf node with value 'A'. We add 'A' to the decoded string.
 We move back to the root.

 Decoded String = "ABACA"

 */
public class TreeHuffmanDecoding {

	private int counter;

	void decode(String string, Node2 root) {
		
		StringBuilder output = new StringBuilder();
		for (; counter < string.length();) {
			output.append(getData(string, root));
		}
		
	}

	private char getData(String value, Node2 node) {
		char data = '/';
		if (node == null) {
		} else if (isLeafNode(node)) {
			data = node.data;
		} else {
			if (counter < value.length()) {
				char valueAtCounter = value.charAt(counter);
				counter++;
				if (valueAtCounter == '1') {
					data = getData(value, node.right);
				} else if (valueAtCounter == '0') {
					data = getData(value, node.left);
				}
			}
		}
		return data;
	}

	private boolean isLeafNode(Node2 node) {
		return (node.left == null && node.right == null) ? true : false;
	}

}

class Node2 {
	public int frequency;
	char data;
	public Node2 left, right;
}
