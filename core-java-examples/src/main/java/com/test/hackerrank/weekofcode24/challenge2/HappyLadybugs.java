package com.test.hackerrank.weekofcode24.challenge2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HappyLadybugs {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int noOfGames = in.nextInt();
        int[] stringLenArr = new int[noOfGames];
        String[] gamesStringArr = new String[noOfGames];
        
        for (int i=0; i < noOfGames; i++) {
        	stringLenArr[i] = in.nextInt();
        	gamesStringArr[i] = in.next();
        }
        in.close();
        
        for (int j=0; j < gamesStringArr.length; j++) {
        	
        	String ladyBugGameString = gamesStringArr[j];
        	boolean isLadybugsHappy = true;
        	
        	if (ladyBugGameString.indexOf('_') != -1) {
        		
        		Map<Character, Integer> colorCountMap = generateColorCountMap(ladyBugGameString.replaceAll("_", ""));
        		
        		for (Integer colorCount : colorCountMap.values()) {
        			if (colorCount < 2) {
        				isLadybugsHappy = false;
        				break;
        			}
        		}
        	} else {
        		if (ladyBugGameString.length() == 1) {
        			isLadybugsHappy = false;
        		} else {
        			isLadybugsHappy = compareColors(ladyBugGameString);
        		}
        	}
        	if (isLadybugsHappy) {
        		System.out.println("YES");
        	} else {
        		System.out.println("NO");
        	}
        	
        }
        
	}
	
	private static Map<Character, Integer> generateColorCountMap(String ladyBugGameString) {
		
		Map<Character, Integer> colorCountMap = new HashMap<>();
		ladyBugGameString = ladyBugGameString.replaceAll("_", "");
		for (int i=0; i < ladyBugGameString.length(); i++) {
			Character ch = ladyBugGameString.charAt(i);
			if (colorCountMap.containsKey(ch)) {
				Integer colorCount = colorCountMap.get(ch);
				colorCountMap.put(ch, ++colorCount);
			} else {
				colorCountMap.put(ch, 1);
			}
		}
		return colorCountMap;
	}
	private static boolean compareColors(String ladyBugGameString) {

		char prevChar = ladyBugGameString.charAt(0);
		int charCount = 1;
		for (int i=1; i < ladyBugGameString.length(); i++) {
			char currChar = ladyBugGameString.charAt(i);
			if (currChar == prevChar) {
				charCount++;
			} else {
				if (charCount < 2) {
					return false;
				} else {
					prevChar = currChar;
					charCount = 1;
				}
			}
		}
		return true;
	}

}
