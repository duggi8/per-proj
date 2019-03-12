package com.tj.core.concurrency;

public class KThreadInteference {
	
	static KCounter kc = new KCounter() ;

	public static void main(String[] args) {
		
		//thread object by extending thread class
		Thread a = new Thread() {
			@Override
			public void run() {
				kc.increment();
			}
		};
		a.start();
		try {
			a.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		Thread b = new Thread(new Runnable() {
			
			@Override
			public void run() {
				kc.decrement();
			}
		});
		b.start();
		
		try {
			b.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(kc.value());
		
		
		
		
	}
}
