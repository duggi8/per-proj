package com.tj.avlTree;


//AVLTree impl
class AVLTreeImpl { 

	TreeNode rootTreeNode; 

	// get height
	int height(TreeNode N) { 
		if (N == null) 
			return 0; 

		return N.height; 
	} 

	//get max val
	int max(int a, int b) { 
		return (a > b) ? a : b; 
	} 

	// for rotation
	TreeNode rightRotate(TreeNode y) { 
		TreeNode x = y.left; 
		TreeNode T2 = x.right; 

		//doing rotation 
		x.right = y; 
		y.left = T2; 

		// Upd height
		y.height = max(height(y.left), height(y.right)) + 1; 
		x.height = max(height(x.left), height(x.right)) + 1; 


		return x; 
	} 

	//rotate left
	TreeNode leftRotate(TreeNode x) { 
		TreeNode y = x.right; 
		TreeNode T2 = y.left; 

		y.left = x; 
		x.right = T2; 

		x.height = max(height(x.left), height(x.right)) + 1; 
		y.height = max(height(y.left), height(y.right)) + 1; 

		return y; 
	} 

	// derive balance factor
	int getBalance(TreeNode N) { 
		if (N == null) 
			return 0; 

		return height(N.left) - height(N.right); 
	} 

	TreeNode insert(TreeNode node, int key) { 

		if (node == null) 
			return (new TreeNode(key)); 

		if (key < node.key) 
			node.left = insert(node.left, key); 
		else if (key > node.key) 
			node.right = insert(node.right, key); 
		else 
			return node; 

		node.height = 1 + max(height(node.left), 
							height(node.right)); 

	
		int balance = getBalance(node); 

		if (balance > 1 && key < node.left.key) 
			return rightRotate(node); 

		// RR
		if (balance < -1 && key > node.right.key) 
			return leftRotate(node); 

		// LR
		if (balance > 1 && key > node.left.key) { 
			node.left = leftRotate(node.left); 
			return rightRotate(node); 
		} 

		// RL
		if (balance < -1 && key < node.right.key) { 
			node.right = rightRotate(node.right); 
			return leftRotate(node); 
		} 

		return node; 
	} 

	//PRINT PREORDER
	void preOrder(TreeNode node) { 
		if (node != null) { 
			System.out.print(node.key + " "); 
			preOrder(node.left); 
			preOrder(node.right); 
		} 
	} 
	
	static class TreeNode { 
		int key, height; 
		TreeNode left, right; 

		TreeNode(int d) { 
			key = d; 
			height = 1; 
		} 
	} 

	public static void main(String[] args) { 
		AVLTreeImpl t = new AVLTreeImpl(); 

		//build tree
		t.rootTreeNode = t.insert(t.rootTreeNode, 12); 
		t.rootTreeNode = t.insert(t.rootTreeNode, 8); 
		t.rootTreeNode = t.insert(t.rootTreeNode, 18); 
		t.rootTreeNode = t.insert(t.rootTreeNode, 5); 
		t.rootTreeNode = t.insert(t.rootTreeNode, 11); 
		t.rootTreeNode = t.insert(t.rootTreeNode, 17); 
		t.rootTreeNode = t.insert(t.rootTreeNode, 4);
		t.rootTreeNode = t.insert(t.rootTreeNode, 7);
		t.rootTreeNode = t.insert(t.rootTreeNode, 2);
		
		
		//print pre order
		System.out.println("Preorder traversal is : "); 
		t.preOrder(t.rootTreeNode); 
	} 
} 
