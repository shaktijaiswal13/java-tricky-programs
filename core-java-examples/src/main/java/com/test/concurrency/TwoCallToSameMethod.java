package com.test.concurrency;

public class TwoCallToSameMethod {
	public static void main(final String[] args) {
		final TwoCallToSameMethod callToSameMethod = new TwoCallToSameMethod();

		final Runnable target = new Runnable() {

			@Override
			public void run() {
				callToSameMethod.anyMethod();
			}
		};
		new Thread(target).start();
		new Thread(target).start();

	}

	int i = 0;

	public void anyMethod() {
		System.err.println("Entring method : " + i);
		try {
			i++;
			Thread.sleep(2000);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
		System.err.println("Exiting method : " + i);
	}

}
