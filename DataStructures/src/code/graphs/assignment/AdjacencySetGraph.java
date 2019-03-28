/*package code.graphs.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import code.graphs.Graph.GraphType;

 This is Graph implementation, In this implementation we use 'Node' to represent each vertex in the graph and we have HashSet for each Node to represent
 * adjacent vertices 
public class AdjacencySetGraph {

	 To store all vertices from 0-9 we create a List 
	private List<Node> vertexList = new ArrayList<>();

	enum GraphType {
		DIRECTED, UNDIRECTED
	}

	private GraphType graphType;

	private int numVertices = 0;

	
	 * Constructor to initialize the Graph, we input number of vertices in the graph
	 * and graphType for directed/undirected
	 
	public AdjacencySetGraph(int numVertices, GraphType graphType) {
		this.numVertices = numVertices;
		for (int i = 0; i < numVertices; i++) {
			vertexList.add(new Node(i));
		}
		this.graphType = graphType;

	}

	public int getNumVertices() {
		return numVertices;
	}

	 To add edges after the graph creation 
	public void addEdge(int v1, int v2) {
		if (v1 >= numVertices || v1 < 0 || v2 >= numVertices || v2 < 0) {
			throw new IllegalArgumentException();
		}
		vertexList.get(v1).addEdge(v2);
		if (graphType == GraphType.UNDIRECTED) {
			vertexList.get(v2).addEdge(v1);
		}
	}

	 This method return adjacent vertices of an input vertex 
	public List<Integer> getAdjacentVertices(int v) {
		if (v >= numVertices || v < 0)
			throw new IllegalArgumentException();
		return vertexList.get(v).getAdjacentVertices();
	}

	 DEPTH FIRST TRAVERSAL 
	public static void depthFirstTraversal(AdjacencySetGraph graph, int[] visited, int currentVertex) {
		if (visited[currentVertex] == 1) {
			return;
		}
		visited[currentVertex] = 1;
		List<Integer> list = graph.getAdjacentVertices(currentVertex);
		for (int vertex : list) {
			depthFirstTraversal(graph, visited, vertex);
		}
		System.out.print(currentVertex + "-->");
	}

	 BREADTH FIRST TRAVERSAL 
	public static void breadthFirstTraversal(AdjacencySetGraph graph, int[] visited, int currentVertex) {

		java.util.Queue<Integer> queue = new LinkedList();

		queue.add(currentVertex);

		while (!queue.isEmpty()) {
			int current = queue.remove();
			if (visited[current] == 1) {
				continue;
			}
			System.out.print(current + "-->");
			visited[current] = 1;
			List<Integer> list = graph.getAdjacentVertices(current);
			for (int i : list) {
				if (visited[i] != 1) {
					queue.add(i);
				}

			}
		}
	}

	
	 * Node class to represent each vertex. Each vertex has a number to represent it
	 * in the graph and Each vertex has adjacent vertices and they are represented
	 * using Adjacent Set.
	 
	public static class Node {

		private int vertexNumber;
		private Set<Integer> adjacencySet = new HashSet<>();

		public Node(int vertexNumber, Set<Integer> adjacencySet) {
			super();
			this.vertexNumber = vertexNumber;
			this.adjacencySet = adjacencySet;
		}

		public Node(int vertexNumber) {
			this.vertexNumber = vertexNumber;
		}

		public int getVertexNumber() {
			return vertexNumber;
		}

		public void addEdge(int vertexNumber) {
			adjacencySet.add(vertexNumber);
		}

		public List<Integer> getAdjacentVertices() {
			List<Integer> adjacencyList = new ArrayList<>(adjacencySet);
			Collections.sort(adjacencyList);
			return adjacencyList;
		}
	}

	
	 * main method to initialize our graph and execute traversals.
	 

	public static void main(String[] args) {

		// create graph
		AdjacencySetGraph graph = new AdjacencySetGraph(10, GraphType.DIRECTED);
		
		//create 10 vertices in the graph.
		Node n0 = new Node(0, new HashSet<Integer>(Arrays.asList(1, 3)));
		Node n1 = new Node(1, new HashSet<Integer>(Arrays.asList(2)));
		Node n2 = new Node(2, new HashSet<Integer>());
		Node n3 = new Node(3, new HashSet<Integer>(Arrays.asList(4)));
		Node n4 = new Node(4, new HashSet<Integer>(Arrays.asList(5, 8)));
		Node n5 = new Node(5, new HashSet<Integer>(Arrays.asList(1, 6)));
		Node n6 = new Node(6, new HashSet<Integer>(Arrays.asList(7)));
		Node n7 = new Node(7, new HashSet<Integer>());
		Node n8 = new Node(8, new HashSet<Integer>(Arrays.asList(5, 9)));
		Node n9 = new Node(9, new HashSet<Integer>());

		//Adding the vertices created above to the graph
		graph.vertexList.set(0, n0);
		graph.vertexList.set(1, n1);
		graph.vertexList.set(2, n2);
		graph.vertexList.set(3, n3);
		graph.vertexList.set(4, n4);
		graph.vertexList.set(5, n5);
		graph.vertexList.set(6, n6);
		graph.vertexList.set(7, n7);
		graph.vertexList.set(8, n8);  
		graph.vertexList.set(9, n9);

		int[] visitedDepth = new int[graph.getNumVertices()];
		System.out.println("\n" + "*****Depth first traversal*****" + "\n");
		
		depthFirstTraversal(graph, visitedDepth, 0);
		
		int[] visitedBreadth = new int[graph.getNumVertices()];
		System.out.println("\n" + "*****Breadth first traversal*****" + "\n");
		
		breadthFirstTraversal(graph, visitedBreadth, 0);

	}

}
*/