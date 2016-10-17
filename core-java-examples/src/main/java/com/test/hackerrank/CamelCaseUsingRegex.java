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
public class CamelCaseUsingRegex {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        String camelCaseString = in.next();
        in.close();
        
        String normalString = "";
        if (camelCaseString.charAt(0) >= 97) {
        	normalString = ((char) (camelCaseString.charAt(0) - 32)) + camelCaseString.substring(1);
        } else {
        	normalString = camelCaseString;
        }
        
//        String camelCaseRegex = "([a-z]+)?(([A-Z])([a-z]+))";
        
        String camelCaseRegex = "([A-Z][a-z]+)+?";
        Pattern pattern = Pattern.compile(camelCaseRegex);
        Matcher matcher = pattern.matcher(normalString);
        
        int wordsCount = 0;
        while (matcher.find()) {
        	wordsCount++;
        }
        System.out.println(wordsCount);
	}

}
