package com.test.synchronize;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

	private static AtomicInteger count = new AtomicInteger();
	
	public static void main(String[] args) {
		count.incrementAndGet();
	}
}
