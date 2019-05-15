package code.graphs;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import code.graphs.AdjacencySetGraph.Node;
import code.graphs.RoadsAndLibrariesAdjacencySetHR.Graph;

public class Solution {
	
	

	public static void main(String[] args) throws IOException {
		//BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		
		final Scanner scanner = new Scanner(new File("input03.txt"));
		
		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String[] nmC_libC_road = scanner.nextLine().split(" ");

			int n = Integer.parseInt(nmC_libC_road[0]);

			int m = Integer.parseInt(nmC_libC_road[1]);

			int c_lib = Integer.parseInt(nmC_libC_road[2]);

			int c_road = Integer.parseInt(nmC_libC_road[3]);

			int[][] cities = new int[m][2];

			for (int i = 0; i < m; i++) {
				String[] citiesRowItems = scanner.nextLine().split(" ");
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				for (int j = 0; j < 2; j++) {
					int citiesItem = Integer.parseInt(citiesRowItems[j]);
					cities[i][j] = citiesItem;
				}
			}

			long result = roadsAndLibraries(n, c_lib, c_road, cities);

			System.out.println(result);
			//bufferedWriter.write(String.valueOf(result));
			//bufferedWriter.newLine();
		}

		//bufferedWriter.close();

		scanner.close();
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
		//System.out.println(NodesInEachSubUnconnectedGraph);

		//if c_road>c_lib build libraries a each node else build min road for connectivity and one lib per each component

		if (c_lib > c_road) {
			//System.out.println(NodesInEachSubUnconnectedGraph.stream().mapToInt(p-> (p-1)*c_road+c_lib).sum());
			return NodesInEachSubUnconnectedGraph.stream().mapToInt(p -> (p - 1) * c_road + c_lib).sum();
		} else {
			//System.out.println(NodesInEachSubUnconnectedGraph.stream().mapToInt(p->p).sum()*c_lib);
			return NodesInEachSubUnconnectedGraph.stream().mapToInt(p -> p).sum() * c_lib;
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
		private List<Node> vertexList = new ArrayList<>();

		Graph(int vertices) {
			this.numOfVertices = vertices;
			for (int i = 0; i < vertices; i++) {
				vertexList.add(new Node(i));
			}
		}

		public int getNumOfVertices() {
			return numOfVertices;
		}

		public List<Integer> getAdjacentVertices(int vertex) {
			List<Integer> list = new ArrayList<>();
			if (vertex < numOfVertices && vertex >= 0) {
				list = vertexList.get(vertex).getAdjacentVertices();
			}
			return list;
		}

		// Undirected Graph
		public void addEdge(int v1, int v2) {
			if (v1 <= numOfVertices && v1 >= 1 && v2 <= numOfVertices && v2 >= 1) {
				vertexList.get(v1-1).addEdge(v2-1);
				vertexList.get(v2-1).addEdge(v1-1);
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
