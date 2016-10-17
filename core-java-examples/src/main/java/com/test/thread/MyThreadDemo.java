package com.test.thread;

public class MyThreadDemo {

	public static void main(String[] args) {

		System.err.println("Main method started execution.");

		Thread myThread = new Thread(new MyThread());
//		myThread.run();		//run() method can be called any no of times. If run() is called instead of start(),
//		myThread.run();		//then no new thread is created and run() executed within the current thread(in this case, main thread).
//		myThread.run();		//Ideal way to execute a thread is to call start() method.
		myThread.start();
		
		System.err.println("Main method is about to exit.");

	}

}
