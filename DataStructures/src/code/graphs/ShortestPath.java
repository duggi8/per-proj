package code.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ShortestPath {
	
	public static void main(String[] args) {
		
	}

	public List<Integer> shortestPathUsingBFS(Graph g, int source, int destination) {

		int[][] distanceTable = initTable(g, source, destination);
		int[] processed = new int[g.getNumVertices()];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(source);
		while (!queue.isEmpty()) {
			int vertex = queue.poll();
			processed[vertex] = 1;
			List<Integer> adj = g.getAdjacentVertices(vertex);
			for (int v = 0; v < adj.size(); v++) {
				distanceTable[adj.get(v)][0] = distanceTable[vertex][0] + 1;
				distanceTable[adj.get(v)][1] = vertex;
			}
			
			//add vertex which are not already processed
			for(int i :adj) {
				if(processed[adj.get(i)]!=1)
					queue.add(adj.get(i));
			}
		}

		List<Integer> pathFromBackwards = new ArrayList<>();
		pathFromBackwards.add(destination);

		int lastVertex = destination;

		while (true) {
			int element = distanceTable[lastVertex][1];
			pathFromBackwards.add(element);
			if (element == source)
				break;
			lastVertex = element;
		}

		return pathFromBackwards;
	
	}

	private static int[][] initTable(Graph g, int s, int d) {
		int[][] distanceTable = new int[g.getNumVertices()][2];
		for (int i = 0; i < g.getNumVertices(); i++) {
			if (i == s) {
				distanceTable[i][0] = 0; // distance from source to source
				distanceTable[i][1] = i; // source in last vertex column
			} else {
				distanceTable[i][0] = -1;
			}
		}
		return distanceTable;
	}
}
