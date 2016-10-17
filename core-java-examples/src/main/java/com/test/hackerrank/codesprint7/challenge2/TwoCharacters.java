package com.test.hackerrank.codesprint7.challenge2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 13 beafbeefeaeab
 *
 */
public class TwoCharacters {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String actualString = in.next();
        in.close();
        
        String stringWithoutDuplicateChars = findDuplicateCharactersUsingRegex(actualString);
        
        Set<Character> characterSet = new HashSet<>();
        for (int i=0; i < stringWithoutDuplicateChars.length(); i++) {
        	characterSet.add(stringWithoutDuplicateChars.charAt(i));
        }
        
        // ([a-zA-Z]+) matches any character, one or more times and \\1 matches whatever was in the first 
        // set of parentheses is repeated. So for string 'babab' it will match to
        // 'ba' as it is repeated twice in the string.
        String repeatedCharsRegex = "([a-zA-Z]+)\\1";
        Pattern repeatedCharsPattern = Pattern.compile(repeatedCharsRegex);
        
        if (characterSet.size() == 2) {
        	if (repeatedCharsPattern.matcher(stringWithoutDuplicateChars).find()) {
        		System.out.println(stringWithoutDuplicateChars.length());
        	} else if (stringWithoutDuplicateChars.length() == 2) {
        		System.out.println(stringWithoutDuplicateChars.length());
        	} else {
        		System.out.println(0);
        	}
        } else {
        	String strPattern = "";
        	int patternLength = 0;
        	for (Character c : characterSet) {
        		System.out.println("character is: "+ c.toString());
        		String temp = stringWithoutDuplicateChars.replaceAll(c.toString(), "");
        		System.out.println(temp);
        		Matcher matcher = repeatedCharsPattern.matcher(temp);
        		if (matcher.find()) {
        			System.out.println("duplicate character found: " + matcher.group(1));
        			System.out.println(temp.length());
        			if (patternLength < temp.length()) {
        				strPattern = temp;
        				patternLength = temp.length();
        			}
        		}
        	}
        	System.out.println(strPattern + ", " + patternLength);
//        	System.out.println(patternLength);

        }
	}
	/**
	 * This method removes the each duplicate character from the given string using regex. For eg:
	 * 'beabeefeaab' will be converted to 'babfaab' after removing 'e', then
	 * 'babfaab' will be converted to 'bbfb' after removing 'a', and so on.
	 */
	private static String findDuplicateCharactersUsingRegex(String s) {
		
		// ([a-zA-Z]) matches any single character and \\1+ matches whatever was in the first 
		// set of parentheses, one or more times. So for string 'beabeefeab' it will match to
		// 'e' as e is repeated twice (as 'ee') in the string.
		String regex = "([a-zA-Z])\\1+";	
		Pattern pattern = Pattern.compile(regex);
		String temp = s;
		
		while (true) {
			Matcher matcher = pattern.matcher(temp);
			if (matcher.find()) {
				System.out.println("duplicate character found: " + matcher.group(1));
				temp = temp.replaceAll(matcher.group(1), "");
				System.out.println(temp);
			} else {
				break;
			}
		}
		return temp;
	}
	
	private static void findAlternateCharacterString(String stringWithoutDuplicateChars, Set<Character> characterSet) {

		String repeatedCharsRegex = "([a-zA-Z]+)\\1";
        Pattern repeatedCharsPattern = Pattern.compile(repeatedCharsRegex);
    	String temp = stringWithoutDuplicateChars;
    	int patternLength = 0;
    	for (Character c : characterSet) {
    		System.out.println("character is: "+ c.toString());
    		Matcher matcher = repeatedCharsPattern.matcher(temp);
    		if (matcher.find()) {
    			System.out.println("duplicate character found: " + matcher.group(1));
    			System.out.println(temp.length());
    			if (patternLength < temp.length()) {
    				patternLength = temp.length();
    			}
    		}
    		temp = stringWithoutDuplicateChars.replaceAll(c.toString(), "");
    		System.out.println(temp);
    	}
    	System.out.println(temp + ", " + patternLength);
//    	System.out.println(patternLength);

    
	}
	
	/**
	 * This method removes the each duplicate character from the given string using for loop. For eg:
	 * 'beabeefeaab' will be converted to 'babfaab' after removing 'e', then
	 * 'babfaab' will be converted to 'bbfb' after removing 'a', and so on.
	 */
	private static String removeEachDupliacteCharacter(String s) {
		Character c = '\0';
		String temp = s;
		for (int i=0; i<temp.length();) {
			if (temp.charAt(i) == c) {
        		System.out.println("duplicate character found: " + c);
				temp = temp.replaceAll(c.toString(), "");
        		System.out.println("String after replacement:" + temp);
        		i = 0;
			} else {
				c = temp.charAt(i);
				i++;
			}
		}
		return temp;
	}
	

}
