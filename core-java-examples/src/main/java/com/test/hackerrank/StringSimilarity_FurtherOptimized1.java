package com.test.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/string-similarity
 *
 */
public class StringSimilarity_FurtherOptimized1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        String[] testStrings = new String[testCases];
        for(int i=0; i < testCases; i++){
            testStrings[i] = in.next();
        }
        in.close();
        
        for (String testString : testStrings) {
        	
        	long similaritiesWithSuffixes = calculateSimilaritiesWithSuffixes(testString);
        	System.out.println(similaritiesWithSuffixes);
        }
	}
	
	private static long calculateSimilaritiesWithSuffixes(String testString) {
    	
		int testStrLen = testString.length();
		long similaritiesWithSuffixes = testStrLen;
		char firstChar = testString.charAt(0);
		long firstCharMaxCount = 1;
		
		int index = 1;
		for (; index < testStrLen; index++) {
			
			if (testString.charAt(index) == firstChar) {
				firstCharMaxCount++;
			} else {
				similaritiesWithSuffixes += calculateSimilarities(firstCharMaxCount - 1);
				break;
			}
		}
		if (firstCharMaxCount == testStrLen) {
			similaritiesWithSuffixes += calculateSimilarities(firstCharMaxCount - 1);
			return similaritiesWithSuffixes;
		}
		
		int firstCharCount = 0;
		for (int i=index+1; i < testStrLen; i++) {
		
			if (testString.charAt(i) == firstChar) {
				firstCharCount++;
			} else if (firstCharCount < firstCharMaxCount) {
			
				similaritiesWithSuffixes += calculateSimilarities(firstCharCount);
				firstCharCount = 0;
			} else  if (firstCharCount >= firstCharMaxCount) {
				
				similaritiesWithSuffixes += calculateSimilarityForStrings(testString, firstCharCount, (i - firstCharCount));
				firstCharCount = 0;
			}
		}
		
		if (firstCharCount != 0 && firstCharCount <= firstCharMaxCount) {
			
			similaritiesWithSuffixes += calculateSimilarities(firstCharCount);
		} else  if (firstCharCount != 0 && firstCharCount > firstCharMaxCount) {
			
			similaritiesWithSuffixes += calculateSimilarityForStrings(testString, firstCharCount, (testStrLen - firstCharCount));
		}
		return similaritiesWithSuffixes;
    }
	
	private static long calculateSimilarityForStrings(String testString, long firstCharMatchCount, int index) {
		
		long prefixMatchCount = 0;
		
		for (int i=0; i < firstCharMatchCount; i++) {
			for (int j=i; j < testString.length() - index; j++) {
				if (testString.charAt(index + j) == testString.charAt(j - i)) {
					prefixMatchCount++;
				} else {
					break;
				}
			}
		}
		return prefixMatchCount;
	}
	
	private static long calculateSimilarities(long count) {
		return (count * (count + 1)) / 2;
	}
}
