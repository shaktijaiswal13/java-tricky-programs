package com.test.hackerrank.weekofcode24.challenge3;

import java.util.Scanner;

public class SimplifiedChessEngine {

	public static void main(String[] args) {
		String[][] whiteChess = new String[4][4];
//		String[][] blackChess = new String[4][4];
		int noOfMoves = 0;
		Scanner scan = new Scanner(System.in);
		int noOfGames = scan.nextInt();
		
		for (int noOfGames_i=0; noOfGames_i < noOfGames; noOfGames_i++) {
			int whitePieces = scan.nextInt();
			int blackPieces = scan.nextInt();
			noOfMoves = scan.nextInt();
			
			for (int whitePieces_i=0; whitePieces_i < whitePieces; whitePieces_i++) {
				String piece = scan.next();
				String column = scan.next();
				int row = scan.nextInt();
				if (column.equals("A")) {
					whiteChess[row-1][0] = "W" + piece;
				} else if (column.equals("B")) {
					whiteChess[row-1][1] = "W" + piece;
				} else if (column.equals("C")) {
					whiteChess[row-1][2] = "W" + piece;
				} else if (column.equals("D")) {
					whiteChess[row-1][3] = "W" + piece;
				}
			}
			for (int blackPieces_i=0; blackPieces_i < blackPieces; blackPieces_i++) {
				String piece = scan.next();
				String column = scan.next();
				int row = scan.nextInt();
				if (column.equals("A")) {
					whiteChess[row-1][0] = "B" + piece;
				} else if (column.equals("B")) {
					whiteChess[row-1][1] = "B" + piece;
				} else if (column.equals("C")) {
					whiteChess[row-1][2] = "B" + piece;
				} else if (column.equals("D")) {
					whiteChess[row-1][3] = "B" + piece;
				}
			}
		}
		scan.close();

		for (int i=0; i < whiteChess.length; i++) {
			 for (int j=0; j < whiteChess[i].length; j++) {
				 System.out.print(whiteChess[i][j] + " ");
			 }
			 System.out.println();
		 }
	}

}
