package com.test.concurrency.philosopher;

public class PhelosopherDemo {
	public static void main(final String[] args) {
		final Philosopher1 philosopher1 = new Philosopher1();
		final Philosopher2 philosopher2 = new Philosopher2();
		final Philosopher3 philosopher3 = new Philosopher3();
		final Philosopher4 philosopher4 = new Philosopher4();
		final Philosopher5 philosopher5 = new Philosopher5();
		philosopher1.setNextPhelosopher(philosopher2);
		philosopher2.setNextPhelosopher(philosopher3);
		philosopher3.setNextPhelosopher(philosopher4);
		philosopher4.setNextPhelosopher(philosopher5);
		philosopher5.setNextPhelosopher(philosopher1);
		philosopher1.start();
		philosopher2.start();
		philosopher3.start();
		philosopher4.start();
		philosopher5.start();
	}
}
