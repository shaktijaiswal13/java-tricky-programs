package com.test.classinitialization;

/**
 * Java program to demonstrate <b>Method Hiding</b>.
 */
public class MethodHidingTest {

	public static void main(String args[]) {// /throws InterruptedException {

		/*Company cmp = new SisterCompany();
		cmp.staticMethod();		//call staticMethod of Company, as static fields are accessed depending on type not actual instance
		cmp.nonStaticMethod();	//call nonStaticMethod of SisterCompany, as not-static fields are accessed depending on actual instance
		
		SisterCompany sisCmp = new SisterCompany();
		sisCmp.staticMethod();
		sisCmp.nonStaticMethod();*/
		
		SisterCompany.staticMethod();
		//SisterCompany.staticMethod1();
	}
}

class Company {

	static {
		System.err.println("static block of Company class is initialized in Java ");
	}
	{
		System.err.println("non static blocks in Company class is initialized");
	}
	
	public static void staticMethod() {
		System.err.println("Company: static method");
	};
	
	public void nonStaticMethod() {
		System.err.println("Company: non static metyhod");
	}
}

class SisterCompany extends Company {

	static {
		System.err.println("static block of SisterCompany class is initialized in Java ");
	}
	{
		System.err.println("non static blocks in SisterCompany class is initialized");
	}
	
	public static void staticMethod() {
		System.err.println("SisterCompany: static method");
	};
	
	/*public static void staticMethod1() {
		System.err.println("SisterCompany: static method1");
	};*/
	
	@Override
	public void nonStaticMethod() {
		System.err.println("SisterCompany: non static metyhod");
	}
}

// Read more:
// https://crunchify.com/java-method-hiding-and-overriding-override-static-method-in-java/
