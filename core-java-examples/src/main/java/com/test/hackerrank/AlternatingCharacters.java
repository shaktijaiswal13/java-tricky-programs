package com.test.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/alternating-characters
 * 
 * Generic solution to replace any duplicate character with single character.
 * But slow for long inputs.
 *
 */
public class AlternatingCharacters {

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
			Character prevChar = '\0';
			int deletionCount = 0;
			
			for (int j=0; j < testString.length();) {
				Character curChar = testString.charAt(j);
				if (curChar == prevChar) {
					testString = testString.substring(0, j) + testString.substring(j + 1, testString.length());
					prevChar = '\0';
					deletionCount++;
					j = 0;
				} else {
					prevChar = curChar;
					j++;
				}
			}
			System.out.println(deletionCount + ", " + testString);
		}
	}

}