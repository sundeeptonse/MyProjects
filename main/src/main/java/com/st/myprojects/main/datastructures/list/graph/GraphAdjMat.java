/**
 * 
 */
package com.st.myprojects.main.datastructures.list.graph;

/*-
 * @author sundeeptonse
 * 
 * An Adjacency Matrix is a N*N boolean Matrix where N is the Number of Nodes, where a true value at matrix[i][j] indicates a node From i to k
 * 
 * 		0 	1	2	3
 * 0	0	1	0	0 
 * 1	0	0	1	0
 * 2	1	0	0	0
 * 3	0	0	1	0
 * 
 * 
 */
public class GraphAdjMat {

	boolean[][] adjMatrix;

	GraphAdjMat(int size) {
		adjMatrix = new boolean[size][size];
	}

}
