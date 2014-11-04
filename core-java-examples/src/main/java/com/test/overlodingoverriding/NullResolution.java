package com.test.overlodingoverriding;

public class NullResolution {
	class A {
		public void show(Object a) {
			System.err.println("A show is called" + a);
		}

		public void show(Number a) {
			System.err.println("B show is called" + a);
		}
	}

	public static void main(String[] args) {
		NullResolution n = new NullResolution();
		A a = n.new A();
		a.show(10);
		Object o = 11;
		a.show(o);// bind at compile time with type
		a.show(null);// will call specific instance
	}

}
