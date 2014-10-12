package com.test.dpattern.singalten;

/**
 * Singleton pattern example with Double checked Locking here getInstance()
 * method checks two times to see whether INSTANCE is null or not and that’s why
 * it’s called double checked locking pattern, remember that double checked
 * locking is broker before Java 5 but with the guranteed of volatile variable
 * in Java 5 memory model, it should work perfectly.
 * 
 * Read more:
 * http://javarevisited.blogspot.com/2012/07/why-enum-singleton-are-better
 * -in-java.html#ixzz3BTllTPrv
 */
public class DoubleCheckedLockingSingleton {
	private volatile DoubleCheckedLockingSingleton INSTANCE;

	private DoubleCheckedLockingSingleton() {
	}

	public DoubleCheckedLockingSingleton getInstance() {
		if (INSTANCE == null) {
			synchronized (DoubleCheckedLockingSingleton.class) {
				// double checking Singleton instance
				if (INSTANCE == null) {
					INSTANCE = new DoubleCheckedLockingSingleton();
				}
			}
		}
		return INSTANCE;
	}
}
