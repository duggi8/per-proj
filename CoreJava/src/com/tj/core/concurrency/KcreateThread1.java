package com.tj.core.concurrency;

public class KcreateThread1 extends Thread {

	@Override
	public void run() {
		System.out.println("Hello from Thread implementation 1 by extending Thread class - createThread1");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("createThread1 woke up because it is interrupted - createThread1");
			return;  //to stop further execution and return
		}
		System.out.println("Three seconds are passed and I am awake - createThread1");
	}
}
