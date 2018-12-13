package com.arrayImp;

import java.awt.image.DataBufferShort;
import java.lang.reflect.Array;

import com.linkedListImp.QueueOverflowException;
import com.linkedListImp.QueueUnderflowException;

public class CircularQueue<T> {

	public int getHeadIndex() {
		return headIndex;
	}

	public void setHeadIndex(int headIndex) {
		this.headIndex = headIndex;
	}

	public int getTailIndex() {
		return tailIndex;
	}

	public void setTailIndex(int tailIndex) {
		this.tailIndex = tailIndex;
	}

	private static int MAX_SIZE = 8;
	private T[] elements;
	private static final int SPECIAL_EMPTY_VAL = -1;
	private int headIndex = SPECIAL_EMPTY_VAL;
	private int tailIndex = SPECIAL_EMPTY_VAL;

	CircularQueue(Class<T> c, int size) {
		elements = (T[]) Array.newInstance(c, MAX_SIZE);
	}

	public boolean isFull() {
		int nextIndex = (tailIndex + 1) % elements.length;
		return nextIndex == headIndex;
	}

	public boolean isEmpty() {
		return headIndex == SPECIAL_EMPTY_VAL;
	}

	public void enqueue(T data) throws QueueOverflowException {
		if (isFull())
			throw new QueueOverflowException("Queue is full");
		tailIndex = (tailIndex+1) % elements.length;
		elements[tailIndex] = data;
		if(headIndex == SPECIAL_EMPTY_VAL) {
			headIndex  = tailIndex;
		}
			
	}

	public T dequeue() throws QueueUnderflowException {
		if(isEmpty())
			throw new QueueUnderflowException("Queue is empty");
		T data =  elements[headIndex];
		if(headIndex==tailIndex) {
			headIndex = SPECIAL_EMPTY_VAL;
		}
		else {
			headIndex = (headIndex+1)% elements.length;
		}
		return data;
	}

}