package code.trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import code.trees.VerticalSumGFG.NodeData;

/*
 * https://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
 * Performed In-order traversal and stored vertical sum in hashMap.
* */
public class VerticalSumGFGSol {

	public static void main(String[] args) {
		/* Create the following Binary Tree 
		      1 
		    /    \ 
		  2        3 
		 / \      / \ 
		4   5    6   7 
		
		*/
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		VerticalSumGFGSol t = new VerticalSumGFGSol();

		System.out.println("Following are the values of" + " vertical sums with the positions"
				+ " of the columns with respect to root ");
		t.printVertical(root);
	}

	void printVertical(Node root) {

		Map<Integer, Integer> map = new HashMap<>();

		if (root != null) {
			printVerticalSub(root, 0, map);
		}

		if (map != null) {
			System.out.println(map.entrySet());
		}
	}

	//inorder traversal
	private void printVerticalSub(Node root, int i, Map<Integer, Integer> map) {
		if (root == null)
			return;
		printVerticalSub(root.left, i - 1, map);
		int prevSum = map.get(i) == null ? 0 : map.get(i);
		map.put(i, root.data + prevSum);
		printVerticalSub(root.right, i + 1, map);
	}
}
