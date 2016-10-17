package com.test.hackerrank;

import java.util.Scanner;

public class MarsExploration {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String sosMessage = scan.next();
		scan.close();
		
		int alteredLettersCount = 0;
		for (int i=0; i < sosMessage.length(); i=i+3) {
			if (sosMessage.charAt(i) != 'S') {
				alteredLettersCount++;
			}
			if (sosMessage.charAt(i + 1) != 'O') {
				alteredLettersCount++;
			}
			if (sosMessage.charAt(i + 2) != 'S') {
				alteredLettersCount++;
			}
		}
		System.out.println(alteredLettersCount);
	}

}
