package com.test.compareto;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.TreeSet;

public class CompareToIssue {

	/*
	 * Following program test the Issue if equals() and compareTo() methods of a
	 * object are not is synch
	 */
	public static void main(String[] args) {
		BigDecimal big1 = new BigDecimal("2.5");
		BigDecimal big2 = new BigDecimal("2.50");

		System.err.println(big1.equals(big2));// above two bigdecimal values are
												// not equal, created from
												// String
		System.err.println(big1.compareTo(big2));

		BigDecimal big3 = new BigDecimal(2.5);
		BigDecimal big4 = new BigDecimal(2.50);

		System.err.println(big3.equals(big4));// above two bigdecimal values are
												// equal, created from double
		System.err.println(big3.compareTo(big4));

		HashSet<BigDecimal> set = new HashSet<>();
		set.add(big1);
		set.add(big2);

		System.err.println(set.size());// set usses equals() to compare objects,
										// so big1 and big2 are treated as 2
										// different objects which is wrong

		// set.add(big3);
		// set.add(big4);
		// System.err.println(set.size());

		TreeSet<BigDecimal> treeSet = new TreeSet<>();
		treeSet.add(big1);
		treeSet.add(big2);
		System.err.println(treeSet.size());// treeset uses compareTo() to
											// compare objects, so big1 and big2
											// are treated as same objects which
											// is correct

		int i1 = Integer.MIN_VALUE;// -2147483648
		int i2 = Integer.MAX_VALUE;// 2147483647
		System.err.println(i1 - i2);
	}
}
