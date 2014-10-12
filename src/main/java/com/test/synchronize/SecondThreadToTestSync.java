package com.test.synchronize;

public class SecondThreadToTestSync extends Thread {

	private TwoSyncMethod sharedObj;

	public SecondThreadToTestSync(TwoSyncMethod sharedObj) {
		this.sharedObj = sharedObj;
	}

	// @Override
	// public synchronized void run() {
	// try {
	// sharedObj.secondSyncMethod();
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	private Counter counter;

	public SecondThreadToTestSync(Counter counter) {
		this.counter = counter;
	}

	@Override
	public synchronized void run() {
		counter.setCount(1);
	}
}
