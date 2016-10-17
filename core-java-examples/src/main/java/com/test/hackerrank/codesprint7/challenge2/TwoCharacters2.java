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
public class TwoCharacters2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String actualString = in.next();
        in.close();
        
        if (actualString.length() > len || !actualString.matches("[a-z]+")) {
        	System.out.println(0);
        	return;
        }
        String stringWithoutDuplicateChars = findStringWithoutDuplicateCharactersUsingRegex(actualString);
        
        Set<Character> characterSet = new HashSet<>();
        for (int i=0; i < stringWithoutDuplicateChars.length(); i++) {
        	characterSet.add(stringWithoutDuplicateChars.charAt(i));
        }
        
        StringBuffer distinctCharsStringBuf = new StringBuffer();
        for (int i=0; i<stringWithoutDuplicateChars.length(); i++) {
        	char c= stringWithoutDuplicateChars.charAt(i);
        	if (distinctCharsStringBuf.toString().indexOf(c) == -1) {
        		distinctCharsStringBuf.append(c);
        	}
        }
        String distinctCharsString = distinctCharsStringBuf.toString();
        System.out.println(distinctCharsString);
        
        for (int j=0; j<stringWithoutDuplicateChars.length()-1; j++) {
        	String distinctCharsSubStr = distinctCharsString.substring(j, j+2);
        	String temp = stringWithoutDuplicateChars.replaceAll("[^" + distinctCharsSubStr + "]", "");
        	System.out.println(temp);
        }
	}
	
	/**
	 * This method removes the each duplicate character from the given string using regex. For eg:
	 * 'beabeefeaab' will be converted to 'babfaab' after removing 'e', then
	 * 'babfaab' will be converted to 'bbfb' after removing 'a', and so on.
	 */
	private static String findStringWithoutDuplicateCharactersUsingRegex(String s) {
		
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
