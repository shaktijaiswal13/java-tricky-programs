package com.test.nestedclass;

public class InnerClassDemo {

	public static void main(String[] args) {

		//No enclosing instance of type EnclosingClass is accessible. Must qualify the allocation 
		//with an enclosing instance of type EnclosingClass (e.g. x.new A() where x is an instance 
		//of EnclosingClass).
		//cannot access non-static inner class like this.
		/*
		EnclosingClass.InnerClass innerClass = new EnclosingClass.InnerClass();		//compile time error
		System.out.println(innerClass.getY());
		*/
		
		EnclosingClass enclosingClass = new EnclosingClass();
		System.out.println(enclosingClass.getX());
		
		EnclosingClass.InnerClass innerClass1 = enclosingClass.new InnerClass();
		System.out.println(innerClass1.getY());
		innerClass1.printValues();
	}
}

class EnclosingClass {
	
	private int x = 1;
	private static int z = 3;
	
	public int getX() {
		return x;
	}
	
	public static int getZ() {
		return z;
	}
	
	//non-static inner class can access the instance members and methods of the enclosing
	//class as it is associated with the instance if the enclosing class.
	class InnerClass {
		
		private int y = z;
		
		public int getY() {
			return y;
		}
		
		public void printValues() {
			System.out.println(getZ());
			System.out.println(getX());
		}
	}
}
