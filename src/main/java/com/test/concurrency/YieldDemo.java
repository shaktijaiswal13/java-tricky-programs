package com.test.concurrency;

class YieldDemo extends Thread {
	static boolean finished = false;
	static int sum = 0;

	public static void main(final String[] args) {
		new YieldDemo().start();
		for (int i = 1; i <= 50000; i++) {
			sum++;
			if (true) {
				Thread.yield();
			}
		}
		finished = true;
	}

	@Override
	public void run() {
		while (!finished)
			System.out.println("sum = " + sum);
	}
}