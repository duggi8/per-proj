package code.heap;

public class MinHeap<T extends Comparable<T>> extends Heap<T> {

	public MinHeap(Class<T> cl ) {
		super(cl);
	}
	
	public MinHeap(Class<T> cl,int size) {
		super(cl,size);
	}
	
	protected void siftDown(int index) {
		int leftIndex = getLeftChildIndex(index);
		int rightIndex = getRightChildIndex(index);
		
		int smallerIndex = -1;
		if(leftIndex != -1 && rightIndex != -1 ) {
			smallerIndex = getElementAtIndex(leftIndex).compareTo(getElementAtIndex(rightIndex)) < 0 ? leftIndex : rightIndex;
		}
		else if(leftIndex!= -1) {
			smallerIndex = leftIndex;
		}
		else if(rightIndex!= -1) {
			smallerIndex = rightIndex;
		}
		
		if(smallerIndex == -1)
			return;
		
		if(getElementAtIndex(smallerIndex).compareTo(getElementAtIndex(index)) < 0) {
			swap(smallerIndex,index);
			siftDown(smallerIndex);
		}
	}
	
	protected void siftUp(int index) {
		int parentIndex = getParentIndex(index);
		if(parentIndex!= -1 && getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex)) < 0) {
			swap(index,parentIndex);
			siftUp(parentIndex);
		}
	}
	
	public void insert(T val) throws HeapFullException {
		if(isFull())
			throw new HeapFullException("Heap is Full");
		array[count] = val;
		siftUp(count);
		count++;
	}
	
	public T remove() throws HeapEmptyException{
		if(isEmpty())
			throw new HeapEmptyException("Heap is empty");
		T min = getHighestPriority();
		array[0] = array[count-1];
		count--;
		siftDown(0);
		return min;
	}
	
	public void print() {
		for(int i = 0;i< count;i++) {
			System.out.println(array[i].toString());
		}
			
	}
}
