package com.test.hackerrank.weekofcode24.challenge4;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 2;
		int b = 4;
		int c = 5; 
		int d = 7;
		
		System.out.println(a^b^c^d);
		System.out.println((a^b) + ", " + (b^c) + ", " + (c^d));
		System.out.println(((a^b)^(b^c)) + ", " + ((b^c)^(c^d)));
		System.out.println(((a^b)^(b^c)) + ", " + (a^c));
		System.out.println(((a^b)^(b^c))^((b^c)^(c^d)));

	}

}
