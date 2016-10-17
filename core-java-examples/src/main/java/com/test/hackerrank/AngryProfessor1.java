package com.test.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/angry-professor
 */
public class AngryProfessor1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCases = scan.nextInt();
		List<int[]> studentThresholdList = new ArrayList<>();
		List<int[]> studentsTimesList = new ArrayList<>();
		for (int i = 0; i < testCases; i++) {
			
			int[] stuThrs = new int[2];
			stuThrs[0] = scan.nextInt();
			stuThrs[1] = scan.nextInt();
			studentThresholdList.add(stuThrs);
			
			int[] stuTimes = new int[stuThrs[0]];
			for (int j = 0; j < stuThrs[0]; j++) {
				stuTimes[j] = scan.nextInt();
			}
			studentsTimesList.add(stuTimes);
		}
		scan.close();
		for (int i = 0; i < studentsTimesList.size(); i++) {
			determineIfClassIsCancelled(studentsTimesList.get(i), studentThresholdList.get(i)[0],
					studentThresholdList.get(i)[1]);
		}
	}

	private static void determineIfClassIsCancelled(int[] studentsTimesArray, int studentsCount, int threshold) {
		int studentsArrived = 0;
		for (int i = 0; i < studentsCount; i++) {
			int studentArrivalTime = studentsTimesArray[i];
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
