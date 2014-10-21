package com.test.concurrency.philosopher;

public class Philosopher extends Thread {
	protected Philosopher p;

	public Philosopher() {
	}

	public void setNextPhelosopher(final Philosopher p) {
		this.p = p;
	}

	protected void thinking() {
		System.err.println(this.getName() + " thinking...");
	}

	protected void eating() {
		System.err.println(this.getName() + " eating...");
	}

	@Override
	public void run() {
		while (true) {
			thinking();
			synchronized (p) {
				eating();
				yield();
				// try {
				// p.notifyAll();
				// p.wait();
				// } catch (final InterruptedException e) {
				// e.printStackTrace();
				// }
				// p.notifyAll();
			}
		}
		// synchronized (p) {
		// p.notifyAll();
		// }
	}
}
