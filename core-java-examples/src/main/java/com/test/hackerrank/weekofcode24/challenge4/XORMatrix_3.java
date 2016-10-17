package com.test.hackerrank.weekofcode24.challenge4;

import java.util.Scanner;

/**
 * 7 5
1 3 6 8 9 3 2
8 0 4 9 10 5 10 
 * @author shaktikumar
 *
 */
public class XORMatrix_3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long noOfColumns = scan.nextLong();
		long noOfRows = scan.nextLong();
		
		int[] xorMatrix = new int[(int) noOfColumns];
		for (int col=0; col < xorMatrix.length; col++) {
			xorMatrix[col] = scan.nextInt();
		}
		scan.close();
		
		int rowCount = 1;
		if (noOfColumns % 2 == 1) {
			if ((noOfRows -1) % noOfColumns == 0) {
				while (rowCount++ <= noOfColumns) {
					
					int columns = (int) noOfColumns;
					int firstValue = xorMatrix[0];
					for (int col=0; col < columns-1; col++) {
						xorMatrix[col] = xorMatrix[col] ^ xorMatrix[col+1];
//					System.out.println(xorMatrix[col] + " ^ " + xorMatrix[col+1] + " = " + xorMatrix[col]);
					}
					xorMatrix[columns-1] = xorMatrix[columns-1] ^ firstValue;
				}
			} else {
				int totalRows = (int) ((noOfRows -1) % noOfColumns);
				while (rowCount++ <= totalRows) {
					
					int columns = (int) noOfColumns;
					int firstValue = xorMatrix[0];
					for (int col=0; col < columns-1; col++) {
						xorMatrix[col] = xorMatrix[col] ^ xorMatrix[col+1];
//					System.out.println(xorMatrix[col] + " ^ " + xorMatrix[col+1] + " = " + xorMatrix[col]);
					}
					xorMatrix[columns-1] = xorMatrix[columns-1] ^ firstValue;
				}
			}
		} else {
			double res = Math.log(noOfColumns) / Math.log(2);
			System.out.println(res);
			if ((int)res == res) {
				System.out.println("is 2's exponential");
				if ((noOfRows - 1) >= noOfColumns) {
					for (int col=0; col < noOfColumns; col++) {
						xorMatrix[col] = 0;
					}
				} else {
					int columns = xorMatrix.length;
					int rowCount1 = 2;
					while (rowCount1++ <= noOfRows) {
						
						int firstValue = xorMatrix[0];
						for (int col=0; col < columns-1; col++) {
							xorMatrix[col] = xorMatrix[col] ^ xorMatrix[col+1];
	//						System.out.println(xorMatrix[col] + " ^ " + xorMatrix[col+1] + " = " + xorMatrix[col]);
						}
						xorMatrix[columns-1] = xorMatrix[columns-1] ^ firstValue;
	//					System.out.println(xorMatrix[columns-1] + " ^ " + xorMatrix[0] + " = " + xorMatrix[columns-1]);
	//					System.out.println("======================");
					}
				}
			} else {
				int firstValue = xorMatrix[0];
				int columns = xorMatrix.length;
				for (int col=0; col < columns-1; col++) {
					xorMatrix[col] = xorMatrix[col] ^ xorMatrix[col+1];
				}
				xorMatrix[columns-1] = xorMatrix[columns-1] ^ firstValue;
				
				if ((noOfRows - 2) % noOfColumns == 0) {
					while (rowCount++ <= noOfColumns) {
						
						firstValue = xorMatrix[0];
						for (int col=0; col < columns-1; col++) {
							xorMatrix[col] = xorMatrix[col] ^ xorMatrix[col+1];
						}
						xorMatrix[columns-1] = xorMatrix[columns-1] ^ firstValue;
					}
				} else {
					
					int totalRows = (int) ((noOfRows - 2) % noOfColumns);
					while (rowCount++ <= totalRows) {
						
						firstValue = xorMatrix[0];
						for (int col=0; col < columns-1; col++) {
							xorMatrix[col] = xorMatrix[col] ^ xorMatrix[col+1];
						}
						xorMatrix[columns-1] = xorMatrix[columns-1] ^ firstValue;
					}
				}
			}
		}
		
		for (int col=0; col < xorMatrix.length; col++) {
			System.out.print(xorMatrix[col] + " ");
		}
	}

}
