package com.test.hackerrank.sorting;

import java.util.Scanner;

public class SearchNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int valueTosearch = scan.nextInt();
		int arrayLength = scan.nextInt();
		int[] testArray = new int[arrayLength];
		
		for (int i=0; i < arrayLength; i++) {
			testArray[i] = scan.nextInt();
		}
		scan.close();
		
		for (int i=0; i < testArray.length; i++) {
			if (testArray[i] == valueTosearch) {
				System.out.println(i);
				break;
			}
		}
	}

}
