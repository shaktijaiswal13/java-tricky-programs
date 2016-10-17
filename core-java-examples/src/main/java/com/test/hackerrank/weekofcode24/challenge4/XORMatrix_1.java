package com.test.hackerrank.weekofcode24.challenge4;

import java.util.Scanner;

public class XORMatrix_1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long noOfColumns = scan.nextLong();
		long noOfRows = scan.nextLong();
		
		int[][] xorMatrix = new int[(int) noOfRows][(int) noOfColumns];
		for (int col=0; col < xorMatrix[0].length; col++) {
			xorMatrix[0][col] = scan.nextInt();
		}
		scan.close();
		
		for (int row=1; row < xorMatrix.length; row++) {
			int columns = xorMatrix[row].length;
			for (int col=0; col < columns-1; col++) {
				xorMatrix[row][col] = xorMatrix[row-1][col] ^ xorMatrix[row-1][col+1];
				System.out.println(xorMatrix[row-1][col] + " ^ " + xorMatrix[row-1][col+1] + " = " + xorMatrix[row][col]);
			}
			xorMatrix[row][columns-1] = xorMatrix[row-1][columns-1] ^ xorMatrix[row-1][0];
			System.out.println(xorMatrix[row-1][columns-1] + " ^ " + xorMatrix[row-1][0] + " = " + xorMatrix[row][columns-1]);
			System.out.println("======================");
		}
		for (int row=0; row < xorMatrix.length; row++) {
			for (int col=0; col < xorMatrix[row].length; col++) {
				System.out.print(xorMatrix[row][col] + " ");
			}
			System.out.println();
		}
	}

}
