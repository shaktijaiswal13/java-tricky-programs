package com.test.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/beautiful-binary-string
 *
 */
public class BinaryStringUsingLoop {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int len = scan.nextInt();
		String testString = scan.next();
		if (testString.length() > len || !testString.matches("[01]+")) {
			System.out.println("0");
		}
		scan.close();
		
		int stepsToUpdateString = 0;
		while (testString.indexOf("010") != -1) {
			testString = testString.replaceFirst("010", "011");
			System.out.println(testString);
			stepsToUpdateString++;
		}
		System.out.println(stepsToUpdateString);
	}

}
