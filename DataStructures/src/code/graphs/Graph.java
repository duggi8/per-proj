package code.graphs;

import java.util.List;

/*we have 3 standard ways that graphs can be implemented.
 * 1. Adjacency Matrix
 * 2. Adjacency List
 * 3. Adjacency Set*/
public interface Graph {

	enum GraphType {
		DIRECTED, UNDIRECTED
	}

	void addEdge(int v1, int v2);

	List<Integer> getAdjacentVertices(int v);

	int getNumVertices();

	int getIndegree(int v);

	int getWeightedEdge(int s, int n);
}
