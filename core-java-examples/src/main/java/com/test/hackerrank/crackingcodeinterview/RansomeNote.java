package com.test.hackerrank.crackingcodeinterview;

import java.util.Hashtable;
import java.util.Scanner;

public class RansomeNote {

	public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int magazineWordsCount = in.nextInt();
        int ransomeNoteWordsCount = in.nextInt();
        String magazine[] = new String[magazineWordsCount];
        for(int magazine_i=0; magazine_i < magazineWordsCount; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[ransomeNoteWordsCount];
        for(int ransom_i=0; ransom_i < ransomeNoteWordsCount; ransom_i++){
            ransom[ransom_i] = in.next();
        }
        in.close();
        
        if (ransomeNoteWordsCount > magazineWordsCount) {
        	System.out.println("No");
        	return;
        }
        
        Hashtable<String, Integer> magazineWords = new Hashtable<>();
        
        for (int i=0; i<magazine.length; i++) {
        	String word = magazine[i];
        	if (magazineWords.containsKey(word)) {
        		Integer wordCount = magazineWords.get(word);
        		magazineWords.put(word, ++wordCount);
        	} else {
        		magazineWords.put(word, 1);

        	}
        }
        System.out.println("magazineWords.size() : " + magazineWords.size());
        Hashtable<String, Integer> ransomeNoteWords = new Hashtable<>();
        
        for (int i=0; i < ransom.length; i++) {
        	String word = ransom[i];
        	if (ransomeNoteWords.containsKey(word)) {
        		Integer wordCount = ransomeNoteWords.get(word);
        		ransomeNoteWords.put(word, ++wordCount);
        	} else {
        		ransomeNoteWords.put(word, 1);

        	}
        }
        System.out.println("ransomeNoteWords.size() : " + ransomeNoteWords.size());
        boolean isReplicaPossible = true;
        for (String ransomeWord : ransomeNoteWords.keySet()) {
        	System.out.println("ransomeWord: " + ransomeWord);
        	System.out.println("ransomeNoteWords.get(ransomeWord) : " +  ransomeNoteWords.get(ransomeWord));
        	System.out.println("magazineWords.get(ransomeWord) : " + magazineWords.get(ransomeWord));
        	
        	if (magazineWords.containsKey(ransomeWord)) {
        		if (ransomeNoteWords.get(ransomeWord) > magazineWords.get(ransomeWord)) {
        			isReplicaPossible = false;
        			break;
        		}
        	} else {
        		isReplicaPossible = false;
    			break;
        	}
        }
        if (isReplicaPossible) {
        	System.out.println("Yes");
        } else {
        	System.out.println("No");
        }
	}

}
