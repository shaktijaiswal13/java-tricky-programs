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
public class StringSimilarity_FurtherOptimized {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        String[] testStrings = new String[testCases];
        for(int i=0; i < testCases; i++){
            testStrings[i] = in.next();
        }
        in.close();
        
        for (String testString : testStrings) {
        	
        	int similaritiesWithSuffixes = calculateSimilaritiesWithSuffixes(testString);
        	System.out.println(similaritiesWithSuffixes);
        }
	}
	
	private static int calculateSimilaritiesWithSuffixes(String testString) {
    	
		int similaritiesWithSuffixes = testString.length();
		char firstChar = testString.charAt(0);
		int firstCharMaxCount = 1;
		int firstCharCount = 1;
		int charNotMatchCount = 0;
		
		for (int i=1; i < testString.length(); i++) {
			
			System.out.println("testString.charAt(" + i + "): " + testString.charAt(i));
			if (testString.charAt(i) == firstChar) {
				firstCharCount++;
			} else {
				System.out.println(firstCharCount);
				charNotMatchCount++;
				if (charNotMatchCount == 1) {
					similaritiesWithSuffixes += (firstCharCount * (firstCharCount + 1)) / 2;
					firstCharMaxCount = firstCharCount;
				} else if (firstCharCount < firstCharMaxCount) {
					similaritiesWithSuffixes += (firstCharCount * (firstCharCount + 1)) / 2;
				} else  if (firstCharCount >= firstCharMaxCount) {
					similaritiesWithSuffixes += calculateSimilarityForString(testString, testString.substring(i-1));
				}
				firstCharCount = 0;
				System.out.println("similaritiesWithSuffixes: " + similaritiesWithSuffixes);
			}
		}
		System.out.println("firstCharCount: " + firstCharCount + ", firstCharMaxCount: " + firstCharMaxCount);
		if (firstCharCount != 0 && firstCharCount <= firstCharMaxCount) {
			similaritiesWithSuffixes += (firstCharCount * (firstCharCount + 1)) / 2;
		} else  if (firstCharCount != 0 && firstCharCount > firstCharMaxCount) {
			for (int i=1; i<firstCharCount; i++) {
				similaritiesWithSuffixes += firstCharMaxCount;
			}
			similaritiesWithSuffixes += 1;
		}
		return similaritiesWithSuffixes;
    }
	
	private static int calculateSimilarityForString(String testString, String testSubString) {
		
		System.out.println("testString: " + testString + ", testSubString: " + testSubString);
		int prefixMatchCount = 0;
		
		for (int j=0; j < testSubString.length(); j++) {
			if (testSubString.charAt(j) == testString.charAt(j)) {
				prefixMatchCount++;
			} else {
				break;
			}
		}
		System.out.println("prefixMatchCount: " + prefixMatchCount);
		return prefixMatchCount;
	}
}
