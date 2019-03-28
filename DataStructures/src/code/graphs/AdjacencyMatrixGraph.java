package code.graphs;

import java.awt.peer.FramePeer;
import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrixGraph implements Graph {

	private int[][] adjacencyMatrix;
	private GraphType graphType = GraphType.DIRECTED;
	private int numVertices=0;
	
	//matrix initialization in constructor using num of vertices and graph type.
	public AdjacencyMatrixGraph(int numVertices,GraphType graphType) {
		this.adjacencyMatrix = new int[numVertices][numVertices];
		this.numVertices = numVertices;
		this.graphType = graphType;
		for(int i = 0;i<numVertices;i++) {
			for(int j = 0;j<numVertices;j++) {
				adjacencyMatrix[i][j] = 0;
			}
		}
		
	}
	
	public int getNumVertices() {
		return numVertices;
	}

	public void setNumVertices(int numVertices) {
		this.numVertices = numVertices;
	}

	@Override
	public void addEdge(int v1, int v2) {
		if(v1>numVertices || v1<0 || v2>numVertices ||v2<0) {
			throw new IllegalArgumentException("vertex number is not valid");
		}
		adjacencyMatrix[v1][v2]= 1;
		if(graphType == GraphType.UNDIRECTED) {
			adjacencyMatrix[v2][v1] = 1;
		}
	}

	@Override
	public List<Integer> getAdjacentVertices(int v) {
		if(v>= numVertices || v<0)
			throw new IllegalArgumentException();
		List<Integer> result = new ArrayList<>();
		for(int j = 0;j<adjacencyMatrix.length;j++) {
			if(adjacencyMatrix[v][j]==1)
				result.add(j);
		}
		return result;
	}
	
	public int getIndegree(int v) {
		if(v>= numVertices || v<0)
			throw new IllegalArgumentException();
		
		int indegree=0;
		for(int j = 0;j<adjacencyMatrix.length;j++) {
			if(adjacencyMatrix[j][v]==1)
				indegree++;
		} 
		
		return indegree;
	}

	@Override
	public int getWeightedEdge(int s, int n) {
		// TODO Auto-generated method stub
		return 0;
	}

}
