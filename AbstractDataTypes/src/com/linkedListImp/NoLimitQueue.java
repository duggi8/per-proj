package com.linkedListImp;

public class NoLimitQueue<T> {
	private int count = 0;

	private Element<T> first, last;

	

	public int getCount() {
		return count;
	}

	// add element at tail of queue
	public void enqueue(T data) throws QueueOverflowException {
		Element<T> curr = new Element<T>(data);
		if (first == null ) {
			first = curr;
			last = curr;
		}
		else {
			last.setNext(curr);
			last = curr;
		}
		
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

	
	public boolean isEmpty() {
		return first == null ;
	}

	public T getFirst() {
		return first.getData();
	}
}
