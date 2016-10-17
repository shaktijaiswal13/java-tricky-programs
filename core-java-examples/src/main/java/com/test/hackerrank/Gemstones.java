package com.test.hackerrank;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/gem-stones
 * 
 */
public class Gemstones {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int rocksCount = scan.nextInt();
		String[] rocksArray = new String[rocksCount];
		
		for (int i=0; i<rocksCount; i++) {
			rocksArray[i] = scan.next();
		}
		scan.close();
		
		Set<Character> gemElementsSet = new HashSet<>();
		for (int i=0; i<rocksArray[0].length(); i++) {
			gemElementsSet.add(rocksArray[0].charAt(i));
		}
		
		for (int j=1; j<rocksArray.length; j++) {
			String rock = rocksArray[j];
			Iterator<Character> gemElementIterator = gemElementsSet.iterator();
			while (gemElementIterator.hasNext()) {
				Character gemElement = gemElementIterator.next();
				if (rock.indexOf(gemElement) == -1) {
					gemElementIterator.remove();
				}
			}
		}
		System.out.println(gemElementsSet.size());
	}

}
