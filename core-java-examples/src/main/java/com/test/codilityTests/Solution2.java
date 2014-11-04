package com.test.codilityTests;

// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class Solution2 {
	public int solution(IntList l) {
		if (l == null) {
			return 0;
		}
		int len = 1;
		while (l.next != null) {
			len++;
			l = l.next;
		}
		return len;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3, 4, 5 };
		IntList node = null;
		IntList firstNode = null;
		for (int i = 0; i < a.length; i++) {
			IntList newNode = new IntList();
			newNode.value = a[i];
			if (node == null) {
				firstNode = newNode;
			} else {
				node.next = newNode;
			}
			node = newNode;
		}
		System.err.println(firstNode);
		Solution2 solution2 = new Solution2();
		System.err.println(solution2.solution(firstNode));
	}
}

class IntList {
	public int value;
	public IntList next;

	@Override
	public String toString() {
		return "IntList [value=" + value + ", next=" + next + "]";
	}

}
