package com.test.thread;

public class MyThread implements Runnable {

	@Override
	public void run() {
		System.out.println("run() of MyThread is called...");
		for (int i=0; i<10; i++) {
			System.err.println("Value of i in MyThread is:" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
