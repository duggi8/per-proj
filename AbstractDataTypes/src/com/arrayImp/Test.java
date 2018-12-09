package com.arrayImp;

import com.arrayImp.CircularQueue.QueueOverflowException;
import com.arrayImp.CircularQueue.QueueUnderflowException;

public class Test {

	public static void main(String[] args) throws QueueUnderflowException, QueueOverflowException{
		CircularQueue<Integer> cq = new CircularQueue<>(Integer.class, 7);
		
			cq.enqueue(3);	
			cq.enqueue(4);
			cq.enqueue(5);
			cq.enqueue(6);
			cq.enqueue(7);
			cq.enqueue(8);
			cq.enqueue(9);
			cq.enqueue(10);
			System.out.println(cq.getHeadIndex());
			System.out.println(cq.getTailIndex());
			System.out.println(cq.isFull());
			System.out.println(cq.isEmpty());
			cq.dequeue();
			cq.enqueue(11);
		
	}
}
