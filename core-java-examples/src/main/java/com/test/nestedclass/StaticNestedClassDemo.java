package com.test.nestedclass;

public class StaticNestedClassDemo {

	public static void main(String[] args) {

		System.out.println(OuterClass.StaticNestedClass.getZ());
		
		OuterClass.StaticNestedClass staticNestedClass = new OuterClass.StaticNestedClass();
		System.out.println(staticNestedClass.getY());
		
	}

}

class OuterClass {
	
	private int x = 1;
	private static int b = 5;
	
	public int getX() {
		return x;
	}
	
	public static int getB() {
		return b;
	}
	
	//As with class methods and variables, a static nested class is associated with its outer class. 
	//And like static class methods, a static nested class cannot refer directly to instance variables
	//or methods defined in its enclosing class: it can use them only through an object reference.
	static class StaticNestedClass {
		
		private int y = b;
		private static int z = 3;
		//private int a = x;		//compile time error, cannot access instance member
		
		public int getY() {
			return y;
		}
		
		public static int getZ() {
			return z;
		}
		
		public void printValues() {
			//System.out.println(getX());		//compile time error, cannot access instance member
			System.out.println(getB());

		}
	}
}
