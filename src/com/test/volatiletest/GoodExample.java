package com.test.volatiletest;

import java.util.Random;

class GoodExample {
	private static volatile int temperature;

	// Called by some other thread than main
	public static void todaysTemperature(int temp) {
		// This operation is a single operation, so you
		// do not need compound atomicity
		temperature = temp;
	}

	public static void main(String[] args) throws Exception {

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					int nextInt = new Random().nextInt();
					GoodExample.todaysTemperature(nextInt);
					System.err.println("Today's temperature is changed "
							+ nextInt);
				}
			}
		}).start();
		while (true) {
			Thread.sleep(2000);
			System.err.println("Today's temperature is " + temperature);
		}
	}
}
