package com.tj.core.concurrency;

public class KMainTestInterrupts {

	public static void main(String[] args) {
		
		Thread threadImps1 = new KcreateThread1();
		threadImps1.start(); 
		//
		threadImps1.interrupt();
	}
}
