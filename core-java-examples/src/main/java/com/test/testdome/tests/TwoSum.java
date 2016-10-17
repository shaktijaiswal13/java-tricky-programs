package com.test.testdome.tests;

public class TwoSum {
	public static int[] findTwoSumOther(int[] list, int sum) {
		int[] indices = null;
		int length = list.length;
		for (int i = 0; i < length; i++) {
			for (int j = length - 1; j > 0; j--) {
				int twoElementsSum = list[i] + list[j];
				if (sum > twoElementsSum) {
					// System.out.print("list[i] + list[j]:" + list[i] + "+" +
					// list[j] + "======");
					// System.out.println(sum + ">" + twoElementsSum + " so
					// +breaking...");
					break;
				}
				if (sum == twoElementsSum) {
					indices = new int[2];
					indices[0] = i;
					indices[1] = j;
					return indices;
				}
			}
		}
		return indices;
	}

	public static int[] findTwoSum1(int[] list, int sum) {
		int[] indices = null;
		int length = list.length;
		for (int i = 0; i < length; i++) {
			for (int j = length - 1; j > i; j--) {
				int twoElementsSum = list[i] + list[j];
				if (sum > twoElementsSum) {
					// System.out.print("list[i] + list[j]:" + list[i] + "+" +
					// list[j] + "======");
					// System.out.println(sum + ">" + twoElementsSum + " so
					// +breaking...");
					break;
				}
				if (sum == twoElementsSum) {
					indices = new int[2];
					indices[0] = i;
					indices[1] = j;
					return indices;
				}
			}
		}
		return indices;
	}

	public static int[] findTwoSum(int[] list, int sum) {
		int[] indices = null;
		int length = list.length;
		for (int i = 0; i < length; i++) {
			int low = i;
			int high = length - 1;
			while (high >= low) {
				int middle = (low + high) / 2;
				if (list[i] + list[middle] == sum) {
					indices = new int[2];
					indices[0] = i;
					indices[1] = middle;
					return indices;
				}
				if (list[i] + list[middle] < sum) {
					low = middle + 1;
				}
				if (list[i] + list[middle] > sum) {
					high = middle - 1;
				}
			}
		}
		return indices;
	}

	public static void main(String[] args) {
		int[] indices = findTwoSum(new int[] { 1, 3, 5, 7, 9 }, 12);
		System.out.println(indices[0] + " " + indices[1]);

		int[] indices1 = findTwoSum(new int[] { 1, 3, 5, 7, 9 }, 16);
		System.out.println(indices1[0] + " " + indices1[1]);

		// int[] indices2 = findTwoSum(new int[] { 1, 3, 5, 7, 9 }, 18);
		// System.out.println(indices2[0] + " " + indices2[1]);

		int[] indices3 = findTwoSum(
				new int[] { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35, 37, 39 }, 76);
		System.out.println(indices3[0] + " " + indices3[1]);
	}

	public static int[] findTwoSumOld(int[] list, int sum) {
		int[] indices = null;
		for (int i = 0; i < list.length; i++) {
			for (int j = i + 1; j < list.length; j++) {
				int twoElementsSum = list[i] + list[j];
				if (sum == twoElementsSum) {
					indices = new int[2];
					indices[0] = i;
					indices[1] = j;
					return indices;
				}
			}
		}
		return indices;
	}
}