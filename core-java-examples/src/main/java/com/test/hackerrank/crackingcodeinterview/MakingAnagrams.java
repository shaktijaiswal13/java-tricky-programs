package com.test.hackerrank.crackingcodeinterview;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-making-anagrams
 * Input: abc cde Output: 4
 * Input: bacdc dcbad Output: 2
 * Input: bacdc dcbac Output: 0
 */
public class MakingAnagrams {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String firstString = in.next();
        String secondString = in.next();
        in.close();
        System.out.println(numberNeeded(firstString, secondString));
    }

	private static int numberNeeded(String first, String second) {
		
		char[] firstStrCharArray = first.toCharArray();
		int charsToDelete = 0;
		for (char firstStrChar : firstStrCharArray) {
			
			int index = second.indexOf(firstStrChar);
			if (index != -1) {
				second = second.substring(0, index) + second.substring(index + 1, second.length());
			} else {
				charsToDelete++;
			}
		}
		charsToDelete += second.length();
		return charsToDelete;
	}
}
