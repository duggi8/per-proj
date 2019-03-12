package com.tj.core.concurrency;

public class KSynchronization {

	public static void main(String[] args) {

		CountDown countDown = new CountDown();
		CountDownThread cdt1 = new CountDownThread(countDown);
		CountDownThread cdt2 = new CountDownThread(countDown);

		Thread thread1 = new Thread(cdt1);
		Thread thread2 = new Thread(cdt2);

		thread1.start();
		thread2.start();

	}
}

class CountDown {
	private int i;
	Object lock1 = new Object();

	public void doCountDown() {

		String color;
		
		synchronized (lock1) {
			for (i = 10; i > 0; i--) {

				System.out.println(Thread.currentThread().getName() + " " + i);
			}
		}
	}

}

class CountDownThread extends Thread {
	private CountDown countDown;

	public CountDownThread(CountDown cd) {
		this.countDown = cd;
	}

	@Override
	public void run() {
		countDown.doCountDown();
	}
}