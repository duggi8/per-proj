package teja.test;

class BinaryTree {
	TreeNode root;

	BinaryTree() {
		root = null;
	}
	void printPreorder(TreeNode node) {
		if (node == null)
			return;

		System.out.print(node.key + " ");

		printPreorder(node.left);

		printPreorder(node.right);
	}


	void printPreorder() {
		printPreorder(root);
	}

	static class TreeNode {
		int key;
		TreeNode left, right;

		public TreeNode(int item) {
			key = item;
			left = right = null;
		}
	}
	public static void main(String[] args) {
		BinaryTree t = new BinaryTree();
		t.root = new TreeNode(8);
		t.root.left = new TreeNode(5);
		t.root.right = new TreeNode(15);
		t.root.left.left = new TreeNode(2);
		t.root.left.right = new TreeNode(6);

		System.out.println("Preorder = ");
		t.printPreorder();
	}
}
