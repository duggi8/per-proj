package code.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

// https://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
/*
 * */
public class VerticalSumGFG {

	public static void main(String[] args) {
		
		Node n = new Node(5);
		Node n1 = new Node(2);
		Node n2 = new Node(1);
		Node n3 = new Node(3);
		Node n4 = new Node(1);
		Node n5 = new Node(4);
		Node n6 = new Node(2);
		Node n7 = new Node(2);
		n.left = n1;
		n.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.left = n5;
		n2.right = n6;
		n5.right = n7;
		
		printVertical(n);
		
		
	}
	
	static void printVertical(Node root){
		
		//Create a Queue for BFT
		Queue<NodeData> queue = new LinkedList<>();
		//final Map to store all sum of vertical lines
		Map<Integer, Integer> finalMap = new TreeMap<>();
		
		queue.add(new NodeData(root, 0));
		
		while(!queue.isEmpty()) {
			NodeData nd = queue.poll();
			
			Integer vertLine = nd.getVerticalLine();
			
			Integer dataToAdd = nd.getNode().data;
			if(finalMap.containsKey(vertLine)) {
				Integer dataInMap = finalMap.get(vertLine);
				finalMap.put(vertLine, dataInMap+dataToAdd);
			}
			else {
				finalMap.put(vertLine, dataToAdd);
			}
			
			
			
			Node nLeft  = nd.getNode().left;
			if(nLeft!=null) {
				queue.offer(new NodeData(nLeft, vertLine-1));
			}
			Node nRight = nd.getNode().right;
			if(nRight!=null) {
				queue.offer(new NodeData(nRight, vertLine+1));
			}
		}
		
		finalMap.forEach((k,v)-> System.out.print(v+" "));
		
	}
	
	static class NodeData{
		Node node;
		Integer verticalLine;
		public Node getNode() {
			return node;
		}
		public void setNode(Node node) {
			this.node = node;
		}
		public Integer getVerticalLine() {
			return verticalLine;
		}
		public NodeData(Node node, Integer verticalLine) {
			super();
			this.node = node;
			this.verticalLine = verticalLine;
		}
		public void setVerticalLine(Integer verticalLine) {
			this.verticalLine = verticalLine;
		}
		
		
	}
}
