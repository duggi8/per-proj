package com.tj.core.concurrency;

public class KMain {

	public static void main(String[] args) {

		System.out.println("Hello from Main thread");
		Thread threadImps1 = new KcreateThread1();
		threadImps1.start();
		System.out.println("Hello again from Main thread");
		//threadImps1.start();
		
		new Thread() {
			@Override
			public void run() {
				
				System.out.println("Hello from anonymous thread instance");
			}
		}.start();
	}

}
