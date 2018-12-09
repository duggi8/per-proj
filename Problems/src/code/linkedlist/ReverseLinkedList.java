package code.linkedlist;

//Very confusing if proper naming is not followed. Go through this again and again.
public class ReverseLinkedList {

	public static Node<Integer> head = new Node<Integer>(10);

	public static void main(String[] args) {
		Node<Integer> h = new Node<Integer>(2);
		LinkedList<Integer> list = new LinkedList<>(h);
		list.add(new Node<Integer>(4));
		list.add(new Node<Integer>(6));
		list.add(new Node<Integer>(8));
		list.add(new Node<Integer>(10));
		list.add(new Node<Integer>(12));
		list.add(new Node<Integer>(14));
		list.add(new Node<Integer>(16));
		LinkedList<Integer> res = reverse(list);
		Node<Integer> temp = res.getHead();
		while (temp != null) {
			System.out.println(temp.getData());
			temp = temp.getNextNode();
		}
		System.out.println("---using recursion now---");

		Node<Integer> h1 = new Node<>(20);
		Node<Integer> h2 = new Node<>(30);
		Node<Integer> h3 = new Node<>(40);
		Node<Integer> h4 = new Node<>(50);
		Node<Integer> h5 = new Node<>(70);
		head.setNextNode(h1);
		h1.setNextNode(h2);
		h2.setNextNode(h3);
		h3.setNextNode(h4);
		h4.setNextNode(h5);
		reverseUsingRecursion(head);
		while (head != null) {
			System.out.println(head.getData());
			head = head.getNextNode();
		}

	}

	public static LinkedList<Integer> reverse(LinkedList<Integer> list) {
		Node<Integer> prev = null;
		Node<Integer> curr = list.getHead();
		Node<Integer> next;
		while (curr != null) {
			next = curr.getNextNode();
			curr.setNextNode(prev);
			prev = curr;
			curr = next;
		}
		return new LinkedList<>(prev);
	}

	public static void reverseUsingRecursion(Node<Integer> node) {
		if (node.getNextNode() == null) {
			head = node;
			return;
		}
		reverseUsingRecursion(node.getNextNode());
		node.getNextNode().setNextNode(node);
		node.setNextNode(null);

	}

	/*
	 * public static Node<Integer> reverseUsingRecursionReturn(Node<Integer> node){
	 * Node<Integer> head = null; if(node.getNextNode()==null) { head = node; return
	 * node; } reverseUsingRecursionReturn(node.getNextNode());
	 * node.getNextNode().setNextNode(node); node.setNextNode(null);
	 * 
	 * }
	 */

}
