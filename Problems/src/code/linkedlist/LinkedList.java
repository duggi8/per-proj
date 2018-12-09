package code.linkedlist;

public class LinkedList<T extends Comparable<T>> {

	private Node<T> head;
	private Node<T> tail;
	
	
	public LinkedList(Node<T> head) {
		this.head = head;
		tail = head;
		
	}
	
	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	public Node<T> getTail() {
		return tail;
	}

	public void setTail(Node<T> tail) {
		this.tail = tail;
	}

	public void add(Node<T> node) {
		tail.setNextNode(node);
		tail = node;
	}
}
