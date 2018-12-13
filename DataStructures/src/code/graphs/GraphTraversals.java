package code.graphs;

import java.util.List;

import com.linkedListImp.Queue;
import com.linkedListImp.QueueOverflowException;
import com.linkedListImp.QueueUnderflowException;

import code.graphs.Graph.GraphType;

/*graph traversal can begin with any node since there is no concept of root node.*/
public class GraphTraversals {
	
	public static void main(String[] args) throws QueueOverflowException, QueueUnderflowException {
		GraphTraversals gt = new GraphTraversals();
		Graph graph = new AdjacencyMatrixGraph(8, GraphType.UNDIRECTED);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 5);
		graph.addEdge(5, 2);
		graph.addEdge(5, 6);
		graph.addEdge(2, 6);
		graph.addEdge(2, 3);
		graph.addEdge(6, 3);
		graph.addEdge(6, 7);
		graph.addEdge(3, 7);
		gt.BFTForGraph(graph, 1);
	}

	public void BFTForGraph(Graph g,int vertex) throws QueueOverflowException, QueueUnderflowException {
		Queue<Integer> q = new Queue<>(((AdjacencyMatrixGraph)g).getNumVertices());
		int[] processed = new int[((AdjacencyMatrixGraph)g).getNumVertices()];
		q.enqueue(vertex);
		while(!q.isEmpty()) {
			int vertexProcessed = q.dequeue();
			if(processed[vertexProcessed]==1) {
			continue;
			}
			System.out.print(vertexProcessed + "---");
			processed[vertexProcessed] = 1; 
			
			List<Integer> adj =  g.getAdjacentVertices(vertexProcessed);
			for(int i=0;i<adj.size();i++) {
				if(processed[adj.get(i)]!=1)
				q.enqueue(adj.get(i));
			}
		}
	}
	
}
