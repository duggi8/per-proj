package code.heap;

import java.lang.reflect.Array;
//Base class
public abstract class Heap<T extends Comparable<T>> {
	private static int MAX_SIZE = 40;
	protected int count = 0;
	protected T[] array;
	
	Heap(Class<?> cl){
		this(cl,MAX_SIZE);
	}

	Heap(Class<?> cl,int size){
		array = (T[])Array.newInstance(cl,size);
	}
	
	public static class HeapFullException extends Exception{
		public HeapFullException(String msg) {
			super(msg);
		}
	}
	
	public static class HeapEmptyException extends Exception{
		public HeapEmptyException(String msg) {
			super(msg);
		}
	}
	
	public T getHighestPriority() throws HeapEmptyException {
		if(isEmpty())
			throw new HeapEmptyException("Heap is empty");
		return array[0];
	}
	public int getLeftChildIndex(int index) {
		int leftChildIndex = 2*index+1;
		if(leftChildIndex>= count)
			return -1;
		return leftChildIndex;
	}
	
	public int getRightChildIndex(int index) {
		int rightChildIndex = 2*index+2;
		if(rightChildIndex >= count)
			return -1;
		return rightChildIndex;
				
	}
	
	public int getParentIndex(int index) {
		int parentIndex = (index - 1)/2;
		if(parentIndex <0) {
			return -1;
		}
		return parentIndex;
	}
	
	protected void swap(int index1,int index2) {
		T temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	public int getCount() {
		return count;
	}
	
	public boolean isEmpty() {
		return count==0;
	}
	
	public boolean isFull() {
		return count==array.length;
	}
	public T getElementAtIndex(int index) {
		return array[index];
	}
	
	
}
