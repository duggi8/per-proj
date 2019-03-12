package com.tj.core.concurrency;

public class KGuardedBlocks {

	static boolean joy;

	public static void main(String[] args) {

/*		new Thread(new Runnable() {

			@Override
			public void run() {
				guardedJoy();

			}

		}).start();*/
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				guardedJoy1();

			}

		}).start();

		try {
			Thread.currentThread().sleep(2000);
			joy = true;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void guardedJoy() {
		// Simple loop guard. Wastes
		// processor time. Don't do this!
		while (!joy) {
			System.out.println("No joy");
		}
		System.out.println("Joy has been achieved!");
	}

	public static synchronized void guardedJoy1() {
		// This guard only loops once for each special event, which may not
		// be the event we're waiting for.
		while (!joy) {
			try {
				System.out.println("No joy");
				KGuardedBlocks kg = new KGuardedBlocks();
				kg.wait();
			} catch (InterruptedException e) {

			}
		}
		System.out.println("Joy and efficiency have been achieved!");
	}

}
