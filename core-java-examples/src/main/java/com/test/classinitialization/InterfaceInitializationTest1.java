package com.test.classinitialization;

/**
 * Java program to demonstrate class loading and initialization in Java.
 */
public class InterfaceInitializationTest1 {

	/**
	 * Another Java program example to demonstrate class initialization and
	 * loading in Java.
	 */

	public static void main(String args[]) {// /throws InterruptedException {

		// accessing static field of Parent through child, should only initialize Parent
		System.err.println(Class.familyName);
		
		System.err.println(Interface.familyName);
		
		Class.familyName1 = "new name";
		System.err.println("initialized");
		System.err.println(Class.familyName1);
	}
	
	public static String getString(String name, String value) {
		System.err.println(name + "=" + value);
		return value;
	}
}

interface Interface {
	
	// compile time constant, accessing this will not trigger interface initialization
	// static final String familyNameFinal = "Lawson Final";

	//accessing this will trigger interface initialization
	static String familyName = InterfaceInitializationTest1.getString("familyName", "Lawson Static");
	static String familyNameNonStatic = InterfaceInitializationTest1.getString("familyNameNonStatic", "Lawson");

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
