package com.test.hackerrank;

import java.util.Scanner;

public class AngryProfessor {

	/**
	 * https://www.hackerrank.com/challenges/angry-professor
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCases = scan.nextInt();
		long[][] studentThresholdArray = new long[testCases][2];
		long[][] studentsTimesArray = new long[testCases][];
		for (int i = 0; i < testCases; i++) {
			studentThresholdArray[i][0] = scan.nextLong();
			studentThresholdArray[i][1] = scan.nextLong();
			studentsTimesArray[i] = new long[(int) studentThresholdArray[i][0]];
			for (int j = 0; j < studentThresholdArray[i][0]; j++) {
				studentsTimesArray[i][j] = scan.nextLong();
			}
		}
		scan.close();
		for (int i = 0; i < studentsTimesArray.length; i++) {
			determineIfClassIsCancelled(studentsTimesArray[i], studentThresholdArray[i][0],
					studentThresholdArray[i][1]);
		}
	}

	private static void determineIfClassIsCancelled(long[] studentsTimesArray, long studentsCount, long threshold) {
		long studentsArrived = 0;
		for (int i = 0; i < studentsCount; i++) {
			long studentArrivalTime = studentsTimesArray[i];
			if (studentArrivalTime <= 0) {
				studentsArrived++;
			}
		}
		if (studentsArrived >= threshold) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}
	}
}
