package code.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.linkedListImp.Queue;
import com.linkedListImp.QueueOverflowException;
import com.linkedListImp.QueueUnderflowException;

import code.graphs.Graph.GraphType;

/*graph traversal can begin with any node since there is no concept of root node.
 * 
 * https://www.hackerrank.com/challenges/torque-and-development/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=graphs
 * */
public class RoadsAndLibrariesHR {

	public static void main(String[] args) throws QueueOverflowException, QueueUnderflowException {
		
		//int[][] cities = { { 1, 3 }, { 3, 4 }, { 2, 4 }, { 1, 2 }, { 2, 3 }, { 5, 6 } };
		int[][] cities = { { 1, 2 }, { 3, 1 } };
		long result = roadsAndLibraries(3, 2, 1, cities);
		//long result = roadsAndLibraries(6, 2, 5, cities);
		System.out.println(result);
	}

	// Complete the roadsAndLibraries function below.
	static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
		
		//create a graph with cities as nodes
		Graph graph = new Graph(n);
		
		//modeling the graph with cities connections given
		for (int i = 0; i < cities.length; i++) {
			int[] temp = cities[i];
			graph.addEdge(temp[0], temp[1]);
		}

		
		int[] initProcessArray = new int[graph.getNumOfVertices()];
		int[] processedArray = new int[graph.getNumOfVertices()];
		
		List<Integer> NodesInEachSubUnconnectedGraph = new ArrayList<>();

		//below step for unconnected graph else no for loop is needed.
		for (int i = 0; i < graph.getNumOfVertices(); i++) {
			/*once it starts below method only comes out when there is unconnected graph.
			So each time it comes out we capture the node count to keep count of nodes in each unconnected component
			of the graph*/
			graph.DFTGraph(graph, i, processedArray);
			compare(initProcessArray, processedArray, NodesInEachSubUnconnectedGraph);
		}

		//prints nodes in each sub graph (graph which are unconnected)
		System.out.println(NodesInEachSubUnconnectedGraph);
		
		//if c_road>c_lib build libraries a each node else build min road for connectivity and one lib per each component
		
		if(c_lib>c_road) {
			//System.out.println(NodesInEachSubUnconnectedGraph.stream().mapToInt(p-> (p-1)*c_road+c_lib).sum());
			return NodesInEachSubUnconnectedGraph.stream().mapToInt(p-> (p-1)*c_road+c_lib).sum();
		}
		else {
			//System.out.println(NodesInEachSubUnconnectedGraph.stream().mapToInt(p->p).sum()*c_lib);
			return NodesInEachSubUnconnectedGraph.stream().mapToInt(p->p).sum()*c_lib;
		}
	}

	private static void compare(int[] initProcessArray, int[] processedArray, List<Integer> list) {
		int countNodes = 0;
		for (int i = 0; i < initProcessArray.length; i++) {
			if (initProcessArray[i] != processedArray[i]) {
				countNodes++;
				initProcessArray[i] = processedArray[i];
			}
		}
		if (countNodes != 0) {
			list.add(countNodes);
		}
	}



	static class Graph {
		private int numOfVertices;
		private int[][] adjacencyMatrix;

		Graph(int vertices) {
			this.numOfVertices = vertices;
			this.adjacencyMatrix = new int[vertices][vertices];
		}

		public int getNumOfVertices() {
			return numOfVertices;
		}

		public List<Integer> getAdjacentVertices(int vertex) {
			List<Integer> list = new ArrayList<>();
			if (vertex < numOfVertices && vertex >= 0) {

				for (int i = 0; i < numOfVertices; i++) {
					if (adjacencyMatrix[vertex][i] == 1) {
						list.add(i);
					}
				}
			}
			return list;
		}

		// Undirected Graph
		public void addEdge(int v1, int v2) {
			if (v1 <= numOfVertices && v1 >= 1 && v2 <= numOfVertices && v2 >= 1) {
				adjacencyMatrix[v1 - 1][v2 - 1] = 1;
				adjacencyMatrix[v2 - 1][v1 - 1] = 1;
			}
		}
		
		public void DFTGraph(Graph g, int vertex, int[] processed) {
			if (processed[vertex] == 1)
				return;

			List<Integer> adjacent = g.getAdjacentVertices(vertex);
			processed[vertex] = 1;
			//System.out.print(vertex + "--->");
			for (int i = 0; i < adjacent.size(); i++) {
				DFTGraph(g, adjacent.get(i), processed);
			}

		}
	}
}
