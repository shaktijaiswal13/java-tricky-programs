package com.test.hackerrank;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.hackerrank.com/challenges/reduced-string
 *
 */
public class SuperReducedStringUsingRegex {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String testString = scan.next();
		scan.close();
		
		String removeDuplicateCharRegex = "([a-z])?\\1";
		Pattern pattern = Pattern.compile(removeDuplicateCharRegex);
		
		while (true) {
			Matcher matcher = pattern.matcher(testString);
			if (matcher.find()) {
				String match = matcher.group(1);
				System.out.println(match + " start at " + matcher.start() + " end at " + matcher.end());
				testString = testString.replace(match + match, "");
				System.out.println(testString);
			} else {
				System.out.println(testString.length() > 0 ? testString : "Empty String");
				break;
			}
		}
	}
}
