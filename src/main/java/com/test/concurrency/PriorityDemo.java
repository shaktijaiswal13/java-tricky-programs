package com.test.concurrency;

// PriorityDemo.java
public class PriorityDemo {
	public static void main(final String[] args) {
		final BlockingThread bt = new BlockingThread();
		bt.setPriority(Thread.NORM_PRIORITY + 1);
		final CalculatingThread ct = new CalculatingThread();
		bt.start();
		ct.start();
		try {
			Thread.sleep(10000);
		} catch (final InterruptedException e) {
		}
		bt.setFinished(true);
		ct.setFinished(true);
	}
}

class BlockingThread extends Thread {
	private boolean finished = false;

	@Override
	public void run() {
		while (!finished) {
			try {
				int i;
				do {
					i = System.in.read();
					System.out.println(i + " ");
				} while (i != '\n');
				System.out.println('\n');
			} catch (final java.io.IOException e) {
			}
		}
	}

	public void setFinished(final boolean f) {
		finished = f;
	}
}

class CalculatingThread extends Thread {
	private boolean finished = false;

	@Override
	public void run() {
		int sum = 0;
		while (!finished) {
			sum++;
			System.out.println("CalculatingThread : " + sum);
		}
	}

	public void setFinished(final boolean f) {
		finished = f;
	}
}