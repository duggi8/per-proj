package code.graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import code.graphs.Graph.GraphType;

/*This is AdjacencySet impl of Graph. Here every node(vertex) in graph stores its adjacent vertices using a set.Hence we modeled a node such a way that it has
 * hashset in it to store its adjacent vertices
 * Observe we are instantiating a static class here.'Node' class is created as static because it belongs to 'AdjacencySetGraph' only. 
 * 
 * AdjacencyList uses linkedlist to store their adjacent element similar to below AjacencySet which uses HashSet.
 * 
 * Adjacency Matrix is worth it if there are large number of connections between vertices. Because in Matrix Impl we are creating a space
 * even when there is edge between two vertices. So if many vertices have large connections then it is worth using matrix impl.
 * 
 * Adjacency set we will add to hashset only when there is an adjacent element for a vertex so we don't create empty spaces before itself like in Matrix Impl
 * we use it when there is a sparse graph with less connections.
 * 
 * find out about arraylist,hashset time complexity to search for element.*/
public class AdjacencySetGraph {

	private List<Node> vertexList = new ArrayList<>();
	private GraphType graphType = GraphType.DIRECTED; // we can pass this from constructor but for now we are hardcoding this value.
														
	private int numVertices;

	public AdjacencySetGraph(int numVertices, GraphType graphType) {
		this.numVertices = numVertices;
		for (int i = 0; i < numVertices; i++) {
			vertexList.add(new Node(i));
		}
		this.graphType = graphType;

	}
	
	public void addEdge(int v1,int v2) {
		if(v1>= numVertices || v1<0 || v2>= numVertices || v2 <0) {
			throw new IllegalArgumentException();
		}
		vertexList.get(v1).addEdge(v2);
		if(graphType==GraphType.UNDIRECTED) {
			vertexList.get(v2).addEdge(v1);
		}
	}
	
	public List<Integer> getAdjacentVertices(int v){
		if(v>= numVertices || v<0)
			throw new IllegalArgumentException();
		return vertexList.get(v).getAdjacentVertices();
	}

	public static class Node {
		private int vertexNumber;
		private Set<Integer> adjacencySet = new HashSet<>();

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
}
