package com.test.classinitialization;

/**
 * Java program to demonstrate class loading and initialization in Java.
 */
public class ClassInitializationTest2 {

	/**
	 * Another Java program example to demonstrate class initialization and
	 * loading in Java.
	 */

	public static void main(String args[]) {// /throws InterruptedException {

		// accessing static field of Parent through child, should only
		// initialize Parent
		 //System.err.println(Child1.familyName1);
		System.err.println(Interface.familyName);// = "new name";
		//Class.show();

		// System.err.println(new Child1().familyName);
	}
}

interface Interface {
	// compile time constant, accessing this will not trigger class
	// initialization
	// protected static final String familyName = "Lawson";

	static String familyName = "Lawson";
	String familyNameNonStatic = "Lawson";

	public void show() ;
}

class Class implements Interface {
	protected static String familyName1 = "Lawson";

	static {
		System.err.println("static block of Sub class is initialized in Java ");
	}
	{
		System.err.println("non static blocks in sub class is initialized");
	}
	public void show() {
		System.err.println("static method of sub class is called");
	}
}

// Read more:
// http://javarevisited.blogspot.com/2012/07/when-class-loading-initialization-java-example.html#ixzz3E3vW5kq8
