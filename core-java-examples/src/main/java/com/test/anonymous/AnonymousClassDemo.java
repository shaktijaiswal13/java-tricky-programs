package com.test.anonymous;

public class AnonymousClassDemo {
	
	//why instance variables need not be final to be accessed in anonymous class.
	private int x = 18;
	private int y = 25;
	
	private static void performMathOperations1(int x, int y) {
		
		MathOperations1 math = new MathOperations1() {
			
			@Override
			public int subtract(int a, int b) {
				return a - b;
			}
			@Override
			public int add(int a, int b) {
				return a + b;
			}
		};
		System.out.println(math.add(x, y));
		System.out.println(math.subtract(x, y));
	}
	
	//need to set x, y final, as anonymous class cannot access the non-final variables.
	private static void performMathOperations2(final int x, final int y) {
		
		MathOperations2 math = new MathOperations2() {
			
			@Override
			public int subtract() {
				return x - y;
			}
			@Override
			public int add() {
				return x + y;
			}
		};
		System.out.println(math.add());
		System.out.println(math.subtract());
	}
	
	//need to set x, y final, as anonymous class cannot access the non-final variables.
	private static void performMathOperations3() {
		final int x = 30;
		final int y = 20;
		
		MathOperations2 math = new MathOperations2() {
			
			//int x = 100;	//if this is uncommented then the x declared above will not be used in this class. this is called shadowing.
			//int static y = 50;	//anonymous class cannot have static variables
			
			@Override
			public int subtract() {
				return x - y;
			}
			@Override
			public int add() {
				return x + y;
			}
		};
		System.out.println(math.add());
		System.out.println(math.subtract());
	}
	
	//accessing the instance variables of this class. Instance variables need not to be final.
	private void performMathOperations4() {
		MathOperations2 math = new MathOperations2() {
			
			@Override
			public int subtract() {
				return x - y;
			}
			@Override
			public int add() {
				return x + y;
			}
		};
		System.out.println(math.add());
		System.out.println(math.subtract());
	}

	public static void main(String[] args) {
		performMathOperations1(5, 2);
		performMathOperations2(15, 12);
		performMathOperations3();
		new AnonymousClassDemo().performMathOperations4();
	}
}

interface MathOperations1 {
	int add (int a, int b);
	int subtract(int a, int b);
}

interface MathOperations2 {
	int add ();
	int subtract();
}
