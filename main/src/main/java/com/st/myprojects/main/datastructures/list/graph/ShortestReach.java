/**
 * 
 */
package com.st.myprojects.main.datastructures.list.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author sundeeptonse
 *
 */
public class ShortestReach {

	public static class Graph {
		private Map<Integer, Node> nodeLookUp;

		public Graph(int size) {
			this.nodeLookUp = new TreeMap<Integer, Node>();
			for (int i = 1; i <= size; i++) {
				getNode(i);
			}
		}

		public void addEdge(int first, int second) {
			System.err.println("Adding Edge:" + first + ":" + second);
			Node sourceNode = getNode(first);
			Node destinationNode = getNode(second);
			sourceNode.adjacent.add(destinationNode);
		}

		private Node getNode(int id) {
			Node node = nodeLookUp.get(id);
			if (node == null) {
				node = new Node(id);
				nodeLookUp.put(id, node);
			}
			return node;
		}

		public int[] shortestReach(int startId) {
			visitAllElements(startId);
			int[] array = new int[nodeLookUp.size() - 1];
			int count = 0;
			for (Integer key : nodeLookUp.keySet()) {
				Node node = nodeLookUp.get(key);
				if (node.id != startId) {
					array[count++] = (node != null && node.level > 0 ? (node.level - 1) * 6
							: -1);
				}
			}
			return array;
		}

		private void visitAllElements(int source) {
			// While there are no elements Left in the Queue, keep going over
			// them
			Deque<Node> nodesToBeProcessed = new ArrayDeque<>();
			Node sourceNode = getNode(source);
			sourceNode.level = 1;
			sourceNode.state = State.Visiting;
			nodesToBeProcessed.add(sourceNode);

			while (!nodesToBeProcessed.isEmpty()) {
				// Remove the Current Node
				Node currentNode = nodesToBeProcessed.remove();
				// Set the State to Visited
				currentNode.state = State.Visited;
				// Loop through its Adjacent Values
				for (Node node : currentNode.adjacent) {
					if (node.state == State.Unvisited) {
						// Parent Node Level + 1
						node.level = currentNode.level + 1;
						// Set State to Visiting
						node.state = State.Visiting;
						nodesToBeProcessed.add(node);
					}
				}
			}
		}
	}

	public static class Node {
		private int id;
		public int level;
		public State state = State.Unvisited;
		public LinkedList<Node> adjacent = new LinkedList<>();;

		private Node(int id) {
			this.id = id;
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

	enum State {
		Unvisited, Visited, Visiting;
	};

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int queries = scanner.nextInt();
		for (int t = 0; t < queries; t++) {
			// Create a graph of size n where each edge weight is 6:
			int size = scanner.nextInt();
			Graph graph = new Graph(size);
			int m = scanner.nextInt();
			// read and set edges
			for (int i = 0; i < m; i++) {
				int u = scanner.nextInt();
				int v = scanner.nextInt();
				// add each edge to the graph
				graph.addEdge(u, v);
			}

			// Find shortest reach from node s
			int startId = scanner.nextInt();
			int[] distances = graph.shortestReach(startId);

			for (int i = 0; i < distances.length; i++) {
				System.out.print(distances[i]);
				System.out.print(" ");
			}
			System.out.println();
		}

		scanner.close();
	}
}
