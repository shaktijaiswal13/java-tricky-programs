package com.test.hackerrank.weekofcode24.challenge4;

import java.util.Scanner;

public class XORMatrix_2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long noOfColumns = scan.nextLong();
		long noOfRows = scan.nextLong();
		
		int[] xorMatrix = new int[(int) noOfColumns];
		for (int col=0; col < xorMatrix.length; col++) {
			xorMatrix[col] = scan.nextInt();
		}
		scan.close();
		
		int columns = xorMatrix.length;
		int rowCount = 2;
		while (rowCount++ <= noOfRows) {
			
			int firstValue = xorMatrix[0];
			for (int col=0; col < columns-1; col++) {
				xorMatrix[col] = xorMatrix[col] ^ xorMatrix[col+1];
//				System.out.println(xorMatrix[col] + " ^ " + xorMatrix[col+1] + " = " + xorMatrix[col]);
			}
			xorMatrix[columns-1] = xorMatrix[columns-1] ^ firstValue;
//			System.out.println(xorMatrix[columns-1] + " ^ " + xorMatrix[0] + " = " + xorMatrix[columns-1]);
//			System.out.println("======================");
		}
		
		for (int col=0; col < xorMatrix.length; col++) {
			System.out.print(xorMatrix[col] + " ");
		}
	}

}
