package com.test.hackerrank;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.hackerrank.com/challenges/reduced-string
 *
 */
public class SuperReducedStringUsingLoop {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String testString = scan.next();
		scan.close();
		
		Character c = '\0';
		for (int i=0; i<testString.length();) {
			if (testString.charAt(i) == c) {
				System.out.println("duplicate character : " + c);
				testString = testString.replace(c.toString() + c.toString(), "");
				System.out.println(testString);
				i = 0;
				c = '\0';
			} else {
				c = testString.charAt(i);
				i++;
			}
		}
		System.out.println(testString.length() > 0 ? testString : "Empty String");
	}
}
