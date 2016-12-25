/**
 * 
 */
package com.st.myprojects.main.datastructures.list.graph;

/*-
 * @author sundeeptonse
 * 
 * A graph(G) is an ordered pair of a set of vertices V with a set of Edges G
 * A tree is a graph 
 * G = (V,E)
 * 
 * 	Ordered Pair
 * 		(a,b) != (b,a) if b!=a
 * 
 * 	Unordered Pair where Order isnt important
 * 		{a,b} = {b,a}
 * 
 * Edges can be directed edges(like a tree) or undirected
 * 
 * Directed  - ordered : (u,v) or (v,u) - either way
 * Undirected - unordered : {u,v}
 * 
 * A graph with a directed edges --> Directed Graph (Di Graph)
 * A graph with all undirected edges --> Undirected Graph
 * 
 * Examples: Social N/W (Undirected), Web Pages with Links (Web Crawling), Road N/W
 * 
 * Weighted vs UnWeighted
 * Weighted - If Edges have some importance :: Example Road N/W with the length of the road
 * UnWeighted - A weighted graph with same edge value 	
 * 
 * Self-Loop: if the vertices is the same
 * Multi-Edge : two edges to the same set of vertices(airplanes + destinations)
 * 
 * If a graph has no self loop and multi-edge it is called a Simple Graph
 * 
 * Max No of edges in a graph
 *  directed : n*(n-1)
 *  un-directed : n*(n-1)/2
 *  Dense vs Sparse Graph
 * 
 *  Walk : a sequence of vertices where each adj pair are connected by an edge
 *  Simple Path : A walk where no vertices and thus no edges are repeated
 *  Trail : a walk where no edges are repeated
 *  
 */
public interface GraphI {

}
