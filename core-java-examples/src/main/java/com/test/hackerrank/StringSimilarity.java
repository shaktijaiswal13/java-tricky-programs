package com.test.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/string-similarity
 *
 */
public class StringSimilarity {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        String[] testStrings = new String[testCases];
        for(int i=0; i < testCases; i++){
            testStrings[i] = in.next();
        }
        in.close();
        
        for (String testString : testStrings) {
        	
        	Map<String, Integer> suffixesMap = new HashMap<>();
        	int similaritiesWithSuffixes = 0;
        	suffixesMap.put(testString, testString.length());
        	
        	calculateSimilaritiesWithSuffixes(testString, suffixesMap);
        	
        	for (Integer prefixCount : suffixesMap.values()) {
        		similaritiesWithSuffixes += prefixCount;
        	}
        	System.out.println(similaritiesWithSuffixes);
        }
	}
	
	private static void calculateSimilaritiesWithSuffixes(String testString, Map<String, Integer> suffixesMap) {
		for (int i=1; i < testString.length(); i++) {
    		String subStr = testString.substring(i);
    		int prefixMatchCount = 0;
    		
    		for (int j=0; j < subStr.length(); j++) {
    			if (subStr.charAt(j) == testString.charAt(j)) {
    				prefixMatchCount++;
    			} else {
    				break;
    			}
    		}
//    		System.out.println("subStr: " + subStr + ", " + "match: " + prefixMatchCount);
    		if (prefixMatchCount > 0) {
            	suffixesMap.put(subStr, prefixMatchCount);
    		}
    	}
	}

}
