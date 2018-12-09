package com.arrayImp;
//generic array implementation
public class Stack<T> {
	private static int MAX_SIZE = 10;
	private T[] a;
	private int size = 0;
	
	public boolean push(T e) throws StackFullException{
		if(size == MAX_SIZE)
			throw new StackFullException("Stack is already full");
		else{
			a[size] = e;
			size++;
			return true;
		}
		
	}

	public static class StackFullException extends Exception{
		public StackFullException(String msg) {
		super(msg);
		}
	}
	
	public static class StackEmptyException extends Exception{
		public StackEmptyException(String msg) {
			super(msg);
		}
	}
	
	public T peek() {
		return a[size-1];
	}
	
	public boolean pop() throws StackEmptyException {
		if(size==0)
			throw new StackEmptyException("Stack is empty");
		else {
			size--;
			return true;
		}
	}
}
