package com.test.hackerrank.crackingcodeinterview;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation
 * Input:
 * 5 4
 * 1 2 3 4 5
 * Output:
 * 5 1 2 3 4
 */
public class ArraysLeftRotation {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arrayLength = scan.nextInt();
		int rotations = scan.nextInt();
		int[] arrayElements = new int[arrayLength];
		for (int i=0; i<arrayLength; i++) {
			arrayElements[i] = scan.nextInt();
		}
		scan.close();
		
		int[] arrayAfterRotations = new int[arrayLength];
		
		for (int index=0; index < arrayLength; index++) {
			int newPos = index - rotations;
			if (newPos < 0) {
				newPos += arrayLength; 
			}
			arrayAfterRotations[newPos] = arrayElements[index];
		}
		
		for (int i=0; i<arrayAfterRotations.length; i++) {
			System.out.print(arrayAfterRotations[i] + " ");
		}
	}

}
