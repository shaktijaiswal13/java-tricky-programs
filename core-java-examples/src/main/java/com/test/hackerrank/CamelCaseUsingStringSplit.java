package com.test.hackerrank;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Alice wrote a sequence of words in CamelCase as a string of letters, s, having the following properties:
 * It is a concatenation of one or more words consisting of English letters.
 * All letters in the first word are lowercase.
 * For each of the subsequent words, the first letter is uppercase and rest of the letters are lowercase.
 * Given s, print the number of words in s on a new line.
 * Constraints: 1<= s <= 10^5
 * Input: saveChangesInTheEditor, Output: 5
 * 
 */
public class CamelCaseUsingStringSplit {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        String camelcaseString = in.next();
        in.close();
//        String camelCaseRegex = "([a-z]+)?(([A-Z])([a-z]+))";
//        String camelCaseRegex = "([a-z]?)?([A-Z][a-z]?)+?";
//        Pattern pattern = Pattern.compile(camelCaseRegex);
//        Matcher matcher = pattern.matcher(camelcaseString);
//        while (matcher.find()) {
//        	System.out.println("match found...");
//        	for (int i=1; i<=matcher.groupCount(); i++) {
//        		System.out.println(matcher.group(i));
//        		
//        	}
////        	System.out.println(matcher.groupCount());
////        	System.out.println(matcher.group(2));
//
//        }
        
        String[] stringArray = camelcaseString.split("[A-Z]");
        System.out.println(stringArray.length);
	}

}
