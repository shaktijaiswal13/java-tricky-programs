package com.test.hackerrank;

import java.util.Date;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/alternating-characters
 * 
 * it is not a generic solution and slow as well.
 *
 */
public class AlternatingCharacters1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCases = scan.nextInt();
		String[] testStringsArray = new String[testCases];
		
		for (int i=0; i<testCases; i++) {
			testStringsArray[i] = scan.next();
		}
		scan.close();
		Date startDate = new Date();

		for (int i=0; i < testStringsArray.length; i++) {
			String testString = testStringsArray[i];
			int deletionCount = 0;
			int indexAA = testString.indexOf("AA");
			
			while (indexAA != -1) {
				testString = testString.substring(0, indexAA) + testString.substring(indexAA + 1, testString.length());
				indexAA = testString.indexOf("AA");
				deletionCount++;
			}
			
			int indexBB = testString.indexOf("BB");
			while (indexBB != -1) {
				testString = testString.substring(0, indexBB) + testString.substring(indexBB + 1, testString.length());
				indexBB = testString.indexOf("BB");
				deletionCount++;
			}
			
			System.out.println(deletionCount);
			Date endDate = new Date();

			System.out.println(startDate + ", " + endDate);
		}
	}

}