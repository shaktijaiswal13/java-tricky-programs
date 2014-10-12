package com.test.codilityTests;

class CodilityTest2 {
	public int solution1(int[] A) {
		int minDiff = Integer.MAX_VALUE;
		int total = 0;
		int tempSum = A[1];
		for (int i = 0; i < A.length; i++) {
			total = total + A[i];
		}
		for (int i = 1; i < A.length; i++) {
			tempSum = tempSum + A[i];
			minDiff = getMinDiff(minDiff, total - tempSum);
		}
		return minDiff;
	}

	public int solution(int[] A) {
		int totalPart1 = 0;
		int totalPart2 = 0;
		int i, j;
		for (i = 0, j = A.length - 1; i < A.length / 2; i++, j--) {
			totalPart1 = totalPart1 + A[i];
			totalPart2 = totalPart2 + A[j];
		}
		System.err.println(i + "" + j);
		if (j == i) {
			return totalPart1 + totalPart2 + A[i];
		} else {

			return totalPart1 + totalPart2;
		}
	}

	public static void main(String[] args) {
		System.err.println(new CodilityTest2().solution(new int[] { 1 }));
	}

	private int getMinDiff(int minDiff, int val) {

		return Math.min((val >= 0 ? val : (val * (-1))), minDiff);
	}

}