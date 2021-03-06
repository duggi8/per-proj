package code.binaryTree;

public class Node {

	public int value;
	public Node leftNode;
	public Node rightNode;
	
	public static void postOrder(Node n) {
		if(n== null)
			return;
	//left-> right->Node itself
		postOrder(n.leftNode);
		postOrder(n.rightNode);
		System.out.println("node val " + n.value);
	}
	
	Node(int val){
		this.value = val;
	}
	
	public static void main(String args[]) {
		Node n1 = new Node(1);
		Node n2 = new Node(6);
		Node n3 = new Node(5);
		Node n4 = new Node(2);
		Node n5 = new Node(3);
		Node n6 = new Node(7);
		Node n7 = new Node(4);
		Node n8 = new Node(8);
		n8.leftNode = n7;
		n8.rightNode = n6;
		n7.leftNode = n4;
		n7.rightNode = n5;
		n6.leftNode = n3;
		n6.rightNode = n2;
		n4.leftNode = n1;
		
		//postOrder(n8);
		T(n8);
		
	}
	
	public static void T(Node n) {
		if(n== null)
			return;
	 System.out.println("node val " + n.value);
	 T(n.leftNode);
	 T(n.rightNode);
	 
	}
}
