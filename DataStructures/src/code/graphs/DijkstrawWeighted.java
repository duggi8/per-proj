package code.graphs;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

import code.graphs.ShortestPathUnweightedLoony.DistanceInfo;

public class DijkstrawWeighted {
	
	public static void shortestPath(Graph g, int source,int destination) {
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
			System.out.println("Dijkstra weighted DONE!!");
		}

	}

	public static Map<Integer, DistanceInfo> buildDistanceTable(Graph g, int source) {
		Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
		PriorityQueue<VertexInfo> queue = new PriorityQueue<>(new Comparator<VertexInfo>() {
			@Override
			public int compare(VertexInfo o1, VertexInfo o2) {

				return ((Integer) o1.getDistance()).compareTo((Integer) o2.getDistance());
			}
		});

		Map<Integer, VertexInfo> vertexInfoMap = new HashMap<>();

		for (int j = 0; j < g.getNumVertices(); j++) {
			distanceTable.put(j, new DistanceInfo());
		}

		distanceTable.get(source).setDistance(0);
		distanceTable.get(source).setLastVertex(source);

		VertexInfo sourceVertexInfo = new VertexInfo(source, 0);
		queue.add(sourceVertexInfo);
		vertexInfoMap.put(source, sourceVertexInfo);

		while (!queue.isEmpty()) {
			VertexInfo vertexInfo = queue.poll();
			int currentVertex = vertexInfo.getVertexId();

			for (Integer neighbour : g.getAdjacentVertices(currentVertex)) {
				int distance = distanceTable.get(currentVertex).getDistance()
						+ g.getWeightedEdge(currentVertex, neighbour);

				/*
				 * If we find a new shortest path to the neighbour update the distance and the
				 * last vertex.
				 */
				if (distanceTable.get(neighbour).getDistance() > distance) {
					distanceTable.get(neighbour).setDistance(distance);
					distanceTable.get(neighbour).setLastVertex(currentVertex);

					/*
					 * we have found short path to neighbour so remove the old node from priority
					 * queue
					 */
					VertexInfo neighbourVertexInfo = vertexInfoMap.get(neighbour);
					if (neighbourVertexInfo != null) {
						queue.remove(neighbourVertexInfo);
					}

					// add neighbour back with updated distance
					neighbourVertexInfo = new VertexInfo(neighbour, distance);
					queue.add(neighbourVertexInfo);
					vertexInfoMap.put(neighbour, neighbourVertexInfo);

				}
			}
		}
		return distanceTable;
	}

	// for storing object in priority queue
	public static class VertexInfo {
		private int vertexId;
		private int distance;

		public VertexInfo(int vertexId, int distance) {
			super();
			this.vertexId = vertexId;
			this.distance = distance;
		}

		public int getVertexId() {
			return vertexId;
		}

		public int getDistance() {
			return distance;
		}

	}

	// For distance table
	public static class DistanceInfo {
		private int distance;
		private int lastVertex;

		public DistanceInfo() {
			distance = Integer.MAX_VALUE;
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
