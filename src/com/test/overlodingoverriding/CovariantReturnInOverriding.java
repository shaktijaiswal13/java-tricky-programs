package com.test.overlodingoverriding;

import java.io.FileNotFoundException;
import java.io.IOException;

/* in Java 5 in the case of method overriding, When a subclass wants to change the method implementation of an 
 * inherited method (an override), the subclass must define a method that matches the inherited version exactly. 
 * Or, as of Java 5, you're allowed to change the return type in the overriding method as long as the new return 
 * type is a subtype of the declared return type of the overridden (super class) method. This is called 
 * covariant return. */

public class CovariantReturnInOverriding {

	public static void main(String[] args) throws IOException {

		Alpha alpha = new Alpha();
		alpha.create();

		Alpha beta = new Beta();
		beta.create();

		Beta beta1 = new Beta();
		beta1.create();
	}

}

class Alpha {

	static {
		System.err.println("in Alpha class.....statis block....");
		int i=1/0;
	}

	public Alpha create() throws IOException {
		System.err.println("in Alpha class.....");
		return new Alpha();
	}

}

class Beta extends Alpha {

	@Override
	public Beta create() throws FileNotFoundException {
		System.err.println("in Beta class.....");
		return new Beta();
	}
}

// Read more:
// http://javarevisited.blogspot.com/2011/12/method-overloading-vs-method-overriding.html#ixzz3DO33G1uZ
