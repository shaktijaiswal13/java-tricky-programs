package com.test.substring;

import java.util.Arrays;

public class SubstringTest {
	static char[] newCharArray;
	static String[] newStringArray;
	static int[] newIntArray;
	static Integer[] newIntegerArray;
	static transient int s;

	public static void main(String[] args) {
		String original = "original";
		String sub = original.substring(2);
		String sub2 = original.substring(2, 2);

		System.out.println(sub + "test");
		System.out.println(sub2 + "test");

		char[] subChar = Arrays.copyOfRange(original.toCharArray(), 2, 10);

		System.out.print(String.valueOf(subChar));
		System.out.print(subChar.length);
		System.out.println("test");

		for (int i = 0; i < subChar.length; i++) {
			System.out.println(subChar[i] + " " + (int) subChar[i]);
		}
		// uninitialized char array throws NPE while using in sysout or
		// String.valueOf().
		// All other array are treated as objects except character array. and
		// these are null safe in sysout or String.valueOf().
		// System.out.println(String.valueOf(newCharArray));
		// System.err.println(newCharArray);

		System.out.println(newStringArray);
		System.out.println(String.valueOf(newIntArray));
		System.out.println(String.valueOf(newIntegerArray));

	}
}
