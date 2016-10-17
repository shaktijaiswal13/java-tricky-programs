package com.test.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/string-similarity
 *
 */
public class StringSimilarity_Optimized {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        String[] testStrings = new String[testCases];
        for(int i=0; i < testCases; i++){
            testStrings[i] = in.next();
        }
        in.close();
        
        for (String testString : testStrings) {
        	
        	int similaritiesWithSuffixes = testString.length();
        	similaritiesWithSuffixes += calculateSimilaritiesWithSuffixes(testString);
        	System.out.println(similaritiesWithSuffixes);
        }
	}
	
	private static int calculateSimilaritiesWithSuffixes(String testString) {
    	
		int similaritiesWithSuffixes = 0;
		for (int i=0; i < testString.length(); i++) {
			
			int prefixMatchCount = 0;
			for (int j=i+1; j < testString.length(); j++) {
				if (testString.charAt(j-i-1) == testString.charAt(j)) {
					prefixMatchCount++;
				} else {
					break;
				}
			}
        	similaritiesWithSuffixes += prefixMatchCount;
		}
		return similaritiesWithSuffixes;
    }
}
