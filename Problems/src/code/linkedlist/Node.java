package code.linkedlist;

public class Node<T extends Comparable<T>> {

	private T data;
	private Node<T> nextNode;
	
	public Node(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	@Override
	public String toString() {
		return String.valueOf(data);
	}

	public Node<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}
	
	
	
}
