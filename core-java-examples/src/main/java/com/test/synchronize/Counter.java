package com.test.synchronize;

public class Counter {

	private static int count = 0;

	public static int getCount() {
		System.out.println("getting the count with first thread");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("count from getcount is:" + count);
		synchronized (Counter.class) {
			return count;

		}
	}

	public void setCount(int count) {
		System.out.println("setting the count with second thread");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (this) {
			this.count = count;
		}
		System.out.println("count is set to:" + this.count);
	}

}

// Read more:
// http://javarevisited.blogspot.com/2011/04/synchronization-in-java-synchronized.html#ixzz3FTP4rOte