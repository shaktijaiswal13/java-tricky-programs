package com.test.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/funny-string
 */
public class FunnyString {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCases = scan.nextInt();
		String[] testStringsArray = new String[testCases];
		
		for (int i=0; i<testCases; i++) {
			testStringsArray[i] = scan.next();
		}
		scan.close();
		
		for (int i=0; i < testStringsArray.length; i++) {
			String testString = testStringsArray[i];
			int testStringLength = testString.length();
			boolean isFunnyString = true;
			
			for (int j=1; j < testStringLength; j++) {
				int lhs = testString.charAt(j) - testString.charAt(j - 1);
				int rhs = testString.charAt((testStringLength - 1) - j) - testString.charAt(testStringLength - j);
				System.out.println("lhs: " + lhs + ", rhs: " + rhs + ", j: " + j);
				if (Math.abs(lhs) != Math.abs(rhs)) {
					isFunnyString = false;
					break;
				}
			}
			if (isFunnyString) {
				System.out.println("Funny");
			} else {
				System.out.println("Not Funny");
			}
		}
	}

}
