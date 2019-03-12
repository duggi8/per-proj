package com.tj.core.concurrency;

public class KThreadJoin1 {

	public static void main(String[] args) {
		//here we created a runnable object.To create a thread we need to pass runnable object to Thread constructor.
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0;i<5;i++) {
					System.out.println("thread r = " + i);
				}
				System.out.println("execution completed by " + Thread.currentThread().getName() );
			}
		};
		
		Thread rt = new Thread(r);
		rt.start();
		try {
			rt.join();
			//we can do below to interrupt rt thread if it is taking too long
			rt.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for(int i = 0;i<10;i++) {
			System.out.println("executing completed by " + Thread.currentThread().getName());
		}
		
	}

}
