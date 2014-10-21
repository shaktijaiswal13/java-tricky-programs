package com.test.synchronize;

public class TwoSyncMethodDemo {
	public static void main(String[] args) {
		// TwoSyncMethod sharedObj = new TwoSyncMethod();
		// FirstThreadToTestSync firstThreadToTestSync = new
		// FirstThreadToTestSync(
		// sharedObj);
		// SecondThreadToTestSync secondThreadToTestSync = new
		// SecondThreadToTestSync(
		// sharedObj);
		// firstThreadToTestSync.start();
		// secondThreadToTestSync.start();
		test1();
		// firstThreadToTestSync.start(); java.lang.IllegalThreadStateException

	}

	private static void test1() {
		Class<FirstThreadToTestSync> a = FirstThreadToTestSync.class;
		System.out.println(a);

		Counter sharedObj = new Counter();
		FirstThreadToTestSync firstThreadToTestSync = new FirstThreadToTestSync(
				sharedObj);
		SecondThreadToTestSync secondThreadToTestSync = new SecondThreadToTestSync(
				sharedObj);
		firstThreadToTestSync.start();
		secondThreadToTestSync.start();
	}

}
