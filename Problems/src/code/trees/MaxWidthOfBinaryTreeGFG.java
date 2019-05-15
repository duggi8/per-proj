package code.trees;

import java.util.HashMap;
import java.util.Map;

/*
 * https://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/
 * 
 * perform in-order traversal and sum depth of nodes	
 * */
public class MaxWidthOfBinaryTreeGFG {

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
		root.left.left.left = new Node(9);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.left.left = new Node(8);
		root.right.right = new Node(7);
		maxWidth(root);
	}

	/*
	root node is at depth '0'
	So at each depth we calculate width by finding number of nodes at that depth.
	*/
	static void maxWidth(Node root) {
		Map<Integer, Integer> map = new HashMap<>();
		int maxVal = 0;
		maxWidthSub(root, 0, map);
		System.out.println(map.entrySet());
		System.out.println(map.entrySet().stream().mapToInt(v -> v.getValue()).max().getAsInt());
	}

	static void maxWidthSub(Node root, int depth, Map<Integer, Integer> map1) {
		if (root == null)
			return;
		//current depth+1 for left child of current node
		maxWidthSub(root.left, depth + 1, map1);
		//everytime we come across a node in certain depth we update the map.
		//we check if there is already some nodes registered in the map at certain depth- if yes we add +1 to 
		//existing width.
		int WidthAtDepth = map1.get(depth) == null ? 0 : map1.get(depth);
		map1.put(depth, WidthAtDepth + 1);
		maxWidthSub(root.right, depth + 1, map1);
	}
}
