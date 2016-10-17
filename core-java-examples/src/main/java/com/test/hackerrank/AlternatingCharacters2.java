package com.test.hackerrank;

import java.util.Date;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/alternating-characters
 * 
 * It is also not generic but is most optimal solution, takes very less time.
 *
 */
public class AlternatingCharacters2 {

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
			
			while (testString.indexOf("AA") != -1 || testString.indexOf("BB") != -1) {
				
				testString = testString.replaceAll("AA", "A").replaceAll("BB", "B");
			}
			
			System.out.println(testStringsArray[i].length() - testString.length());
		}
		Date endDate = new Date();

		System.out.println(startDate + ", " + endDate);
	}

}