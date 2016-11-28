package com.test.hackerrank.womenscodesprint2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * <pre>
 * https://www.hackerrank.com/contests/womens-codesprint-2/challenges/minimum-loss
 * 
 * Optimized version
 * 1) Create a 2-D array with indexes and actual elements
 * 2) Sort the array in asc order of elements.
 * 3) Now iterate the sorted 2-d array to compare the actual indexes of the elements as follows:
 * a) Leave the element at position 0, as house bought at this price cannot be sold at loss.
 * b) If index value at position x is less than the index of position x-1, 
 * 	then subtract the values at these positions.
 * c) If index value at position x is not less than the index of position x-1, 
 * 	then compare it with x-2, x-3... till the position 1.
 * 
 * 10 20 10 5 30 6 8 10 7 14 5 answer - 1
 * 
 * 5 20 7 8 2 5 answer - 2
 * 
 * 3 5 10 3 answer - 2
 * </pre>
 */

public class MinimumLoss1 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int noOfYears = scan.nextInt();
		long[][] housePricesWithIndex = new long[noOfYears][2];
		
		//Create a 2-D array with indexes and actual elements
		for (int i = 0; i < noOfYears; i++) {
			housePricesWithIndex[i][0] = i;					//index
			housePricesWithIndex[i][1] = scan.nextLong();	//element(house price)
		}
		scan.close();

		//Sort the array in asc order of elements.
		Arrays.sort(housePricesWithIndex, new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				return Long.compare(((long[]) o1)[1], ((long[]) o2)[1]);
			}
		});

		for (int i = 0; i < housePricesWithIndex.length; i++) {
			for (int j = 0; j < housePricesWithIndex[i].length; j++) {
				System.out.print(housePricesWithIndex[i][j] + " ");
			}
			System.out.println();
		}

		long actualLoss = 0;
		
		//Leave the element at position 0, as house bought at this price cannot be sold at loss.
		for (int i = 1, j = 1; i < housePricesWithIndex.length; i++, j = i) {
			while (j > 0) {
				
				//If index value at position x is less than the index of position x-1, 
				//then subtract the values at these positions else continue looping till j is 1.
				if (housePricesWithIndex[i][0] < housePricesWithIndex[--j][0]) {
					long tempLoss = housePricesWithIndex[i][1] - housePricesWithIndex[j][1];
					if (actualLoss > tempLoss || actualLoss == 0) {
						actualLoss = tempLoss;
					}
					break;
				}
			}
		}

		//Another way to achieve the same as above with one loop only. 
//		int i = 1, j = 1;
//		while (i < housePricesWithIndex.length) {
//			if (j > 0) {
//				if (housePricesWithIndex[i][0] < housePricesWithIndex[--j][0]) {
//					long tempLoss = housePricesWithIndex[i][1] - housePricesWithIndex[j][1];
//					if (actualLoss > tempLoss || actualLoss == 0) {
//						actualLoss = tempLoss;
//					}
//				} else {
//					continue;
//				}
//			}
//			i++;
//		}

		System.out.println(actualLoss);
	}

}
