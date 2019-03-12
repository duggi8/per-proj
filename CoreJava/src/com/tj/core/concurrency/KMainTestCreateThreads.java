package com.tj.core.concurrency;

public class KMainTestCreateThreads {

	public static void main(String[] args) {

		System.out.println("Hello from Main thread");
		
		Thread threadImps1 = new KcreateThread1();
		threadImps1.start();
		
		System.out.println("Hello again from Main thread");
		//threadImps1.start();
		//anonymous thread instance
		new Thread() {
			@Override
			public void run() {
				
				System.out.println("Hello from anonymous thread instance");
			}
		}.start();
		
		Thread threadImps2 = new Thread(new KcreateThread2());
		threadImps2.start();
		
		//Thread class has a consructor which takes thread instances. Below is anonymous thread instance.
		new Thread(new KcreateThread2() {
			@Override
			public void run() {
				System.out.println("Hello from anonymous thread instance created from overriding run method of KcreateThread2");
			}
		}).start();
		
	}

}
