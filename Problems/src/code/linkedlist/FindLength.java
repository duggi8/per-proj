package code.linkedlist;

public class FindLength {

	public static void main(String[] args) {
		Node<Integer> n1 = new Node<Integer>(12);
		Node<Integer> n2 = new Node<Integer>(11);
		Node<Integer> n3 = new Node<Integer>(12);
		Node<Integer> n4 = new Node<Integer>(21);
		Node<Integer> n5 = new Node<Integer>(41);
		Node<Integer> n6 = new Node<Integer>(43);
		Node<Integer> n7 = new Node<Integer>(21);
		n1.setNextNode(n2);
		n2.setNextNode(n3);
		n3.setNextNode(n4);
		n4.setNextNode(n5);
		n5.setNextNode(n6);
		n6.setNextNode(n7);
		
		System.out.println("length");
		System.out.println(length(n1));
	}
	//recursion
	public static int length(Node<Integer> n) {
		//base condition which stops recursion to come back
		if(n==null)
			return 0;
		return 1+ length(n.getNextNode());
	}

}
