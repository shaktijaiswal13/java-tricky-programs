package com.test.testdome.tests;
public class AreAnagrams {
    public static boolean areAnagrams(String a, String b) {
    	if (a.length() != b.length()) {
    		return false;
    	}
        /*for (int i=0; i < a.length(); i++) {
        	for (int j=0; j < b.length(); j++) {
        		if (a.charAt(i) == b.charAt(j)) {
        			b = b.substring(0, j) + b.substring(j+1, b.length());
        		}
        	}
        }*/
        
        char[] charArray = a.toCharArray();
        for (char c : charArray) {
        	int index = b.indexOf(c);
        	if (index != -1) {
        		b = b.substring(0, index) + b.substring(index + 1, b.length());
        	} else {
        		return false;
        	}
        }
    	
    	return b.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(areAnagrams("neural", "unreal"));
        System.out.println(areAnagrams("neurall", "unreal"));
        System.out.println(areAnagrams("neural", "unreald"));
        System.out.println(areAnagrams("neurall", "unreafl"));
        System.out.println(areAnagrams("schoolmaster", "theclafsroom"));
		System.out.println(areAnagrams("schoolmaster", "theclassroom"));
		System.out.println(areAnagrams("schoolmaster", "theclafsroomq"));
		System.out.println(areAnagrams("schoolmaste", "theclafsroom"));
		System.out.println(areAnagrams("tough", "ughto"));
    }
}