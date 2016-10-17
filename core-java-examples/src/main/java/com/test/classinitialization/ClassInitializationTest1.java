package com.test.classinitialization;

/**
 * Java program to demonstrate class loading and initialization in Java.
 */
public class ClassInitializationTest1 {

	/**
	 * Another Java program example to demonstrate class initialization and
	 * loading in Java.
	 */

	public static void main(String args[]) {// /throws InterruptedException {

//		System.err.println(Child1.familyNameFinal);

		// accessing static field of Parent through child, should only initialize Parent
		System.err.println(Child1.familyName);
		
		//Child1.familyName1 = "new name";
		Child1.show();

		//creating an object of child class will trigger initialization of parent class along with child class.
		System.err.println(new Child1().familyNameNonStatic);
	}
}

class Parent1 {
	
	// compile time constant, accessing this will not trigger class initialization
	protected static final String familyNameFinal = "Lawson final";

	// Accessing this will trigger class initialization
	protected static String familyName = "Lawson";
	
	protected String familyNameNonStatic = "Lawson";

	static {
		System.err.println("static block of Super class is initialized");
	}
	
	{
		System.err.println("non static blocks in super class is initialized");
	}

	public static void show1() {
		System.err.println("static method of Super class is called" + familyName);
	}
}

class Child1 extends Parent1 {
	
	protected static String familyName1 = "Lawson";

	static {
		System.err.println("static block of Sub class is initialized in Java ");
	}
	
	{
		System.err.println("non static blocks in sub class is initialized");
	}
	
	public static void show() {
		System.err.println("static method of sub class is called");
	}
}

// Read more:
// http://javarevisited.blogspot.com/2012/07/when-class-loading-initialization-java-example.html#ixzz3E3vW5kq8
