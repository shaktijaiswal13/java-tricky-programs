package com.test;

import java.util.HashSet;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		Set<MyObj> s = new HashSet<>();
		MyObj myObj1 = new MyObj("shakti");
		MyObj myObj2 = new MyObj("shakti");
		s.add(myObj1);
		s.add(myObj2);

		System.err.println(s);

	}
}
