package com.test.hackerrank.codesprint7.challenge2;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {

	public static void main(String[] args) {
		String stringToMatch = "nkrtilugufndzwdoabujujdeglaihiutnfjqjoaohr";
		Pattern p = Pattern.compile("([a-zA-Z])\\1+");
		Matcher m = p.matcher(stringToMatch);
		if (m.find())
		{
		    System.out.println("Word contains duplicate characters " + m.group(1));
		}
		Set<Character> characterSet = new HashSet<>();
    	for (int i=0; i < stringToMatch.length(); i++) {
    		characterSet.add(stringToMatch.charAt(i));
    	}
    	
    	System.out.println(characterSet.size());
    	System.out.println(stringToMatch.replaceAll("[nkr]", ""));
	}

}
