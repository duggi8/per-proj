package code.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TopologicalSort {
	
	public static void main(String[] args) {
		
	}

	
	public static List<Integer> sort(Graph g){
		LinkedList<Integer> queue = new LinkedList<>();
		Map<Integer,Integer> indegreeMap = new HashMap<>();
		
		for(int vertex =0;vertex<g.getNumVertices();vertex++) {
			int indegree = g.getIndegree(vertex);
			indegreeMap.put(vertex, indegree);
			if(indegree==0) {
				queue.add(vertex);
			}
		}
		
		List<Integer> sortedList = new ArrayList<>();
		while(!queue.isEmpty()) {
			int vertex = queue.pollLast();
			sortedList.add(vertex);
			List<Integer> adjacentVertices = g.getAdjacentVertices(vertex);
			for(int adjacentVertex :adjacentVertices) {
				int updatedIndegree = indegreeMap.get(adjacentVertex)-1;
				indegreeMap.remove(adjacentVertex);
				indegreeMap.put(adjacentVertex, updatedIndegree);
				if(updatedIndegree==0) {
					queue.add(adjacentVertex);
				}
			}
		}
		
		if(sortedList.size()!=g.getNumVertices())
			throw new RuntimeException("Graph is cyclic");
		
		return sortedList;
	}
}
