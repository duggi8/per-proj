package code.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class ShortestPathUnweightedLoony {

	public static void shortestPath(Graph g, int source, int destination) {
		Map<Integer, DistanceInfo> distanceTable = buildDistanceTable(g, source);

		Stack<Integer> stack = new Stack<>();
		stack.push(destination);

		int previousVertex = distanceTable.get(destination).getLastVertex();
		while (previousVertex != -1 && previousVertex != source) {
			stack.push(previousVertex);
			previousVertex = distanceTable.get(previousVertex).getLastVertex();
		}

		if (previousVertex == -1)
			System.out.println("There is no path from node: " + source + " to node: " + destination);
		else {
			System.out.println("Smallest path is " + source);
			while (!stack.isEmpty()) {
				System.out.println("--> " + stack.pop());
			}
			System.out.println("Shortest Path Unweighted DONE!!");
		}

	}

	// distanceTable is built based on our source.For different sources distance
	// table will differ.
	private static Map<Integer, DistanceInfo> buildDistanceTable(Graph g, int source) {
		Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
		for (int j = 0; j < g.getNumVertices(); j++) {
			distanceTable.put(j, new DistanceInfo());
		}

		distanceTable.get(source).setDistance(0);
		distanceTable.get(source).setLastVertex(source);

		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(source);

		while (!queue.isEmpty()) {
			int currentVertex = queue.pollFirst();
			/* for each adjacent vertex of source, starting from source */
			for (int i : g.getAdjacentVertices(currentVertex)) {
				int currentDistance = distanceTable.get(i).getDistance();
				/* once a vertex is visited we do not visit it again */
				if (currentDistance == -1) {
					currentDistance = 1 + distanceTable.get(currentVertex).getDistance();
					distanceTable.get(i).setDistance(currentDistance);
					distanceTable.get(i).setLastVertex(currentVertex);
					if (!g.getAdjacentVertices(i).isEmpty()) {
						queue.add(i);
					}
				}
			}
		}

		return distanceTable;
	}

	public static class DistanceInfo {
		private int distance;
		private int lastVertex;

		public DistanceInfo() {
			distance = -1;
			lastVertex = -1;
		}

		public int getDistance() {
			return distance;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}

		public int getLastVertex() {
			return lastVertex;
		}

		public void setLastVertex(int lastVertex) {
			this.lastVertex = lastVertex;
		}
	}

}
