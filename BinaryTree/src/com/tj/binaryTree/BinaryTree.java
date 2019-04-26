package com.tj.binaryTree;

public class BinaryTree {

	private Node root;

	public BinaryTree(Node root) {
		super();
		this.root = root;
	}
	
	public Node getRoot() {
		return root;
	}
	
	public static void main(String[] args) {
		Node root = new Node(8);
		BinaryTree tree = new BinaryTree(root);
		
		tree.insert(3);
		tree.insert(1);
		tree.insert(6);
		tree.insert(4);
		tree.insert(7);
		tree.insert(10);
		tree.insert(14);
		tree.insert(13);
		
		System.out.println("Base Tree is like below shown in Inorder Traversal...");
		tree.inorderTraversal(tree.getRoot());
		
		System.out.println("Inserting an element 2...");
		tree.insert(2);
		tree.inorderTraversal(tree.getRoot());
		System.out.println("Inserting an element 11...");
		tree.insert(11);
		tree.inorderTraversal(tree.getRoot());
		
		System.out.println("Searching an element 34..should return false");
		System.out.println(tree.search(34));
		System.out.println("Searching an element 6..should return true");
		System.out.println(tree.search(6));
		
		System.out.println("Delete an element 1 and printing tree inorder");
		System.out.println(tree.delete(1));
		tree.inorderTraversal(root);
		System.out.println("Delete an element 13 and printing tree inorder");
		System.out.println(tree.delete(13));
		tree.inorderTraversal(root);
		System.out.println("Delete an element 33 and printing tree inorder");
		System.out.println(tree.delete(33));
		tree.inorderTraversal(root);
	}

	//if found the match in tree we return true
	public boolean search(int data) {

		Node current = getRoot();
		while (current != null) {
			if (data < current.getData()) {
				current = current.getLeft();
			} else if (data > current.getData()) {
				current = current.getRight();
			} else
				return true;
		}
		return false;
	}


	//According to binary search tree property we insert data
	public boolean insert(int data) {
		Node n = new Node(data);
		Node current = getRoot();

		while (current != null) {
			if (data <= current.getData()) {
				if (current.getLeft() != null) {
					current = current.getLeft();
				} else {
					current.setLeft(n);
					return true;
				}
			} else {
				if (current.getRight() != null) {
					current = current.getRight();
				} else {
					current.setRight(n);
					return true;
				}
			}
		}

		return true;
	}

	// if any node data matches input we delete it and return true
	public boolean delete(int data) {
		Node current = getRoot();
		Node currentParent = null;
		while (current != null) {
			if (data < current.getData()) {
				if (current.getLeft() != null) {
					currentParent = current;
					current = current.getLeft();
				} else
					return false;
			} else if (data > current.getData()) {
				if (current.getRight() != null) {
					currentParent = current;
					current = current.getRight();
				} else
					return false;
			} else {
				if(currentParent.getLeft()!=null && currentParent.getLeft().getData()==data) {
					currentParent.setLeft(null);
				}
				else {
					currentParent.setRight(null);
				}
				return true;
			}

		}
		return false;
	}
	
	public void inorderTraversal(Node root) {
		if(root!=null) {
			inorderTraversal(root.getLeft());
			System.out.println(root.getData());
			inorderTraversal(root.getRight());
		}
		
	}

	static class Node {
		private int data;

		private Node left;
		private Node right;

		public Node(int data) {
			super();
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}
	}
}
