package com.test.synchronize;

public class FirstThreadToTestSync extends Thread {

	private TwoSyncMethod sharedObj;

	public FirstThreadToTestSync(TwoSyncMethod sharedObj) {
		this.sharedObj = sharedObj;
	}

	private Counter counter;

	public FirstThreadToTestSync(Counter counter) {
		this.counter = counter;
	}

	// @Override
	// public synchronized void run() {
	// try {
	// sharedObj.firstSyncMethod();
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	@Override
	public synchronized void run() {
		System.out.println("counter.getCount() : " + counter.getCount());
	}
}
