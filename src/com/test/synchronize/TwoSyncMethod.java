package com.test.synchronize;

public class TwoSyncMethod {
	public synchronized void firstSyncMethod() throws InterruptedException {
		System.err.println("firstSyncMethod start...");
		Thread.sleep(2000);
		System.err.println("firstSyncMethod end...");
	}

	public static synchronized void secondSyncMethod()
			throws InterruptedException {
		System.err.println("secondSyncMethod start...");
		Thread.sleep(2000);
		System.err.println("secondSyncMethod end...");
	}

}
