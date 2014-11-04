package com.test.codilityTests;

// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class CodilityTest3 {
	public int solution(int[] a) {
		int maxSliceIndex = 0;
		int maxSliceLen = -1;
		int tempSliceIndex = 0;
		int tempSliceLen = 1;
		for (int i = 1; i < a.length; i++) {
			if (a[i - 1] >= a[i]) {
				System.err.println("i=" + i + ", temsliLen=" + tempSliceLen
						+ ", tempSlIndex=" + tempSliceIndex);
				if (maxSliceLen < tempSliceLen) {
					maxSliceLen = tempSliceLen;
					maxSliceIndex = tempSliceIndex;
				}
				tempSliceLen = 1;
				tempSliceIndex = i;
			} else {
				tempSliceLen++;
			}
		}
		return maxSliceIndex;
	}
}

// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution1 {
	public String solution1(String s) {
		StringBuilder builder = new StringBuilder();
		String[] words = s.split(" ");
		for (String word : words) {
			int len = word.length();
			for (int i = len - 1; i >= 0; i--) {
				builder.append(word.charAt(i));
			}
			builder.append(' ');
			// syserr
		}
		return "";

	}

	// private String reverse(String word) {
	//
	// }
}
