package com.test.hackerrank;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.hackerrank.com/challenges/beautiful-binary-string
 *
 */
public class BinaryStringUsingRegex {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int len = scan.nextInt();
		String testString = scan.next();
		if (testString.length() > len || !testString.matches("[01]+")) {
			System.out.println("0");
		}
		scan.close();
		
		String regex = "(010)+?";
		Pattern pattern = Pattern.compile(regex);
		int stepsToUpdateString = 0;
		while(true) {
			Matcher matcher = pattern.matcher(testString);
			if (matcher.find()) {
				String match = matcher.group(1);
				System.out.println(match + " start at " + matcher.start() + " end at " + matcher.end());
				testString = testString.replaceFirst("010", "011");
				System.out.println(testString);
				stepsToUpdateString++;
			} else {
				break;
			}
		}
		System.out.println(stepsToUpdateString);
	}

}
