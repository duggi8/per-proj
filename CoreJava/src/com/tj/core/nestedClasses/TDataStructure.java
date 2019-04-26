package com.tj.core.nestedClasses;

import java.util.Iterator;

public class TDataStructure {

	private final static int SIZE = 15;
	private int[] arr = new int[SIZE];
	
	public TDataStructure() {
		for(int i=0; i<SIZE; i++) {
			arr[i] = i;
		}
	}
	
	public void printEven() {
		DataStructureIterator iterator  = this.new EvenIterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next()+" ");
		}
	}
	
	interface DataStructureIterator extends Iterator<Integer>{}
	
	//Inner Class
	private class EvenIterator implements DataStructureIterator{

		private int next = 0;
		
		@Override
		public boolean hasNext() {
			return next<=SIZE -1;
		}

		@Override
		public Integer next() {
			Integer retVal = Integer.valueOf(arr[next]);
			next = next+2;
			return retVal;
		}
		
	}
	
	public static void main(String[] args) {
		TDataStructure dt = new TDataStructure();
		dt.printEven();
		
	}
	
	
}
