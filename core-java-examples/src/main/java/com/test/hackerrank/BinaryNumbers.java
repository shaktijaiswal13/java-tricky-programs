package com.test.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int decimalNumber = scan.nextInt();
		scan.close();
		List<Integer> remainderList = new ArrayList<>();
		while (decimalNumber != 1) {
			remainderList.add(decimalNumber % 2);
			decimalNumber = decimalNumber / 2;
		}
		remainderList.add(decimalNumber);
//		int size = remainderList.size();
//		for (int i=(size-1); i>=0; i--) {
//			System.out.print(remainderList.get(i));
//		}
//		for (int i=0; i<size; i++) {
//			System.out.print(remainderList.get(i));
//		}
		int onesMaxCount = 0;
		int tempCount = 0;
		for (Integer remainder : remainderList) {
			if (remainder == 1) {
				tempCount++;
			}
			if (tempCount > onesMaxCount) {
				onesMaxCount = tempCount;
			}
			if (remainder == 0) {
				tempCount = 0;
			}
		}
		System.out.println(onesMaxCount);
	}

}
