package com.test.dpattern.singalten;

/**
 * Singleton pattern example with static factory method Read more:
 * http://javarevisited
 * .blogspot.com/2012/07/why-enum-singleton-are-better-in-java
 * .html#ixzz3BTnHalqt
 */

public class Singleton {
	// initailzed during class loading
	private static final Singleton INSTANCE = new Singleton();

	// to prevent creating another instance of Singleton
	private Singleton() {
	}

	public static Singleton getSingleton() {
		return INSTANCE;
	}
}
