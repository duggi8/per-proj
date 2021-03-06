package code.heap;

import code.heap.Heap.HeapEmptyException;
import code.heap.Heap.HeapFullException;

public class Box<T extends Comparable<T>> implements Comparable<Box<T>> {
	
		T size;
		T weight;
		
		public Box(T size, T weight) {
			super();
			this.size = size;
			this.weight = weight;
		}
		public T getSize() {
			return size;
		}
		public void setSize(T size) {
			this.size = size;
		}
		public T getWeight() {
			return weight;
		}
		public void setWeight(T weight) {
			this.weight = weight;
		}
		@Override
		public int compareTo(Box<T> o) {
			//if two box has same size, we check for less weight box as next priority.
			int res = this.getSize().compareTo(o.getSize());
			if(res == 0 ) {
				res = this.getWeight().compareTo(o.getWeight());
			}
			//else if(res<0)
			return res;
		}
		
		@Override
		public String toString() {
			return "Box [size=" + size + ", weight=" + weight + "]";
		}
		public static void main(String[] args) {
			Box<Integer> b1 = new Box<>(3,3);
			Box<Integer> b2 = new Box<>(3,3);
			Box<Integer> b3 = new Box<>(2,4);
			Box<Integer> b4 = new Box<>(2,3);
			Box<Integer> b5 = new Box<>(2,5);
			Box<Integer> b6 = new Box<>(3,2);
			Box<Integer> b7 = new Box<>(4,1);
			MinHeap<Box<Integer>> min = new MinHeap<>((Class<Box<Integer>>) b1.getClass());
			System.out.println(b5.compareTo(b6));
			try {
				min.insert(b2);
			//	System.out.println("after (3,3) insert");
			//	min.print();
			    min.insert(b3);
			  //  System.out.println("after (2,4) insert");
			 //   min.print();
				min.insert(b4);
				//System.out.println("after (2,3) insert");
				//min.print();
			    min.insert(b5);
			    //System.out.println("after (2,5) insert");
			    //min.print();
			    min.insert(b6);
			    //System.out.println("after (3,2) insert");
			    //min.print();
			    min.insert(b7);
			    //System.out.println("after (4,1) insert");
			    //min.print();
				while(min.getCount()>0) {
					min.print();
					System.out.println("********");
					System.out.println("removed object - "+min.remove().toString());
				}
			} catch (HeapFullException e) {
				e.printStackTrace();
			} catch (HeapEmptyException e) {
				e.printStackTrace();
			}
		}
		
		
		 
	
}
