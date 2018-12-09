package com.linkedListImp;

/*Linkedlist implementation of stack. Here the trick is 'top' is like head of the linkedlist. When we add new element
 * it is added as head rather than tail. So head changes for every additional element.*/
public class Stack<T> {

	private int MAX_SIZE = 10;
	private Element<T> top;
	private int size = 0;

	public static class StackFullException extends Exception {
		public StackFullException(String msg) {
			super(msg);
		}
	}

	public static class StackEmptyException extends Exception {
		public StackEmptyException(String msg) {
			super(msg);
		}
	}

	public void push(T data) throws StackFullException {
		if (size == MAX_SIZE)
			throw new StackFullException("Stack is Full");
		Element<T> elem = new Element<T>(data, top);
		top = elem;
		size++;
	}

	public T pop() throws StackEmptyException {
		if (size == 0)
			throw new StackEmptyException("Stack is Empty");
		T data = top.getData();
		top = top.getNext();
		size--;
		return data;

	}

	public T peek() throws StackEmptyException {
		if (size == 0)
			throw new StackEmptyException("Stack is empty");
		return top.getData();
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == MAX_SIZE;
	}

}
