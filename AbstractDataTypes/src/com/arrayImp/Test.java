package com.arrayImp;

import com.linkedListImp.Queue;
import com.linkedListImp.QueueOverflowException;
import com.linkedListImp.QueueUnderflowException;

public class Test {

	public static void main(String[] args) throws QueueOverflowException,QueueUnderflowException{
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
			System.out.println("****test queue with linked list implementation******");
			Queue<Integer> q = new Queue<Integer>(5);
			q.enqueue(4);
			q.enqueue(5);
			q.enqueue(6);
			System.out.println(q.getCount());
			q.enqueue(7);
			q.enqueue(8);
			System.out.println(q.isFull());
			System.out.println(q.getFirst());
			q.dequeue();
			System.out.println(q.getFirst());
	}
}
