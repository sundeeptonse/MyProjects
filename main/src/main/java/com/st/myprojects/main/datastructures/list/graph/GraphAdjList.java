/**
 * 
 */
package com.st.myprojects.main.datastructures.list.graph;

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;


/*-
 * @author sundeeptonse
 *
 *	This can also be represented as HashMap List, 
 *
 *	Example 
 *  0:1
 *  1:2
 *  2:0,3
 *  3:2
 *  
 *  4:6
 *  5:4
 *  6:5
 *
 */
public class GraphAdjList {

	public static void main(String... args) throws FileNotFoundException {

		// System.setOut(new
		// PrintStream("/Users/sundeeptonse/Desktop/temp.log"));
		GraphAdjList graph = new GraphAdjList();
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(1, 6);
		graph.addEdge(1, 8);
		graph.addEdge(1, 9);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 2);
		graph.addEdge(6, 1);
		graph.printNodes();
		// System.out.println(graph.hasPathDFS(2, 6));
		// System.out.println("BFS::");
		graph.printNodes();
		System.out.println(graph.hasPathBFS(1, 6));
		System.out.println(graph.getLevelBFS(1, 3));
		// graph.printNodes();
		// System.out.println(graph.hasPathBiBFS(1, 6));
	}

	private Map<Integer, Node> nodeLookUp = new HashMap<>();

	private Node getNode(int id) {
		Node node = nodeLookUp.get(id);
		if (node == null) {
			node = new Node(id);
			nodeLookUp.put(id, node);
		}
		return node;
	}

	public void addEdge(int source, int destination) {
		Node sourceNode = getNode(source);
		Node destinationNode = getNode(destination);
		sourceNode.adjacent.add(destinationNode);
	}

	public void printNodes() {
		System.out.println(nodeLookUp.toString());
	}

	public static class Node {
		private int id;
		public int level;
		public State state;
		public LinkedList<Node> adjacent;

		private Node(int id) {
			this.id = id;
			this.adjacent = new LinkedList<>();
		}

		@Override
		public String toString() {
			StringBuilder str = new StringBuilder();
			str.append(this.id).append(",L:'").append(this.level).append("':");
			if (adjacent.isEmpty()) {
				str.append("Empty");
			} else {
				for (Node node : adjacent) {
					str.append(node.id).append("-");
				}
			}
			return str.toString();
		}
	}

	/*-
	 * Breadth First Search
	 * Here we iterate Level by Level
	 * 
	 * If the path from s to t has length d, if in each level there are k nodes
	 * For Level 1 - k times
	 * For Level 2 - k^2 times
	 * For level d - k^d times
	 * 
	 * Time Complexity : O(k^d)
	 */

	enum State {
		Unvisited, Visited, Visiting;
	};

	public boolean hasPathBFS(int source, int destination) {
		return hasPathBFSN(source, destination) != null;
	}

	public int getLevelBFS(int source, int destination) {
		Node destinationNode = hasPathBFSN(source, destination);
		return destinationNode != null ? destinationNode.level - 1 : -1;
	}

	/*
	 * Returns the Node Associated with the Destination with its Level Set
	 */
	private Node hasPathBFSN(int source, int destination) {

		Deque<Node> nodesToBeProcessed = new ArrayDeque<>();

		// Set the State as Unvisited
		for (Integer key : this.nodeLookUp.keySet()) {
			Node node = this.nodeLookUp.get(key);
			node.state = State.Unvisited;
			node.level = 0;
		}
		int currentLevel = 1;

		Node destinationNode = getNode(destination);
		Node sourceNode = getNode(source);

		sourceNode.state = State.Visiting;
		sourceNode.level = currentLevel;
		// Add the Source Node
		nodesToBeProcessed.add(sourceNode);

		Node returnNode = null;
		while (!nodesToBeProcessed.isEmpty()) {
			System.out.println("Queue:" + nodesToBeProcessed);
			// Visit the Node
			Node currentNode = nodesToBeProcessed.remove();
			currentNode.state = State.Visited;
			System.out.println("CurrentNode:" + currentNode + ":Destination:"
					+ destination);
			if (currentNode.id == destinationNode.id) {
				returnNode = destinationNode;
				break;
			} else {
				// Add the Adjacent List to the Queue to be processed in order
				for (Node node : currentNode.adjacent) {
					// Add for those who are unvisited
					if (node.state == State.Unvisited) {
						// Set State to Visiting and add to the Nodes to be
						// processed
						node.state = State.Visiting;
						// Parent Node Level + 1
						node.level = currentNode.level + 1;
						nodesToBeProcessed.add(node);
					}
				}
			}
		}

		return returnNode;

	}

	/*-
	 * Breadth First Search
	 * Here we iterate Level by Level from both the source and the destination till we meet in the middle
	 * 
	 * 
	 * If the path from s to t has length d, if in each level there are k nodes
	 * For Level 1 - k times *2
	 * For Level 2 - k^2 times * 2
	 * For level d - k^(d/2) times * 2
	 * 
	 * Time Complexity : O(k^(d/2)) 
	 * 
	 * TBD
	 */

	public boolean hasPathBiBFS(int source, int destination) {

		// Get the Source/Destination Node
		// Get to Level 1

		Node sourceNode = getNode(source);
		Node destinationNode = getNode(destination);

		// Set Levels Per node
		int currentLevel = 1;

		Deque<Node> queueSource = new ArrayDeque<>();
		// Add the Source Node with Level 1
		sourceNode.level = currentLevel;
		sourceNode.state = State.Visiting;
		queueSource.add(sourceNode);

		Deque<Node> queueDestination = new ArrayDeque<>();
		// Add the Destination Node with Level 2
		destinationNode.level = currentLevel;
		destinationNode.state = State.Visiting;
		queueDestination.add(destinationNode);

		System.out.println(queueDestination);

		boolean hasPath = false;

		while (!queueSource.isEmpty() && !queueDestination.isEmpty()) {

			// Enter the Source Queue
			// Process Level by Level
			// If a Node is either the destination or Matches one of the Nodes
			// in
			// the Visited Nodes of the Destination, then found

			// Enter the Destination Queue
			// Process Level by Level
			// If a Node is either the destination or Matches one of the Nodes
			// in
			// the Visited Nodes of the Source, then found

			

			currentLevel++;
		}
		return hasPath;
	}

	/*
	 * Returns the Mid Node with the Level Added in 
	 * */
	private Node checkNthLevelOfQueue(Deque<Node> queue, int currentLevel,
			boolean source) {

		
		Node node = null;
		System.out.println("Source:" + Boolean.toString(source)
				+ ":currentLevel" + currentLevel + ":" + "Queue:" + queue);
		// Enter the Queue
		// Matches one of the Nodes in the Others Queue, then Found, else add by
		// increasing the currentLevel

		while (!queue.isEmpty()) {
			Node currentNode = queue.peek();
			// If the Node is of the Next Level, return false
			if (currentNode.level > currentLevel) {
				return null;
			} else {
				// Remove the Current Node
				queue.remove();
				currentNode.state = State.Visited;
				
			}
		}
		return node;
	}

	/*-
	 * Depth First Search
	 * Here store the value of the Visited Nodes, and iterate over the adjacents 
	 * 
	 * If number of Levels is l
	 * Then the desitination might lie anywhere in these values
	 * TBD 
	 */
	public boolean hasPathDFS(int source, int destination) {
		Node sourceNode = getNode(source);
		Node destinationNode = getNode(destination);
		Set<Integer> visited = new HashSet<Integer>();
		return hasPathDFS(sourceNode, destinationNode, visited);
	}

	private boolean hasPathDFS(Node source, Node destination,
			Set<Integer> visited) {

		System.out.println("Visited:" + visited);
		System.out.println("CurrentNode:" + source + ":Destination:"
				+ destination);
		// Add to the Visited List
		visited.add(source.id);
		// Check if the id's are Matching
		if (source.id == destination.id) {
			return true;
		}

		// For all the Adjacents Go and call the same method
		for (Node node : source.adjacent) {
			if (!visited.contains(node.id)
					&& hasPathDFS(node, destination, visited)) {
				return true;
			}
		}
		return false;
	}
}
