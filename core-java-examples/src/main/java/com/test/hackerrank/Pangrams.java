package com.test.hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/pangrams
 * (Pangrams are sentences constructed by using every letter of the alphabet at least once.)
 * 
 * 1) The quick brown fox jumps over the lazy dog
 * 2) We promptly judged antique ivory buckles for the next prize
 */
public class Pangrams {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String testString = scan.nextLine();
		scan.close();
		
		String updatedString = testString.replaceAll("\\s+", "").toLowerCase();
		System.out.println(updatedString);
		Set<Character> charactersSet = new HashSet<>();
		
		for (int i=0; i<updatedString.length(); i++) {
			charactersSet.add(updatedString.charAt(i));
		}
		System.out.println(charactersSet.size());
		if (charactersSet.size() == 26) {
			System.out.println("pangram");
		} else {
			System.out.println("not pangram");
		}
	}

}
