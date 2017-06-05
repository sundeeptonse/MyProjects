/**
 * 
 */
package com.st.myprojects.main.datastructures.list.graph;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.st.myprojects.main.util.StringUtil;

/**
 * @author sundeeptonse
 *
 */
public class GraphProblemBuildOrder {

	public static void main(String... args) {
		GraphProblemBuildOrder graph = new GraphProblemBuildOrder();
		graph.addEdge("a", "d");
		graph.addEdge("f", "b");
		graph.addEdge("b", "d");
		graph.addEdge("f", "a");
		graph.addEdge("d", "c");
		graph.addProject("e");

		System.out.println(graph.orderProjects());
	}

	Map<String, ProjectNode> allProjects = new HashMap<>();

	public ProjectNode createIfAbsentProject(String name) {
		if (StringUtil.isNull(name)) {
			throw new NullPointerException();
		}
		ProjectNode projectNode = allProjects.get(name);
		if (projectNode == null) {
			projectNode = new ProjectNode(name);
			allProjects.put(name, projectNode);
		}
		return projectNode;
	}

	public void addProject(String project) {
		createIfAbsentProject(project);
	}

	public void addEdge(String source, String destination) {
		ProjectNode sourceP = createIfAbsentProject(source);
		ProjectNode destinationP = createIfAbsentProject(destination);
		sourceP.addChild(destinationP);
	}

	public Set<String> orderProjects() {

		System.out.println("All Projects:" + allProjects);
		// Set a Build Order
		Set<String> buildOrder = new LinkedHashSet<>(allProjects.size());
		for (int i = 0; i < allProjects.size(); i++) {
			// If the Build Order is Complete then get Out
			if (buildOrder.size() == allProjects.size()) {
				break;
			}
			processNodeWithNoIncoming(buildOrder);
		}
		// If at the end, there isn't a size, then mark as null
		if (buildOrder.size() != allProjects.size()) {
			buildOrder = null;
		}
		System.out.println("All Projects:" + allProjects);
		return buildOrder;
	}

	private void processNodeWithNoIncoming(Set<String> buildOrder) {
		for (String key : allProjects.keySet()) {
			ProjectNode node = allProjects.get(key);
			if (!buildOrder.contains(key)) {
				// Add the Nodes with no Incoming Nodes to the Build Order
				// If all the Children are in the Map an
				// Remove the Children for these Nodes
				if (node.dependencies == 0) {
					buildOrder.add(key);
					node.removeAllChildren();
				}
			}
		}
	}

	public static class ProjectNode {
		String name;
		int dependencies;
		Map<String, ProjectNode> children = new ConcurrentHashMap<>();

		public ProjectNode(String name) {
			this.name = name;
		}

		public void addChild(ProjectNode node) {
			if (!children.containsKey(node.name)) {
				node.dependencies++;
				children.put(node.name, node);
			}
		}

		public void removeChild(ProjectNode node) {
			if (!children.containsKey(node.name)) {
				node.dependencies--;
				children.remove(node.name);
			}
		}

		public void removeAllChildren() {
			for (String child : children.keySet()) {
				ProjectNode childNode = children.get(child);
				children.remove(child);
				childNode.dependencies--;
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			StringBuilder string = new StringBuilder();
			string.append(this.name).append(":").append(this.dependencies)
					.append(":");
			for (String child : children.keySet()) {
				string.append(child).append("/");
			}
			return string.toString();
		}
	}
}
