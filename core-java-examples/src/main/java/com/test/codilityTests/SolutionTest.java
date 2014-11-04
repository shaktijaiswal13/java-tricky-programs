package com.test.codilityTests;

class SolutionTest {

	public int solution(int[] a) {
		int n = a.length;
		int result = -1;
		if (n == 0 || n == 1) {
			return -1;
		} else if (n == 2) {
			if (a[1] == 0) {
				return 0;
			} else if (a[0] == 0) {
				return 1;
			}
		}
		for (int i = 0; i < n; i++) {
			if (i == 0 && getSum(1, n - 1, a) == 0) {
				result = 0;
			} else if (i == n - 1 && getSum(0, n - 2, a) == 0) {
				result = n - 1;
			} else if (i < n - 2
					&& getSum(0, i - 1, a) == getSum(i + 1, n - 1, a)) {
				result = i;
			}
		}
		return result;
	}

	private long getSum(int beginIndex, int lastIndex, int[] a) {
		long sum = 0;
		for (int i = beginIndex; i <= lastIndex; i++) {
			sum = sum + a[i];
		}
		return sum;
	}
}