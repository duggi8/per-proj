package com.linkedListImp;

public class Queue<T> {

	private int size = 0, count = 0;

	private Element<T> first, last;

	public Queue(int size) {
		this.size = size;
	}

	public int getCount() {
		return count;
	}

	// add element at tail of queue
	public void enqueue(T data) throws QueueOverflowException {
		if (isFull())
			throw new QueueOverflowException("Queue is full");
		Element<T> curr = new Element<T>(data);
		if (first == null && last == null) {
			first = curr;
			last = curr;
		}

		last.setNext(curr);
		last = curr;
		count++;
	}

	// remove element from head of queue
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty())
			throw new QueueUnderflowException("Queue is empty");
		Element<T> curr = first;
		first = first.getNext();
		count--;
		return curr.getData();
	}

	public boolean isFull() {
		return size == count;
	}

	public boolean isEmpty() {
		return first == null ;
	}

	public T getFirst() {
		return first.getData();
	}
}
