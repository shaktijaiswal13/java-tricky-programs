package com.test;

import java.util.HashSet;
import java.util.Set;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(firstRepeatedWord("a ; b	c.b,r;a:g--y"));
	}

	static String firstRepeatedWord(String s) {
		String spaceDelimitedString = s.replaceAll("[\\t:,;/.-]", " ");
		System.out.println(spaceDelimitedString);
		String[] words = spaceDelimitedString.split("\\s+");
		Set<String> uniqueWordsSet = new HashSet<>();
		
		for (String word : words) {
			System.out.println(word + "====");
			// If word already exist in the set, that means first duplicate word
			// found
			if (!uniqueWordsSet.add(word)) {
				return word;
			}
		}
		// No repeated word found
		return null;
	}
}
