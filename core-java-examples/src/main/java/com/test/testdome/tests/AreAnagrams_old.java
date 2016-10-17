package com.test.testdome.tests;

public class AreAnagrams_old {
	public static boolean areAnagrams(String a, String b) {
		StringBuffer str = new StringBuffer(b);
		if (a.length() != b.length()) {
			return false;
		}
		for (int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			boolean charFound = false;
			for (int j = 0; j < str.length(); j++) {
				if (c == str.charAt(j)) {
					charFound = true;
					str.deleteCharAt(j);
					break;
				}
			}
			if (!charFound) {
				return false;
			}
		}
		return true;
	}

	public static boolean isAnagram(String word, String anagram) {
		if (word.length() != anagram.length()) {
			return false;
		}
		char[] chars = word.toCharArray();
		for (char c : chars) {
			int index = anagram.indexOf(c);
			if (index != -1) {
				anagram = anagram.substring(0, index) + anagram.substring(index + 1, anagram.length());
			} else {
				return false;
			}
		}
		return anagram.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(isAnagram("schoolmaster", "theclafsroom"));
		System.out.println(areAnagrams("schoolmaster", "theclassroom"));
		System.out.println(areAnagrams("schoolmaster", "theclafsroomq"));
		System.out.println(areAnagrams("schoolmaste", "theclafsroom"));
		System.out.println(areAnagrams("tough", "ughto"));

	}
}