package com.test.codilityTests;

import java.util.Arrays;

// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class CodilityTest4 {
	public boolean solution(int[] a) {
		int[] copiedArr = copyArray(a);
		int[] sortedArray = trySort(copiedArr);
		return isSorted(sortedArray);
	}

	private int[] copyArray(int[] a) {
		int[] newArr = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			newArr[i] = a[i];
		}
		return newArr;
	}

	private boolean isSorted(int[] a) {
		boolean sorted = true;
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				sorted = false;
				break;
			}
		}
		return sorted;
	}

	private int[] trySort(int[] a) {
		int firstIndexToSwap = -1;
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i + 1] < a[i]) {
				if (firstIndexToSwap != -1) {
					// do swap
					int temp = a[firstIndexToSwap];
					a[firstIndexToSwap] = a[i + 1];
					a[i + 1] = temp;
					System.err.println("swaping index : " + firstIndexToSwap
							+ ", " + (i + 1));
					break;
				} else {
					firstIndexToSwap = i;
					Arrays.sort(a);
				}
			}
		}
		return a;
	}

	public static void main(String[] args) {
		System.err.println(new CodilityTest4().solution(new int[] { 1, 2, 2, 3, 4,
				5, 6, 9, 8 }));
	}
}
