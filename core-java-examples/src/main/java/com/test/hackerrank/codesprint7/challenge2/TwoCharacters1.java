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
 * 10 abcaabccab
 *
 */
public class TwoCharacters1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String actualString = in.next();
        in.close();
        
        if (actualString.length() > len || !actualString.matches("[a-z]+")) {
        	System.out.println(0);
        	return;
        }
        String stringWithoutDuplicateChars = findDuplicateCharactersUsingRegex(actualString);
        
        boolean isStringValid = validateStringIswithAlternateCharacters(stringWithoutDuplicateChars);
        System.out.println(isStringValid);
        
        if (!isStringValid) {
        	Set<Character> characterSet = new HashSet<>();
        	for (int i=0; i < stringWithoutDuplicateChars.length(); i++) {
        		characterSet.add(stringWithoutDuplicateChars.charAt(i));
        	}
        	System.out.println("characterSet size: " + characterSet.size());
        	int validPatternLength = 0;
        	String validPattern = "";
        	for (Character c : characterSet) {
        		System.out.println("character is: "+ c.toString());
        		String temp = stringWithoutDuplicateChars.replaceAll(c.toString(), "");
        		System.out.println("String after replacing " + c + " with  is : " + temp);
        		boolean isTempStringValid = validateStringIswithAlternateCharacters(temp);
        		if (isTempStringValid && validPatternLength < temp.length()) {
        			validPatternLength = temp.length();
        			validPattern = temp;
        		}
        	}
        	System.out.println(validPattern + ", " + validPatternLength);
        } else {
        	System.out.println(stringWithoutDuplicateChars.length() > 1 ? stringWithoutDuplicateChars.length() : 0);
        }
	}
	
	private static boolean validateStringIswithAlternateCharacters(String stringWithoutDuplicateChars) {

		System.out.println("validateStringIswithAlternateCharacters called with string: " + stringWithoutDuplicateChars);
		int length = stringWithoutDuplicateChars.length();
		boolean isStringValid = true;
		
		if (length <= 1) {
			return true;
		}
		if (length == 2) {
			if (stringWithoutDuplicateChars.charAt(0) != stringWithoutDuplicateChars.charAt(1)) {
				return true;
			} else {
				return false;
			}
		}
		String temp = stringWithoutDuplicateChars.substring(0, 2);
		System.out.println("temp is: " + temp);
		for (int i=2; i < length; i = i+2) {
			if (i == length - 1) {
				if (temp.charAt(0) == stringWithoutDuplicateChars.charAt(i)) {
					isStringValid = true;
					System.out.println("matched... " + stringWithoutDuplicateChars.charAt(i));
				} else {
					isStringValid = false;
					System.out.println("Not Matched...");
					break;
				}
			}  else  if (temp.equals(stringWithoutDuplicateChars.substring(i, i+2))) {
				isStringValid = true;
				System.out.println("matched... " + stringWithoutDuplicateChars.substring(i, i+2));
				continue;
			} else {
				isStringValid = false;
				System.out.println("Not Matched...");
				break;
			}
		}
		return isStringValid;
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

}
