package com.test.nestedclass;

/**
 * Nested interface demo.
 *
 */
public class NestedInterfaceDemo {

	public static void main(String[] args) {
		Parent parent = new Parent();
		parent.setX(10);
		//As a nested interface is "static", it needs to be accessed in static way.
		Parent.Child child = new Parent.Child() {
			
			@Override
			public void print(int a) {
				System.out.println("Child instantiated from parent class..." + a);
			}
		};
		child.print(parent.getX());
	}
}

class Parent {
	private int x;
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	//It is acceptable style to create a nested interface this way if you expect it to be used only 
	//from the outer class, so that you do not create a new top-level name.
	//a nested interface is automatically "static"
	interface Child {
		public void print(int a);
	}
}