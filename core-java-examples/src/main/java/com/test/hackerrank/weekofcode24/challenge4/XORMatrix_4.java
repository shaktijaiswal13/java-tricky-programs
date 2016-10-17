package com.test.hackerrank.weekofcode24.challenge4;

import java.util.Scanner;

/**
 * 7 5
1 3 6 8 9 3 2
8 0 4 9 10 5 10 
 * @author shaktikumar
 *
 */
public class XORMatrix_4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long noOfColumns = scan.nextLong();
		long noOfRows = scan.nextLong();
		
		int[] xorMatrix = new int[(int) noOfColumns];
		for (int col=0; col < xorMatrix.length; col++) {
			xorMatrix[col] = scan.nextInt();
		}
		scan.close();
		
		int[] generatedMatrix = new int[(int) noOfColumns];
		int rowCount = 1;
		int columns = xorMatrix.length;
		
		if (noOfColumns % 2 == 1) {
			if ((noOfRows - 1) % noOfColumns == 0) {
				while (rowCount++ <= noOfColumns) {
					
					for (int col=0; col < columns-1; col++) {
						generatedMatrix[col] = xorMatrix[col] ^ xorMatrix[col+1];
					}
					generatedMatrix[columns-1] = xorMatrix[columns-1] ^ xorMatrix[0];
				}
			} else {
				int totalRows = (int) ((noOfRows - 1) % noOfColumns);
				while (rowCount++ <= totalRows) {
					
					for (int col=0; col < columns-1; col++) {
						generatedMatrix[col] = xorMatrix[col] ^ xorMatrix[col+1];
					}
					generatedMatrix[columns-1] = xorMatrix[columns-1] ^ xorMatrix[0];
				}
			}
		} else {
			double res = Math.log(noOfColumns) / Math.log(2);
			if ((int)res == res) {
				if ((noOfRows - 1) < noOfColumns) {

					while (rowCount++ <= noOfRows - 1) {
						
						for (int col=0; col < columns-1; col++) {
							generatedMatrix[col] = xorMatrix[col] ^ xorMatrix[col+1];
						}
						generatedMatrix[columns-1] = xorMatrix[columns-1] ^ xorMatrix[0];
					}
				}
			} else {
				int firstValue = xorMatrix[0];
				for (int col=0; col < columns-1; col++) {
					xorMatrix[col] = xorMatrix[col] ^ xorMatrix[col+1];
				}
				xorMatrix[columns-1] = xorMatrix[columns-1] ^ firstValue;
				
				if ((noOfRows - 2) % noOfColumns == 0) {
					while (rowCount++ <= noOfColumns) {
						
						for (int col=0; col < columns-1; col++) {
							generatedMatrix[col] = xorMatrix[col] ^ xorMatrix[col+1];
						}
						generatedMatrix[columns-1] = xorMatrix[columns-1] ^ xorMatrix[0];
					}
				} else {
					
					int totalRows = (int) ((noOfRows - 2) % noOfColumns);
					while (rowCount++ <= totalRows) {
						
						for (int col=0; col < columns-1; col++) {
							generatedMatrix[col] = xorMatrix[col] ^ xorMatrix[col+1];
						}
						generatedMatrix[columns-1] = xorMatrix[columns-1] ^ xorMatrix[0];
					}
				}
			}
		}
		
		for (int col=0; col < generatedMatrix.length; col++) {
			System.out.print(generatedMatrix[col] + " ");
		}
	}

}
